package ast;


public class DecType implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Ast idf;
    public Ast type;

    public DecType(Ast idf, Ast type) {
        this.idf = idf;
        this.type = type;

    }

}