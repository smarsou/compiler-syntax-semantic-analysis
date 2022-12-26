package tds;

import java.util.ArrayList;

//Cette classe a pour but de manipuler les résultats lors de la visite des noeuds
//Vous pouvez ajouter n'importe qu'elle attribut que vous souhaitez

public class Result {
   
    //typeName = 'int', 'array' pour les tableau de même type, 'rec' pour les tableaux avec différents types
    String typeName;

    String name;
    String strValue;
    int intValue;

    Array ar;
    Rec rc;

    ArrayList<Integer> subscript;
}
