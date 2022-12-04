package ast;



public class LetInEnd implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Declaration_list declaration_list;
    public Ast exprseq;


    public LetInEnd(Declaration_list l1st, Ast exprseq) {
        this.declaration_list = l1st;
        this.exprseq = exprseq;
    }

    public LetInEnd(Declaration_list l1st) {
        this.declaration_list = l1st;
    }

}