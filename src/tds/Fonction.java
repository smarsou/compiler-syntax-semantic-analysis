package tds;

import ast.AstVisitor;

public class Fonction implements Entry{

    private String nom;
    private String typeDeRetour;
    private Tds infos;

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Fonction(String nom, String typeDeRetour, Tds infos){
        this.nom = nom;
        this.typeDeRetour = typeDeRetour;
        this.infos = infos;
    }

}