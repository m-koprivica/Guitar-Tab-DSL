Define FUNCTION "Shift" (BAR b, NUMBER s):
	b.chords[1].strings[s]=3

Define CHORD "E" X 0 1 2 2 0
Define BAR "bar1" (chords="E", pattern=([1+2+3],4,5,4))

//This here should be a good ol' pass by value
Define SEGMENT "Before":
	bar="bar1"

Define SEGMENT "After":
	bar="bar1"

Compose:
	"Before"
	"Shift"("bar1", 4)
	"After"
