package tds;

import ast.AstVisitor;

public class Var implements Entry{

    private String nom;
    private String type;
    private Object valeur;
    
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Var(String nom, String type, Object valeur){
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
    }
    public Var(String nom, String type){
        this.nom = nom;
        this.type = type;
    }


}