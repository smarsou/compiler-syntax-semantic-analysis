package ast;



public class LetInEnd implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Declaration_list declaration_list;
    public Ast exprseq;
    public int line;


    public LetInEnd(Declaration_list l1st, Ast exprseq, int line) {
        this.declaration_list = l1st;
        this.exprseq = exprseq;
        this.line = line;
    }

    public LetInEnd(Declaration_list l1st, int line) {
        this.declaration_list = l1st;
        this.line = line;
    }

}