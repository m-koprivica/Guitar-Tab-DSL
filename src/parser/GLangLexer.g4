lexer grammar GLangLexer;

// keywords
DEFINE          : 'Define';
COMPOSE         : 'Compose';
LOOP            : 'Loop' | 'loop';
END             : 'end';

TYPE_CHORD      : 'CHORD';
TYPE_BAR        : 'BAR';
TYPE_SEGMENT    : 'SEGMENT';
TYPE_FUNCTION   : 'FUNCTION';
TYPE_NUMBER     : 'NUMBER';

CHORDS          : 'chords';
STRINGS         : 'strings';
PATTERN         : 'pattern';
PLAYED          : 'played';
BAR             : 'bar';

// symbols
LPAREN          : '(';
RPAREN          : ')';
LBRACK          : '[';
RBRACK          : ']';
COLON           : ':';
COMMA           : ',';
DOT             : '.';
DASH            : '-';
PLUS            : '+';
EQUALS          : '=';

// input
NUMBER          : [0-9]+;
X               : 'X';
NAME            : '"' (~["\r\n])* '"';
ID              : [A-Za-z_] [A-Za-z0-9_]*;

// misc
NEWLINE         : '\r'? '\n';
WS              : [ \t]+ -> skip;
COMMENT         : '//' ~[\r\n]* NEWLINE? -> skip;