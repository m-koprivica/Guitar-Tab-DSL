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
