package tds;

import java.util.HashMap;

import ast.AstVisitor;

public class Var implements Entry{

    public String nom;
    public String type;
    public Object valeur;
    public Rec rec;
    public Array array;
    
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
    public String getName(){
        return nom;
    }

    public Var(){

    }
    public void arrayCreate(int nbr, Object obj){

    }


}