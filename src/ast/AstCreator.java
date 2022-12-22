package ast;

import java.util.ArrayList;

import javax.lang.model.type.ArrayType;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.antlr.v4.runtime.tree.ParseTree;

import parser.exprBaseVisitor;
import parser.exprParser;

public class AstCreator extends exprBaseVisitor<Ast> {
    @Override
    public Ast visitProgram(exprParser.ProgramContext ctx) {

        Program exprList = new Program();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            exprList.exprList.add(ctx.getChild(i).accept(this));
        }

        return exprList;
    }

    @Override
    public Ast visitNil(exprParser.NilContext ctx) {
        return ctx.accept(this);
    }

    @Override
    public Ast visitCallExpr(exprParser.CallExprContext ctx) {
        String idf = ctx.getChild(0).toString();
        StrNode str = new StrNode(idf);
        if (ctx.getChildCount() == 4) {
            Ast expr_list = ctx.getChild(2).accept(this);
            return new CallExpr(str, expr_list);
        }
        return new CallExpr(str);
    }

    @Override
    public Ast visitString(exprParser.StringContext ctx) {
        String idf = ctx.getChild(0).toString();
        return new StrNode(idf);
    }

    // @Override
    // public Ast visitLvalue_call_or_declare(exprParser.StringContext ctx) {
    // String idf = ctx.getChild(0).toString();
    // return new StrNode(idf);
    // }

    @Override
    public Ast visitLvalueExpr(exprParser.LvalueExprContext ctx) {
        Ast lvalue = ctx.getChild(0).accept(this);
        if (ctx.getChild(1).accept(this) != null) {
            Ast lvalue_call_or_declare = ctx.getChild(1).accept(this);
            return new LvalueAffect(lvalue, lvalue_call_or_declare);
        }
        return new LvalueInit((LvalueInit) lvalue);
    }

    @Override
    public Ast visitParenthesis(exprParser.ParenthesisContext ctx) {
        if (ctx.getChildCount() == 3) {
            return ctx.getChild(1).accept(this);
        }
        return ctx.accept(this);
    }

    @Override
    public Ast visitTypeIdCreate(exprParser.TypeIdCreateContext ctx) {
        Ast typeid = ctx.getChild(0).accept(this);
        ParseTree typeidprime = ctx.getChild(1);
        Ast returnAst = new StrNode("error");
        switch (typeidprime.getChild(0).toString()) {
            case "{":
                returnAst = new RecCreate(typeid, typeidprime.accept(this));
                break;
            case "[":
                Ast expr1 = typeidprime.getChild(1).accept(this);
                Ast expr2 = typeidprime.getChild(4).accept(this);
                returnAst = new ArrayCreate(typeid, expr1, expr2);
                break;
            default:
                break;
        }
        return returnAst;

    }

    @Override
    public Ast visitIfThen(exprParser.IfThenContext ctx) {
        Ast condition = ctx.getChild(1).accept(this);
        Ast thenBlock = ctx.getChild(3).accept(this);
        return new IfThen(condition, thenBlock);
    }

    @Override
    public Ast visitIfThenElse(exprParser.IfThenElseContext ctx) {
        Ast condition = ctx.getChild(1).accept(this);
        Ast thenBlock = ctx.getChild(3).accept(this);
        Ast elseBlock = ctx.getChild(5).accept(this);
        return new IfThenElse(condition, thenBlock, elseBlock);
    }

    @Override
    public Ast visitWhile(exprParser.WhileContext ctx) {
        While tant_que = new While(ctx.getChild(1).accept(this), ctx.getChild(3).accept(this));
        return tant_que;
    }

    @Override
    public Ast visitFor(exprParser.ForContext ctx) {
        String idf = ctx.getChild(1).toString();
        StrNode str = new StrNode(idf);
        Ast expr1 = ctx.getChild(3).accept(this);
        Ast expr2 = ctx.getChild(5).accept(this);
        Ast expr3 = ctx.getChild(7).accept(this);
        return new For(str, expr1, expr2, expr3);
    }

    @Override
    public Ast visitBreak(exprParser.BreakContext ctx) {
        return ctx.accept(this);
    }

    @Override
    public Ast visitLetInEnd(exprParser.LetInEndContext ctx) {

        Declaration_list declaration_list = new Declaration_list();
        for (int i = 0; i < ctx.getChild(1).getChildCount(); i++) {
            declaration_list.addDeclaration(ctx.getChild(1).getChild(i).accept(this));
        }
        if (ctx.getChildCount() == 5) {
            LetInEnd letinend = new LetInEnd(declaration_list, ctx.getChild(3).accept(this));
            return letinend;
        }
        return new LetInEnd(declaration_list);
    }

    @Override
    public Ast visitPrint(exprParser.PrintContext ctx) {
        return new Print(new StrNode(ctx.getChild(2).toString()));
    }

    @Override
    public Ast visitRecCreate(exprParser.RecCreateContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Ast visitArrayCreate(exprParser.ArrayCreateContext ctx) {
        return visitChildren(ctx);
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
        LvalueInit id = new LvalueInit(new StrNode(idStr));
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
        // ParseTree premier = ctx.getChild(0);
        // ParseTree suivant = ctx.getChild(1);
        // ArrayList<Ast> list = new ArrayList<>();

        // list.add(new StrNode(premier.toString()));
        // list.add(new StrNode(suivant.getChild(1).toString()));

        ParseTree premier = ctx.getChild(0);
        ParseTree suivant = ctx.getChild(1);

        if (suivant.getChildCount() == 0) {
            return new LvalueInit(new StrNode(premier.toString()));
        }

        ArrayList<Ast> list = new ArrayList<>();
        boolean printed = false;
        while (suivant.getChildCount() != 0) {
            switch (suivant.getChild(0).toString()) {
                case ".":
                    if (!printed) {
                        list.add(new StrNode(premier.toString()));
                    }
                    printed = false;
                    premier = suivant.getChild(1);
                    suivant = suivant.getChild(2);
                    break;
                case "[":
                    Ast subscript = suivant.getChild(1).accept(this);
                    String typeOfLast;
                    if (list.size() > 0) {
                        typeOfLast = list.get(list.size() - 1).getClass().getName();
                    } else {
                        typeOfLast = "None";
                    }
                    if (typeOfLast.equals("ast.LvalueSub")) {
                        LvalueSub lastSubList = (LvalueSub) list.get(list.size() - 1);
                        lastSubList.successiveSub.add(subscript);
                    } else {
                        ArrayList<Ast> successiveSub = new ArrayList<>();
                        successiveSub.add(subscript);
                        LvalueSub sub = new LvalueSub(premier.toString(), successiveSub);
                        list.add(sub);
                        printed = true;
                    }
                    suivant = suivant.getChild(3);
                    break;
                default:
                    break;
            }
        }
        list.add(new StrNode(premier.toString()));
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

        DecType decType = new DecType(ctx.getChild(1).accept(this), ctx.getChild(3).accept(this));
        return decType;
    }

    @Override
    public Ast visitTypeId(exprParser.TypeIdContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitRecType(exprParser.RecTypeContext ctx) {
        if (ctx.getChildCount() == 3) {
            return ctx.getChild(1).accept(this);
        }
        return ctx.accept(this);
    }

    @Override
    public Ast visitArrayType(exprParser.ArrayTypeContext ctx) {
        return new ArrayTypeNode(ctx.getChild(2).accept(this));
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
        Ast id1 = new StrNode(ctx.getChild(0).toString());
        Ast id2 = ctx.getChild(2).accept(this);
        return new TypeField(id1, id2);
    }

    @Override
    public Ast visitType_id(exprParser.Type_idContext ctx) {
        return new StrNode(ctx.getChild(0).toString());
    }

    @Override
    public Ast visitDecVarTypeNotSpec(exprParser.DecVarTypeNotSpecContext ctx) {
        String idf = ctx.getChild(1).toString();
        StrNode str = new StrNode(idf);
        Ast expr = ctx.getChild(3).accept(this);
        return new DecVarTypeNotSpec(idf, expr);

    }

    @Override
    public Ast visitDecVarTypeSpec(exprParser.DecVarTypeSpecContext ctx) {
        String idf1 = ctx.getChild(1).toString();
        StrNode str1 = new StrNode(idf1);
        String idf2 = ctx.getChild(0).getChild(0).toString();
        StrNode str2 = new StrNode(idf2);
        Ast expr = ctx.getChild(5).accept(this);
        return new DecVarTypeSpec(str1, str2, expr);
    }

    @Override
    public Ast visitDecFunctVoid(exprParser.DecFunctVoidContext ctx) {
        String idf = ctx.getChild(1).toString();
        if (ctx.getChildCount() == 7) {
            Ast type_field_list = ctx.getChild(3).accept(this);
            Ast expr = ctx.getChild(6).accept(this);
            return new DecFunctVoid(str, type_field_list, expr);
        }
        Ast expr = ctx.getChild(5).accept(this);
        return new DecFunctVoid(str, expr);

    }

    @Override
    public Ast visitDecFunctWithReturnType(exprParser.DecFunctWithReturnTypeContext ctx) {
        String idf1 = ctx.getChild(1).toString();
        if (ctx.getChildCount() == 9) {
            Ast type_field_list = ctx.getChild(3).accept(this);
            String idf2 = ctx.getChild(6).getChild(0).toString();
            StrNode str2 = new StrNode(idf2);
            Ast expr = ctx.getChild(8).accept(this);
            return new DecFunctWithReturnType(str1, type_field_list, str2, expr);
        }
        String idf2 = ctx.getChild(5).getChild(0).toString();
        StrNode str2 = new StrNode(idf2);
        Ast expr = ctx.getChild(7).accept(this);
        return new DecFunctWithReturnType(str1, expr, str2, expr);
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
                default:
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
                default:
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
                default:
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitPred_4(exprParser.Pred_4Context ctx) {
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
                default:
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
                default:
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitRec_negate(exprParser.Rec_negateContext ctx) {
        int j = 0;

        int size = ctx.getChildCount();
        String g = ctx.getChild(j).toString();
        while ((j < size) && (g.equals("-"))) {

            j++;
            g = ctx.getChild(j).toString();

        }
        if (j < size) {

            Negate_instruction p = new Negate_instruction(ctx.getChild(j).accept(this));

            return p;

        }
        return null;

    }

    @Override
    public Ast visitExpression(exprParser.ExpressionContext ctx) {

        return ctx.getChild(1).accept(this);

    }

    @Override
    public Ast visitInteger(exprParser.IntegerContext ctx) {
        int p = Integer.parseInt(ctx.getChild(0).toString());
        IntNode a = new IntNode(p);
        return a;

    }

}
