package ast;


public class DecVarTypeNotSpec implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public StrNode idf;
    public Ast expr;
    public int line;

    public DecVarTypeNotSpec(StrNode idf, Ast expr, int line){
        this.idf = idf;
        this.expr = expr;
        this.line = line;
    }


}