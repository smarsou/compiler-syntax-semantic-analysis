package ast;

import java.util.ArrayList;

public class LvalueInit implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> lvalue;
    public ArrayList<Ast> lvalue2;
    public int line;

    public LvalueInit(ArrayList<Ast> lvalue, int line){
        this.lvalue = lvalue;
        this.line = line;
    }

    public LvalueInit(ArrayList<Ast> lvalue, ArrayList<Ast> lvalue2, int line){
        this.lvalue = lvalue;
        this.lvalue2 = lvalue2;
        this.line = line;
    }

    public LvalueInit(Ast ast, int line){
        lvalue = new ArrayList<>();
        lvalue.add(ast);
        lvalue2 = new ArrayList<>();
        lvalue2.add(ast);
        this.line = line;
    }

    public LvalueInit(LvalueInit ast, int line){
        this.lvalue = ast.lvalue;
        this.lvalue2 = ast.lvalue;
        this.line = line;
    }

}