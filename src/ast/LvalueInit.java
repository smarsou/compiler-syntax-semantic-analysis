package ast;

import java.util.ArrayList;

public class LvalueInit implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Object> lvalue;

    public LvalueInit(ArrayList<Object> lvalue){
        this.lvalue = lvalue;
    }

    public LvalueInit(String str){
        lvalue = new ArrayList<>();
        lvalue.add(str);
    }
    

}