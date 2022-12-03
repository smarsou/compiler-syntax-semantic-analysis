package ast;

import parser.exprBaseVisitor;
import parser.exprParser;

public class AstCreator extends exprBaseVisitor<Ast> {
    @Override
    public Ast visitProgram(exprParser.ProgramContext ctx) {
        
        Program exprList = new Program();

		for (int i = 0; i<ctx.getChildCount();i++){
			exprList.addExpr(ctx.getChild(i).accept(this));
		}

		return exprList;
    }

    @Override
    public Ast visitExpr(exprParser.ExprContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitNil(exprParser.NilContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitInteger(exprParser.IntegerContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitCallExpr(exprParser.CallExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitString(exprParser.StringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueExpr(exprParser.LvalueExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitParenthesis(exprParser.ParenthesisContext ctx) {
        return ctx.getChild(1).accept(this); 
    }

    @Override
    public Ast visitTypeIdCreate(exprParser.TypeIdCreateContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitIfThen(exprParser.IfThenContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitIfThenElse(exprParser.IfThenElseContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitWhile(exprParser.WhileContext ctx) {
        While tant_que = new While(ctx.getChild(1).accept(this),ctx.getChild(3).accept(this));
        return tant_que;
    }

    @Override
    public Ast visitFor(exprParser.ForContext ctx) {
        For for1 = new For(ctx.getChild(0).toString(),ctx.getChild(3).accept(this),ctx.getChild(5).accept(this),ctx.getChild(7).accept(this));
        return for1;
    }

    @Override
    public Ast visitBreak(exprParser.BreakContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLetInEnd(exprParser.LetInEndContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitPrint(exprParser.PrintContext ctx) {
        return ctx.getChild(2).accept(this);
    }

    @Override
    public Ast visitRecCreate(exprParser.RecCreateContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Ast visitArrayCreate(exprParser.ArrayCreateContext ctx) {
        ArrayCreate arrayCreate = new ArrayCreate(ctx.getChild(1).accept(this), ctx.getChild(4).accept(this));
        return arrayCreate;
    }

    @Override
    public Ast visitExprSeqInit(exprParser.ExprSeqInitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitExprSeqAdd(exprParser.ExprSeqAddContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitExprSeqFinish(exprParser.ExprSeqFinishContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitExprListInit(exprParser.ExprListInitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitExprListAdd(exprParser.ExprListAddContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitExprListFinish(exprParser.ExprListFinishContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitRecFieldListInit(exprParser.RecFieldListInitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitRecFieldListAdd(exprParser.RecFieldListAddContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitRecFieldListFinish(exprParser.RecFieldListFinishContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueInit(exprParser.LvalueInitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueAdd(exprParser.LvalueAddContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueSubscript(exprParser.LvalueSubscriptContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueFinish(exprParser.LvalueFinishContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueDec(exprParser.LvalueDecContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Ast visitLvalueNone(exprParser.LvalueNoneContext ctx) {
        return ctx.accept(this);
    }

    @Override
    public Ast visitDeclaration_list(exprParser.Declaration_listContext ctx) {
        Declaration_list declarationList = new Declaration_list();

		for (int i = 0; i<ctx.getChildCount();i++){
			declarationList.addDeclaration(ctx.getChild(i).accept(this));
		}

		return declarationList;
    }

    @Override
    public Ast visitDeclaration(exprParser.DeclarationContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitDecType(exprParser.DecTypeContext ctx) {
        DecType decType = new DecType(ctx.getChild(1).toString(), ctx.getChild(3).accept(this));
        return decType;
    }

    @Override
    public Ast visitTypeId(exprParser.TypeIdContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitRecType(exprParser.RecTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitArrayType(exprParser.ArrayTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitTypeFieldListInit(exprParser.TypeFieldListInitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitTypeFieldListAdd(exprParser.TypeFieldListAddContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitTypeFieldListFinish(exprParser.TypeFieldListFinishContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitTypeField(exprParser.TypeFieldContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitType_id(exprParser.Type_idContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitDecVarTypeNotSpec(exprParser.DecVarTypeNotSpecContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitDecVarTypeSpec(exprParser.DecVarTypeSpecContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitDecFunctVoid(exprParser.DecFunctVoidContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitDecFunctWithReturnType(exprParser.DecFunctWithReturnTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitBinary_operation(exprParser.Binary_operationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitPrecedence_1(exprParser.Precedence_1Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitPrecedence_2(exprParser.Precedence_2Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitPrecedence_3(exprParser.Precedence_3Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitPrecedence_4(exprParser.Precedence_4Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitNegate_instruction(exprParser.Negate_instructionContext ctx) {
        return visitChildren(ctx);
    }

}
