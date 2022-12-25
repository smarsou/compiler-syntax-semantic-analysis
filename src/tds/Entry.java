package tds;

import ast.AstVisitor;

public interface Entry{
    public <T> T accept(AstVisitor<T> visitor);
}