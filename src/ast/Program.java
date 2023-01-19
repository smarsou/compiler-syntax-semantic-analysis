package ast;

import java.util.ArrayList;

public class Program implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> exprList;
    public int line;

    public Program(int line) {
        this.exprList = new ArrayList<>();
        this.line = line;
    }

}