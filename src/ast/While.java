package ast;


public class While implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Ast expr1;
    public Ast expr2;

    public While(Ast expr1, Ast expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;

    }

}