package ast;

import java.util.ArrayList;

public class ExprSeq implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> astList;

    public ExprSeq(ArrayList<Ast> astList){
        this.astList = astList;
    }

}