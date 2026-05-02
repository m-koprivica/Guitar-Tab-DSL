Define CHORD "D" X 1 0 2 3 X
Define BAR "Bar1" (chords="D", played=2)

Define SEGMENT "Intro" Loop 2:
	bar="Bar1"

Compose:
	"Intro"
