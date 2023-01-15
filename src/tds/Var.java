package tds;

import java.util.HashMap;

import ast.AstVisitor;

public class Var implements Entry{

    public String nom;
    public String type;
    public Object valeur;
<<<<<<< HEAD
    public Rec rec;
    public Array array;
=======
    public boolean isParm;
>>>>>>> 4ce117729ebee5fdde1ac6bb211c85d6fa73b07e
    
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

    public Var(String nom,String type,boolean isParm) {
        this.nom = nom;
        this.type = type;
        this.isParm = true;

    }
    public String getName(){
        return nom;
    }

    public Var(){

    }
    public void arrayCreate(int nbr, Object obj){

    }


}