package ast;

public interface AstVisitor<T> {
    public T visit(Program ctx);

    public T visit(Expr ctx);

    public T visit(Nil ctx);

    public T visit(Integer ctx);

    public T visit(CallExpr ctx);

    public T visit(String ctx);

    public T visit(LvalueExpr ctx);

    public T visit(Parenthesis ctx);

    public T visit(TypeIdCreate ctx);

    public T visit(IfThen ctx);

    public T visit(IfThenElse ctx);

    public T visit(While ctx);

    public T visit(For ctx);

    public T visit(Break ctx);

    public T visit(LetInEnd ctx);

    public T visit(Print ctx);

    public T visit(RecCreate ctx);

    public T visit(ArrayCreate ctx);

    public T visit(ExprSeqInit ctx);

    public T visit(ExprSeqAdd ctx);

    public T visit(ExprSeqFinish ctx);

    public T visit(ExprListInit ctx);

    public T visit(ExprListAdd ctx);

    public T visit(ExprListFinish ctx);

    public T visit(RecFieldListInit ctx);

    public T visit(RecFieldListAdd ctx);

    public T visit(RecFieldListFinish ctx);

    public T visit(LvalueInit ctx);

    public T visit(LvalueAdd ctx);

    public T visit(LvalueSubscript ctx);

    public T visit(LvalueFinish ctx);

    public T visit(LvalueDec ctx);

    public T visit(LvalueNone ctx);

    public T visit(Declaration_list ctx);

    public T visit(Declaration ctx);

    public T visit(DecType ctx);

    public T visit(TypeId ctx);

    public T visit(RecType ctx);

    public T visit(ArrayType ctx);

    public T visit(TypeFieldListInit ctx);

    public T visit(TypeFieldListAdd ctx);

    public T visit(TypeFieldListFinish ctx);

    public T visit(TypeField ctx);

    public T visit(Type_id ctx);

    public T visit(DecVarTypeNotSpec ctx);

    public T visit(DecVarTypeSpec ctx);

    public T visit(DecFunctVoid ctx);

    public T visit(DecFunctWithReturnType ctx);

    public T visit(Binary_operation ctx);

    public T visit(Precedence_1 ctx);

    public T visit(Precedence_2 ctx);

    public T visit(Precedence_3 ctx);

    public T visit(Precedence_4 ctx);

    public T visit(Negate_instruction ctx);

}
