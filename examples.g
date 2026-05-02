
===========EXAMPLE 1===========
| Showcasing patterns and bar |
| sequences                   |
===============================

Define CHORD "A7sus4" 0 3 2 0 0 3
Define CHORD "E7sus4" 0 3 0 0 2 0
Define CHORD "open" 0 0 0 0 0 0

Define BAR "intro1" (chords="A7sus4", played=3)
Define BAR "intro2" (chords="A7sus4", pattern=(2, 3, 1, 2, 3))
Define BAR "intro3" (chords="A7sus4", pattern=(6, 2, 3, 1, 2, 3))
Define BAR "intro4" (chords="A7sus4", pattern=(6, 3, 2, 4, 1, 2, 3))

Define BAR "bridgeAugment" (chords="open", pattern=(2))

Define BAR "bridge1" ((chords="A7sus4", pattern=([1+2+3+4+5+6], 6, 2, 6)), "bridgeAugment", (chords="A7sus4", pattern=(6, 2, 6)))
Define BAR "bridge2" ((chords="A7sus4", pattern=(1, 6, 2, 6)), "bridgeAugment", (chords="A7sus4", pattern=(6, 2, 6)))
Define BAR "bridge3" ((chords="E7sus4", pattern=([1+2+3+4+5+6], 6, 2, 6)), "bridgeAugment", (chords="E7sus4", pattern=(6, 2, 6)))
Define BAR "bridge4" ((chords="E7sus4", pattern=(1, 6, 2, 6)), "bridgeAugment", (chords="E7sus4", pattern=(6, 2, 6)))

Define SEGMENT "Intro":
    bar="intro1"
    bar="intro2"
    bar="intro1"
    bar="intro3"
    bar="intro4"

Define SEGMENT "Bridge":
    bar="bridge1"
    bar="bridge2"
    bar="bridge3"
    bar="bridge4"


Compose:
    "Intro"
    Loop 2:
        "Bridge"
    end

===========EXAMPLE 2==============
| Showcasing mutation statements |
|                                |
==================================

Define CHORD "D" 2 3 2 0 0 0

Define BAR "Intro" (chords="D", played=3)

Define SEGMENT "segment":
    bar="Intro"

Compose:
    "segment"
    "Intro".chords[1].strings[1]=3
    "segment"

===========EXAMPLE 3==============
| Showcasing function calls      |
| and loops                      |
==================================
Define FUNCTION "MoveFretUp" (CHORD c):
    c.strings[1]+1
    c.strings[2]+1
    c.strings[3]+1
    c.strings[4]+1
    c.strings[5]+1
    c.strings[6]+1

Define CHORD "EM7" 7 9 8 9 7 X

Define BAR "bar1" (chords="EM7", pattern=(1, 2, 3, 4, 5))

Define SEGMENT "Intro":
    bar="bar1"

Compose:
    Loop 5:
        "Intro"
        "MoveFretUp"("EM7")
    end