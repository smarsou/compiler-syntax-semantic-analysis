// Generated from expr.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link exprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface exprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link exprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(exprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Nil}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil(exprParser.NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(exprParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(exprParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LvalueExpr}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueExpr(exprParser.LvalueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(exprParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdCreate}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdCreate(exprParser.TypeIdCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThen}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(exprParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(exprParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(exprParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(exprParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(exprParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetInEnd}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetInEnd(exprParser.LetInEndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(exprParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pred_4}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_4(exprParser.Pred_4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code RecCreate}
	 * labeled alternative in {@link exprParser#type_id_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecCreate(exprParser.RecCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayCreate}
	 * labeled alternative in {@link exprParser#type_id_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreate(exprParser.ArrayCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSeqInit}
	 * labeled alternative in {@link exprParser#expr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSeqInit(exprParser.ExprSeqInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSeqAdd}
	 * labeled alternative in {@link exprParser#expr_seq_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSeqAdd(exprParser.ExprSeqAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSeqFinish}
	 * labeled alternative in {@link exprParser#expr_seq_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSeqFinish(exprParser.ExprSeqFinishContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprListInit}
	 * labeled alternative in {@link exprParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprListInit(exprParser.ExprListInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprListAdd}
	 * labeled alternative in {@link exprParser#expr_list_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprListAdd(exprParser.ExprListAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprListFinish}
	 * labeled alternative in {@link exprParser#expr_list_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprListFinish(exprParser.ExprListFinishContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecField}
	 * labeled alternative in {@link exprParser#rec_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecField(exprParser.RecFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecFieldListInit}
	 * labeled alternative in {@link exprParser#rec_field_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecFieldListInit(exprParser.RecFieldListInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecFieldListAdd}
	 * labeled alternative in {@link exprParser#rec_field_list_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecFieldListAdd(exprParser.RecFieldListAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecFieldListFinish}
	 * labeled alternative in {@link exprParser#rec_field_list_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecFieldListFinish(exprParser.RecFieldListFinishContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LvalueInit}
	 * labeled alternative in {@link exprParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueInit(exprParser.LvalueInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LvalueAdd}
	 * labeled alternative in {@link exprParser#lvalue_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueAdd(exprParser.LvalueAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LvalueSubscript}
	 * labeled alternative in {@link exprParser#lvalue_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueSubscript(exprParser.LvalueSubscriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LvalueFinish}
	 * labeled alternative in {@link exprParser#lvalue_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueFinish(exprParser.LvalueFinishContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#lvalue_call_or_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue_call_or_declare(exprParser.Lvalue_call_or_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_list(exprParser.Declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(exprParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecType}
	 * labeled alternative in {@link exprParser#type_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecType(exprParser.DecTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeId}
	 * labeled alternative in {@link exprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeId(exprParser.TypeIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecType}
	 * labeled alternative in {@link exprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecType(exprParser.RecTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link exprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(exprParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeFieldListInit}
	 * labeled alternative in {@link exprParser#type_field_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFieldListInit(exprParser.TypeFieldListInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeFieldListAdd}
	 * labeled alternative in {@link exprParser#type_field_list_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFieldListAdd(exprParser.TypeFieldListAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeFieldListFinish}
	 * labeled alternative in {@link exprParser#type_field_list_prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFieldListFinish(exprParser.TypeFieldListFinishContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeField}
	 * labeled alternative in {@link exprParser#type_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeField(exprParser.TypeFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#type_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_id(exprParser.Type_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecVarTypeNotSpec}
	 * labeled alternative in {@link exprParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecVarTypeNotSpec(exprParser.DecVarTypeNotSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecVarTypeSpec}
	 * labeled alternative in {@link exprParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecVarTypeSpec(exprParser.DecVarTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecFunctVoid}
	 * labeled alternative in {@link exprParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecFunctVoid(exprParser.DecFunctVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecFunctWithReturnType}
	 * labeled alternative in {@link exprParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecFunctWithReturnType(exprParser.DecFunctWithReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#precedence_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence_1(exprParser.Precedence_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#precedence_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence_2(exprParser.Precedence_2Context ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#precedence_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence_3(exprParser.Precedence_3Context ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#precedence_4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence_4(exprParser.Precedence_4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code rec_negate}
	 * labeled alternative in {@link exprParser#negate_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRec_negate(exprParser.Rec_negateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link exprParser#negate_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(exprParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link exprParser#negate_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(exprParser.ExpressionContext ctx);
}