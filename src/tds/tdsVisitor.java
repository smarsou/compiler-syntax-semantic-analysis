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

    private ArrayList<Tds> tdsGlobal; //La liste de toutes les TDS
    private Stack pileRO;  // La pile des régions ouvertes
    private TDS currentTDS;

    @Override
    public String visit(RecField affect) {
        //Controle sémantique de type
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

    }

    @Override
    public String visit(ArrayCreate a) {

    }

    @Override
    public String visit(RecCreate a) {

    }   

    @Override
    public String visit(For f) {

    }

    @Override
    public String visit(While d) {

    }

    @Override
    public String visit(LvalueAffect d) {

    }

    @Override
    public String visit(StrNode d) { 

    }

    @Override
    public String visit(ArrayTypeNode n) {
        
    }

    @Override
    public String visit(CallExpr d) {

    }

    @Override
    public String visit(Program d) {
        TDS tds = new TDS(/*region*/, /*imbrication*/);
    }

    @Override
    public String visit(Precedence_1 mult) {

    }

    @Override
    public String visit(Precedence_2 plus) {

    }

    @Override
    public String visit(Precedence_3 equal) {

    }

    @Override
    public String visit(Precedence_4 and) {

    }

    @Override
    public String visit(Or or) {

    }

    @Override
    public String visit(Sup_equal supeq) {

    }

    @Override
    public String visit(Inf_equal infeq) {

    }

    @Override
    public String visit(Superior sup) {

    }

    @Override
    public String visit(Inferior inf) {

    }

    @Override
    public String visit(Sup_inf sinf) {

    }

    @Override
    public String visit(Negate_instruction Ni) {

    }

    @Override
    public String visit(IfThen ifThen) {


    }

    @Override
    public String visit(IfThenElse ifThenElse) {


    }

    @Override
    public String visit(Divide divide) {
        

    }

    @Override
    public String visit(ExprSeq exprseq) {


    }

    @Override
    public String visit(ExprList exprlist) {


    }

    @Override
    public String visit(TypeFieldList typeFieldList) {

    }

    @Override
    public String visit(RecFieldList recFieldList) {


    }

    @Override
    public String visit(LvalueInit lvalueInit) {

    }

    @Override
    public String visit(IntNode intNode) {

    }

    @Override
    public String visit(Minus minus) {


    }

    @Override
    public String visit(Print print) {

    }

}
