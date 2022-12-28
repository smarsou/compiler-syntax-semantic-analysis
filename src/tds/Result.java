package tds;

import java.util.ArrayList;

import ast.Ast;

//Cette classe a pour but de manipuler les résultats lors de la visite des noeuds
//Vous pouvez ajouter n'importe qu'elle attribut que vous souhaitez

public class Result {
   
    //typeName = 'int', 'array' pour les tableau de même type, 'rec' pour les tableaux avec différents types
    String typeName;

    String name;
    String strValue;
    int intValue;
    Object objValue;

    Array ar;
    Rec rc;

<<<<<<< HEAD
    ArrayList<Result> subscript;

    Boolean lvalueCorrect;
    Object lvalueObject;
    String lvalueType;
    ArrayList<Ast> linkToLvalue;
    Object varObject;
    String varIdf;

    ArrayList<Ast> recFieldList;

    
=======
    ArrayList<Integer> subscript;

    String conditionBlockReturn;
    String thenBlockReturn;
    String ElseBlockReturn;
>>>>>>> c529a379165c6945d419ce6b4d7a9655f7123ce4
}
