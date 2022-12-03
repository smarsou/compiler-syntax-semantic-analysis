package ast;

public class RecField implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast idf;
    public Ast expression;

    public RecField(LvalueInit idf, Ast expression){
        this.idf = idf;
        this.expression = expression;
    }
}
