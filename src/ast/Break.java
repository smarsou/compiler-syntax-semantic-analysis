package ast;

public class Break implements Ast{
    public String strValue;

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Break(){
        this.strValue = "break";
    }
}
