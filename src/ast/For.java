package ast;


public class For implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public String idf;
    public Ast expr1;
    public Ast expr2;
    public Ast expr3;

    public For(String idf,Ast expr1, Ast expr2, Ast expr3) {
        this.idf = idf;
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.expr3 = expr3;

    }

}