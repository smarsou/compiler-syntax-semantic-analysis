package tds;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
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
import tds.Result;

import tds.Exceptions.*;


public class tdsVisitor implements AstVisitor<Result> {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private ArrayList<Tds> tdsGlobal = new ArrayList<>(); // La liste de toutes les TDS
    private Stack<Integer> pileRO = new Stack<>(); // La pile des régions ouverte;

    public void createNewTds(){
        int currentRegion = pileRO.peek();
        int newRegion = tdsGlobal.size();
        int numImbrication = pileRO.size();
        Tds tds = new Tds(newRegion, numImbrication, currentRegion);
        pileRO.push(newRegion);
        tdsGlobal.add(tds);
    }

    @Override
    public String visit(RecField affect) {
        // Field names, expression types, and the order thereof must exactly
        // match those of the given record type.

    }

    @Override
    public String visit(DecFunctWithReturnType dec) {
        //On créer une nouvelle entrée et on l'ajoute à la TDS du bloc courant
        Fonction func = new Fonction(dec.idf1.name, dec.type_id.name);
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(func);
        
        //On créer une nouvelle tds pour la déclaration de la fonction
        createNewTds();
        
        //On ajoute cette Tds à l'entrée
        int numRegiontTds = tdsGlobal.get(tdsGlobal.size()-1).numRegion;
        func.setTds(numRegiontTds);
        
        //On visit le bloc de la fonction
        String retourDeExpr = dec.expr.accept(this);
 
        //TODO Controle sémantique pour vérifier si l'exp correspond au type de retour

        //On revient au père
        pileRO.pop();
        
        return "NoReturn";
    }

    @Override
    public String visit(DecFunctVoid dec) {
        //On créer une nouvelle entrée et on l'ajoute à la TDS du bloc courant
        Fonction func = new Fonction(dec.idf.name, "void");
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(func);
        
        //On créer une nouvelle tds pour la déclaration de la fonction
        createNewTds();
        
        //On ajoute cette Tds à l'entrée
        int numRegiontTds = tdsGlobal.get(tdsGlobal.size()-1).numRegion;
        func.setTds(numRegiontTds);

        //On visit le bloc de la fonction
        dec.expr.accept(this);
 
        //On revient au père
        pileRO.pop();
        
        //La sémantique dit que la déclaration de la fonction ne renvoie rien
        return "NoReturn";
    }

    @Override
    public String visit(LetInEnd dec) {
        // On créer une nouvelle TDS pour le nouveau bloc d'environnement
        createNewTds();

        //On visit tout le LetInEnd
        dec.declaration_list.accept(this);
        String retourOfLastInstruction = dec.exprseq.accept(this);


        //Quand on a terminé de visiter le LetInEnd, on revient chez le père
        pileRO.pop();
        return retourOfLastInstruction;
    }

    @Override
    public String visit(DecVarTypeSpec dec) {
        //TODO controle sémantique pour vérifier si l'exp correspond au type
        String retourOfExpr = dec.expr.accept(this);

        //On créer une nouvelle entrée
        Var var = new Var(dec.idf1.name, dec.idf2.name, retourOfExpr);

        //On ajoute l'entrée à la TDS courante
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(var);

        return "NoReturn";
    }

    @Override
    public String visit(DecVarTypeNotSpec dec) {
        String retourOfExpr = dec.expr.accept(this);

        //On créer une nouvelle entrée
        Var var = new Var(dec.idf.name, "NoType", retourOfExpr);

        //On ajoute l'entrée à la TDS courante
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(var);
        
        return "NoReturn";
    }

    @Override
    public String visit(TypeField dec) {

    }

    @Override
    public String visit(DecType dec) {

        //On créer une nouvelle entrée
        Type type = new Type(dec.idf.accept(this), dec.type.accept(this));

        //On ajoute l'entrée à la TDS courante
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(type);
        
        return "NoReturn";
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
    public Object visit(Program d) {
        Tds tds = new Tds(0,0,-1);
        pileRO.push(0);
        tdsGlobal.add(tds);
        return "Program";
    }

    @Override
    public Result visit(Precedence_1 mult){
        // les opérands et le résultat doivent être de type int
        Result l = mult.left.accept(this);
        Result r = mult.right.accept(this);
        Result n = new Result();
        n.typeName = "int"; 
        if (l.typeName == "int" && r.typeName == "int"){
            return n;
        }else{
            if (l.typeName != "int"){
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int"){
                System.err.println(ANSI_RED + "Type Error: Right side of the operation is not of type int" + ANSI_RESET);
            }
            return n;
        }
        // Result l = mult.left.accept(this);
        // Result r = mult.right.accept(this);
        // if (l.typeName == "int" && r.typeName == "int"){
        //     Result n = new Result();
        //     n.intValue = l.intValue*r.intValue;
        //     n.typeName = "int"; 
        //     n.name = "Precedence_1";
        //     return n;
        // }else{
        //     Result n = new Result();
        //     int leftSideOfOp=1;
        //     int rightSideOfOp=1;
        //     if (l.typeName != "int"){
        //         System.err.println("Type Error: Left side of the operation is not of type int");
        //     }else{
        //         leftSideOfOp = l.intValue;
        //     }
        //     if (r.typeName != "int"){
        //         System.err.println("Type Error: Right side of the operation is not of type int");
        //     }else{
        //         leftSideOfOp = r.intValue;
        //     }
        //     n.intValue = leftSideOfOp * rightSideOfOp;
        //     return n;
        // }
    }

    @Override
    public Result visit(Precedence_2 plus) {
        // les opérands et le résultat doivent être de type int
        Result l = plus.left.accept(this);
        Result r = plus.right.accept(this);
        Result n = new Result();
        n.typeName = "int"; 
        if (l.typeName == "int" && r.typeName == "int"){
            return n;
        }else{
            if (l.typeName != "int"){
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" +ANSI_RESET);
            }
            if (r.typeName != "int"){
                System.err.println(ANSI_RED+"\u001B[33m Type Error: Right side of the operation is not of type int"+ANSI_RESET);
            }
            return n;
        }
    }

    @Override
    public Result visit(Precedence_3 equal) {
        // les opérands doivent avoir le même type et le résultat doit être de type int
        Result l = equal.left.accept(this);
        Result r = equal.right.accept(this);
        Result n = new Result();
        n.typeName = l.typeName; 
        if (l.typeName == r.typeName){
            return n;
        }else{
            System.err.println(ANSI_RED+"Type Error: Not the same type for operands"+ANSI_RESET);
            return n;
        }
    }

    @Override
    public Result visit(Precedence_4 and) {
        // les opérands et le résultat doivent être de type int
        Result l = and.left.accept(this);
        Result r = and.right.accept(this);
        Result n = new Result();
        n.typeName = "int"; 
        if (l.typeName == "int" && r.typeName == "int"){
            return n;
        }else{
            if (l.typeName != "int"){
                System.err.println(ANSI_RED+"Type Error: Left side of the operation is not of type int"+ANSI_RESET);
            }
            if (r.typeName != "int"){
                System.err.println(ANSI_RED+"Type Error: Right side of the operation is not of type int"+ANSI_RESET);
            }
            return n;
        }
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
