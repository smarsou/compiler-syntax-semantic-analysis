package tds;

public class Entry{
    Var var;
    Fonction fonc;
    Type type;
    public Entry(Var v){
        this.var = v;
    }

    public Entry(Fonction f){
        this.fonc = f;
    }

    public Entry(Type t){
        this.type = t;
    }
}