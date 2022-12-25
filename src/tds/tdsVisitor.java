package tds;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

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

public class tdsVisitor implements AstVisitor<String> {

    private ArrayList<Tds> tdsGlobal; // La liste de toutes les TDS
    private Stack pileRO; // La pile des régions ouvertes
    private TDS currentTDS;

    @Override
    public String visit(RecField affect) {
        // Field names, expression types, and the order thereof must exactly
        // match those of the given record type.

    }

    @Override
    public String visit(DecFunctWithReturnType dec) {
        currentTDS.add(/* entry */)
        TDS tds = new TDS(/*region*/, /*imbrication*/);
    }

    @Override
    public String visit(DecFunctVoid dec) {
        currentTDS.add(/* entry */)
        TDS tds = new TDS(/*region*/, /*imbrication*/);
    }

    @Override
    public String visit(LetInEnd dec) {

        currentTDS.add(/* entry */)
        TDS tds = new TDS(/*region*/, /*imbrication*/);
        //change currentTDS
    }

    @Override
    public String visit(DecVarTypeSpec dec) {
        currentTDS.add(/* entry */)
    }

    @Override
    public String visit(DecVarTypeNotSpec dec) {
        currentTDS.add(/* entry */)
    }

    @Override
    public String visit(TypeField dec) {

    }

    @Override
    public String visit(DecType dec) {

    }

    @Override
    public String visit(Declaration_list dec) {

    }

    @Override
    public String visit(LvalueSub dec) {
        // l'index expr doit de type int
        // l'identifiant de la lvalue doit être de type array
        // le résultat doit avoit le même type que les éléments de la lvalue qui est de
        // type array
    }

    @Override
    public String visit(ArrayCreate a) {
        // The type of the Id must refer to an array type.
        // The expression in square brackets must be int, and
        // the expression after of must match the element
        // type of the array. The result type is the array type.

    }

    @Override
    public String visit(RecCreate a) {
        // The tyId(type of the id) must refer to a record type,
        // and the order, names, and types of fields must
        // match. The result type is the record type.

    }

    @Override
    public String visit(For f) {
        // The start and end index must be of type int. The variable is of type int and
        // must not be
        // assigned to in the body. The body must be of type
        // void. The result type is void.

    }

    @Override
    public String visit(While d) {
        // The condition type must be int, and the
        // body type must be void. The result type is void.

    }

    @Override
    public String visit(LvalueAffect d) {
        // l'identifiant et l'expression doivent avoir le même type

    }

    @Override
    public String visit(StrNode d) {

    }

    @Override
    public String visit(ArrayTypeNode n) {

    }

    @Override
    public String visit(CallExpr d) {
        // The identifier must refer to a function.
        // The number and types of actual and formal parameters must be the same. The
        // type of the call is
        // the return type of the function

    }

    @Override
    public String visit(Program d) {
        TDS tds = new TDS(/*region*/, /*imbrication*/);
    }

    @Override
    public String visit(Precedence_1 mult) {
        // les opérands et le résultat doivent être de type int

    }

    @Override
    public String visit(Precedence_2 plus) {
        // les opérands et le résultat doivent être de type int

    }

    @Override
    public String visit(Precedence_3 equal) {
        // les opérands doivent avoir le même type et le résultat doit être de type int

    }

    @Override
    public String visit(Precedence_4 and) {
        // les opérands et le résultat doivent être de type int

    }

    @Override
    public String visit(Or or) {
        // les opérands et le résultat doivent être de type int

    }

    @Override
    public String visit(Sup_equal supeq) {
        // les opérands doivent avoir le même type et le résultat doit être de type int

    }

    @Override
    public String visit(Inf_equal infeq) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int

    }

    @Override
    public String visit(Superior sup) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int

    }

    @Override
    public String visit(Inferior inf) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int

    }

    @Override
    public String visit(Sup_inf sinf) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int

    }

    @Override
    public String visit(Negate_instruction Ni) {
        // l'opérand et le résultat sont de type int

    }

    @Override
    public String visit(IfThen ifThen) {
        // The condition type must be int, and the
        // then-clause must be of type void. The result type
        // is also void

    }

    @Override
    public String visit(IfThenElse ifThenElse) {
        // The condition type must be int, and
        // the then-clause and else-clause must have the same
        // type, which becomes the result type

    }

    @Override
    public String visit(Divide divide) {
        // les opérands et le résultat doivent être de type int

    }

    @Override
    public String visit(ExprSeq exprseq) {
        // If the sequence is empty, the type is void,
        // otherwise, the type is that of the last expression

    }

    @Override
    public String visit(ExprList exprlist) {

    }

    @Override
    public String visit(TypeFieldList typeFieldList) {

    }

    @Override
    public String visit(RecFieldList recFieldList) {
        // Field names, expression types, and the order thereof must exactly
        // match those of the given record type.

    }

    @Override
    public String visit(LvalueInit lvalueInit) {
        // l'identifiant doit référencer une variable

    }

    @Override
    public String visit(IntNode intNode) {

    }

    @Override
    public String visit(Minus minus) {
        // les opérands et le résultat doivent être de type int

    }

    @Override
    public String visit(Print print) {
        // l'argument doit être de type string

    }

}
