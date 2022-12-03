package ast;

public class Inferior implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Inferior(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
