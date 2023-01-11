package tds;

import java.util.ArrayList;
import java.util.HashMap;

import ast.AstVisitor;

public class Type implements Entry{

    public String nom;
    public String typeDeType;
    public Object Element;
    public String typeid;
    public String arrayOf;
    public HashMap<String, String> typeFieldDict;

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Type(String nom, String typeDeType, Object Element){
        this.nom = nom;
        this.typeDeType = typeDeType;
        this.Element = Element;
    }

    public Type(String nom, String typeDeType){
        this.nom = nom;
        this.typeDeType = typeDeType;
    }

    public Type(String nom){
        this.nom = nom;
    }

    public String getName(){
        return nom;
    }

}