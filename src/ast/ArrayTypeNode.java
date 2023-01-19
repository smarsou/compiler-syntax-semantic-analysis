package ast;

public class ArrayTypeNode implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Ast arrayType;
    public int line;

    public ArrayTypeNode(Ast arrayType, int line) {
        this.arrayType = arrayType;
        this.line = line;
    }

}