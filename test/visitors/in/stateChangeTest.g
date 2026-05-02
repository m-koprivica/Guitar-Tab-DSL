Define CHORD "D" - 1 0 2 3 X
Define BAR "bar1" (chords="D", played=2)

Define SEGMENT "SegmentWithBar1":
	bar="bar1"

//Check to make sure state change persists
Define SEGMENT "After":
	bar="bar1"

Compose:
    "SegmentWithBar1"
    "bar1".chords[1].strings[1]=3
    Loop 2:
      "SegmentWithBar1"
    end
    "After"