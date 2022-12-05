package ast;

import java.util.ArrayList;

public class LvalueInit implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> lvalue;

    public LvalueInit(ArrayList<Ast> lvalue){
        this.lvalue = lvalue;
    }

    public LvalueInit(Ast ast){
        lvalue = new ArrayList<>();
        lvalue.add(ast);
    }

    public LvalueInit(LvalueInit ast){
        this.lvalue = ast.lvalue;
    }
    

}