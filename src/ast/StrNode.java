package ast;

public class StrNode implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;

    public StrNode(String name){
        this.name=name;
    }
    

}
