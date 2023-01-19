package ast;

import java.util.ArrayList;

public class Declaration_list implements Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> declarationList;
    public int line;

    public Declaration_list(int line) {
        this.declarationList = new ArrayList<>();
        this.line = line;
    }

    public void addDeclaration(Ast declaration){
        this.declarationList.add(declaration);
    }
}