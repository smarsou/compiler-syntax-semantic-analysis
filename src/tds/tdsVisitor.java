package tds;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

import javax.lang.model.type.ArrayType;

import org.antlr.v4.parse.ANTLRParser.ruleEntry_return;

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

    public ArrayList<Tds> tdsGlobal = new ArrayList<>(); // La liste de toutes les TDS
    public Stack<Integer> pileRO = new Stack<>(); // La pile des régions ouverte;

    public void printTDS(){
        tdsGlobal.remove(0);
        System.out.println(ANSI_PURPLE + "TDS");
        for (Tds tds : tdsGlobal){
            System.out.println(ANSI_PURPLE + "------------------------------");
            System.out.println("|Région: " + tds.numRegion + " |Imbric: " + tds.numImbrication + "| Père: " +tds.pere);
            for (Entry e : tds.rows){
               
                if (e.getClass().getName() == "tds.Var"){
                    System.out.println(ANSI_CYAN+ "| Var  | "+e.getName()+" | " +((Var) e).valeur.toString());
                }
                if (e.getClass().getName() == "tds.Type"){
                    System.out.println(ANSI_CYAN+ "| Type | "+e.getName()+" | "+((Type) e).typeDeType);
                }
            }
            System.out.println(ANSI_PURPLE+"------------------------------" + ANSI_RESET);
            System.out.println();
        }
    }

    public void createNewTds() {
        int currentRegion = pileRO.peek();
        int newRegion = tdsGlobal.size();
        int numImbrication = pileRO.size()-1;
        Tds tds = new Tds(newRegion, numImbrication, currentRegion);
        pileRO.push(newRegion);
        tdsGlobal.add(tds);
    }

    @Override
    public Result visit(RecField affect) {
        // Field names, expression types, and the order thereof must exactly
        // match those of the given record type.
        String idf = affect.idf.accept(this).strValue;
        Result expr = affect.expression.accept(this); 
        String type = affect.lvTname.accept(this).strValue;

        Result r = new Result();

        //l'entrée existe car elle a été vérifié dans RecFieldList
        Entry e = findEntryByName(type, pileRO.peek());
        Type entry = (Type) e;
        String typeDeExpr = expr.typeName;

        String typeOfIdf = entry.typeFieldDict.get(idf);
        if (typeOfIdf != typeDeExpr){
            System.err.println(ANSI_RED + "Type Error: type mismatch " + typeOfIdf + "/" +typeDeExpr +ANSI_RESET);
            return r;
        }
        r.typeName = typeOfIdf;
        r.objValue = expr.objValue;
        
        return r;
    }

    @Override
    public Result visit(DecFunctWithReturnType dec) {
        // On créer une nouvelle entrée et on l'ajoute à la TDS du bloc courant
        Fonction func = new Fonction(dec.idf1.name, dec.type_id.name);
        Tds currentTds = tdsGlobal.get(tdsGlobal.size() - 1);
        currentTds.addEntry(func);

        // On créer une nouvelle tds pour la déclaration de la fonction
        createNewTds();

        // On ajoute cette Tds à l'entrée
        int numRegiontTds = tdsGlobal.get(tdsGlobal.size() - 1).numRegion;
        func.setTds(numRegiontTds);

        // On visit le bloc de la fonction
        Result res = dec.expr.accept(this);

        // TODO Controle sémantique pour vérifier si l'exp correspond au type de retour

        // On revient au père
        pileRO.pop();

        return res;
    }

    @Override
    public Result visit(DecFunctVoid dec) {
        // On créer une nouvelle entrée et on l'ajoute à la TDS du bloc courant
        Fonction func = new Fonction(dec.idf.name, "void");
        Tds currentTds = tdsGlobal.get(tdsGlobal.size() - 1);
        currentTds.addEntry(func);

        // On créer une nouvelle tds pour la déclaration de la fonction
        createNewTds();

        // On ajoute cette Tds à l'entrée
        int numRegiontTds = tdsGlobal.get(tdsGlobal.size() - 1).numRegion;
        func.setTds(numRegiontTds);

        // On visit le bloc de la fonction
        Result res = dec.expr.accept(this);

        // On revient au père
        pileRO.pop();

        // La sémantique dit que la déclaration de la fonction ne renvoie rien
        return res;
    }

    @Override
    public Result visit(LetInEnd dec) {
        // On créer une nouvelle TDS pour le nouveau bloc d'environnement
        createNewTds();
        Result result = new Result();
        // On visit tout le LetInEnd
        dec.declaration_list.accept(this);
        if (dec.exprseq != null){
            result = dec.exprseq.accept(this);
        }
        // Quand on a terminé de visiter le LetInEnd, on revient chez le père
        pileRO.pop();
        return result;
    }

    @Override
    public Result visit(DecVarTypeSpec dec) {
        // TODO controle sémantique pour vérifier si l'exp correspond au type
        Result result = dec.expr.accept(this);

        // On créer une nouvelle entrée
        Var var = new Var(dec.idf1.name, dec.idf2.name);

        // On ajoute l'entrée à la TDS courante
        Tds currentTds = tdsGlobal.get(tdsGlobal.size() - 1);
        currentTds.addEntry(var);

        Result res = new Result();
        res.typeName = "void";
        return res;
    }

    @Override
    public Result visit(DecVarTypeNotSpec dec) {
        // On récupère le resultat de l'expression
        Result result = dec.expr.accept(this);

        // On créer une nouvelle entrée
        Var var = new Var(dec.idf.name, result.typeName, result.objValue);

        // On ajoute l'entrée à la TDS courante
        System.out.println("Sommet de pile: "+pileRO.peek());
        Tds currentTds = tdsGlobal.get(pileRO.peek());
        currentTds.addEntry(var);

        Result res = new Result();
        res.typeName = "void";
        return res;
    }

    @Override
    public Result visit(TypeField dec) {
        return new Result();
    }

    @Override
    public Result visit(DecType dec) {

        // On créer une nouvelle entrée
        Type type = new Type(dec.idf.accept(this).strValue, dec.type.accept(this).strValue);

        // On ajoute l'entrée à la TDS courante
        Tds currentTds = tdsGlobal.get(pileRO.peek());
        currentTds.addEntry(type);
        
        return new Result();
    }

    @Override
    public Result visit(Declaration_list dec) {
        for (Ast a : dec.declarationList) {
            a.accept(this);
        }
        return new Result();
    }

    @Override
    public Result visit(LvalueSub dec) {
        // l'index expr doit de type int
        // l'identifiant de la lvalue doit être de type array
        // le résultat doit avoit le même type que les éléments de la lvalue qui est de
        // type array
        Result r = new Result();
        r.strValue = dec.id;
        r.typeName = "LvalueSub";
        ArrayList<Result> a = new ArrayList<>();
        for (Ast d : dec.successiveSub){
            if (d.accept(this).typeName != "int"){
                System.err.println(ANSI_RED + "Subscript Error: Not an Integer"  + ANSI_RESET);
            }
            a.add(d.accept(this));
        }
        r.subscript = a;

        return r;

    }

    @Override
    public Result visit(ArrayCreate a) {
        // The type of the Id must refer to an array type.
        // The expression in square brackets must be int, and
        // the expression after of must match the element
        // type of the array. The result type is the array type.
        Result res = new Result();

        Result expr1 = a.expr1.accept(this);
        if (expr1.typeName != "int"){
            System.err.println(ANSI_RED+"Can't create Array because it's not an integer in []" +ANSI_RESET);
            return res;
        }
        res.typeName = "array";
        Array tableau = new Array();
        
        Result second = a.expr2.accept(this);
        if (second.typeName == "int"){
            tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.intValue );
        }
        if (second.typeName == "array"){
            tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.ar );
            res.ar = tableau;
        }
        if (second.typeName == "rec"){
            tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.rc);
        }

        res.ar = tableau;
        res.objValue = tableau;

        return res;

    }

    @Override
    public Result visit(RecCreate a) {
    
        Result res = new Result();
        res.typeName = "rec";
    
        Rec rc = new Rec();
        rc.type_id = a.typeid.accept(this).name;
        for (Result r : a.fieldList.accept(this).recFieldList){
            rc.dict.put(r.typeName, r.objValue);
        }
        res.rc = rc;
        res.objValue = rc;
        return res;
        // The tyId(type of the id) must refer to a record type,
        // and the order, names, and types of fields must
        // match. The result type is the record type.

    }

    @Override
    public Result visit(For f) {
        
        //On créer une nouvelle TDS
        createNewTds();
        
        //On créer l'entrée pour la variable d'increment
        Var increment = new Var(f.idf.name, "int");
        //On ajoute en entrée la variable d'incrment
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(increment);

        //TODO: COntroles sémantiques
        // The start and end index must be of type int. The variable is of type int and
        // must not be
        // assigned to in the body. The body must be of type
        // void. The result type is void.
        
        //On parcours la boucle for et on récupère les infos du resultat dans Result. (on peut ajouter des attributs à Result si necessaire)
        Result r = f.expr3.accept(this);
        


        Result c = f.expr1.accept(this);
        Result l = f.expr2.accept(this);

        if (c.typeName == "int" && l.typeName == "int") {
            if (r.typeName != "void") {
                System.err.println(
                        ANSI_RED + "Type Error: The body must be of type void" + ANSI_RESET);
            }
        } 
        else {
                System.err.println(
                        ANSI_RED + "Type Error: The start and end index of boucle for must be of type int" + ANSI_RESET);
        }

        //On remonte dans le bloc père
        pileRO.pop();

        return r;

    }

    @Override
    public Result visit(While d) {

        // On créer une nouvelle TDS
        createNewTds();

        // TODO: COntrole sémantique 1
        // The condition type must be int
        Result c = d.expr1.accept(this);

        // On parcours la boucle while et on récupère le type de retour
        Result r = d.expr2.accept(this);

        // TODO: COntrole sémantqie 2
        // The body type must be void. En gros c'est le Result r qui doit être de type
        // void je crois


        if (c.typeName == "int"){
            if (r.typeName != "void"){
                System.err.println(ANSI_RED + "Type Error: The body type must be void" + ANSI_RESET);
            }
        }
        
        else{
            System.err.println(
                ANSI_RED + "Type Error: The condition type must be int" + ANSI_RESET);
        }

        // On remonte dans le bloc père
        pileRO.pop();

        return r;

    }

    @Override
    public Result visit(LvalueAffect d) {
        // l'identifiant et l'expression doivent avoir le même type
        Result res = new Result();
        Result lv = d.lvalue.accept(this);
        Result expr = d.lvalue_call_or_declare.accept(this);
        if (!lv.lvalueCorrect){
            System.err.println(ANSI_RED + "Affect Error: Can't find variable" + ANSI_RESET);
            return res;
        }
        if (lv.lvalueType != expr.typeName){
            System.err.println(ANSI_RED + "Affect Error: Type mismatch "+ lv.lvalueType + "/" + expr.typeName + ANSI_RESET);
            return res;
        }
        Rec nR = new Rec();
        nR.dict.put(lv.varIdf, lv.varObject);
        checkLvalue(nR, lv.linkToLvalue, expr.objValue, false);
        return res;
    }

    @Override
    public Result visit(StrNode d) {
        Result r = new Result();
        r.typeName = "string";
        r.strValue = d.name;
        r.objValue = d.name;
        return r;
    }

    @Override
    public Result visit(ArrayTypeNode n) {
        return null;
    }

    @Override
    public Result visit(CallExpr d) {
        // The identifier must refer to a function.
        // The number and types of actual and formal parameters must be the same. The
        // type of the call is
        // the return type of the function
        return null;
    }

    @Override
    public Result visit(Program d) {
        Tds tds = new Tds(0, 0, -1);
        pileRO.push(0);
        tdsGlobal.add(tds);
        for (Ast ast : d.exprList) {
            if (ast != null) {
                ast.accept(this);
            } else {
                System.out.println("EOF");
            }
        }
        return new Result();
    }

    @Override
    public Result visit(Precedence_1 mult) {
        // les opérands et le résultat doivent être de type int
        Result l = mult.left.accept(this);
        Result r = mult.right.accept(this);
        Result n = new Result();
        n.typeName = "int"; 
        if (l.typeName == "int" && r.typeName == "int"){
            n.intValue = l.intValue*r.intValue;
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(
                        ANSI_RED + "Type Error: Left side of the multiplication is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int") {
                System.err.println(
                        ANSI_RED + "Type Error: Right side of the multiplication is not of type int" + ANSI_RESET);
            }
            return n;
        }
        // Result l = mult.left.accept(this);
        // Result r = mult.right.accept(this);
        // if (l.typeName == "int" && r.typeName == "int"){
        // Result n = new Result();
        // n.intValue = l.intValue*r.intValue;
        // n.typeName = "int";
        // n.name = "Precedence_1";
        // return n;
        // }else{
        // Result n = new Result();
        // int leftSideOfOp=1;
        // int rightSideOfOp=1;
        // if (l.typeName != "int"){
        // System.err.println("Type Error: Left side of the operation is not of type
        // int");
        // }else{
        // leftSideOfOp = l.intValue;
        // }
        // if (r.typeName != "int"){
        // System.err.println("Type Error: Right side of the operation is not of type
        // int");
        // }else{
        // leftSideOfOp = r.intValue;
        // }
        // n.intValue = leftSideOfOp * rightSideOfOp;
        // return n;
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
            n.intValue = l.intValue+r.intValue;
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int") {
                System.err.println(ANSI_RED + "\u001B[33m Type Error: Right side of the operation is not of type int"
                        + ANSI_RESET);
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
        if (l.typeName == r.typeName) {
            return n;
        } else {
            System.err.println(ANSI_RED + "Type Error: Not the same type for operands" + ANSI_RESET);
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
        if (l.typeName == "int" && r.typeName == "int") {
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int") {
                System.err
                        .println(ANSI_RED + "Type Error: Right side of the operation is not of type int" + ANSI_RESET);
            }
            return n;
        }
    }

    @Override
    public Result visit(Or or) {
        // les opérands et le résultat doivent être de type int
        Result l = or.left.accept(this);
        Result r = or.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        if (l.typeName == "int" && r.typeName == "int") {
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int") {
                System.err
                        .println(ANSI_RED + "Type Error: Right side of the operation is not of type int" + ANSI_RESET);
            }
            return n;
        }
    }

    @Override
    public Result visit(Sup_equal supeq) {
        // les opérands doivent avoir le même type et le résultat doit être de type int
        Result l = supeq.left.accept(this);
        Result r = supeq.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            return n;

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET);

        }
        return n;

    }

    @Override
    public Result visit(Inf_equal infeq) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int
        Result l = infeq.left.accept(this);
        Result r = infeq.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                return n;
            } else if (l.typeName.equals("string")) {
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET);
            return n;

        }

    }

    @Override
    public Result visit(Superior sup) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int
        Result l = sup.left.accept(this);
        Result r = sup.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                return n;
            } else if (l.typeName.equals("string")) {
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET);
            return n;

        }

    }

    @Override
    public Result visit(Inferior inf) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int
        Result l = inf.left.accept(this);
        Result r = inf.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                return n;
            } else if (l.typeName.equals("string")) {
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET);
            return n;

        }

    }

    @Override
    public Result visit(Sup_inf sinf) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int
        Result l = sinf.left.accept(this);
        Result r = sinf.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                return n;
            } else if (l.typeName.equals("string")) {
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET);
            return n;

        }
    }

    @Override
    public Result visit(Negate_instruction Ni) {
        // l'opérand et le résultat sont de type int
        Result Ne= Ni.exp.accept(this);
        Result n = new Result();
        n.typeName = Ne.typeName; 
        if (Ne.typeName == "int"){
            return n;
        }else{
            System.err.println(ANSI_RED+"Type Error: The operand type is not int"+ANSI_RESET);
            return n;
        }

    }

    @Override
    public Result visit(IfThen ifThen) {
        // The condition type must be int, and the
        // then-clause must be of type void. The result type
        // is also void
        Result c = ifThen.condition.accept(this);
        Result b = ifThen.thenBlock.accept(this);
        if (c.typeName == "int"){
            if (b.typeName == "void"){
                return b;
            }
            else{
                System.err.println(ANSI_RED+"Type Error: The then-clause must be of type void"+ANSI_RESET);
                return b;
            }
        }
        else{
            System.err.println(ANSI_RED+"Type Error: The condition type must be int"+ANSI_RESET);
            return b;
        }

    }

    @Override
    public Result visit(IfThenElse ifThenElse) {
        // The condition type must be int, and
        // the then-clause and else-clause must have the same
        // type, which becomes the result type
        Result c = ifThenElse.condition.accept(this);
        Result t = ifThenElse.thenBlock.accept(this);
        Result e = ifThenElse.elseBlock.accept(this);
        Result n = new Result();
        n.thenBlock = t;
        n.elseBlock= e;
        if (c.typeName == "int"){
            if (t.typeName == e.typeName){
                n.typeName = t.typeName;
                return n;
            }
            else{
                System.err.println(ANSI_RED+"The then-clause and else-clause must have the same type"+ANSI_RESET);
                return n;
            }
        }

        else{
            System.err.println(ANSI_RED+"Type Error: The condition type must be int"+ANSI_RESET);
            return n;
        }
    }

    @Override
    public Result visit(Divide divide) {
        // les opérands et le résultat doivent être de type int
        Result l = divide.left.accept(this);
        Result r = divide.right.accept(this);
        Result n = new Result();
        n.typeName = "int"; 
        if (l.typeName == "int" && r.typeName == "int"){
            if (r.intValue==0){
                System.err.println(ANSI_RED + "Divide by zero error !" + ANSI_RESET);
                return n;
            }
            n.intValue = l.intValue/r.intValue;
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Left side of the division is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Right side of the division is not of type int" + ANSI_RESET);
            }
            return n;
        }
    }

    @Override
    public Result visit(ExprSeq exprseq) {
        // If the sequence is empty, the type is void,
        // otherwise, the type is that of the last expression
        Result r = new Result();
        if (exprseq.astList.size()==0){
            r.typeName ="void";
            return r;
        }
        for (Ast a : exprseq.astList){
            r = a.accept(this);
        }
        return r;
    }

    @Override
    public Result visit(ExprList exprlist) {
        return null;
    }

    @Override
    public Result visit(TypeFieldList typeFieldList) {
        return null;
    }

    @Override
    public Result visit(RecFieldList recFieldList) {
        Result res = new Result();
        String type = recFieldList.type.accept(this).strValue;

        Entry e = findEntryByName(type, pileRO.peek());
        if (e==null){
            System.err.println(ANSI_RED + "Type Not found Error: "+ type +" doesn't exist." +ANSI_RESET);
            return res;
        }
        if (e.getClass().getName() != "tds.Type"){
            System.err.println(ANSI_RED + "Type Not found Error: "+ type +" is the name of a variable or un function." +ANSI_RESET);
            return res;
        }
        Type entry = (Type) e;
        if (entry.typeDeType != "rectype"){
            System.err.println(ANSI_RED + "Type Error: "+type + " is not a type with child types." +ANSI_RESET);
            return res;
        }
        ArrayList<Result> recFLRes = new ArrayList<>();
        for (Ast a : recFieldList.astList){
            recFLRes.add(a.accept(this));
        } 
        res.recFieldList = recFLRes;
        return res;

    }

    @Override
    public Result visit(LvalueInit lvalueInit) {

        //l'identifiant doit référencer une variable
            // On récupère l'identifiant de la lvalue
            Ast a = lvalueInit.lvalue.get(0);
            Result r = a.accept(this);
            Result returnRes = new Result();
            String idf = r.strValue;
            // On cherche dans la tds cette variable
            Entry e = findEntryByName(idf, pileRO.peek());
            //Si on ne trouve pas cette idf
            if (e == null){
                System.err.println(ANSI_RED + "Variable Not Found: "+ idf+" doesn't exist" +ANSI_RESET);
                returnRes.lvalueCorrect = false;
                return returnRes;
            }
            //Si ce n'est pas une variable
            if (e.getClass().getName() != "tds.Var"){
                System.err.println(ANSI_RED + "Variable Not Found: "+ idf +" is not a variable " +ANSI_RESET);
                returnRes.lvalueCorrect = false;
                return returnRes;
            }
            //Si on a trouvé cette lvalue, on la parcours en entier pour vérifier qu'elle existe
            Rec nR = new Rec();
            nR.dict.put(idf, ((Var) e).valeur);
            Object res = checkLvalue(nR, lvalueInit.lvalue, null, true);
            if (res == null){
                returnRes.lvalueCorrect = false;
                return returnRes;
            }
            returnRes.lvalueCorrect = true;
            returnRes.lvalueObject = res;
            returnRes.lvalueType = res.getClass().getName();
            returnRes.linkToLvalue = lvalueInit.lvalue;
            returnRes.varObject = ((Var) e).valeur;
            returnRes.varIdf = idf;
            return returnRes;

    }

    public Object checkLvalue(Object obj, ArrayList<Ast> lvalue, Object affect, Boolean print){
        if (lvalue.size()==0){
            if (affect != null){
                obj = affect;
            }
            return obj;
        }
        Result current = lvalue.get(0).accept(this);
        String id = current.strValue; // QUe ce soit une LvalueSub ou un StrNode, on récupère l'id
        // Si l'objet pdans lequel on cherche la suite de la lvalue n'est pas un Rec, cela veut dire que c'est forcément un entier, donc qu'il ne possède pas de sous idf
        if (obj.getClass().getName()!="tds.Rec"){
            if (print){
            System.err.println(ANSI_RED + "Variable Not Found: "+ id +" can't be find because father doesn't have children" +ANSI_RESET);
            }
            return null;
        }
        // ON récupère l'obj correspondant à l'id
        Object next = getSubObjInRec(id, (Rec) obj, print);
        if (next == null){
            return null;
        }
        //Si c'est une StrNode, on cherche la suite de la lvalue dans l'obj trouvé
        if (current.typeName == "String"){
            lvalue.remove(0);
            return checkLvalue(next, lvalue, affect, print);
        }
        // Si c'est une Lvalsub, on vérifie que tout est bien subscriptable
        if (current.typeName == "LvalueSub"){
                // Une lvalueSub est forcément un array
            ArrayList<Result> sub = current.subscript;
            for (Result s: sub){
                if (next.getClass().getName() == "tds.Array"){
                    next = getSubObjInArray(s.intValue, (Array) obj, print);
                    if (next == null){
                        return null;
                    }
                }
                else{
                    if (print){
                    System.err.println(ANSI_RED + "Variable Subscript Error: "+ id +" not subscriptable." +ANSI_RESET);
                    }
                    return null;
                }
            }
             // puis on cherche la suite de la lvalue dans l'obj trouvé
            lvalue.remove(0);
            return checkLvalue(next, lvalue, affect,print);
        }
        if (print){
        System.err.println(ANSI_YELLOW + "Erreur bizarre dans Lvalue:current is not LvalueSub nor String " +ANSI_RESET);
        }
        return false;
    }

    public Object getSubObjInRec(String name, Rec rec, Boolean print){
        if (rec.dict.containsKey(name)){
            return rec.dict.get(name);
        }else{
            if (print){
            System.err.println(ANSI_RED + "Variable Error: "+ name + " is not a child of the variable" +ANSI_RESET);
            }
            return null;
        }
    }
    public Object getSubObjInArray(Integer i, Array tab, Boolean print){
        if (i == null){
            if (print){
            System.err.println(ANSI_RED + "Variable Error: subscript value was not initialized" +ANSI_RESET);
            }
            return null;
        }
        if (i>=tab.size){
            if (print){
            System.err.println(ANSI_RED + "Index out of bounds" +ANSI_RESET);
            }
            return null;
        }
        return tab.values[i];
        
    }

    public Entry findEntryByName(String id, int tdsStartIndex){

        int tdsIndex = tdsStartIndex;
        Tds currentTds = tdsGlobal.get(tdsIndex);

        while (tdsIndex != 0){

            tdsIndex = currentTds.numRegion;
            // Je cherche dans la TDS si le nom existe de la variable
            Entry e = findEntryInTds(id, tdsIndex);      

            if (e == null){
                // Si ce n'est pas le cas je passe à la TDS père
                currentTds = tdsGlobal.get(currentTds.pere);
            }
            else{
                // Sinon je prends le premier venu
                return e;
            }
        }
        // Si je ne trouve rien, je renvoie null
        return null;

    }

    
    public Entry findEntryInTds(String id, int tdsIndex){
        Tds currentTds = tdsGlobal.get(tdsIndex);
        String idf;
        Entry goodOne;
        for (Entry e : currentTds.rows){
            idf = e.getName();
            if (idf == id){
                goodOne = e;
                return goodOne;
            }
        }
        return null;
    }

    @Override
    public Result visit(IntNode intNode) {
        Result r = new Result();
        r.typeName = "int";
        r.intValue = intNode.value;
        r.objValue = intNode.value;
        return r;
    }

    @Override
    public Result visit(Minus minus) {
        // les opérands et le résultat doivent être de type int
        Result l = minus.left.accept(this);
        Result r = minus.right.accept(this);
        Result n = new Result();
        n.typeName = "int"; 
        if (l.typeName == "int" && r.typeName == "int"){
            n.intValue = l.intValue-r.intValue;
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET);
            }
            if (r.typeName != "int") {
                System.err.println(ANSI_RED + "\u001B[33m Type Error: Right side of the operation is not of type int"
                        + ANSI_RESET);
            }
            return n;
        }

    }

    @Override
    public Result visit(Print print) {
        // l'argument doit être de type string
        return null;
    }
    @Override
    public Result visit(Entry e) {
        // TODO Auto-generated method stub
        return null;
    }

}
