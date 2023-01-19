package ast;


public class TypeField implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public Ast idf1;
    public Ast idf2;
    public int line;

    public TypeField(Ast idf1, Ast idf2, int line){
        this.idf1 = idf1;
        this.idf2 = idf2;
        this.line = line;
    }
}