package ast;

public class Or implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Or(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
