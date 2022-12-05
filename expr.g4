grammar expr    ;

@header{
package parser;
}

program: expr+ EOF;

expr: instruction | binary_operation;

instruction
    :    'nil'                                  #Nil
    |    INT                                    #Integer
    |    ID '(' expr_list ?')'                  #CallExpr
    |    STR                                    #String
    |    lvalue lvalue_call_or_declare          #LvalueExpr
    |    '(' expr_seq ?')'                      #Parenthesis
    |    type_id type_id_prime                  #TypeIdCreate
    |    'if' expr 'then' expr                  #IfThen
    |    'if' expr 'then' expr 'else' expr      #IfThenElse
    |    'while' expr 'do' expr                 #While
    |    'for' ID ':=' expr 'to' expr 'do' expr #For
    |    'break'                                #Break
    |    'let' declaration_list 'in' expr_seq? 'end' #LetInEnd
    |    'print' '(' expr ')'                   #Print
    ;
    

type_id_prime 
    :    '{' rec_field_list?'}'                 #RecCreate
    |    '[' expr ']' 'of' expr                 #ArrayCreate
    ;
       


expr_seq
            :           expr expr_seq_prime     #ExprSeqInit
            ;
expr_seq_prime
            :           ';' expr expr_seq_prime  #ExprSeqAdd
            |                                    #ExprSeqFinish
            ;

expr_list
           :       expr expr_list_prime         #ExprListInit
           ;
expr_list_prime
           :       ',' expr expr_list_prime     #ExprListAdd
           |                                    #ExprListFinish
           ;

rec_field
        :   ID '=' expr #RecField
        ;

rec_field_list
           :  rec_field rec_field_list_prime          #RecFieldListInit
           ;
rec_field_list_prime
           :      ',' rec_field rec_field_list_prime  #RecFieldListAdd
           |                                            #RecFieldListFinish
           ;

lvalue
         :            ID   lvalue_prime     #LvalueInit
         ;

lvalue_prime
        :       '.'  ID lvalue_prime        #LvalueAdd
        |       '[' expr ']' lvalue_prime   #LvalueSubscript
        |                                   #LvalueFinish
        ;

lvalue_call_or_declare 
        :    ':=' expr                      
        |                                   
        ;


declaration_list
         :        declaration+
         ;

declaration
          :        variable_declaration     
          |        function_declaration     
          |        type_declaration         
          ;

type_declaration
:     'type' type_id  '=' type  #DecType
;

type
:     type_id                   #TypeId
|    '{' type_field_list? '}'   #RecType
|    'array' 'of' type_id       #ArrayType
;


type_field_list
              :         type_field type_field_list_prime    #TypeFieldListInit
              ;

type_field_list_prime
               :        ',' type_field type_field_list_prime    #TypeFieldListAdd
               |                                                #TypeFieldListFinish
               ;

type_field
:     ID ':' type_id       #TypeField
;

type_id : ID ;          

variable_declaration
:    'var' ID ':=' expr                 #DecVarTypeNotSpec
|    'var' ID ':' type_id ':=' expr     #DecVarTypeSpec
;

function_declaration
:     'function' ID '(' type_field_list? ')' '=' expr               #DecFunctVoid
|     'function' ID '(' type_field_list? ')' ':' type_id '=' expr   #DecFunctWithReturnType
;   

binary_operation: precedence_4;

precedence_1 : negate_instruction ( binary_operator_1 negate_instruction)*;

precedence_2 : precedence_1 ( binary_operator_2 precedence_1)*;

precedence_3 : precedence_2 ( binary_operator_3 precedence_2)*;

precedence_4 : precedence_3 ( binary_operator_4 precedence_3)*;
    
negate_instruction:  '-' negate_instruction | instruction ;

//binary_operation : instruction ((binary_operator_1|binary_operator_2|binary_operator_3|binary_operator_4) instruction)*;

// les Terminaux

ID    :  LETTER ( LETTER | INT | '_' )*
    ;
fragment LETTER : ('a'..'z' | 'A'..'Z');

INT    : DIGIT+
;

STR   : '"' (DIGIT | LETTER | ' ' | ',' | ';' | '.' | ':'| '!'| '?'| '/'| '\\' | '-'| '_' | [èêéàâîïÏÎç] )+ '"' 
;

fragment DIGIT: ('0'..'9');

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

WS    : [ \n\t\r]+ ->skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
;
