package tds;

public class Fonction{

    private String nom;
    private String typeDeRetour;
    private Tds infos;

    public Fonction(String nom, String typeDeRetour, Tds infos){
        this.nom = nom;
        this.typeDeRetour = typeDeRetour;
        this.infos = infos;
    }

}