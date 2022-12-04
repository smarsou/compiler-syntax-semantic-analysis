package ast;

public class Precedence_3 implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Precedence_3(Ast l, Ast r) {
        this.right = r;
        this.left = l;

    }

}
