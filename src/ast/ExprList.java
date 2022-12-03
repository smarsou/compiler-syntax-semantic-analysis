package ast;

import java.util.ArrayList;

public class ExprList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> astList;

    public ExprList(ArrayList<Ast> astList){
        this.astList = astList;
    }

}