package ast;

public class Negate_instruction implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast exp;

    public Negate_instruction(Ast exp) {
        this.exp = exp;

    }

}
