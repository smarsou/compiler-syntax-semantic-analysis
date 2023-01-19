package ast;

public class Divide implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;
    public int line;

    public Divide(Ast l, Ast r,int line) {
        this.right = r;
        this.left = l;
        this.line = line;

    }

}
