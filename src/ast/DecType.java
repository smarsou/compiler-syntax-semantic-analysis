package ast;


public class DecType implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public String idf;
    public Ast type;

    public DecType(String idf, Ast type) {
        this.idf = idf;
        this.type = type;

    }

}