package ast;

public class Divide implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Divide(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}