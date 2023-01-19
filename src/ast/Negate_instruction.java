package ast;

public class Negate_instruction implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast exp;
    public int line;

    public Negate_instruction(Ast exp, int line) {
        this.exp = exp;
        this.line = line;

    }

}
