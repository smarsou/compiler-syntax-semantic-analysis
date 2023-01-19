package ast;

import java.util.ArrayList;

public class RecFieldList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast>  astList;
    public Ast type;
    public int line;

    public RecFieldList(ArrayList<Ast> astList,Ast type, int line){
        this.astList = astList;
        this.type = type;
        this.line = line;
    }

}