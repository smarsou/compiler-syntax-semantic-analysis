package ast;

public class Print implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public StrNode str;
    public int line;

    public Print(StrNode str, int line){
        this.str=str;
        this.line=line;
    }

}
