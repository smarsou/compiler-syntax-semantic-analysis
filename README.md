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
    
    visitIfThen                     ✅
    visitIfThenElse                 ✅
    visitString                     ✅
    visitInteger                    ✅

    Les méthodes triviales:

    visitProgram                    ✅
    visitExpr                       ✅
    visitDeclaration_list           ✅
    visitDeclaration                ✅
    visitBreak                      ✅
    visitParenthesis                ✅
    visitType_id
    visitNil

    Les méthodes normales:

    visitTypeIdCreate               
    visitWhile                      ✅
    visitFor                        ✅
    visitLetInEnd
    visitPrint                      ✅
    visitRecCreate
    visitArrayCreate                ✅
    visitLvalueDec                  ✅
    visitLvalueNone                 ✅
    visitDecType                    ✅
    visitTypeId
    visitRecType
    visitArrayType
    visitLvalueExpr 
    visitCallExpr
    visitTypeField
    visitDecVarTypeNotSpec
    visitDecVarTypeSpec
    visitDecFunctVoid
    visitDecFunctWithReturnType
    
    Les méthodes qui traitent les règles qui se comporte comme des listes (Initialisation, ajout, fin de liste):

    visitExprSeqInit
    visitExprSeqAdd
    visitExprSeqFinish
    visitExprListInit
    visitExprListAdd
    visitExprListFinish
    visitRecFieldListInit
    visitRecFieldListAdd
    visitRecFieldListFinish
    visitTypeFieldListInit
    visitTypeFieldListAdd
    visitTypeFieldListFinish
    visitLvalueInit
    visitLvalueAdd
    visitLvalueSubscript
    visitLvalueFinish

    Les méthodes pour traiter les opérations (même chose que dans le TP2 avec plus d'opérateurs):

    visitBinary_operation
    visitPrecedence_1
    visitPrecedence_2
    visitPrecedence_3
    visitPrecedence_4
    visitNegate_instruction
