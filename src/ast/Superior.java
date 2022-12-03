package ast;

public class Superior implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Superior(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
