package tds;

import ast.AstVisitor;

public class Type implements Entry{

    private String nom;
    private String typeDeType;
    private Object Element;

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

}