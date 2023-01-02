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


    Boolean lvalueCorrect;
    Object lvalueObject;
    String lvalueType;
    ArrayList<Ast> linkToLvalue;
    Object varObject;
    String varIdf;

    ArrayList<Result> recFieldList;

    
    ArrayList<Result> subscript;
    String conditionBlockReturn;
    Result thenBlock;
    Result elseBlock;
}
