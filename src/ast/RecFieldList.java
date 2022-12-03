package ast;

import java.util.ArrayList;

public class RecFieldList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast>  astList;

    public RecFieldList(ArrayList<Ast> astList){
        this.astList = astList;
    }

}