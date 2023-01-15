package tds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.lang.model.type.ArrayType;
import javax.swing.plaf.synth.SynthScrollBarUI;

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

public class tdsVisitor implements AstVisitor<Result>{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_TAB = "    ";
    private String file;
    private ArrayList<String> lignes;

    public ArrayList<Tds> tdsGlobal = new ArrayList<>(); // La liste de toutes les TDS
    public Stack<Integer> pileRO = new Stack<>(); // La pile des régions ouverte;

    public tdsVisitor(String testFile) {
        this.file = testFile;
        this.lignes = new ArrayList<String>();
        this.setLines();
    }

   

    public void printTDS() {
        tdsGlobal.remove(0);
        System.out.println(ANSI_PURPLE + "TDS");
        for (Tds tds : tdsGlobal){
            System.out.println(ANSI_TAB+ ANSI_PURPLE + "------------------------------");
            System.out.println(ANSI_TAB+"|Région: " + tds.numRegion + " |Imbric: " + tds.numImbrication + "| Père: " +tds.pere);
            for (Entry e : tds.rows){
                // System.out.println("entree est " + ((Var) e).type);
                if (e.getClass().getName() == "tds.Var"){
                    System.out.println(ANSI_TAB + ANSI_CYAN+ "| Var  | "+e.getName()+" | "+((Var) e).type +" | "+((Var) e).valeur.toString());
                }
                if (e.getClass().getName() == "tds.Type") {
                    if (((Type) e).typeDeType.equals("rectype")) {
                        System.out.print(ANSI_TAB + ANSI_CYAN + "| Type | " + e.getName() + " | " + ((Type) e).typeDeType + " | ");
                        printHashMap(((Type) e).typeFieldDict);
                    }if (((Type) e).typeDeType.equals("arrayof")) {
                        System.out.println(ANSI_TAB + ANSI_CYAN + "| Type | " + e.getName() + " | " + ((Type) e).typeDeType + " | " + ((Type) e).arrayOf);
                    } else {
                        System.out.println(ANSI_TAB + ANSI_CYAN + "| Type | " + e.getName() + " | "+ ((Type) e).typeDeType + " | " + ((Type) e).typeid);
                    }
                }
            }
            System.out.println(ANSI_TAB + ANSI_PURPLE + "------------------------------" + ANSI_RESET);
            System.out.println();
        }
    }

    public void printHashMap(HashMap<String, String> map) {
        for (Map.Entry<String, String> set : map.entrySet()) {
            System.out.print("{" + set.getKey() + ":" + set.getValue() + "} ");
        }
        System.out.println(ANSI_RESET);
    }

    public void createNewTds() {
        int currentRegion = pileRO.peek();
        int newRegion = tdsGlobal.size();
        int numImbrication = pileRO.size() - 1;
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

        // l'entrée existe car elle a été vérifié dans RecFieldList
        Entry e = findEntryByName(type, pileRO.peek());
        Type entry = (Type) e;
        String typeDeExpr = expr.typeName;

        String typeOfIdf = entry.typeFieldDict.get(idf);
        if (typeOfIdf != typeDeExpr) {
            System.err.println(ANSI_RED + "Type Error: type mismatch " + typeOfIdf + "/" + typeDeExpr + ANSI_RESET);
            return r;
        }
        r.typeName = typeOfIdf;
        r.objValue = expr.objValue;

        return r;
    }

    @Override
    public Result visit(DecFunctWithReturnType dec) {
        // Laisser à Serge
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
        HashMap<String,String> parms = dec.type_field_list.accept(this).typeFieldList;
        for (Map.Entry m : parms.entrySet()) {
            Var e = new Var(m.getKey().toString(),m.getValue().toString(),true);
            tdsGlobal.get(tdsGlobal.size() - 1).addEntry(e);

        }
        

        // TODO Controle sémantique pour vérifier si l'exp correspond au type de retour
        if (!res.typeName.equals(dec.type_id.accept(this).typeName)) {
            System.out.println(ANSI_TAB + ANSI_RED + "Type of expression does not match the type of function");


        }
        
            
        

        // On revient au père
        pileRO.pop();

        return res;
    }

    @Override
    public Result visit(DecFunctVoid dec) {
        // Laisser à Serge
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
        HashMap<String,String> parms = dec.type_field_list.accept(this).typeFieldList;
        for (Map.Entry m : parms.entrySet()) {
            Var e = new Var(m.getKey().toString(),m.getValue().toString());
            tdsGlobal.get(tdsGlobal.size() - 1).addEntry(e);

        }
        

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
        if (dec.exprseq != null) {
            result = dec.exprseq.accept(this);
        }
        // Quand on a terminé de visiter le LetInEnd, on revient chez le père
        pileRO.pop();
        return result;
    }

    @Override
    public Result visit(DecVarTypeSpec dec) {
        // On récupère le resultat de l'expression
        Result result = dec.expr.accept(this);

        Var var;
        Tds currentTds = tdsGlobal.get(pileRO.peek());
        // On vérifie qu'une variable de ce nom n'existe pas dans la tds courrante.
        Entry e = findEntryInTds(dec.idf1.name, pileRO.peek());
        if (e == null || e.getClass().getName() != "tds.Var") {
            // dec.idf2.name.equals(result.typeName);
            if (compareType(dec.idf2.name, result.typeName)) {
                var = new Var(dec.idf1.name, dec.idf2.name, result.objValue);
                currentTds.addEntry(var);
            } else {
                int lig = this.numberLine("var"+dec.idf1.name+":"+dec.idf2.name);
                System.err.println(ANSI_TAB + ANSI_RED + "Declaration Error: Type mismatch for \"" + dec.idf1.name
                        + "\" (" + dec.idf2.name + " / " + result.typeName + " )." + ANSI_RESET+" "+"ligne"+" "+lig);
            }
        } else {
            int lig = this.numberLine("var"+dec.idf1.name+":"+dec.idf2.name);
            System.err.println(ANSI_TAB + ANSI_RED + "Declaration Error: Variable \"" + dec.idf1.name
                    + "\" is already declared." + ANSI_RESET+" "+"ligne"+" "+lig);
        }

        // On ajoute l'entrée à la TDS courante
        Result res = new Result();
        res.typeName = "void";
        return res;
    }

    public Boolean compareType(String typeTDS, String typeResult) {

        Entry e = findEntryByName(typeTDS, pileRO.peek());
        if (e == null || e.getClass().getName() != "tds.Type") {
            System.err.println(ANSI_TAB + ANSI_RED + "Type error: Type " + typeTDS + " is not found.");
            return false;
        }
        Type t = (Type) e;
        if (t.typeDeType.equals("typeid")) {
            return t.typeid.equals(typeResult);
        }
        if (t.typeDeType.equals("arrayof")) {
            return t.arrayOf.equals(typeResult);
        }
        return false;
    }

    @Override
    public Result visit(DecVarTypeNotSpec dec) {
        // On récupère le resultat de l'expression
        Result result = dec.expr.accept(this);

        Var var;
        Tds currentTds = tdsGlobal.get(pileRO.peek());
        // On vérifie qu'une variable de ce nom n'existe pas dans la tds courrante.
        Entry e = findEntryInTds(dec.idf.name, pileRO.peek());
        if (e == null || e.getClass().getName() != "tds.Var") {
            if (result.objValue != null){
                var = new Var(dec.idf.name, result.typeName, result.objValue);
                currentTds.addEntry(var);
            }
        } else {
            int lig = this.numberLine("var"+dec.idf.name+":="+this.getAttr(result));
            System.err.println(ANSI_TAB + ANSI_RED + "Declaration Error: Variable \"" + dec.idf.name
                    + "\" is already declared." + ANSI_RESET+" "+"ligne"+" "+lig);
        }

        // On ajoute l'entrée à la TDS courante
        Result res = new Result();
        res.typeName = result.typeName;
        return res;
    }

    @Override
    public Result visit(TypeField dec) {
        Result r = new Result();
        r.typeFieldidf = dec.idf1.accept(this).strValue;
        r.typeFieldType = dec.idf2.accept(this).strValue;
        return r;
    }

    @Override
    public Result visit(DecType dec) {

        Entry e2 = findEntryInTds(dec.idf.accept(this).strValue, pileRO.peek());
        if (e2 != null && e2.getClass().getName() == "tds.Type") {
            int lig = this.numberLine("type"+dec.idf.accept(this).strValue+"=");
            System.err.println(
                    ANSI_TAB + ANSI_RED + "Type Name Error: " + dec.idf.accept(this).strValue + " is already a type."+" "+"ligne"+" "+lig);
            return new Result();
        }
        // On créer une nouvelle entrée
        Type type = new Type(dec.idf.accept(this).strValue);
        Result typeExpr = dec.type.accept(this);
        if (typeExpr.typeDeType == "arrayof") {
            type.typeDeType = typeExpr.typeDeType;
            type.arrayOf = typeExpr.strValue;
        }
        if (typeExpr.typeDeType == "rectype") {
            type.typeDeType = typeExpr.typeDeType;
            type.typeFieldDict = typeExpr.typeFieldList;
        }
        if (typeExpr.typeDeType == null) {
            Entry e = findEntryByName(typeExpr.strValue, pileRO.peek());
            if (e != null && e.getClass().getName() == "tds.Type") {
                type.typeDeType = "typeid";
                type.typeid = typeExpr.strValue;
            } else {
                if (typeExpr.strValue.equals("string") || typeExpr.strValue.equals("int")) {
                    type.typeDeType = "typeid";
                    type.typeid = typeExpr.strValue;
                } else {
                    type.typeDeType = "???";
                    type.typeid = typeExpr.strValue;
                    int lig = this.numberLine("type"+type.typeid+"=");
                    System.err.println(ANSI_TAB + ANSI_RED + "Type Not found: " + typeExpr.strValue+" "+"ligne"+" "+lig);
                    return new Result();
                }
            }
        }
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
        for (Ast d : dec.successiveSub) {
            if (d.accept(this).typeName != "int") {
                int lig = this.numberLine(r.strValue);
                System.err.println(ANSI_RED + "Subscript Error: Not an Integer" + ANSI_RESET+" "+"ligne"+" "+lig);
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
        if (expr1.typeName != "int") {
            int lig = this.numberLine("[" +this.getAttr(expr1)+"]"+"of");
            System.err.println(ANSI_RED + "Can't create Array because it's not an integer in []" + ANSI_RESET+" "+"ligne"+" "+lig);
            return res;
        }
        res.typeName = "array";
        Array tableau = new Array();

        Result second = a.expr2.accept(this);
        if (second.typeName == "int") {
            tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.intValue);
        }
        if (second.typeName == "array") {
            tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.ar);
            res.ar = tableau;
        }
        if (second.typeName == "rec") {
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
        for (Result r : a.fieldList.accept(this).recFieldList) {
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

        // On créer une nouvelle TDS
        createNewTds();
        //On parcours la boucle for et on récupère les infos du resultat dans Result. (on peut ajouter des attributs à Result si necessaire)

        Result c = f.expr1.accept(this);
        Result l = f.expr2.accept(this);


        //On créer l'entrée pour la variable d'increment
        Var increment = new Var(f.idf.name, "int", c.intValue);
        //On ajoute en entrée la variable d'increment
        Tds currentTds = tdsGlobal.get(tdsGlobal.size()-1);
        currentTds.addEntry(increment);
        
        Result r = f.expr3.accept(this);
        if (c.typeName == "int" && l.typeName == "int") {

            if (r.typeName != "void") {
                int lig = this.numberLine("for"+f.idf.name+":="+this.getAttr(c)+"to"+this.getAttr(l));
                System.err.println(
                        ANSI_RED + "Type Error: The body must be of type void" + ANSI_RESET+" "+"ligne"+" "+lig);
                pileRO.pop();
                return r;
            }
            else{
                createNewTds();
                Tds currentTds1 = tdsGlobal.get(tdsGlobal.size()-1);
                int v = findIndexInTds(f.idf.name, pileRO.peek());
                Var v1 = (Var) currentTds.rows.get(v);
                Result a = new Result();
                for (int x=c.intValue; x<l.intValue;x++) {
                    Result exprBlock = f.expr3.accept(this);
                    int index = pileRO.peek();
                    Entry e = findEntryByName(f.idf.name, index);
                    v1.valeur = (Integer) v1.valeur + 1;
                    a = exprBlock;
                 }
                //On remonte dans le bloc père
                pileRO.pop();
                return a;
            }
        }
        else {
            int lig = this.numberLine("for"+f.idf.name+":="+this.getAttr(c)+"to"+this.getAttr(l));
            System.err.println(
                    ANSI_RED + "Type Error: The start and end index of boucle for must be of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
            pileRO.pop();
            return r;
        }
        

        //TODO: COntroles sémantiques
        // The start and end index must be of type int. The variable is of type int and
        // must not be
        // assigned to in the body. The body must be of type
        // void. The result type is void.
        

        // On remonte dans le bloc père


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

        if (c.typeName.equals("int")) {
            if (r.typeName != "void") {
                System.err.println(ANSI_RED + "Type Error: The body type must be void" + ANSI_RESET);
            }

        }

        else {
            int lig = this.numberLine("while"+this.getAttr(c)+"do");
            System.err.println(
                    ANSI_RED + "Type Error: The condition type must be int" + ANSI_RESET+ " "+ "ligne"+" "+lig);
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
        res.typeName = expr.typeName;
        if (!lv.lvalueCorrect) {
            int lig = this.numberLine(this.getAttr(lv)+":=");
            System.err.println(ANSI_RED + "Affect Error: Can't find variable" + ANSI_RESET+" "+"ligne"+" "+lig);
            return res;
        }
        if (!lv.lvalueType.equals(expr.typeName)) {
            int lig1 = this.numberLine(":="+this.getAttr(expr));
            System.err.println(
                    ANSI_RED + "Affect Error: Type mismatch " + lv.lvalueType + "/" + expr.typeName + ANSI_RESET+" "+"ligne"+" "+lig1);
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
        Result r = new Result();
        r.typeDeType = "arrayof";
        r.strValue = n.arrayType.accept(this).strValue;
        return r;
    }

    @Override
    public Result visit(CallExpr d) {
        
        // The identifier must refer to a function.
        // The number and types of actual and formal parameters must be the same. The
        // type of the call is
        // the return type of the function
        Entry e = findEntryByName(d.idf.name, pileRO.peek());
        Result result = new Result();
        if (e instanceof Fonction) {
            Fonction p = (Fonction) e;
            result.typeName = p.getType();
        }
        if (e == null) {
            if (e instanceof Fonction) {
                System.out.println(ANSI_RED + "name of function undefined"+ANSI_RESET);

            }
            else {
                System.out.println(ANSI_RED + "name of function undefined"+ANSI_RESET);
                System.out.println(ANSI_RED + "The identifier must refer to a function"+ANSI_RESET);

            }  
        }
        else {
            Result lis =  d.exprList.accept(this);
            Fonction f = (Fonction) e;
            Tds tds = tdsGlobal.get(f.gettdsFils());
            int count = 0;
            for (Entry m : tds.rows) {
                if (m instanceof Var) {
                    Var v = (Var) m;
                    if (v.isParm) {
                        count++;
                    }
                }

            }
            if (count == lis.exprList.size()) {
                for (int i = 0;i<count;i++) {
                    Var vr = (Var) tds.rows.get(i);
                    if (vr.isParm && vr.type.equals(lis.exprList.get(i).accept(this).typeName)) {

                    }
                    else {
                        System.out.println(ANSI_RED + "The types of actual and formal parameters must be the same" +  ANSI_RESET);

                    }
                }

            }

            if (count != lis.exprList.size()) {
                System.out.println(ANSI_RED + "The number of actual and formal parameters must be the same" +  ANSI_RESET);

            }

            
        }

        return result;
    }

    @Override
    public Result visit(Program d) {
        Tds tds = new Tds(0, 0, -1);
        pileRO.push(0);
        tdsGlobal.add(tds);
        System.out.println();
        System.out.println(ANSI_BLUE + "°°° Construction TDS et contrôles sémantiques" + ANSI_RESET);
        ;
        for (Ast ast : d.exprList) {
            if (ast != null) {
                ast.accept(this);
            } else {
                System.out.println(ANSI_BLUE + "°°° EOF" + ANSI_RESET);
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"*"+vr);
        if (l.typeName.equals("int") && r.typeName.equals("int")) {
            n.intValue = l.intValue * r.intValue;
            return n;
        } else {
            if (l.typeName.equals("int")) {
                System.err.println(
                        ANSI_RED + "Type Error: Left side of the multiplication is not of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
            }
            if (r.typeName != "int") {
                System.err.println(
                        ANSI_RED + "Type Error: Right side of the multiplication is not of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
            }
            return n;
        }

    }

    @Override
    public Result visit(Precedence_2 plus) {
        // les opérands et le résultat doivent être de type int
        Result l = plus.left.accept(this);
        Result r = plus.right.accept(this);
        System.out.println();
        Result n = new Result();
        n.typeName = "int";
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"+"+vr);
        if (l.typeName.equals("int") && r.typeName.equals("int")) {
            n.intValue = l.intValue + r.intValue;
            return n;
        } else {
            if (!l.typeName.equals("int")) {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET+" "+"ligne"+" "+ lig);
            }
            if (!r.typeName.equals("int")) {
                System.err.println(ANSI_RED + "\u001B[33m Type Error: Right side of the operation is not of type int"
                        + ANSI_RESET+" "+"ligne"+ " "+lig);
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
        n.typeName = "int";
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"="+vr);
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                if (l.intValue == r.intValue) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;
            } else if (l.typeName.equals("string")) {
                if (l.strValue.compareTo(r.strValue) == 0) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;
            } else {
                // Comparer les autres instances non nulles
                return n;
            }
        } else {
            System.err.println(ANSI_RED + "Type Error: Not the same type for operands" + ANSI_RESET+" "+"ligne"+lig);
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"&"+vr);
        if (l.typeName.equals("int") && r.typeName.equals("int")) {
            n.intValue = l.intValue & r.intValue;
            return n;
        } else {
            if (!l.typeName.equals("int")) {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET+" "+"ligne"+" "+ lig);
            }
            if (!r.typeName.equals("int")) {
                System.err
                        .println(ANSI_RED + "Type Error: Right side of the operation is not of type int" + ANSI_RESET+" "+"ligne"+lig);
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"|"+vr);
        
        if (l.typeName.equals("int") && r.typeName.equals("int")) {
            n.intValue = l.intValue | r.intValue;

            return n;
        } else {
            if (!l.typeName.equals("int")) {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET+" "+"ligne"+lig);
            }
            if (!r.typeName.equals("int")) {
                System.err
                        .println(ANSI_RED + "Type Error: Right side of the operation is not of type int" + ANSI_RESET+" "+"ligne"+lig);
            }
            return n;
        }
    }

    @Override
    public Result visit(Sup_equal supeq) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int
        Result l = supeq.left.accept(this);
        Result r = supeq.right.accept(this);
        Result n = new Result();
        n.typeName = "int";
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+">="+vr);
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                if (l.intValue >= r.intValue) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }

                return n;
            } else if (l.typeName.equals("string")) {
                if (l.strValue.compareTo(r.strValue) >= 0) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET + " "+ "ligne" +lig);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET + " "+ "ligne" +lig);
            return n;

        }

    }

    @Override
    public Result visit(Inf_equal infeq) {
        // les opérands doivent avoir le même type et doivent être de type int ou de
        // type string
        // le résultat doit être de type int
        Result l = infeq.left.accept(this);
        Result r = infeq.right.accept(this);
        Result n = new Result();
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"<="+vr);
        
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                if (l.intValue <= r.intValue) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }

                return n;
            } else if (l.typeName.equals("string")) {
                if (l.strValue.compareTo(r.strValue) <= 0) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET+ " " + "ligne" + " " + lig);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET+" " + "ligne" + " " + lig);
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+">"+vr);
        
        
        n.typeName = "int";
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                if (l.intValue > r.intValue) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;
            } else if (l.typeName.equals("string")) {
                if (l.strValue.compareTo(r.strValue) > 0) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET + " " + "ligne" + " " + lig);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET+ " " + "ligne" + " " + lig);
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"<"+vr);
       
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                if (l.intValue < r.intValue) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;
            } else if (l.typeName.equals("string")) {
                if (l.strValue.compareTo(r.strValue) < 0) {
                    n.intValue = 1;
                } else {
                    n.intValue = 0;
                }
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET+" "+"ligne"+lig);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET+" "+"ligne"+" "+lig);
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"<>"+vr);
        
        if (l.typeName.equals(r.typeName)) {
            if (l.typeName.equals("int")) {
                return n;
            } else if (l.typeName.equals("string")) {
                return n;

            } else {
                System.err.println(ANSI_RED + "Type Error: Both operands types must be string or int" + ANSI_RESET+" "+"ligne"+" "+lig);
                return n;
            }

        } else {
            System.err.println(ANSI_RED + "Type Error: the operands types must match" + ANSI_RESET+" "+"ligne"+" "+lig);
            return n;

        }
    }

    @Override
    public Result visit(Negate_instruction Ni) {
        // l'opérand et le résultat sont de type int
        Result Ne= Ni.exp.accept(this);
        String vl = this.getAttr(Ne);
        
        int lig = this.numberLine("-"+vl);
        
        if (Ne.typeName == "int"){
            return Ne;
        }else{
            System.err.println(ANSI_RED+"Type Error: The operand type is not int"+ANSI_RESET+" "+"ligne"+" "+lig);
            return Ne;
        }

    }

    @Override
    public Result visit(IfThen ifThen) {
        // The condition type must be int, and the
        // then-clause must be of type void. The result type
        // is also void
        Result c = ifThen.condition.accept(this);
        Result b = ifThen.thenBlock.accept(this);
        if (c.typeName.equals("int")) {
            if (b.typeName.equals("void")) {
                return b;
            } else {
                int lig = this.numberLine("then"+this.getAttr(b));
                System.err.println(ANSI_RED + "Type Error: The then-clause must be of type void" + ANSI_RESET+" "+"ligne"+" "+lig);
                return b;
            }
        } else {
            int lig = this.numberLine("if" +this.getAttr(c));
            System.err.println(ANSI_RED + "Type Error: The condition type must be int" + ANSI_RESET+" "+"ligne"+" "+lig);
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
        n.elseBlock = e;

        
        if (c.typeName.equals("int")) {
            if (t.typeName.equals(e.typeName)) {
                n.typeName = t.typeName;
                return n;
            } else {
                int lig1 = this.numberLine("then"+this.getAttr(t));
                int lig2 = this.numberLine("else"+this.getAttr(e));

                System.err.println(ANSI_RED + "The then-clause and else-clause must have the same type" + ANSI_RESET+" "+"ligne"+" "+lig1 + " "+"et ligne"+" "+lig2);
                return n;
            }
        }

        else {
            int lig = this.numberLine("if"+this.getAttr(c));
            System.err.println(ANSI_RED + "Type Error: The condition type must be int" + ANSI_RESET+" "+"ligne"+" "+lig);
            return n;
        }
    }

    @Override
    public Result visit(Divide divide) {
        // les opérands et le résultat doivent être de type int
        Result l = divide.left.accept(this);
        Result r = divide.right.accept(this);
        Result n = new Result();
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        int lig = this.numberLine(vl+"/"+vr);
        
        n.typeName = "int";
        if (l.typeName.equals("int") && r.typeName.equals("int")) {
            if (r.intValue == 0) {
                System.err.println(ANSI_RED + "Divide by zero error !" + ANSI_RESET+" "+"ligne"+" "+lig);
                return n;
            }
            n.intValue = l.intValue / r.intValue;
            return n;
        } else {
            if (!l.typeName.equals("int")) {
                System.err.println(ANSI_RED + "Type Error: Left side of the division is not of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
            }
            if (!r.typeName.equals("int")) {
                System.err.println(ANSI_RED + "Type Error: Right side of the division is not of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
            }
            return n;
        }
    }

    @Override
    public Result visit(ExprSeq exprseq) {
        // If the sequence is empty, the type is void,
        // otherwise, the type is that of the last expression
        Result r = new Result();
        if (exprseq.astList.size() == 0) {
            r.typeName = "void";
            return r;
        }
        for (Ast a : exprseq.astList) {
            r = a.accept(this);
        }
        return r;
    }

    @Override
    public Result visit(ExprList exprlist) {
        Result res = new Result();
        res.exprList.addAll(exprlist.astList);
        return res;
    }

    @Override
    public Result visit(TypeFieldList typeFieldList) {
        Result r = new Result();
        r.typeDeType = "rectype";
        r.typeFieldList = new HashMap<>();

        for (Ast a : typeFieldList.astList) {
            Result typefield = a.accept(this);
            r.typeFieldList.put(typefield.typeFieldidf, typefield.typeFieldType);
        }
        return r;
    }

    @Override
    public Result visit(RecFieldList recFieldList) {
        Result res = new Result();
        String type = recFieldList.type.accept(this).strValue;

        Entry e = findEntryByName(type, pileRO.peek());
        if (e == null) {
            System.err.println(ANSI_RED + "Type Not found Error: " + type + " doesn't exist." + ANSI_RESET);
            return res;
        }
        if (e.getClass().getName() != "tds.Type") {
            System.err.println(ANSI_RED + "Type Not found Error: " + type + " is the name of a variable or un function."
                    + ANSI_RESET);
            return res;
        }
        Type entry = (Type) e;
        if (entry.typeDeType != "rectype") {
            System.err.println(ANSI_RED + "Type Error: " + type + " is not a type with child types." + ANSI_RESET);
            return res;
        }
        ArrayList<Result> recFLRes = new ArrayList<>();
        for (Ast a : recFieldList.astList) {
            recFLRes.add(a.accept(this));
        }
        res.recFieldList = recFLRes;
        return res;

    }

    @Override
    public Result visit(LvalueInit lvalueInit) {

        // l'identifiant doit référencer une variable
        // On récupère l'identifiant de la lvalue
        Ast a = lvalueInit.lvalue.get(0);
        Result r = a.accept(this);
        Result returnRes = new Result();
        String idf = r.strValue;
        // On cherche dans la tds cette variable
        Entry e = findEntryByName(idf, pileRO.peek());
        int lig = this.numberLine(idf);
        // Si on ne trouve pas cette idf
        if (e == null) {
            
            System.err.println(ANSI_RED + "Variable Not Found: " + idf + " doesn't exist" + ANSI_RESET+" "+"ligne"+" "+lig);
            returnRes.lvalueCorrect = false;
            return returnRes;
        }
        // Si ce n'est pas une variable
        if (e.getClass().getName() != "tds.Var") {
            System.err.println(ANSI_RED + "Variable Not Found: " + idf + " is not a variable " + ANSI_RESET+" "+"ligne"+" "+lig);
            returnRes.lvalueCorrect = false;
            return returnRes;
        }
        // Si on a trouvé cette lvalue, on la parcours en entier pour vérifier qu'elle
        // existe
        Rec nR = new Rec();
        nR.dict.put(idf, ((Var) e).valeur);
        Object res = checkLvalue(nR, lvalueInit.lvalue, null, true);
        if (res == null) {
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

    public Object checkLvalue(Object obj, ArrayList<Ast> lvalue, Object affect, Boolean print) {
        if (lvalue.size() == 0) {
            if (affect != null) {
                obj = affect;
            }
            return obj;
        }
        Result current = lvalue.get(0).accept(this);
        String id = current.strValue; // QUe ce soit une LvalueSub ou un StrNode, on récupère l'id
        // Si l'objet pdans lequel on cherche la suite de la lvalue n'est pas un Rec,
        // cela veut dire que c'est forcément un entier, donc qu'il ne possède pas de
        // sous idf
        if (obj.getClass().getName() != "tds.Rec") {
            if (print) {
                System.err.println(ANSI_RED + "Variable Not Found: " + id
                        + " can't be find because father doesn't have children" + ANSI_RESET);
            }
            return null;
        }
        // ON récupère l'obj correspondant à l'id
        Object next = getSubObjInRec(id, (Rec) obj, print);
        if (next == null) {
            return null;
        }
        // Si c'est une StrNode, on cherche la suite de la lvalue dans l'obj trouvé
        if (current.typeName == "String") {
            lvalue.remove(0);
            return checkLvalue(next, lvalue, affect, print);
        }
        // Si c'est une Lvalsub, on vérifie que tout est bien subscriptable
        if (current.typeName == "LvalueSub") {
            // Une lvalueSub est forcément un array
            ArrayList<Result> sub = current.subscript;
            for (Result s : sub) {
                if (next.getClass().getName() == "tds.Array") {
                    next = getSubObjInArray(s.intValue, (Array) obj, print);
                    if (next == null) {
                        return null;
                    }
                } else {
                    if (print) {
                        System.err.println(
                                ANSI_RED + "Variable Subscript Error: " + id + " not subscriptable." + ANSI_RESET);
                    }
                    return null;
                }
            }
            // puis on cherche la suite de la lvalue dans l'obj trouvé
            lvalue.remove(0);
            return checkLvalue(next, lvalue, affect, print);
        }
        if (print) {
            System.err.println(
                    ANSI_YELLOW + "Erreur bizarre dans Lvalue:current is not LvalueSub nor String " + ANSI_RESET);
        }
        return false;
    }

    public Object getSubObjInRec(String name, Rec rec, Boolean print) {
        if (rec.dict.containsKey(name)) {
            return rec.dict.get(name);
        } else {
            if (print) {
                System.err
                        .println(ANSI_RED + "Variable Error: " + name + " is not a child of the variable" + ANSI_RESET);
            }
            return null;
        }
    }

    public Object getSubObjInArray(Integer i, Array tab, Boolean print) {
        if (i == null) {
            if (print) {
                System.err.println(ANSI_RED + "Variable Error: subscript value was not initialized" + ANSI_RESET);
            }
            return null;
        }
        if (i >= tab.size) {
            if (print) {
                System.err.println(ANSI_RED + "Index out of bounds" + ANSI_RESET);
            }
            return null;
        }
        return tab.values[i];

    }

    public Entry findEntryByName(String id, int tdsStartIndex) {

        int tdsIndex = tdsStartIndex;
        Tds currentTds = tdsGlobal.get(tdsIndex);

        while (tdsIndex != 0) {

            tdsIndex = currentTds.numRegion;
            // Je cherche dans la TDS si le nom existe de la variable
            Entry e = findEntryInTds(id, tdsIndex);  

            if (e == null && currentTds.pere != -1) {
                // Si ce n'est pas le cas je passe à la TDS père
                if (tdsIndex != 0) {currentTds = tdsGlobal.get(currentTds.pere);}
            }
            else{
                // Sinon je prends le premier venu
                return e;
            }
        }
        // Si je ne trouve rien, je renvoie null
        return null;

    }

    public Entry findEntryInTds(String id, int tdsIndex) {
        Tds currentTds = tdsGlobal.get(tdsIndex);
        String idf;
        Entry goodOne;
        for (Entry e : currentTds.rows) {
            idf = e.getName();
            if (idf.equals(id)) {
                goodOne = e;
                return goodOne;
            }
        }
        return null;
    }

    public int findIndexInTds(String id, int tdsIndex){
        Tds currentTds = tdsGlobal.get(tdsIndex);
        String idf;
        int index = 0;
        for (Entry e : currentTds.rows){
            idf = e.getName();
            if (idf.equals(id)){
                return index;
            }
            index++;
        }
        return 0;
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
        String vl = this.getAttr(l);
        String vr = this.getAttr(r);
        String res = vl+"-"+vr;
        int lig = this.numberLine(res);
        
        if (l.typeName == "int" && r.typeName == "int") {
            n.intValue = l.intValue - r.intValue;
            return n;
        } else {
            if (l.typeName != "int") {
                System.err.println(ANSI_RED + "Type Error: Left side of the operation is not of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
            }
            if (r.typeName != "int") {
                System.err.println(ANSI_RED + "\u001B[33m Type Error: Right side of the operation is not of type int"
                        + ANSI_RESET+" "+"ligne"+" "+lig);
            }
            return n;
        }

    }

    public void setLines() {
        try {
            ArrayList<String> ligs = new ArrayList<String>();
            FileInputStream file = new FileInputStream(this.file);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = sc.nextLine().replaceAll("\\s", "");
                ligs.add(str);

            }
            sc.close();
            this.lignes.addAll(ligs);
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }

    public int numberLine(String val) {
        for (int i = 0;i<this.lignes.size();i++) {
            if (this.lignes.get(i).contains(val)) {
                return i+1;
            }
        }
        return 0;

    }

    public String getAttr(Result r) {
        String res = "";
        if (r.strValue != null) {
            res += r.strValue;
            return res;

        }

        if (r.intValue != 0) {
            res += r.intValue;
            return res;
        }
        if (r.lvalueObject != null) {
            res += r.lvalueObject;
            return res;
        }
        if (r.varIdf != null) {
            res += r.varIdf;
            return res;
        }
        if (r.objValue != null) {
            res += r.objValue;
            return res;
        }
        if (r.elseBlock != null) {
            res += this.getAttr(r.elseBlock);
            return res;

        }
        return res;

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
