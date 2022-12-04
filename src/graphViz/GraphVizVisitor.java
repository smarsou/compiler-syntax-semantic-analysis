package graphViz;

import java.io.FileOutputStream;
import java.io.IOException;

import ast.RecField;
import ast.Ast;
import ast.AstVisitor;
import ast.Couple;
import ast.Divide;
import ast.LvalueInit;
import ast.LvalueSub;
import ast.ExprSeq;
import ast.ExprList;
import ast.RecFieldList;
import ast.StrNode;
import ast.TypeFieldList;

import ast.IfThen;
import ast.IfThenElse;

import ast.IntNode;
import ast.Minus;
import ast.Precedence_1;
import ast.Precedence_2;
import ast.Precedence_3;
import ast.Precedence_4;
import ast.Negate_instruction;
import ast.Minus;
import ast.Or;
import ast.Inf_equal;
import ast.Sup_equal;
import ast.Sup_inf;
import ast.Superior;
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

        this.addNode(nodeIdentifier, "Affect");
        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, expressionState);

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

        String leftState = Ni.instruction.accept(this);

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
        this.addNode(nodeIdentifier, leftstate);
        this.addNode(nodeIdentifier, rightstate);
        return nodeIdentifier;

    }

    @Override
    public String visit(ExprSeq exprseq) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "ExprSeq");

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

        for (Object obj : lvalueInit.lvalue) {
            if (obj.getClass().getName().equals("LvalueSub")) {
                String astState = ((Ast) obj).accept(this);
                this.addTransition(nodeIdentifier, astState);
            } else {
                StrNode strN = new StrNode((String) obj);
                String astState = strN.accept(this);
                this.addTransition(nodeIdentifier, astState);
            }
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
    /*
     * @Override
     * public String visit(Print print) {
     * 
     * String nodeIdentifier = this.nextState();
     * 
     * String valueState = print.value.accept(this);
     * 
     * this.addNode(nodeIdentifier, "print");
     * this.addTransition(nodeIdentifier, valueState);
     * 
     * return nodeIdentifier;
     * 
     * }
     * 
     * @Override
     * public String visit(Program program) {
     * 
     * String nodeIdentifier = this.nextState();
     * 
     * String instructionsState = program.instructions.accept(this);
     * 
     * this.addNode(nodeIdentifier, "Program");
     * this.addTransition(nodeIdentifier, instructionsState);
     * 
     * return nodeIdentifier;
     * 
     * }
     */

}
