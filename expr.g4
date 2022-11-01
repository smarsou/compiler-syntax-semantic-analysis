grammar expr;

@header{
package parser;
}

program: expr+ EOF;

expr: instruction | binary_operation;

instruction
    :    'nil'  
    |    INT | ID | STR   
    |    lvalue
    |    '-' expr
    |    lvalue ':=' expr
    |    ID  '(' expr_list ?')'
    |    '(' expr_seq ?')'
    |    type_id '{' field_list?'}'
    |    type_id '[' expr ']' 'of' expr
    |    'if' expr 'then' expr expr_prime?
    |    'while' expr 'do' expr
    |    'for' ID ':=' expr 'to' expr 'do' expr
    |    'break'
    |    'let' declaration_list 'in' expr_seq? 'end'
    |    print
    ;
    
expr_prime 
    :           cond2
    |           'else'  expr
    ;

cond2
    :    'else' expr
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
|     'function' ID ( type_fields? ) ':' type_id '=' expr
;

binary_operation: precedence_1 | precedence_2 | precedence_3 | precedence_4;

precedence_1: instruction (binary_operator_1 instruction)*;

precedence_2: instruction (binary_operator_2 (instruction|precedence_1))*;

precedence_3: instruction (binary_operator_3 (instruction|precedence_1|precedence_2))*;

precedence_4: instruction (binary_operator_4 (instruction|precedence_1|precedence_2|precedence_3))*;

binary_operator_1
: '*' 
| '/'
;

binary_operator_2
: '+' 
| '-' 
;

binary_operator_3
: '=' 
| '<>' 
| '<' 
| '>' 
| '<=' 
| '>='
;

binary_operator_4
: '&' 
| '|'
;



print
    : 'print(' STR|INT|ID ')'
    ;
// les Terminaux

ID    :  LETTER ( LETTER | INT | '_' )*
    ;
fragment LETTER : ('a'..'z' | 'A'..'Z');

INT    : DIGIT+
;

STR    : '“' (DIGIT | LETTER| '\\'ASCII |' ' | ',' | ';' | '.' | ':'| '!'| '?'| '/'| '-'| '_')+ '“' 
;
fragment ASCII: DIGIT DIGIT DIGIT;
fragment DIGIT: ('0'..'9');

WS    : [ \n\t\r]+ ->skip
    ;
