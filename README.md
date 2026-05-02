# Guitar Tabs DSL

## Purpose

A lot of online guitar forum users like to write guitar tabs (sheet music for guitars specifically) in plain text, something that looks like this:

```
e|----------------|----------------|----------------|------------------|
B|----------------|----------------|----------------|------------------|
G|-----3--5-------|--3--6-5--------|-----3--5----3--|------------------|
D|--5--3--5----5--|--3--6-5--------|--5--3--5----3--|--5---------------|
A|--5-----------5-|----------------|--5-------------|--5---------------|
E|----------------|----------------|----------------|------------------|
```

But putting these kinds of things together, especially with more complex chord shapes, is kind of annoying. Our DSL takes advantage of some very basic music theory stuff to generate these sorts of tabs for users. All while requiring minimal programming knowledge.

## Language Guide

### Chords

The most basic language element is the CHORD which is a collection of strings and their fret values.  
  
They can be created using the Define keyword:  
  
Define CHORD “E” 0 2 1 3 0 4   
  
This creates what is essentially a template for picking out your notes when it comes time to write a bar. An analogy would be like choosing your colors before you start painting.  
  
You can access individual strings within a CHORD to change them:  

“E”.strings[5]=1  

This changes the fifth string of our defined chord from a value of 0 to a value of 1 

### Bars

To define a BAR, you first need to have a chord. Then, you pick what strings you want plucked in 
the bar.   

Define BAR “bar1” (chords=”E”, pattern=([1+3],4,5,4))  

This would produce a bar that looks like: 
```
1|--0--------------| 
2|-----------------| 
3|--1--------------| 
4|------3-----3----| 
5|---------0-------| 
6|-----------------| 
```
Notice how the frets are automatically filled with the fingerings from the chord you chose.  
You can strum chords using the played keyword when creating a BAR:  

Define BAR “bar2” (chords=”E”, played=2)  

This would produce a bar that looks like: 
```
1|--0------0-------| 
2|--2------2-------| 
3|--1------1-------| 
4|--3------3-------| 
5|--0------0-------| 
6|--4------4-------| 
```
Finally, you can create a more complicated BAR using multiple bar constructors, or pre-existing 
bars separated by commas. The resulting bars will be appended in the same order as you listed 
them:  
```
Define BAR “allTheBars” (“bar2”, (chords=”E”, pattern=([1+3],4,5,4))) 

1|--0------0-----0--------------| 
2|--2------2--------------------| 
3|--1------1-----1--------------| 
4|--3------3---------3-----3----| 
5|--0------0------------0-------| 
6|--4------4--------------------| 
```
You can also access the chords in a bar with . notation and change them the same way as 
before:  

“allTheBars”.chords[2].strings[1]=1

### Segments and Loops

When you want to put multiple BARs together without combining them into one, you use a SEGMENT. These are constructs that allow you to :  
```
Define SEGMENT “Intro”:  
  bar=“bar2”   
  bar=”allTheBars”  

Define SEGMENT “Intro” Loop 2:   
  bar=“bar2”  
```

### Outputting your tabs

To output your tabs, use the Compose keyword. It accepts SEGMENTs and BARs, and produces your Tabs:  
```
Compose: 
  “Intro” 
  ”allTheBars” 
```
Compose also supports loops:
```
Compose: 
  Loop 2:
    “Intro”
  ”allTheBars”
```
This will loop the intro segment twice and then add the allTheBars segment right after for a total of 3 bars.

### Functions

You can define functions to do modification tasks that you may want repeated  
```
Define FUNCTION “Shift” (BAR b, NUMBER s): 
  b.chords[1].strings[s]=3 
```
Everything done in a function is passed by reference. That means the changes to b are reflected everywhere else as well. 
```
“Shift”(“Bar1”, 4)
```

## Getting Started

### Requirements

#### Java
Java version 21+ (thought earlier versions may work)

#### JUnit
The test files in this project use the JUnit Jupiter API, which is provided by JUnit version 5+.

#### ANTLR
This project uses the ANTLR Parser Generator to generate its lexer and parser.

To get started, you need to download and install ANTLR for Java. Please make sure that you use at least ANTLR 4.10.

Using the plug-in will simplify lexer+parser generation. You can find this in the plugin hub of your IDE.

#### 

### Clone the repo

Clone the repository here:
```
https://github.com/m-koprivica/Guitar-Tab-DSL.git
```
### Setup
```
STEP 1: Open the /gen folder.

STEP 2: Right-click on the folder named /gen/parser.

STEP 3: Under "Mark Directory As" select "Mark Generated Sources Root"

STEP 4: Open the /src/parser folder

STEP 5: Right-click on GLangLexer.g4

STEP 6: Select "Generate ANTLR Recognizer"

STEP 7: Repeat steps 5 and 6 for GLangParser.g4
```

### Accessing the UI
```
STEP 1: Open the /src/ui folder

STEP 2: Right-click on the file named "Main"

Step 3: Select "Run Main.main()"
```


## Attribution

Developed by Matija Koprivica, Brian Berger, Skye Cheng, Rune Sylte and Dylan Medjnoun at UBC for CPSC 410: Advanced Software Engineering.






