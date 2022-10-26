grammar expr;

@header{
package parser;
}

program: expr+EOF;


expr
    :    'nil'     
    |    exp
    |    lvalue
    |    '-' expr
    |    lvalue ':=' expr
    |    ID  '(' expr_list ?')'
    |    '(' expr_seq ?')'
    |    type_id '{' field_list?'}'
    |    type_id '[' expr ']' 'of' expr
    |    'if' expr 'then' expr expr_prime
    |    'while' expr 'do' expr
    |    'for' ID ':=' expr 'to' expr 'do' expr
    |    'break'
    |    'let' declaration_list 'in' expr_seq? 'end'
    ;
expr_prime 
    :           cond2
    |           'else'  expr
    ;

cond2
    :    'else' expr
    ;

exp 
:     INT
|    ID    
|    STR 
|    (INT | ID | STR) binary_operator expr 
;

binary_operator
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


expr_seq
            :           expr expr_seq_prime
            ;
expr_seq_prime
            :           ';' expr expr_seq_prime
            |           
            ;
expr_list
           :      expr expr_list_prime
           ;
expr_list_prime
           :       ';' expr expr_list_prime
           |        
           ;

field_list
           :  ID '=' expr field_list_prime
           ;
field_list_prime
           :      ',' ID '=' expr field_list_prime
           |       
           ;

lvalue
         :            ID   lvalue_prime
         ;
lvalue_prime
        :       '.'  ID lvalue_prime
        |         '[' expr ']' lvalue_prime
        |          
        ;


declaration_list
         :        declaration
         |        declaration_list declaration
         ;
declaration
          :       variable_declaration
          |        function_declaration
          |        type_declaration
          ;

type_declaration
:     'type' type_id  '=' type 
;
type
:     type_id 
|    '{' type_fields? '}'
|    'array' 'of' type_id 
;
type_fields
              :         type_field type_fields_prime
              ;

type_fields_prime
               :        ',' type_field type_fields_prime
               |         
               ;


type_field
:     ID ':' type_id
;

type_id : ID ;

variable_declaration
:    'var' ID ':=' expr 
|    'var' ID ':' type_id ':=' expr 
;

function_declaration
:     'function' ID ( type_fields? ) '=' expr 
|    'function' ID ( type_fields? ) ':' type_id '=' expr
;


// les Terminaux

ID    :  LETTER ( LETTER | INT | '_' )*
    ;
fragment LETTER : ('a'..'z' | 'A'..'Z');

INT    : ('0'..'9')+
;

STR    : '“' ('0'..'9' | 'a'..'z' | 'A'..'Z'| ESCAPE)+ '“' 
;
fragment ESCAPE : ( '\\n' | '\\t' | '\\”' | '\\' | '\\'CTRL | '\\'ASCII  ) ;
fragment ASCII: DIGIT DIGIT DIGIT;
fragment DIGIT: ('0'..'9');
fragment CTRL    
:     '@' 
|     'A'..'Z'
|     '[' 
|     '\\'
|     ']'
|     '^' 
|    '_' 
|    '.'
;

WS    : [ \n\t\r]+ ->skip
    ;
