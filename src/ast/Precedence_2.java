package ast;

public class Precedence_2 implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Precedence_2(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
