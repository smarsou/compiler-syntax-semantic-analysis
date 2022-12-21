package ast;

public class Print implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public StrNode str;

    public Print(StrNode str){
        this.str=str;
    }

}
