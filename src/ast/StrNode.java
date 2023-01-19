package ast;

public class StrNode implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;
    public int line;

    public StrNode(String name, int line){
        this.name=name;
        this.line = line;
    }
    

}
