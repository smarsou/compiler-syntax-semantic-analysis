package ast;

public class RecCreate implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast typeid;
    public Ast fieldList;
    public int line;

    public RecCreate(Ast typeid, Ast fieldList, int line){
        this.typeid = typeid;
        this.fieldList = fieldList;
        this.line = line;
    }

}