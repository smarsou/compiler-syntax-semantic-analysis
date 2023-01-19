package ast;

public class IfThen implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenBlock;
    public int line;

    public IfThen(Ast condition, Ast thenBlock, int line){
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.line = line;
    }

}