package ast;


public class DecVarTypeNotSpec implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public String idf;
    public Ast expr;

    public DecVarTypeNotSpec(String idf, Ast expr){
        this.idf = idf;
        this.expr = expr;
    }


}