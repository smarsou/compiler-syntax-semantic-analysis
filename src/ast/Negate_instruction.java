package ast;

public class Negate_instruction implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast instruction;

    public Negate_instruction(Ast instrs) {
        this.instruction = instrs;

    }

}
