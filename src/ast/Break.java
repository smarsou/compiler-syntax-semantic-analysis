package ast;

public class Break implements Ast{
    public String strValue;
    public int line;

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Break(int line){
        this.strValue = "break";
        this.line = line;
    }
}
