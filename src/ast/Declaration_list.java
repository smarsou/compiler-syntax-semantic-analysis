package ast;

import java.util.ArrayList;

public class Declaration_list implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> declarationList;

    public Declaration_list() {
        this.declarationList = new ArrayList<>();
    }

    public void addDeclaration(Ast declaration){
        this.declarationList.add(declaration);
    }
}