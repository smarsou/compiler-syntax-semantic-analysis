package ast;


public class DecFunctVoid implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public StrNode idf;
    public Ast type_field_list;
    public Ast expr;

    public DecFunctVoid(StrNode idf, Ast type_field_list, Ast expr){
        this.idf = idf;
        this.type_field_list = type_field_list;
        this.expr = expr;
    }

    public DecFunctVoid(StrNode idf, Ast expr){
        this.idf = idf;
        this.expr = expr;
    }


}