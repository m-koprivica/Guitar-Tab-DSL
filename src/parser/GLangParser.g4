parser grammar GLangParser;
options { tokenVocab=GLangLexer; }

// Grammar
program             : (NEWLINE* statement)* NEWLINE* EOF;
statement           : defineStmt | composeStmt | mutationStmt | functionCallStmt;

defineStmt          : DEFINE (chordDef | barDef | segmentDef | functionDef);

// Chord
chordDef            : TYPE_CHORD NAME fret fret fret fret fret fret;
fret                : NUMBER | X | DASH;

// Bar
barDef              : TYPE_BAR NAME barExpr;
barExpr             : LPAREN (barArgs | barSequence) RPAREN;
barArgs             : barArg (COMMA barArg)*;
barArg              : CHORDS  EQUALS NAME
                    | PATTERN EQUALS pattern
                    | PLAYED  EQUALS NUMBER;
barSequence         : barItem (COMMA barItem)*;
barItem             : NAME | LPAREN barArgs RPAREN;

// Pattern (for Define BAR ...)
pattern             : LPAREN patternItem (COMMA patternItem)* RPAREN;
patternItem         : NUMBER | LBRACK NUMBER (PLUS NUMBER)* RBRACK;

// Segment
segmentDef          : TYPE_SEGMENT NAME COLON segmentBody;
segmentBody         : (NEWLINE segmentLine)+;
segmentLine         : BAR EQUALS NAME;

// Compose
composeStmt         : COMPOSE COLON composeBody;
composeBody         : (NEWLINE composeLine)+;
composeLine         : NAME
                    | LOOP NUMBER COLON composeBody NEWLINE? END
                    | mutationStmt
                    | functionCallStmt;

// Mutation
mutationStmt        : valueAccess (EQUALS | PLUS | DASH) (fret | ID);
valueAccess         : (NAME | ID) (DOT access)+;
access              : (CHORDS | STRINGS) LBRACK (NUMBER | ID) RBRACK;

// Function
functionDef         : TYPE_FUNCTION NAME LPAREN paramList? RPAREN COLON functionBody;
functionBody        : (NEWLINE statement)+;
paramList           : param (COMMA param)*;
param               : (TYPE_CHORD | TYPE_BAR | TYPE_SEGMENT | TYPE_NUMBER) ID;

// Function Call
functionCallStmt    : NAME LPAREN argList? RPAREN;
argList             : arg (COMMA arg)*;
arg                 : NAME | NUMBER;