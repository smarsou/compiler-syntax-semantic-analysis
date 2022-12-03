package ast;

public class Sup_inf implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Sup_inf(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
