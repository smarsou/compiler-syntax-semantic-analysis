package ast;


public class CallExpr implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public StrNode idf;
    public Ast exprList;

    public CallExpr(StrNode idf, Ast exprList){
        this.idf = idf;
        this.exprList = exprList;
    }

    public CallExpr(StrNode idf){
        this.idf = idf;
    }

}