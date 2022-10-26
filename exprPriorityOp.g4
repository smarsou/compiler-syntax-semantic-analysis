grammar expr;

@header{
package parser;
}

program: expre+EOF;

expre
    :    'nil'     
    |    exp
    |    '-' expre
    |    '(' expreseq? ')'
    ;

exp 
:     INT | ID | STR 
|    (INT | ID | STR) binaryoperator expre 
;


// prio1 : (INT|IDF) (('*'|'/') (INT|IDF))*;
// prio2 : (INT|IDF) (('+'|'-') (INT|IDF|prio1))*;
// prio3 : (INT|IDF) (('='|'<>'|'<'|'>'|'>='|'<=') (INT|IDF|prio2|prio1))*;
// prio4 :  (INT|IDF) ( '&' (INT|IDF|prio3|prio2|prio1))*;
// prio5 :  (INT|IDF) ( '|' (INT|IDF|prio4|prio3|prio2|prio1))*;
// prio6 :  (INT|IDF) ( ':=' (INT|IDF|prio5|prio4|prio3|prio2|prio1))*;

expreseq:
         expre
    |    expreseq ';' expre
    ;

binaryoperator
:     '+' 
| '-' 
| '*' 
| '/' 
| '=' 
| '<>' 
| '<' 
| '>' 
| '<=' 
| '>=' 
| '&' 
| '|' 
;


INT : ('0'..'9')+;
// INT : [0-9]+;

ID: LETTERS ( INT | LETTERS | '_' )*;
fragment LETTERS : ('a'..'z' | 'A'..'Z');

STR    : '“' ('0'..'9' | 'a'..'z' | 'A'..'Z')+ '“' 
;


WS : [ \n\t\r]+ -> skip;

