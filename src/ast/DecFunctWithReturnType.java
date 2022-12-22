package ast;


public class DecFunctWithReturnType implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public StrNode idf1;
    public Ast type_field_list;
    public StrNode idf2;
    public Ast expr;

    public DecFunctWithReturnType(StrNode idf1, Ast type_field_list, StrNode idf2, Ast expr){
        this.idf1 = idf1;
        this.type_field_list = type_field_list;
        this.idf2 = idf2;
        this.expr = expr;
    }


}