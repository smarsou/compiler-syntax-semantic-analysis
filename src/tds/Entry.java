package tds;

import ast.AstVisitor;

public interface Entry{

    public String getName();

    public <T> T accept(AstVisitor<T> visitor);
}