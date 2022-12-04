package ast;

import java.util.ArrayList;

import javax.lang.model.type.ArrayType;

import org.antlr.v4.runtime.tree.ParseTree;

import parser.exprBaseVisitor;
import parser.exprParser;

public class AstCreator extends exprBaseVisitor<Ast> {
    @Override
    public Ast visitProgram(exprParser.ProgramContext ctx) {

        Program exprList = new Program();

        for (int i = 0; i < ctx.getChildCount(); i++) {
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
        return ctx.accept(this);
    }

    @Override
    public Ast visitInteger(exprParser.IntegerContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitCallExpr(exprParser.CallExprContext ctx) {
        String idf = ctx.getChild(0).toString();
        if (ctx.getChildCount()==4){
            Ast expr_list = ctx.getChild(2).accept(this);
            return new CallExpr(idf, expr_list);
        }
        return new CallExpr(idf);
    }

    @Override
    public Ast visitString(exprParser.StringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueExpr(exprParser.LvalueExprContext ctx) {
        Ast lvalue = ctx.getChild(0).accept(this);
        Ast lvalue_call_or_declare = ctx.getChild(0).accept(this);
        return new LvalueExpr(lvalue, lvalue_call_or_declare);
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
        While tant_que = new While(ctx.getChild(1).accept(this), ctx.getChild(3).accept(this));
        return tant_que;
    }

    @Override
    public Ast visitFor(exprParser.ForContext ctx) {
        For for1 = new For(ctx.getChild(0).toString(), ctx.getChild(3).accept(this), ctx.getChild(5).accept(this),
                ctx.getChild(7).accept(this));
        return for1;
    }

    @Override
    public Ast visitBreak(exprParser.BreakContext ctx) {
        return ctx.accept(this);
    }

    @Override
    public Ast visitLetInEnd(exprParser.LetInEndContext ctx) {

        Declaration_list declaration_list = new Declaration_list();
        for (int i = 0; i<ctx.getChild(1).getChildCount();i++){
            declaration_list.addDeclaration(ctx.getChild(1).getChild(i).accept(this));
        }
        if (ctx.getChildCount()==4){
            LetInEnd letinend = new LetInEnd(declaration_list, ctx.getChild(3).accept(this));
            return letinend;
        }
        return new LetInEnd(declaration_list);
    }

    @Override
    public Ast visitPrint(exprParser.PrintContext ctx) {
        return ctx.getChild(2).accept(this);
    }

    @Override
    public Ast visitRecCreate(exprParser.RecCreateContext ctx) {
        if (ctx.getChildCount()==3){
            return ctx.getChild(1).accept(this);
        }
        return ctx.accept(this);
    }

    @Override
    public Ast visitArrayCreate(exprParser.ArrayCreateContext ctx) {
        ArrayCreate arrayCreate = new ArrayCreate(ctx.getChild(1).accept(this), ctx.getChild(4).accept(this));
        return arrayCreate;
    }

    @Override
    public Ast visitExprSeqInit(exprParser.ExprSeqInitContext ctx) {
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new ExprSeq(liste);
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
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new ExprList(liste);
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
    public Ast visitRecField(exprParser.RecFieldContext ctx) {
        String idStr = ctx.getChild(0).toString();
        LvalueInit id = new LvalueInit(idStr);
        Ast exp = ctx.getChild(2).accept(this);
        return new RecField(id, exp);
    }

    @Override
    public Ast visitRecFieldListInit(exprParser.RecFieldListInitContext ctx) {
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new RecFieldList(liste);
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
        ParseTree premier = ctx.getChild(0);
        ParseTree suivant = ctx.getChild(1);

        if (suivant.getChildCount() == 0) {
            return new LvalueInit(premier.toString());
        }

        ArrayList<Object> list = new ArrayList<>();
        while (suivant.getChildCount() != 0) {
            switch (suivant.getChild(0).toString()) {
                case ".":
                    list.add(premier.toString());
                    premier = suivant.getChild(1);
                    suivant = suivant.getChild(2);
                    break;
                case "[":
                    Ast subscript = suivant.getChild(1).accept(this);

                    String typeOfLast = list.get(list.size() - 1).getClass().getName();
                    if (typeOfLast.equals("LvalueSub") ){
                        LvalueSub lastSubList = (LvalueSub) list.get(list.size() -1);
                        lastSubList.successiveSub.add(subscript);     
                    }else{
                    ArrayList<Ast> successiveSub = new ArrayList<>();
                    successiveSub.add(subscript);
                    LvalueSub sub = new LvalueSub(premier.toString(), successiveSub);
                    list.add(sub);
                    }
                    suivant = suivant.getChild(3);
                    break;
                default:
                    break;
            }
        }

        return new LvalueInit(list);
    }

    // @Override
    // public Ast visitLvalueInit2(exprParser.LvalueInitContext ctx) {
    // String id = ctx.getChild(0).toString();
    // Ast prime = ctx.getChild(1).accept(this);
    // return new LvalueInit(id,prime);
    // }

    @Override
    public Ast visitLvalueAdd(exprParser.LvalueAddContext ctx) {
        // if (ctx.getChildCount() == 0){
        // return new LvalueFinish();
        // }else{
        // String id = ctx.getChild(1).toString();

        // Ast prime = ctx.getChild(2).accept(this);
        // return new LvalueAdd(id,prime);
        // }
        return visitChildren(ctx);
    }

    @Override
    public Ast visitLvalueSubscript(exprParser.LvalueSubscriptContext ctx) {
        // if (ctx.getChildCount() == 0){
        // return new LvalueFinish();
        // }else{
        // Ast exp = ctx.getChild(1).accept(this);
        // Ast prime = ctx.getChild(3).accept(this);
        // return new LvalueSub(exp,prime);
        // }
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

        for (int i = 0; i < ctx.getChildCount(); i++) {
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
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitRecType(exprParser.RecTypeContext ctx) {
        if (ctx.getChildCount()==3){
            return ctx.getChild(1).accept(this);
        }
        return ctx.accept(this);
    }

    @Override
    public Ast visitArrayType(exprParser.ArrayTypeContext ctx) {
        return ctx.getChild(2).accept(this);
    }

    @Override
    public Ast visitTypeFieldListInit(exprParser.TypeFieldListInitContext ctx) {
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new TypeFieldList(liste);
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
        String id1 = ctx.getChild(0).toString();
        String id2 = ctx.getChild(0).getChild(0).toString();
        return new TypeField(id1, id2);
    }

    @Override
    public Ast visitType_id(exprParser.Type_idContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitDecVarTypeNotSpec(exprParser.DecVarTypeNotSpecContext ctx) {
        String idf = ctx.getChild(1).toString();
        Ast expr = ctx.getChild(3).accept(this);
        return new DecVarTypeNotSpec(idf,expr);

    }

    @Override
    public Ast visitDecVarTypeSpec(exprParser.DecVarTypeSpecContext ctx) {
        String idf1 = ctx.getChild(1).toString();
        String idf2 = ctx.getChild(0).getChild(0).toString();
        Ast expr = ctx.getChild(5).accept(this);
        return new DecVarTypeSpec(idf1, idf2, expr);
    }

    @Override
    public Ast visitDecFunctVoid(exprParser.DecFunctVoidContext ctx) {
        String idf = ctx.getChild(1).toString();
        if (ctx.getChildCount()==7){
            Ast type_field_list = ctx.getChild(3).accept(this);
            Ast expr = ctx.getChild(6).accept(this);
            return new DecFunctVoid(idf, type_field_list, expr);
        }
        Ast expr = ctx.getChild(5).accept(this);
        return new DecFunctVoid(idf, expr);

    }

    @Override
    public Ast visitDecFunctWithReturnType(exprParser.DecFunctWithReturnTypeContext ctx) {
        String idf1 = ctx.getChild(1).toString();
        if (ctx.getChildCount()==9){
            Ast type_field_list = ctx.getChild(3).accept(this);
            String idf2 = ctx.getChild(6).getChild(0).toString();
            Ast expr = ctx.getChild(8).accept(this);
            return new DecFunctWithReturnType(idf1, type_field_list, idf2, expr);
        }
        String idf2 = ctx.getChild(5).getChild(0).toString();
        Ast expr = ctx.getChild(7).accept(this);
        return new DecFunctWithReturnType(idf1, expr, idf2, expr);
    }

    @Override
    public Ast visitBinary_operation(exprParser.Binary_operationContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitPrecedence_1(exprParser.Precedence_1Context ctx) {
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "*":
                    ntmp = new Precedence_1(ntmp, right);
                    break;
                case "/":
                    ntmp = new Divide(ntmp, right);
                    break;

            }

        }

        return ntmp;
    }

    @Override
    public Ast visitPrecedence_2(exprParser.Precedence_2Context ctx) {
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "+":
                    ntmp = new Precedence_2(ntmp, right);
                    break;
                case "-":
                    ntmp = new Minus(ntmp, right);
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitPrecedence_3(exprParser.Precedence_3Context ctx) {
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "=":
                    ntmp = new Precedence_3(ntmp, right);
                    break;
                case "<>":
                    ntmp = new Sup_inf(ntmp, right);
                    break;
                case ">":
                    ntmp = new Superior(ntmp, right);
                    break;
                case "<":
                    ntmp = new Inferior(ntmp, right);
                    break;
                case ">=":
                    ntmp = new Sup_equal(ntmp, right);
                    break;
                case "<=":
                    ntmp = new Inf_equal(ntmp, right);
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitPrecedence_4(exprParser.Precedence_4Context ctx) {
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "&":
                    ntmp = new Precedence_4(ntmp, right);
                    break;
                case "|":
                    ntmp = new Or(ntmp, right);
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitNegate_instruction(exprParser.Negate_instructionContext ctx) {
        Ast instrs;
        if (ctx.getChildCount() > 1) {
            instrs = ctx.getChild(1).accept(this);

        } else {
            instrs = ctx.getChild(0).accept(this);

        }

        return new Negate_instruction(instrs);
    }

}
