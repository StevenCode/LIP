grammar NameList;

//START: parser
list     : '[' elements ']' ;
elements : element (',' element)* ;
element  : NAME | list;
//END: parser

//START: lexer
NAME     : LETTER+;
LETTER   : 'a'..'z'|'A'..'Z'
WS       : (' '|'\t'|'\n'|'\r')+ {skip();}
//END: lexer