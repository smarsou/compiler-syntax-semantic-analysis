# Compilateur

**English:**

This project involves implementing the syntax and semantic analysis phases of a compiler. The chosen language is Tiger. Code generation in assembly language is not part of this project.

The syntax analysis was carried out by establishing an LL grammar, which allowed us to construct the abstract syntax tree (AST).

Next, based on this abstract tree, we implemented semantic checks in Java using the Visitor design pattern.

This enabled us to build the symbol table in the end.

**French:**

Vous êtes sur le dépot git d'un projet de compilation pour le langage Tiger.

Ce projet comporte les phases d'analyse syntaxique et sémantiques. La génération de code en langage assembleur ne fait pas partie de ce projet.

L'analyse syntaxique a pu se faire grâce à la mise en place d'une grammaire en LL, qui nous a permis de pouvoir construire l'abre abstrait syntaxique (AST).

Ensuite, à partir de cette arbre abstrait, nous avons implémenter les contrôles sémantiques en JAVA à l'aide du design pattern Visiteur. 

Ce qui nous a permis de construire pour terminer la table des symboles. 

# Utilisation du Makefile

### Pour tout nettoyer
    make clean

## Arbre Syntaxique
### Pour executer l'analyse syntaxique et afficher l'arbre:
    make run target=tests/succes/<....>

#### Pour seulement compiler la grammaire
    make parser

## AST
### Pour construire l'AST d'un fichier fichier.exp et l'afficher 
    make astrun target=tests/succes/<...>

### Pour seulement compiler la grammaire (permet de changer le fichier exprBaseVisitor)
    make astparser

# 1.AST méthodes et classes à construire
### Pour chaque méthode, il faut faire:
1) Remplir la méthode dans la classe AstCreator
2) Créer les classes des Noeud correspondants (ex: Int.java, Str.java) dans le dossier src/ast/
3) Ajouter une méthode dans la classe AstVisitor pour chaque nouveau Noeud créée
####
    
    visitIfThen                     ✅X
    visitIfThenElse                 ✅X
    visitString                     ✅X
    visitInteger                    ✅X

    Les méthodes triviales:

    visitProgram                    ✅X
    visitExpr                       ✅O
    visitDeclaration_list           ✅X
    visitDeclaration                ✅X
    visitBreak                      ✅X
    visitParenthesis                ✅O
    visitTypeid                     ✅X
    visitNil                        ✅X

    Les méthodes normales:

    visitTypeIdCreate               ✅X
    visitWhile                      ✅O
    visitFor                        ✅O
    visitLetInEnd                   ✅X
    visitPrint                      ✅X
    visitRecCreate                  ✅X
    visitArrayCreate                ✅X
    visitLvalueDec                  ✅
    visitLvalueNone                 ✅
    visitDecType                    ✅X
    visitTypeId                     ✅X
    visitRecType                    ✅X
    visitArrayType                  ✅X
    visitLvalueExpr                 ✅X
    visitCallExpr                   ✅X
    visitTypeField                  ✅X
    visitDecVarTypeNotSpec          ✅O
    visitDecVarTypeSpec             ✅O
    visitDecFunctVoid               ✅O
    visitDecFunctWithReturnType     ✅O
    
    Les méthodes qui traitent les règles qui se comporte comme des listes (Initialisation, ajout, fin de liste):

    visitExprSeqInit        ✅
    visitExprSeqAdd         -> None
    visitExprSeqFinish      -> None
    visitExprListInit       ✅
    visitExprListAdd        -> None
    visitExprListFinish     -> None
    visitRecFieldListInit   ✅
    visitRecFieldListAdd    -> None
    visitRecFieldListFinish ->  None
    visitTypeFieldListInit  ✅
    visitTypeFieldListAdd   -> None
    visitTypeFieldListFinish    -> None
    visitLvalueInit         ✅
    visitLvalueAdd          -> None
    visitLvalueSubscript    -> None
    visitLvalueFinish       -> None

    Les méthodes pour traiter les opérations (même chose que dans le TP2 avec plus d'opérateurs):

    visitBinary_operation
    visitPrecedence_1
    visitPrecedence_2
    visitPrecedence_3
    visitPrecedence_4
    visitNegate_instruction
