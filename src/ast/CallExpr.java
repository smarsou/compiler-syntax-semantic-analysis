package ast;


public class CallExpr implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public StrNode idf;
    public Ast exprList;
    public int line;

    public CallExpr(StrNode idf, Ast exprList, int line){
        this.idf = idf;
        this.exprList = exprList;
        this.line = line;
    }

    public CallExpr(StrNode idf, int line){
        this.idf = idf;
        this.line = line;
    }

}