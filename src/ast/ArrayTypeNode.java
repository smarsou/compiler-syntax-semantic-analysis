package ast;

public class ArrayTypeNode implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Ast arrayType;

    public ArrayTypeNode(Ast arrayType) {
        this.arrayType = arrayType;
    }

}