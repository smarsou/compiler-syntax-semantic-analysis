package ast;

import java.util.ArrayList;

public class Program implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> exprList;

    public Program() {
        this.exprList = new ArrayList<>();
    }

    public void addExpr(Ast expr){
        this.exprList.add(expr);
    }
}