package graphViz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.type.ArrayType;

import ast.RecField;
import ast.ArrayCreate;
import ast.ArrayTypeNode;
import ast.Ast;
import ast.AstVisitor;
import ast.CallExpr;
import ast.Couple;
import ast.DecFunctVoid;
import ast.DecFunctWithReturnType;
import ast.DecType;
import ast.DecVarTypeNotSpec;
import ast.DecVarTypeSpec;
import ast.Declaration_list;
import ast.Divide;
import ast.LvalueInit;
import ast.LvalueSub;
import ast.ExprSeq;
import ast.For;
import ast.ExprList;
import ast.RecFieldList;
import ast.StrNode;
import ast.TypeFieldList;
import ast.While;
import tds.Entry;
import ast.IfThen;
import ast.IfThenElse;

import ast.IntNode;
import ast.LetInEnd;
import ast.LvalueAffect;
import ast.Minus;
import ast.Precedence_1;
import ast.Precedence_2;
import ast.Precedence_3;
import ast.Precedence_4;
import ast.Print;
import ast.Program;
import ast.RecCreate;
import ast.Negate_instruction;
import ast.Minus;
import ast.Or;
import ast.Inf_equal;
import ast.Sup_equal;
import ast.Sup_inf;
import ast.Superior;
import ast.TypeField;
import ast.Inferior;
import ast.Divide;

public class GraphVizVisitor implements AstVisitor<String> {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;

    public GraphVizVisitor() {
        this.state = 0;
        this.nodeBuffer = "digraph \"ast\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
        this.linkBuffer = "\n";
    }

    public void dumpGraph(String filepath) throws IOException {

        FileOutputStream output = new FileOutputStream(filepath);

        String buffer = this.nodeBuffer + this.linkBuffer;
        byte[] strToBytes = buffer.getBytes();

        output.write(strToBytes);

        output.close();

    }

    private String nextState() {
        int returnedState = this.state;
        this.state++;
        return "N" + returnedState;
    }

    private void addTransition(String from, String dest) {
        this.linkBuffer += String.format("\t%s -> %s; \n", from, dest);

    }

    private void addNode(String node, String label) {
        this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node, label);

    }

    @Override
    public String visit(RecField affect) {

        String nodeIdentifier = this.nextState();

        String idfState = affect.idf.accept(this);
        String expressionState = affect.expression.accept(this);

        this.addNode(nodeIdentifier, "AffectVarInType");
        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, expressionState);

        return nodeIdentifier;

    }

    @Override
    public String visit(DecFunctWithReturnType dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "DecFuncVoid");
        String idf1 = dec.idf1.accept(this);
        this.addTransition(nodeIdentifier, idf1);
        String type_id = dec.type_id.accept(this);
        String expr = dec.expr.accept(this);
        this.addTransition(nodeIdentifier, idf1);
        if (dec.type_field_list != null){
            String typefield = dec.type_field_list.accept(this);
            this.addTransition(nodeIdentifier, typefield);
        }
        this.addTransition(nodeIdentifier, type_id);
        this.addTransition(nodeIdentifier, expr);
        return nodeIdentifier;
    }

    @Override
    public String visit(DecFunctVoid dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "DecFuncVoid");
        String idf1 = dec.idf.accept(this);
        String expr = dec.expr.accept(this);
        this.addTransition(nodeIdentifier, idf1);
        if (dec.type_field_list != null){
            String typefield = dec.type_field_list.accept(this);
            this.addTransition(nodeIdentifier, typefield);
        }
        this.addTransition(nodeIdentifier, expr);
        return nodeIdentifier;

    }

    @Override
    public String visit(DecVarTypeSpec dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Dec_Var_Spec");
        String idf1 = dec.idf1.accept(this);
        String idf2 = dec.idf2.accept(this);

        this.addTransition(nodeIdentifier, idf1);
        this.addTransition(nodeIdentifier, idf2);
        return nodeIdentifier;

    }

    @Override
    public String visit(DecVarTypeNotSpec dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Dec_Var");
        String idf = dec.idf.accept(this);
        String expr = dec.expr.accept(this);

        this.addTransition(nodeIdentifier, idf);
        this.addTransition(nodeIdentifier, expr);
        return nodeIdentifier;
    }

    @Override
    public String visit(TypeField dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "TypeField");
        this.addTransition(nodeIdentifier, dec.idf1.accept(this));
        this.addTransition(nodeIdentifier, dec.idf2.accept(this));
        return nodeIdentifier;

    }

    @Override
    public String visit(DecType dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "DecType");
        String id = dec.idf.accept(this);
        String type = dec.type.accept(this);

        this.addTransition(nodeIdentifier, id);
        this.addTransition(nodeIdentifier, type);
        return nodeIdentifier;
    }

    @Override
    public String visit(Declaration_list dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "DeclarationList");
        for (Ast a : dec.declarationList) {
            String declar = a.accept(this);
            this.addTransition(nodeIdentifier, declar);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(LvalueSub dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, dec.id);

        for (Ast sub : dec.successiveSub) {
            String node = sub.accept(this);
            this.addTransition(nodeIdentifier, node);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(ArrayCreate a) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "ArrayCreate");

        String typeid = a.typeid.accept(this);
        String expr1 = a.expr1.accept(this);
        String expr2 = a.expr2.accept(this);

        this.addTransition(nodeIdentifier, typeid);
        this.addTransition(nodeIdentifier, expr1);
        this.addTransition(nodeIdentifier, expr2);

        return nodeIdentifier;

    }

    @Override
    public String visit(RecCreate a) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "RecCreate");

        String typeid = a.typeid.accept(this);
        String fieldList = a.fieldList.accept(this);

        this.addTransition(nodeIdentifier, typeid);
        this.addTransition(nodeIdentifier, fieldList);

        return nodeIdentifier;

    }

    @Override
    public String visit(LetInEnd dec) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "LetInEnd");
        String letin = dec.declaration_list.accept(this);
        this.addTransition(nodeIdentifier, letin);
        if (dec.exprseq != null) {
            String inEnd = dec.exprseq.accept(this);
            this.addTransition(nodeIdentifier, inEnd);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(For f) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "For");     
        String idfState = f.idf.accept(this);
        this.addTransition(nodeIdentifier, idfState);
        String expr1State = f.expr1.accept(this);
        this.addTransition(nodeIdentifier, expr1State);
        String expr2State = f.expr2.accept(this);
        this.addTransition(nodeIdentifier, expr2State);
        String expr3State = f.expr3.accept(this);
        this.addTransition(nodeIdentifier, expr3State);
        return nodeIdentifier;

    }

    @Override
    public String visit(While d) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "While");
        String expr1 = d.expr1.accept(this);
        this.addTransition(nodeIdentifier, expr1);
        String expr2 = d.expr2.accept(this);
        this.addTransition(nodeIdentifier, expr2);
        return nodeIdentifier;

    }

    @Override
    public String visit(LvalueAffect d) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "AffectLvalue");
        String leftState = d.lvalue.accept(this);
        this.addTransition(nodeIdentifier, leftState);
        String rightState = d.lvalue_call_or_declare.accept(this);
        this.addTransition(nodeIdentifier, rightState);
        return nodeIdentifier;

    }

    @Override
    public String visit(StrNode d) {

        String nodeIdentifier = this.nextState();
        String str = d.name;
        if (d.name.charAt(0) == '\"') {
            str = d.name.substring(1, d.name.length() - 1);
            str = "\\\"" + str + "\\\"";
        }
        this.addNode(nodeIdentifier, str);
        return nodeIdentifier;

    }

    @Override
    public String visit(ArrayTypeNode n) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "ArrayType");
        String type = n.arrayType.accept(this);
        this.addTransition(nodeIdentifier, type);
        return nodeIdentifier;
    }

    @Override
    public String visit(CallExpr d) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "CallExpr");

        String id = d.idf.accept(this);
        String exprLst = d.exprList.accept(this);

        this.addTransition(nodeIdentifier, id);
        this.addTransition(nodeIdentifier, exprLst);
        return nodeIdentifier;

    }

    @Override
    public String visit(Program d) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Program");

        for (Ast ast : d.exprList) {
            if (ast != null) {
                String astState = ast.accept(this);
                this.addTransition(nodeIdentifier, astState);
            } else {
                System.out.println("EOF");
            }

        }
        return nodeIdentifier;

    }

    @Override
    public String visit(Precedence_1 mult) {

        String nodeIdentifier = this.nextState();

        String leftState = mult.left.accept(this);
        String rightState = mult.right.accept(this);

        this.addNode(nodeIdentifier, "*");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Precedence_2 plus) {

        String nodeIdentifier = this.nextState();

        String leftState = plus.left.accept(this);
        String rightState = plus.right.accept(this);

        this.addNode(nodeIdentifier, "+");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Precedence_3 equal) {

        String nodeIdentifier = this.nextState();

        String leftState = equal.left.accept(this);
        String rightState = equal.right.accept(this);

        this.addNode(nodeIdentifier, "=");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Precedence_4 and) {

        String nodeIdentifier = this.nextState();

        String leftState = and.left.accept(this);
        String rightState = and.right.accept(this);

        this.addNode(nodeIdentifier, "&");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Or or) {

        String nodeIdentifier = this.nextState();

        String leftState = or.left.accept(this);
        String rightState = or.right.accept(this);

        this.addNode(nodeIdentifier, "|");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Sup_equal supeq) {

        String nodeIdentifier = this.nextState();

        String leftState = supeq.left.accept(this);
        String rightState = supeq.right.accept(this);

        this.addNode(nodeIdentifier, ">=");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Inf_equal infeq) {

        String nodeIdentifier = this.nextState();

        String leftState = infeq.left.accept(this);
        String rightState = infeq.right.accept(this);

        this.addNode(nodeIdentifier, "<=");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Superior sup) {

        String nodeIdentifier = this.nextState();

        String leftState = sup.left.accept(this);
        String rightState = sup.right.accept(this);

        this.addNode(nodeIdentifier, ">");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Inferior inf) {

        String nodeIdentifier = this.nextState();

        String leftState = inf.left.accept(this);
        String rightState = inf.right.accept(this);

        this.addNode(nodeIdentifier, "<");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Sup_inf sinf) {

        String nodeIdentifier = this.nextState();

        String leftState = sinf.left.accept(this);
        String rightState = sinf.right.accept(this);

        this.addNode(nodeIdentifier, "<>");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Negate_instruction Ni) {

        String nodeIdentifier = this.nextState();

        String leftState = Ni.exp.accept(this);

        this.addNode(nodeIdentifier, "Negate");

        this.addTransition(nodeIdentifier, leftState);

        return nodeIdentifier;
    }

    @Override
    public String visit(IfThen ifThen) {

        String nodeIdentifier = this.nextState();

        String conditionState = ifThen.condition.accept(this);
        String thenBlockState = ifThen.thenBlock.accept(this);

        this.addNode(nodeIdentifier, "IfThen");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);

        return nodeIdentifier;

    }

    @Override
    public String visit(IfThenElse ifThenElse) {

        String nodeIdentifier = this.nextState();

        String conditionState = ifThenElse.condition.accept(this);
        String thenBlockState = ifThenElse.thenBlock.accept(this);
        String elseBlockState = ifThenElse.elseBlock.accept(this);

        this.addNode(nodeIdentifier, "IfThenElse");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);
        this.addTransition(nodeIdentifier, elseBlockState);

        return nodeIdentifier;

    }

    @Override
    public String visit(Divide divide) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "/");

        String leftstate = divide.left.accept(this);
        String rightstate = divide.right.accept(this);

        this.addTransition(nodeIdentifier, leftstate);
        this.addTransition(nodeIdentifier, rightstate);

        return nodeIdentifier;

    }

    @Override
    public String visit(ExprSeq exprseq) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "ExprSeq");
        System.out.println(exprseq.astList.size());
        for (Ast ast : exprseq.astList) {
            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(ExprList exprlist) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "ExprList");

        for (Ast ast : exprlist.astList) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(TypeFieldList typeFieldList) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "TypeFieldList");

        for (Ast ast : typeFieldList.astList) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(RecFieldList recFieldList) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "RecFieldList");

        for (Ast ast : recFieldList.astList) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(LvalueInit lvalueInit) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Lvalue");

        for (Ast obj : lvalueInit.lvalue) {
            String astState = obj.accept(this);
            this.addTransition(nodeIdentifier, astState);
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(IntNode intNode) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, String.valueOf(intNode.value));

        return nodeIdentifier;

    }

    @Override
    public String visit(Minus minus) {

        String nodeIdentifier = this.nextState();

        String leftState = minus.left.accept(this);
        String rightState = minus.right.accept(this);

        this.addNode(nodeIdentifier, "-");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(Print print) {

        String nodeIdentifier = this.nextState();

        String valueState = print.str.accept(this);

        this.addNode(nodeIdentifier, "Print");

        this.addTransition(nodeIdentifier, valueState);

        return nodeIdentifier;

    }


    @Override
    public String visit(Entry e) {
        // TODO Auto-generated method stub
        return null;
    }

}
