package ast;

import java.util.ArrayList;

public class ExprList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> astList;
    public int line;

    public ExprList(ArrayList<Ast> astList, int line){
        this.astList = astList;
        this.line = line;
    }

}