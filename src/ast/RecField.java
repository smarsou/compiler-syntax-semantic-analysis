package ast;

public class RecField implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast idf;
    public Ast expression;
    public Ast lvTname;
    
    public RecField(LvalueInit idf, Ast expression, Ast lvTname){
        this.idf = idf;
        this.expression = expression;
        this.lvTname = lvTname;

    }
}
