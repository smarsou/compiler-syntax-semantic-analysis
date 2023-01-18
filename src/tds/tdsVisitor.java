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
import java.util.TimeZone;

import javax.lang.model.type.ArrayType;
import javax.sound.midi.SysexMessage;
import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.swing.plaf.synth.SynthSpinnerUI;

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
            System.out.println();
            for (Entry e : tds.rows){
                // System.out.println("entree est " + ((Var) e).type);
                if (e.getClass().getName() == "tds.Var"){
                    Var k = ((Var) e);
                    if (k.valeur != null) {
                        if (((Var) e).type == "array"){
                            System.out.println(ANSI_TAB + ANSI_CYAN+ "| Var  | "+e.getName()+" | "+((Var) e).type +" de type " + ((Var) e).array.type);
                            printArray(((Var) e).array);
                        }else if (((Var) e).type == "rec") {
                            System.out.print(ANSI_TAB + ANSI_CYAN+ "| Var  | "+e.getName()+" | "+((Var) e).type +" de type " + ((Var) e).rec.type_id+ " | ");
                            printRec(((Var) e).rec);
                        }
                        else {
                            
                        System.out.println(ANSI_TAB + ANSI_CYAN+ "| Var  | "+e.getName()+" | "+((Var) e).type +" | "+((Var) e).valeur.toString());
                        }                        

                    }
                    else {
                        if (k.isParm) {
                            
                            System.out.println(ANSI_TAB + ANSI_CYAN+ "| paramètre  | "+e.getName()+" | "+((Var) e).type );
                            

                        }
                    }
                    
                }

                if (e.getClass().getName().equals("tds.Fonction")) {
                    Fonction f = (Fonction) e;
                    
                    Tds t = tdsGlobal.get(f.gettdsFils()-1);
            
                    int count = 0;
            
                    for (Entry m : t.rows) {
                
                        if (m instanceof Var) {
                    
                            Var v = (Var) m;
                    
                            if (v.isParm) {
                        
                                count++;
                    
                            }
                
                        }
                    }
                    
                    System.out.println(ANSI_TAB + ANSI_CYAN+  "| Function | "+ e.getName()+ " | "+ ((Fonction) e).getType()+ " | "+ count+" paramètres");

                }
                if (e.getClass().getName() == "tds.Type") {
                    if (((Type) e).typeDeType.equals("rectype")) {
                        
                        System.out.print(ANSI_TAB + ANSI_CYAN + "| Type | " + e.getName() + " | " + ((Type) e).typeDeType + " | ");
                        
                        printHashMap(((Type) e).typeFieldDict);
                    }else if (((Type) e).typeDeType.equals("arrayof")) {
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
    public void printRec(Rec rec) {

        for (Map.Entry<String, Object> set : rec.dict.entrySet()) {
            System.out.print("{" + set.getKey() + "=" + set.getValue() + "} ");
        }
        System.out.println(ANSI_RESET);
    }

    public void printArray(Array a){
        for (int i =0; i< a.size; i++){
            System.out.println("                         "+"["+i+"] --> " + a.values[i]);
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
        if (typeOfIdf == null){
            System.err.println(ANSI_TAB + ANSI_RED + "Création de Record: Le champ \""+idf+"\" n'est pas un champ du Record de type \""+type+"\"."+ANSI_RESET);
            return r;
        }
        if (!typeDeExpr.equals(typeOfIdf)) {
            System.err.println(ANSI_TAB+ANSI_RED + "Création de Record: Les types ne correspondent pas pour le champ \""+ idf + "\" (" + typeOfIdf + "/" + typeDeExpr +")."+ ANSI_RESET);
            return r;
        }
        r.strValue = idf;
        r.typeName = typeOfIdf;
        r.objValue = expr.objValue;

        return r;
    }

    @Override
    public Result visit(DecFunctWithReturnType dec) {
        
        // On créer une nouvelle entrée et on l'ajoute à la TDS du bloc courant
        Fonction func = new Fonction(dec.idf1.name, dec.type_id.name);
        
        // On créer une nouvelle tds pour la déclaration de la fonction
        createNewTds();
        int imb = tdsGlobal.get(tdsGlobal.size()-1).numImbrication;
        //System.out.println(imb);
        
        Tds currentTds = tdsGlobal.get(imb);
        


        // On ajoute cette Tds à l'entrée
        int numRegiontTds = tdsGlobal.get(tdsGlobal.size() - 1).numRegion;
        func.setTds(numRegiontTds);

        // On visit le bloc de la fonction
        Result res = dec.expr.accept(this);
        HashMap<String,String> parms = new HashMap<>();
        ArrayList<String> orderParms = new ArrayList<>();

        if (dec.type_field_list.accept(this).typeFieldList != null) {
            parms = dec.type_field_list.accept(this).typeFieldList;
            orderParms = dec.type_field_list.accept(this).orderedParams;
        }
        String pm = "";
        for (Map.Entry m : parms.entrySet()) {
            
            Var e = new Var(m.getKey().toString(),m.getValue().toString(),true);
            tdsGlobal.get(tdsGlobal.size() - 1).addEntry(e);
            

        }
        for (String k : orderParms) {
            pm += k + ":"+parms.get(k)+",";
        }
        
        if (!pm.equals("")) {
            pm = pm.substring(0, pm.length()-1);

        }
        
        
        int lig = this.numberLine("function"+dec.idf1.name+"("+pm+")");
        
        // TODO Controle sémantique pour vérifier si l'exp correspond au type de retour
       
        if (!res.typeName.equals(dec.type_id.name)) {
            System.out.println(ANSI_TAB + ANSI_RED + "Type of expression does not match the type of function"+ANSI_RESET+" ligne "+lig);
        }
        Entry e = findEntryByName(dec.idf1.name, pileRO.peek());
        if (e != null) {
            if (e.getClass().getName().equals("tds.Fonction")) {
                
                System.out.println(ANSI_TAB + ANSI_YELLOW+"The id "+dec.idf1.name+" already exists "+ANSI_RESET+"ligne "+lig);

            }
            

        }
        
        currentTds.addEntry(func);
        
        
        // On revient au père
        pileRO.pop();

        return res;
    }

    @Override
    public Result visit(DecFunctVoid dec) {
        
        // On créer une nouvelle entrée et on l'ajoute à la TDS du bloc courant
        Fonction func = new Fonction(dec.idf.name, "void");
        

        // On créer une nouvelle tds pour la déclaration de la fonction
        createNewTds();
        int imb = tdsGlobal.get(tdsGlobal.size()-1).numImbrication;
        
        
        Tds currentTds = tdsGlobal.get(imb);
        


        // On ajoute cette Tds à l'entrée
        int numRegiontTds = tdsGlobal.get(tdsGlobal.size() - 1).numRegion;
        func.setTds(numRegiontTds);

        // On visit le bloc de la fonction
        Result res = func.accept(this);
        HashMap<String,String> parms = new HashMap<>();
        ArrayList<String> orderParms = new ArrayList<>();

        if (dec.type_field_list != null) {
            if (dec.type_field_list.accept(this).typeFieldList != null) {
                parms = dec.type_field_list.accept(this).typeFieldList;
             
                orderParms = dec.type_field_list.accept(this).orderedParams;

            }
            
        }
        String pm = "";
        for (Map.Entry m : parms.entrySet()) {
            Var e = new Var(m.getKey().toString(),m.getValue().toString(),true);
            tdsGlobal.get(tdsGlobal.size() - 1).addEntry(e);
            
        }
        for (String k : orderParms) {
            pm += k + ":"+parms.get(k)+",";
        }
        
        if (!pm.equals("")) {
            pm = pm.substring(0, pm.length()-1);

        }

        int lig = this.numberLine("function"+dec.idf.name+"("+pm+")");
        
        Entry e = findEntryByName(dec.idf.name, pileRO.peek());
        if (e != null) {
            if (!e.getClass().getName().equals("tds.Fonction")) {
                System.out.println(ANSI_TAB + ANSI_YELLOW+"The id "+dec.idf.name+" already exists "+"ligne "+lig);

            }
            
            
            
        }
        
        currentTds.addEntry(func);
        
        

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
        int lig = this.numberLine("var"+dec.idf1.name+":"+dec.idf2.name);
        if (e == null || e.getClass().getName() != "tds.Var") {
            // dec.idf2.name.equals(result.typeName);
            if (dec.idf2.name.equals(result.typeName) || compareType(dec.idf2.name, result.typeName, lig)) {
                var = new Var(dec.idf1.name, dec.idf2.name, result.objValue);
                currentTds.addEntry(var);
            } else {
                System.err.println(ANSI_TAB + ANSI_RED + "Déclaration de variable: Les types ne correspondent pas pour la variable \"" + dec.idf1.name
                        + "\". (" + dec.idf2.name + " / " + result.typeName + ")." + ANSI_RESET+" "+"ligne"+" "+lig);
            }
        } else {
            System.err.println(ANSI_TAB + ANSI_RED + "Déclaration de variable: L'identifiant \"" + dec.idf1.name
                    + "\" est déja utilisé." + ANSI_RESET+" "+"ligne"+" "+lig);
        }

        // On ajoute l'entrée à la TDS courante
        Result res = new Result();
        res.typeName = dec.idf2.name;
        res.name = dec.idf1.name;
        res.objValue = result.objValue;
        return res;
    }

    public Boolean compareType(String typeTDS, String typeResult, int ligne) {
        if (typeTDS.equals("int") || typeTDS.equals("string")){
            return false;
        }
        Entry e = findEntryByName(typeTDS, pileRO.peek());
        if ((e == null || e.getClass().getName() != "tds.Type")) {
            System.err.println(ANSI_TAB + ANSI_RED + "Déclaration de variable: Le type " + typeTDS + " n'existe pas. " + ANSI_RESET  +"ligne "+ligne);
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
                if (result.typeName == "array"){
                    var.array = result.ar;
                }if (result.typeName == "rec"){
                    var.rec = result.rc;
                }
                currentTds.addEntry(var);
            }
        } else {
            int lig = this.numberLine("var"+dec.idf.name+":="+this.getAttr(result));
            System.err.println(ANSI_TAB + ANSI_RED + "Déclaration de variable: L'identifiant \"" + dec.idf.name
                    + "\" est déja utilisé." + ANSI_RESET+" "+"ligne"+" "+lig);
        }

        // On ajoute l'entrée à la TDS courante
        Result res = new Result();
        res.typeName = result.typeName;
        res.name = dec.idf.name;
        res.objValue = result.objValue;
        
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
                    ANSI_TAB + ANSI_RED + "Déclaration de Type: L'identifiant \"" + dec.idf.accept(this).strValue + "\" est déja utilisé."+ANSI_RESET+" ligne "+" "+lig);
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
                    System.err.println(ANSI_TAB + ANSI_RED + "Déclaration de type: \"" + typeExpr.strValue+"\" n'existe pas. " +ANSI_RESET+"ligne"+" "+lig);
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
            if (!d.accept(this).typeName.equals("int")) {
                int lig = this.numberLine(r.strValue);
                System.err.println(ANSI_TAB+ANSI_RED + "Accès à un Tableau: L'élément entre crochets [_] doit être un entier." + ANSI_RESET+" "+"ligne"+" "+lig);
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
            System.err.println(ANSI_TAB+ANSI_RED + "Création de Tableau: l'objet entre crochets [_] doit être de type int. " + ANSI_RESET+" "+"ligne"+" "+lig);
            return res;
        }
        
        res.typeName = "array";
        Result second = a.expr2.accept(this);
        Entry e = findEntryByName(a.typeid.accept(this).strValue, pileRO.peek());
        
        if (e == null || e.getClass().getName() != "tds.Type" || ((Type) e).arrayOf == null){
            System.err.println(ANSI_TAB+ANSI_RED+"Création de Tableau: Le type \""+a.typeid.accept(this).strValue+"\" n'existe pas ou n'est pas un type de Tableau." + ANSI_RESET);
            return res;
        }
        String arrayof = second.typeName;
        Entry f = findEntryByName(second.strValue, pileRO.peek());
        if (f == null || f.getClass().getName() != "tds.Var"){
            
        }else if (second.typeName.equals("rec")){
            arrayof =((Rec) ((Var) f).rec).type_id;
            second.objValue = (Rec) ((Var) f).rec;
        }else if(second.typeName == "array"){
            arrayof = ((Array) ((Var) f).array).type;
            second.objValue = ((Array) ((Var) f).array).type;
        }

        if (!compareType(a.typeid.accept(this).strValue,arrayof,-1)){
            int lig = this.numberLine("[" +this.getAttr(expr1)+"]"+"of");
            System.err.println(ANSI_TAB+ANSI_RED + "Création de Tableau: Un Tableau de type \""+a.typeid.accept(this).strValue +"\" ne peut contenir un élement de type \""+ arrayof+"\"." + ANSI_RESET+" "+"ligne"+" "+lig);
            return res;
        }

        Array tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).strValue, second.objValue);
        // if (second.typeName == "array") {
        //     tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.ar);
        // }else if (second.typeName == "rec") {
        //     tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.rc);
        // } else {
        //     tableau = new Array(a.expr1.accept(this).intValue, a.typeid.accept(this).name, second.objValue);
        // }
        
        res.ar = tableau;
        res.objValue = tableau;

        return res;

    }

    @Override
    public Result visit(RecCreate a) {

        Result res = new Result();
        res.typeName = "rec";
        Rec rc = new Rec();
        rc.type_id = a.typeid.accept(this).strValue;
        Result rer = a.fieldList.accept(this);
        if (rer.recFieldList==null){
            // System.err.println(ANSI_TAB+ANSI_RED+"Can't create Record." + ANSI_RESET);
            return res;
        }
        for (Result r : rer.recFieldList) {
            rc.dict.put(r.strValue, r.objValue);
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
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa : " + r);
        if (c.typeName == "int" && l.typeName == "int") {
            if (r.typeName != "void") {
                int lig = this.numberLine("for"+f.idf.name+":="+this.getAttr(c)+"to"+this.getAttr(l));
                System.err.println(
                        ANSI_RED + "For Error: The body must be of type void" + ANSI_RESET+" "+"ligne"+" "+lig);
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
                    ANSI_RED + "For Error: The start and end index of boucle for must be of type int" + ANSI_RESET+" "+"ligne"+" "+lig);
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
                System.err.println(ANSI_RED + "While Error: The body type must be void" + ANSI_RESET);
            }

        }

        else {
            int lig = this.numberLine("while"+this.getAttr(c)+"do");
            System.err.println(
                    ANSI_RED + "While Error: The condition type must be int" + ANSI_RESET+ " "+ "ligne"+" "+lig);
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
        if ( (lv.lvalueType == "java.lang.Integer" && expr.typeName == "int") || (lv.lvalueType == "java.lang.String" && expr.typeName == "string")){

        }else
        if (!lv.lvalueType.equals(expr.typeName)) {
            int lig1 = this.numberLine(":="+this.getAttr(expr));
            System.err.println(
                    ANSI_RED + "Affect Error: Type mismatch for the variable " +lv.lvalueType + "/" + expr.typeName + ANSI_RESET+" "+"ligne"+" "+lig1);
            return res;
        }
        
        //Entry e = findEntryByName(lv.varIdf, pileRO.peek());
        // System.out.println("obj to affect : " +expr.objValue);
        //AffectLvalue(lv.varIdf, e, expr.objValue ,lv.linkToLvalue, false);
        // System.out.println(ob);
        // printRec((Rec) ob);
        return res;
    }

    @Override
    public Result visit(StrNode d) {
        Result r = new Result();
        r.typeName = "string";
        r.strValue = d.name;
        r.objValue = d.name;
        r.name = d.name;
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
        ArrayList<Entry> e = findAllEntryByName(d.idf.name, pileRO.peek());
        
        Result result = new Result();
        
        Result lis = new Result();
        if (d.exprList != null) {
            lis =  d.exprList.accept(this);
    
        }
        else {
            lis.exprList = new ArrayList<>();
                
        }
        
        if (e == null) {
            String resf = "";
            
                        
            for (int p = 0;p<lis.exprList.size();p++) {
                            
                resf += lis.exprList.get(p).accept(this).name+",";

                        
            }
             
            if (!resf.equals("")) {
                resf = resf.substring(0,resf.length()-1);


            }
            
                        
            int lig = this.numberLine(d.idf.name+"("+resf+")");
            
            System.out.println(ANSI_RED + "name of function undefined"+ANSI_RESET+" ligne "+lig);

             
        }
       
        else {
            String resf = "";
            for (int p = 0;p<lis.exprList.size();p++) {
                            
                resf += lis.exprList.get(p).accept(this).name+",";

                        
            }
            if (!resf.equals("")) {
                resf = resf.substring(0,resf.length()-1);

            }          
            
                        
            int lig = this.numberLine(d.idf.name+"("+resf+")");
            boolean t = false;
            Fonction f = null;
            for (Entry ent : e) {
                if (ent.getClass().getName().equals("tds.Fonction")) {
                    t = true;
                    f = (Fonction)ent;
                    break;

                }
            }
            if (t == false) {
                System.out.print(ANSI_RED + "Name of function undefined; ");
            
                System.out.println(ANSI_RED + "The identifier must refer to a function"+ANSI_RESET+" ligne "+lig);
                return result;

            }
            
            
            
            result.typeName = f.getType();
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
                       
                        System.out.println(ANSI_RED + "The types of actual and formal parameters must be the same" +  ANSI_RESET+" ligne "+lig);

                    }
                }

            }
            


            else {
                
                System.out.println(ANSI_RED + "The number of actual and formal parameters must be the same" +  ANSI_RESET+" ligne "+lig);

            }

            
        }

        return result;
    }

    @Override
    public Result visit(Program d) {
        Tds tds = new Tds(0, -1, -1);
        pileRO.push(0);
        tdsGlobal.add(tds);
        System.out.println();
        System.out.println(ANSI_BLUE + "°°° Construction TDS et contrôles sémantiques" + ANSI_RESET);
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
            Ne.intValue = -Ne.intValue;
            Ne.objValue = - (Integer) Ne.objValue;
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
                System.err.println(ANSI_RED + "Ifthen Error: The then-clause must be of type void" + ANSI_RESET+" "+"ligne"+" "+lig);
                return b;
            }
        } else {
            int lig = this.numberLine("if" +this.getAttr(c));
            System.err.println(ANSI_RED + "Ifthen Error: The condition type must be int" + ANSI_RESET+" "+"ligne"+" "+lig);
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

                System.err.println(ANSI_RED + "IfthenElse error : The then-clause and else-clause must have the same type" + ANSI_RESET+" "+"ligne"+" "+lig1 + " "+"et ligne"+" "+lig2);
                return n;
            }
        }

        else {
            int lig = this.numberLine("if"+this.getAttr(c));
            System.err.println(ANSI_RED + "IfthenElse Error: The condition type must be int" + ANSI_RESET+" "+"ligne"+" "+lig);
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
        res.exprList = new ArrayList<>();
        
        res.exprList.addAll(exprlist.astList);
        
        
        return res;
    }

    @Override
    public Result visit(TypeFieldList typeFieldList) {
        Result r = new Result();
        r.typeDeType = "rectype";
        r.typeFieldList = new HashMap<>();
        r.orderedParams = new ArrayList<>();

        for (Ast a : typeFieldList.astList) {
            Result typefield = a.accept(this);
            r.typeFieldList.put(typefield.typeFieldidf, typefield.typeFieldType);
            r.orderedParams.add(typefield.typeFieldidf);
        }
        return r;
    }

    @Override
    public Result visit(RecFieldList recFieldList) {
        Result res = new Result();
        String type = recFieldList.type.accept(this).strValue;

        Entry e = findEntryByName(type, pileRO.peek());
        if (e == null) {
            System.err.println(ANSI_TAB + ANSI_RED + "Création de Record: Le type \"" + type + "\" n'existe pas." + ANSI_RESET);
            return res;
        }
        if (e.getClass().getName() != "tds.Type") {
            System.err.println(ANSI_TAB + ANSI_RED + "Type Not found Error: " + type + " is the name of a variable or a function."
                    + ANSI_RESET);
            return res;
        }
        Type entry = (Type) e;
        if (entry.typeDeType != "rectype") {
            System.err.println(ANSI_TAB+ANSI_RED + "Création de Record: Le type \"" + type + "\" n'est pas un type Record." + ANSI_RESET);
            return res;
        }

        if (recFieldList.astList.size() != entry.typeFieldDict.size()){
            System.err.println(ANSI_TAB+ ANSI_RED + "Création de Record: Pas assez de champs initialisés." + ANSI_RESET);
            return res;
        }

        ArrayList<Result> recFLRes = new ArrayList<>();
        Boolean b = false;
        for (int i = 0 ; i < recFieldList.astList.size(); i++) {
            Ast a = recFieldList.astList.get(i);
            Result r = a.accept(this);
            if (r.strValue == null){
                b =true;
            }
            recFLRes.add(r);
        }
        if (b){
            return res;
        }
        res.recFieldList = recFLRes;
        return res;

    }

    public void printLv(ArrayList<Ast> lvalue){
        for (Ast a: lvalue){
            System.out.println(a.accept(this).strValue);
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Result visit(LvalueInit lvalueInit) {

        // l'identifiant doit référencer une variable
        // On récupère l'identifiant de la lvalue
        Ast a = lvalueInit.lvalue.get(0);

        // System.out.println("1:"+lvalueInit.lvalue.size());
        // for (Ast b  : lvalueInit.lvalue){
        //     System.out.println(b.accept(this).strValue);
        // }
        Result r = a.accept(this);
        Result returnRes = new Result();
        String idf = r.strValue;
        // On cherche dans la tds cette variable
        Entry e = findEntryByName(idf, pileRO.peek());
        int lig = this.numberLine(idf);
        // Si on ne trouve pas cette idf
        if (e == null) {
            System.err.println(ANSI_TAB+ ANSI_RED + "Variable Non trouvée: \"" + idf + "\" n'existe pas." + ANSI_RESET+" "+"ligne"+" "+lig);
            returnRes.lvalueCorrect = false;
            return returnRes;
        }
        // Si ce n'est pas une variable
        if (e.getClass().getName() != "tds.Var") {
            System.err.println(ANSI_RED + "Variable Non trouvée: " + idf + " n'est pas une variable." + ANSI_RESET+" "+"ligne"+" "+lig);
            returnRes.lvalueCorrect = false;
            return returnRes;
        }
        // Si on a trouvé cette lvalue, on la parcours en entier pour vérifier qu'elle
        // existe
        Rec nR = new Rec();
        nR.dict.put(idf, ((Var) e).valeur);
        Object res = checkLvalue(nR, lvalueInit.lvalue, null, true);
        // System.out.println(res);
        if (res == null){
            returnRes.lvalueCorrect = false;
            return returnRes;
        }
        returnRes.lvalueCorrect = true;
        returnRes.lvalueObject = res;
        returnRes.lvalueType = res.getClass().getName();
        // System.out.println("2:"+lvalueInit.lvalue2.size());
        returnRes.linkToLvalue = lvalueInit.lvalue2;
        returnRes.varObject = ((Var) e).valeur;
        returnRes.varIdf = idf;
        returnRes.strValue = idf;
        returnRes.typeName = ((Var) e).type;
        return returnRes;

    }

    public void AffectLvalue(String idf,Entry e, Object value, ArrayList<Ast> lvalue, Boolean print){
        Object toAffect;
        Object last;
        Object next;
        Boolean first = true;
        Boolean first2 = true;
        Rec nR = new Rec();
        nR.dict.put(idf, ((Var) e).valeur);
        // System.out.println("1:"+e);
        // System.out.println("2:"+ ((Var) e).valeur);
        toAffect = nR;
        next = nR;
        last = e;
        String lastType = "Entry";
        String lastId = "";

        // System.out.println("3:"+nR.dict.get(idf));

        int i = 0;
        
        for (Ast a  : lvalue){
            // System.out.println(a.accept(this).strValue);
        }

        while (lvalue.size()!=0){
                // for (Ast a : lvalue){
            //     System.out.println(a.accept(this).typeName);
            // }

            Result current = lvalue.get(0).accept(this);
            String id = current.strValue; // QUe ce soit une LvalueSub ou un StrNode, on récupère l'id
            // Si l'objet pdans lequel on cherche la suite de la lvalue n'est pas un Rec,
            // cela veut dire que c'est forcément un entier, donc qu'il ne possède pas de
            // sous idf
            // if (toAffect.getClass().getName() != "tds.Rec") {
            //     if (print) {
            //         System.err.println(ANSI_RED + "Variable Not Found: " + id
            //                 + " Bruuuuuuh" + ANSI_RESET);
            //     }
            // }
            // System.out.println(toAffect.getClass().getName());
            // printRec((Rec) obj);
            // ON récupère l'obj correspondant à l'id
            // System.out.println(current.strValue);
            //     System.out.println(last);
            //     System.out.println(next);
            if(!first2){
                last = next;
                first2 = false;
            }
            next = ((Rec) next).dict.get(id);
            // System.out.println(next);
                
            // System.out.println(next);
            // System.out.println(current.typeName);
            // Si c'est une StrNode, on cherche la suite de la lvalue dans l'obj trouvé

            if (current.typeName == "string") {
                // System.out.println("Bruuuuuuh");
                lvalue.remove(0);
                
                if (first){
                    first = false;
                }else{
                    lastType = "string";
                    lastId = id;
                }
                // System.out.println("    " + toAffect);
                // System.out.println(current.strValue);
                // System.out.println(last);
                // System.out.println(next);
                continue;
            }
            // Si c'est une Lvalsub, on vérifie que tout est bien subscriptable
            if (current.typeName == "LvalueSub") {
                // Une lvalueSub est forcément un array
                ArrayList<Result> sub = current.subscript;
                for (Result s : sub) {
                    if (next.getClass().getName() == "tds.Array") {
                        last = next;
                        lastType = "Array";
                        i = s.intValue;
                        next = ((Array) next).values[s.intValue];
                    }
                }
                // puis on cherche la suite de la lvalue dans l'obj trouvé
                lvalue.remove(0);
                // System.out.println("Wot next=" + next.getClass().getName()+ next+lvalue.size());
                toAffect = next;
            }
        }

        if (lastType == "Array"){
            ((Array) last).values[i] = value;
        }else if(lastType == "string"){
            ((Rec) last).dict.put(lastId, value);
            // printRec((Rec) last);
        }else if(lastType == "Entry"){
            ((Var) last).valeur = value;
        }
        // System.out.println(lastId + " " + value  );
        // System.out.println(toAffect);
        // System.out.println(next);
        // System.out.println(last);
    }


    public Object checkLvalue(Object obj, ArrayList<Ast> lvalue, Object affect, Boolean print) {
        // for (Ast a : lvalue){
        //     System.out.println(a.accept(this).typeName);
        // }

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
                System.err.println(ANSI_TAB+ANSI_RED + "Accès à un Record: \""+id+"\" ne peut pas être trouvé car la varible père n'est pas un Record." + ANSI_RESET);
            }
            return null;
        }
        // System.out.println(obj.getClass().getName());
        // printRec((Rec) obj);
        // ON récupère l'obj correspondant à l'id
        Object next = getSubObjInRec(id, (Rec) obj, print);
        // System.out.println(next);
        // System.out.println(current.typeName);
        if (next == null) {
            return null;
        }
        // Si c'est une StrNode, on cherche la suite de la lvalue dans l'obj trouvé
        if (current.typeName == "string") {
            lvalue.remove(0);
            return checkLvalue(next, lvalue, affect, print);
        }
        // Si c'est une Lvalsub, on vérifie que tout est bien subscriptable
        if (current.typeName == "LvalueSub") {
            // Une lvalueSub est forcément un array
            ArrayList<Result> sub = current.subscript;
            for (Result s : sub) {
                if (next.getClass().getName() == "tds.Array") {
                    next = getSubObjInArray(s.intValue, (Array) next, print);
                    if (next == null) {
                        return null;
                    }
                } else {
                    if (print) {
                        System.err.println(
                                ANSI_TAB+ANSI_RED + "Accès à un Tableau: " + id + " n'est pas un Tableau (En anglais: Not subscriptable)." + ANSI_RESET);
                    }
                    return null;
                }
            }
            // puis on cherche la suite de la lvalue dans l'obj trouvé
            lvalue.remove(0);
            // System.out.println("Wot next=" + next.getClass().getName()+ next+lvalue.size());
            return checkLvalue(next, lvalue, affect, print);
        }
        if (print) {
            // System.err.println(
            //         ANSI_YELLOW + "Erreur bizarre dans Lvalue:current is not LvalueSub nor String " + ANSI_RESET);
        }
        return false;
    }

    public Object getSubObjInRec(String name, Rec rec, Boolean print) {
        if (rec.dict.containsKey(name)) {
            return rec.dict.get(name);
        } else {
            if (print) {
                System.err
                        .println(ANSI_TAB+ANSI_RED + "Accès à un Record: \"" + name + "\" n'est pas un champ de la variable." + ANSI_RESET);
            }
            return null;
        }
    }

    public Object getSubObjInArray(Integer i, Array tab, Boolean print) {
        if (i == null) {
            if (print) {
                System.err.println(ANSI_RED + "Accès à un Tableau: le champ entre [_] est inccorect." + ANSI_RESET);
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

    public ArrayList<Entry> findAllEntryByName(String id, int tdsStartIndex) {
        

        ArrayList<Entry> ents = new ArrayList<>();
        int tdsIndex = tdsStartIndex;
        Tds currentTds = tdsGlobal.get(tdsIndex);

        while (tdsIndex != 0) {

            tdsIndex = currentTds.numRegion;
            // Je cherche dans la TDS si le nom existe de la variable
            ArrayList<Entry> e = findAllEntryInTds(id, tdsIndex);  

            if (e == null && currentTds.pere != -1) {
                // Si ce n'est pas le cas je passe à la TDS père
                if (tdsIndex != 0) {currentTds = tdsGlobal.get(currentTds.pere);}
            }
            else{
                
                ents.addAll(e);
                tdsIndex--;
                
            }
        }
        // Si je ne trouve rien, je renvoie null
        return ents;

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

    public ArrayList<Entry> findAllEntryInTds(String id,int tdsIndex) {
        ArrayList<Entry> res = new ArrayList<>();
        Tds currentTds = tdsGlobal.get(tdsIndex);
        String idf;
        Entry goodOne;
        for (Entry e : currentTds.rows) {
            idf = e.getName();
            if (idf.equals(id)) {
                goodOne = e;
                res.add(goodOne);
            }
        }
        return res;




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
        r.name = intNode.value+"";
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
        
        if (l.typeName.equals("int") && r.typeName.equals("int")) {
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
        if (r.varIdf != null) {
            res += r.varIdf;
            return res;
        }
        if (r.lvalueObject != null) {
            res += r.lvalueObject;
            return res;
        }
        
        if (r.objValue != null) {
            res += r.objValue;
            return res;
        }
        
        return res;

    }

    @Override
    public Result visit(Print print) {
        // l'argument doit être de type string
        Result r = new Result();
        Result pr = print.str.accept(this);
        if (pr.typeName == "string"){
            r.typeName = "void";
            r.strValue = pr.name;
            r.objValue = pr.name;
            return r;
        }
        else {
            System.err.println(ANSI_RED + "Print Error: Argument must be type of string");
            return pr;
        }
    }

    @Override
    public Result visit(Entry e) {
        // TODO Auto-generated method stub
        return null;
        
    }

}
