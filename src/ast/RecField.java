package ast;

public class RecField implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast idf;
    public Ast expression;
    public Ast lvTname;
    public int line;
    
    public RecField(StrNode idf, Ast expression, Ast lvTname, int line){
        this.idf = idf;
        this.expression = expression;
        this.lvTname = lvTname;
        this.line = line;

    }
}
