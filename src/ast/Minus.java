package ast;

public class Minus implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Minus(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
