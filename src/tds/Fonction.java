package tds;

import ast.AstVisitor;

public class Fonction implements Entry{

    private String nom;
    private String typeDeRetour;
    private int tdsFils;
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Fonction(String nom, String typeDeRetour, int tdsFils){
        this.nom = nom;
        this.typeDeRetour = typeDeRetour;
        this.tdsFils = tdsFils;
    }

    public Fonction(String nom, String typeDeRetour){
        this.nom = nom;
        this.typeDeRetour = typeDeRetour;
    }

    public void setTds(int tdsFils){
        this.tdsFils = tdsFils;
    }

    public String getName(){
        return nom;
    }
    public int gettdsFils() {
        return this.tdsFils;
    }

    public String getType() {
        return this.typeDeRetour;
    }

}