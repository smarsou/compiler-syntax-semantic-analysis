package ast;

public class IfThenElse implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenBlock;
    public Ast elseBlock;
    public int line;
    
    public IfThenElse(Ast condition, Ast thenBlock, Ast elseBlock, int line){
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
        this.line = line;
    }
}