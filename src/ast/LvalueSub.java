package ast;

import java.util.ArrayList;

public class LvalueSub implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String id;
    public ArrayList<Ast> successiveSub;

    public LvalueSub(String id, ArrayList<Ast> successiveSub ){
        this.id = id;
        this.successiveSub=successiveSub;
    }
}