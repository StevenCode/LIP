grammar NameList;

//START: parser
stat     : list EOF | assign EOF
assign   : list '=' list
list     : '[' elements ']' ;
elements : element (',' element)* ;
element  : NAME '=' NAME
         | NAME;
         | list;
//END: parser

//START: lexer
NAME     : LETTER+;
LETTER   : 'a'..'z'|'A'..'Z'
WS       : (' '|'\t'|'\n'|'\r')+ {skip();}
//END: lexer