package ast;

import java.util.ArrayList;

public class LvalueInit implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> lvalue;
    public ArrayList<Ast> lvalue2;

    public LvalueInit(ArrayList<Ast> lvalue){
        this.lvalue = lvalue;
    }

    public LvalueInit(ArrayList<Ast> lvalue, ArrayList<Ast> lvalue2){
        this.lvalue = lvalue;
        this.lvalue2 = lvalue2;
    }

    public LvalueInit(Ast ast){
        lvalue = new ArrayList<>();
        lvalue.add(ast);
        lvalue2 = new ArrayList<>();
        lvalue2.add(ast);
    }

    public LvalueInit(LvalueInit ast){
        this.lvalue = ast.lvalue;
        this.lvalue2 = ast.lvalue;
    }

}