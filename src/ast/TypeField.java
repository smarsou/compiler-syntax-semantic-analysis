package ast;


public class TypeField implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public String idf1;
    public String idf2;

    public TypeField(String idf1, String idf2){
        this.idf1 = idf1;
        this.idf2 = idf2;
    }


}