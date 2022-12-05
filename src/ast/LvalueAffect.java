package ast;


public class LvalueAffect implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Ast lvalue;
    public Ast lvalue_call_or_declare;

    public LvalueAffect(Ast lvalue, Ast lvalue_call_or_declare){
        this.lvalue = lvalue;
        this.lvalue_call_or_declare = lvalue_call_or_declare;
    }

}