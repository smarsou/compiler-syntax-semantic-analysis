package ast;


public class DecVarTypeSpec implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public String idf1;
    public String idf2;
    public Ast expr;

    public DecVarTypeSpec(String idf1, String idf2, Ast expr){
        this.idf1 = idf1;
        this.idf2 = idf2;
        this.expr = expr;
    }


}