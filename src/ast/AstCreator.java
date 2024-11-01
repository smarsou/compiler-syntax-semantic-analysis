package ast;

import java.util.ArrayList;

import javax.lang.model.type.ArrayType;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.exprBaseVisitor;
import parser.exprParser;

public class AstCreator extends exprBaseVisitor<Ast> {
    public static int counter;

    @Override
    public Ast visitProgram(exprParser.ProgramContext ctx) {
        int line = ctx.getStart().getLine();
        Program exprList = new Program(line);

        for (int i = 0; i < ctx.getChildCount(); i++) {
            exprList.exprList.add(ctx.getChild(i).accept(this));
        }

        return exprList;
    }

    @Override
    public Ast visitExpr(exprParser.ExprContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitNil(exprParser.NilContext ctx) {
        int line = ctx.getStart().getLine();
        String nil = ctx.getChild(0).toString();
        return new StrNode(nil, line);
    }

    @Override
    public Ast visitCallExpr(exprParser.CallExprContext ctx) {
        int line = ctx.getStart().getLine();
        String idf = ctx.getChild(0).toString();
        StrNode str = new StrNode(idf, line);
        if (ctx.getChildCount() == 4) {
            Ast expr_list = ctx.getChild(2).accept(this);
            return new CallExpr(str, expr_list, line);
        }
        return new CallExpr(str, line);
    }

    @Override
    public Ast visitString(exprParser.StringContext ctx) {
        int line = ctx.getStart().getLine();
        String idf = ctx.getChild(0).toString();
        return new StrNode(idf, line);
    }

    // @Override
    // public Ast visitLvalue_call_or_declare(exprParser.StringContext ctx) {
    // String idf = ctx.getChild(0).toString();
    // return new StrNode(idf);
    // }

    @Override
    public Ast visitLvalueExpr(exprParser.LvalueExprContext ctx) {
        Ast lvalue = ctx.getChild(0).accept(this);
        int line = ctx.getStart().getLine();
        if (ctx.getChild(1).accept(this) != null) {
            Ast lvalue_call_or_declare = ctx.getChild(1).accept(this);
            return new LvalueAffect(lvalue, lvalue_call_or_declare, line);
        }
        return new LvalueInit((LvalueInit) lvalue, line);
    }

    @Override
    public Ast visitParenthesis(exprParser.ParenthesisContext ctx) {
        if (ctx.getChildCount() == 3) {
            return ctx.getChild(1).accept(this);
        }
        return visitChildren(ctx);
    }

    @Override
    public Ast visitTypeIdCreate(exprParser.TypeIdCreateContext ctx) {
        int line = ctx.getStart().getLine();
        Ast typeid = ctx.getChild(0).accept(this);
        ParseTree typeidprime = ctx.getChild(1);
        Ast returnAst = new StrNode("error", line);
        switch (typeidprime.getChild(0).toString()) {
            case "{":
                returnAst = new RecCreate(typeid, typeidprime.accept(this), line);
                break;
            case "[":
                Ast expr1 = typeidprime.getChild(1).accept(this);
                Ast expr2 = typeidprime.getChild(4).accept(this);
                returnAst = new ArrayCreate(typeid, expr1, expr2, line);
                break;
            default:
                break;
        }
        return returnAst;

    }

    @Override
    public Ast visitIfThen(exprParser.IfThenContext ctx) {
        int line = ctx.getStart().getLine();
        Ast condition = ctx.getChild(1).accept(this);
        Ast thenBlock = ctx.getChild(3).accept(this);
        return new IfThen(condition, thenBlock, line);
    }

    @Override
    public Ast visitIfThenElse(exprParser.IfThenElseContext ctx) {
        int line = ctx.getStart().getLine();
        Ast condition = ctx.getChild(1).accept(this);
        Ast thenBlock = ctx.getChild(3).accept(this);
        Ast elseBlock = ctx.getChild(5).accept(this);
        return new IfThenElse(condition, thenBlock, elseBlock, line);
    }

    @Override
    public Ast visitWhile(exprParser.WhileContext ctx) {
        int line = ctx.getStart().getLine();
        While tant_que = new While(ctx.getChild(1).accept(this), ctx.getChild(3).accept(this), line);
        return tant_que;
    }

    @Override
    public Ast visitFor(exprParser.ForContext ctx) {
        int line = ctx.getStart().getLine();
        String idf = ctx.getChild(1).toString();
        StrNode str = new StrNode(idf, line);
        Ast expr1 = ctx.getChild(3).accept(this);
        Ast expr2 = ctx.getChild(5).accept(this);
        Ast expr3 = ctx.getChild(7).accept(this);
        return new For(str, expr1, expr2, expr3, line);
    }

    @Override
    public Ast visitBreak(exprParser.BreakContext ctx) {
        int line = ctx.getStart().getLine();
        return new Break(line);
    }

    @Override
    public Ast visitLetInEnd(exprParser.LetInEndContext ctx) {
        int line = ctx.getStart().getLine();
        Declaration_list declaration_list = new Declaration_list(line);
        for (int i = 0; i < ctx.getChild(1).getChildCount(); i++) {
            declaration_list.addDeclaration(ctx.getChild(1).getChild(i).accept(this));
        }
        if (ctx.getChildCount() == 5) {
            LetInEnd letinend = new LetInEnd(declaration_list, ctx.getChild(3).accept(this), line);
            return letinend;
        }
        return new LetInEnd(declaration_list, line);
    }

    @Override
    public Ast visitPrint(exprParser.PrintContext ctx) {
        int line = ctx.getStart().getLine();
        return new Print(new StrNode(ctx.getChild(2).toString(),line), line);
    }

    @Override
    public Ast visitRecCreate(exprParser.RecCreateContext ctx) {
        int line = ctx.getStart().getLine();
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Ast visitArrayCreate(exprParser.ArrayCreateContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Ast visitExprSeqInit(exprParser.ExprSeqInitContext ctx) {
        int line = ctx.getStart().getLine();
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new ExprSeq(liste, line);
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
        int line = ctx.getStart().getLine();
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new ExprList(liste, line);
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
        int line = ctx.getStart().getLine();
        String idStr = ctx.getChild(0).toString();
        ParserRuleContext ps = ctx.getParent().getParent();
        for (int i =0; i<counter; i++){
            ps = ps.getParent();
        }
        Ast lvalueTypeName = ps.getChild(0).accept(this);
        StrNode id = new StrNode(idStr, line);
        Ast exp = ctx.getChild(2).accept(this);
        return new RecField(id, exp, lvalueTypeName, line);
    }

    @Override
    public Ast visitRecFieldListInit(exprParser.RecFieldListInitContext ctx) {
        int line = ctx.getStart().getLine();
        counter = 1;
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            counter = counter +1;
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        Ast type = ctx.getParent().getParent().getChild(0).accept(this);
        counter = 0;
        return new RecFieldList(liste, type, line);
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
        int line = ctx.getStart().getLine();
        ParseTree premier = ctx.getChild(0);
        ParseTree suivant = ctx.getChild(1);
        String last = "";
        if (suivant.getChildCount() == 0) {
            return new LvalueInit(new StrNode(premier.toString(), line),line);
        }

        ArrayList<Ast> list = new ArrayList<>();
        boolean printed = false;
        while (suivant.getChildCount() != 0) {
            switch (suivant.getChild(0).toString()) {
                case ".":
                    last =".";
                    if (!printed) {
                        list.add(new StrNode(premier.toString(), line));
                    }
                    printed = false;
                    premier = suivant.getChild(1);
                    suivant = suivant.getChild(2);
                    break;
                case "[":
                    last="[";
                    Ast subscript = suivant.getChild(1).accept(this);
                    String typeOfLast;
                    if (list.size() > 0) {
                        typeOfLast = list.get(list.size() - 1).getClass().getName();
                    } else {
                        typeOfLast = "None";
                    }
                    if (typeOfLast.equals("ast.LvalueSub") && printed) {
                        LvalueSub lastSubList = (LvalueSub) list.get(list.size() - 1);
                        lastSubList.successiveSub.add(subscript);
                    } else {
                        ArrayList<Ast> successiveSub = new ArrayList<>();
                        successiveSub.add(subscript);
                        LvalueSub sub = new LvalueSub(premier.toString(), successiveSub, line);
                        list.add(sub);
                        printed = true;
                    }
                    suivant = suivant.getChild(3);
                    break;
                default:
                    break;
            }
        }
        // System.out.println(last);
        if (last!="["){
            list.add(new StrNode(premier.toString(), line));
        }
        // for (Ast a : list){
        //     // System.out.println(a);
        // }
        return new LvalueInit(list, list, line);
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
        int line = ctx.getStart().getLine();
        Declaration_list declarationList = new Declaration_list(line);

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
        int line = ctx.getStart().getLine();
        DecType decType = new DecType(ctx.getChild(1).accept(this), ctx.getChild(3).accept(this), line);
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
        int line = ctx.getStart().getLine();
        return new ArrayTypeNode(ctx.getChild(2).accept(this), line);
    }

    @Override
    public Ast visitTypeFieldListInit(exprParser.TypeFieldListInitContext ctx) {
        int line = ctx.getStart().getLine();
        ArrayList<Ast> liste = new ArrayList<Ast>();
        liste.add(ctx.getChild(0).accept(this));
        ParseTree suivant = ctx.getChild(1);
        while (suivant.getChildCount() != 0) {
            Ast a = suivant.getChild(1).accept(this);
            liste.add(a);
            suivant = suivant.getChild(2);
        }
        return new TypeFieldList(liste, line);
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
        int line = ctx.getStart().getLine();
        Ast id1 = new StrNode(ctx.getChild(0).toString(), line);
        Ast id2 = ctx.getChild(2).accept(this);
        return new TypeField(id1, id2, line);
    }

    @Override
    public Ast visitType_id(exprParser.Type_idContext ctx) {
        int line = ctx.getStart().getLine();
        return new StrNode(ctx.getChild(0).toString(), line);
    }

    @Override
    public Ast visitDecVarTypeNotSpec(exprParser.DecVarTypeNotSpecContext ctx) {
        int line = ctx.getStart().getLine();
        String idf = ctx.getChild(1).toString();
        StrNode str = new StrNode(idf, line);
        Ast expr = ctx.getChild(3).accept(this);
        return new DecVarTypeNotSpec(str, expr, line);

    }

    @Override
    public Ast visitDecVarTypeSpec(exprParser.DecVarTypeSpecContext ctx) {
        int line = ctx.getStart().getLine();
        String idf1 = ctx.getChild(1).toString();
        StrNode str1 = new StrNode(idf1, line);
        String idf2 = ctx.getChild(3).getChild(0).toString();
        StrNode str2 = new StrNode(idf2, line);
        Ast expr = ctx.getChild(5).accept(this);
        return new DecVarTypeSpec(str1, str2, expr, line);
    }

    @Override
    public Ast visitDecFunctVoid(exprParser.DecFunctVoidContext ctx) {
        int line = ctx.getStart().getLine();
        String idf = ctx.getChild(1).toString();
        StrNode str = new StrNode(idf, line);
        if (ctx.getChildCount() == 7) {
            Ast type_field_list = ctx.getChild(3).accept(this);
            Ast expr = ctx.getChild(6).accept(this);
            return new DecFunctVoid(str, type_field_list, expr, line);
        }
        Ast expr = ctx.getChild(5).accept(this);
        return new DecFunctVoid(str, null, expr, line);

    }

    @Override
    public Ast visitDecFunctWithReturnType(exprParser.DecFunctWithReturnTypeContext ctx) {
        int line = ctx.getStart().getLine();
        String idf1 = ctx.getChild(1).toString();
        StrNode str1 = new StrNode(idf1, line);
        if (ctx.getChildCount() == 9) {
            Ast type_field_list = ctx.getChild(3).accept(this);
            String idf2 = ctx.getChild(6).getChild(0).toString();
            StrNode str2 = new StrNode(idf2, line);
            Ast expr = ctx.getChild(8).accept(this);
            return new DecFunctWithReturnType(str1, type_field_list, str2, expr, line);
        }
        String idf2 = ctx.getChild(5).getChild(0).toString();
        StrNode str2 = new StrNode(idf2, line);
        Ast expr = ctx.getChild(7).accept(this);
        return new DecFunctWithReturnType(str1, expr, str2, expr, line);
    }

    @Override
    public Ast visitBinary_operation(exprParser.Binary_operationContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitPrecedence_1(exprParser.Precedence_1Context ctx) {
        int line = ctx.getStart().getLine();
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "*":
                    ntmp = new Precedence_1(ntmp, right, line);
                    break;
                case "/":
                    ntmp = new Divide(ntmp, right, line);
                    break;
                default:
                    break;

            }

        }

        return ntmp;
    }

    @Override
    public Ast visitPrecedence_2(exprParser.Precedence_2Context ctx) {
        
        int line = ctx.getStart().getLine();
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "+":
                    ntmp = new Precedence_2(ntmp, right, line);
                    break;
                case "-":
                    ntmp = new Minus(ntmp, right, line);
                    break;
                default:
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitPrecedence_3(exprParser.Precedence_3Context ctx) {
        int line = ctx.getStart().getLine();
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "=":
                    ntmp = new Precedence_3(ntmp, right, line);
                    break;
                case "<>":
                    ntmp = new Sup_inf(ntmp, right, line);
                    break;
                case ">":
                    ntmp = new Superior(ntmp, right, line);
                    break;
                case "<":
                    ntmp = new Inferior(ntmp, right, line);
                    break;
                case ">=":
                    ntmp = new Sup_equal(ntmp, right, line);
                    break;
                case "<=":
                    ntmp = new Inf_equal(ntmp, right, line);
                    break;
                default:
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitPrecedence_4(exprParser.Precedence_4Context ctx) {
        int line = ctx.getStart().getLine();
        Ast ntmp = ctx.getChild(0).accept(this);
        for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {
            String op = ctx.getChild(2 * i + 1).toString();
            Ast right = ctx.getChild(2 * (i + 1)).accept(this);
            switch (op) {
                case "&":
                    ntmp = new Precedence_4(ntmp, right, line);
                    break;
                case "|":
                    ntmp = new Or(ntmp, right, line);
                    break;
                default:
                    break;

            }

        }

        return ntmp;

    }

    @Override
    public Ast visitInteger(exprParser.IntegerContext ctx) {
        int line = ctx.getStart().getLine();
        int p = Integer.parseInt(ctx.getChild(0).toString());
        IntNode a = new IntNode(p, line);
        return a;

    }

    @Override
    public Ast visitNegate_instruction(exprParser.Negate_instructionContext ctx) {
        int line = ctx.getStart().getLine();
        Ast instrs;
        if (ctx.getChildCount() == 2) {
            instrs = ctx.getChild(1).accept(this);
            return new Negate_instruction(instrs, line);

        } else {
            instrs = ctx.getChild(0).accept(this);
            return instrs;

        }

    }

}
