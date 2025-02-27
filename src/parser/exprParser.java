// Generated from ./expr.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, ID=42, INT=43, STR=44, WS=45, COMMENT=46;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_instruction = 2, RULE_type_id_prime = 3, 
		RULE_expr_seq = 4, RULE_expr_seq_prime = 5, RULE_expr_list = 6, RULE_expr_list_prime = 7, 
		RULE_rec_field = 8, RULE_rec_field_list = 9, RULE_rec_field_list_prime = 10, 
		RULE_lvalue = 11, RULE_lvalue_prime = 12, RULE_lvalue_call_or_declare = 13, 
		RULE_declaration_list = 14, RULE_declaration = 15, RULE_type_declaration = 16, 
		RULE_type = 17, RULE_type_field_list = 18, RULE_type_field_list_prime = 19, 
		RULE_type_field = 20, RULE_type_id = 21, RULE_variable_declaration = 22, 
		RULE_function_declaration = 23, RULE_binary_operation = 24, RULE_precedence_1 = 25, 
		RULE_precedence_2 = 26, RULE_precedence_3 = 27, RULE_precedence_4 = 28, 
		RULE_negate_instruction = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "instruction", "type_id_prime", "expr_seq", "expr_seq_prime", 
			"expr_list", "expr_list_prime", "rec_field", "rec_field_list", "rec_field_list_prime", 
			"lvalue", "lvalue_prime", "lvalue_call_or_declare", "declaration_list", 
			"declaration", "type_declaration", "type", "type_field_list", "type_field_list_prime", 
			"type_field", "type_id", "variable_declaration", "function_declaration", 
			"binary_operation", "precedence_1", "precedence_2", "precedence_3", "precedence_4", 
			"negate_instruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'nil'", "'('", "')'", "'if'", "'then'", "'else'", "'while'", "'do'", 
			"'for'", "':='", "'to'", "'break'", "'let'", "'in'", "'end'", "'print'", 
			"'{'", "'}'", "'['", "']'", "'of'", "';'", "','", "'='", "'.'", "'type'", 
			"'array'", "':'", "'var'", "'function'", "'*'", "'/'", "'+'", "'-'", 
			"'<>'", "'<'", "'>'", "'<='", "'>='", "'&'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "ID", "INT", "STR", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public exprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(exprParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				expr();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__33) | (1L << ID) | (1L << INT) | (1L << STR))) != 0) );
			setState(65);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public Binary_operationContext binary_operation() {
			return getRuleContext(Binary_operationContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				binary_operation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeIdCreateContext extends InstructionContext {
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Type_id_primeContext type_id_prime() {
			return getRuleContext(Type_id_primeContext.class,0);
		}
		public TypeIdCreateContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTypeIdCreate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetInEndContext extends InstructionContext {
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public Expr_seqContext expr_seq() {
			return getRuleContext(Expr_seqContext.class,0);
		}
		public LetInEndContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLetInEnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForContext extends InstructionContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends InstructionContext {
		public BreakContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends InstructionContext {
		public TerminalNode STR() { return getToken(exprParser.STR, 0); }
		public StringContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends InstructionContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WhileContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenContext extends InstructionContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfThenContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIfThen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NilContext extends InstructionContext {
		public NilContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNil(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends InstructionContext {
		public TerminalNode INT() { return getToken(exprParser.INT, 0); }
		public IntegerContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends InstructionContext {
		public TerminalNode STR() { return getToken(exprParser.STR, 0); }
		public TerminalNode INT() { return getToken(exprParser.INT, 0); }
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public PrintContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends InstructionContext {
		public Expr_seqContext expr_seq() {
			return getRuleContext(Expr_seqContext.class,0);
		}
		public ParenthesisContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueExprContext extends InstructionContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public Lvalue_call_or_declareContext lvalue_call_or_declare() {
			return getRuleContext(Lvalue_call_or_declareContext.class,0);
		}
		public LvalueExprContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExprContext extends InstructionContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public CallExprContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseContext extends InstructionContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfThenElseContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new NilContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(T__0);
				}
				break;
			case 2:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(INT);
				}
				break;
			case 3:
				_localctx = new CallExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(ID);
				setState(74);
				match(T__1);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__33) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(75);
					expr_list();
					}
				}

				setState(78);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(STR);
				}
				break;
			case 5:
				_localctx = new LvalueExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				lvalue();
				setState(81);
				lvalue_call_or_declare();
				}
				break;
			case 6:
				_localctx = new ParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				match(T__1);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__33) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(84);
					expr_seq();
					}
				}

				setState(87);
				match(T__2);
				}
				break;
			case 7:
				_localctx = new TypeIdCreateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				type_id();
				setState(89);
				type_id_prime();
				}
				break;
			case 8:
				_localctx = new IfThenContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(91);
				match(T__3);
				setState(92);
				expr();
				setState(93);
				match(T__4);
				setState(94);
				expr();
				}
				break;
			case 9:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(96);
				match(T__3);
				setState(97);
				expr();
				setState(98);
				match(T__4);
				setState(99);
				expr();
				setState(100);
				match(T__5);
				setState(101);
				expr();
				}
				break;
			case 10:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(103);
				match(T__6);
				setState(104);
				expr();
				setState(105);
				match(T__7);
				setState(106);
				expr();
				}
				break;
			case 11:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(108);
				match(T__8);
				setState(109);
				match(ID);
				setState(110);
				match(T__9);
				setState(111);
				expr();
				setState(112);
				match(T__10);
				setState(113);
				expr();
				setState(114);
				match(T__7);
				setState(115);
				expr();
				}
				break;
			case 12:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(117);
				match(T__11);
				}
				break;
			case 13:
				_localctx = new LetInEndContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(118);
				match(T__12);
				setState(119);
				declaration_list();
				setState(120);
				match(T__13);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__33) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(121);
					expr_seq();
					}
				}

				setState(124);
				match(T__14);
				}
				break;
			case 14:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(126);
				match(T__15);
				setState(127);
				match(T__1);
				setState(128);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << STR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(129);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_id_primeContext extends ParserRuleContext {
		public Type_id_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id_prime; }
	 
		public Type_id_primeContext() { }
		public void copyFrom(Type_id_primeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayCreateContext extends Type_id_primeContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayCreateContext(Type_id_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitArrayCreate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecCreateContext extends Type_id_primeContext {
		public Rec_field_listContext rec_field_list() {
			return getRuleContext(Rec_field_listContext.class,0);
		}
		public RecCreateContext(Type_id_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_id_primeContext type_id_prime() throws RecognitionException {
		Type_id_primeContext _localctx = new Type_id_primeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_id_prime);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				_localctx = new RecCreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T__16);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(133);
					rec_field_list();
					}
				}

				setState(136);
				match(T__17);
				}
				break;
			case T__18:
				_localctx = new ArrayCreateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(T__18);
				setState(138);
				expr();
				setState(139);
				match(T__19);
				setState(140);
				match(T__20);
				setState(141);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_seqContext extends ParserRuleContext {
		public Expr_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_seq; }
	 
		public Expr_seqContext() { }
		public void copyFrom(Expr_seqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprSeqInitContext extends Expr_seqContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_seq_primeContext expr_seq_prime() {
			return getRuleContext(Expr_seq_primeContext.class,0);
		}
		public ExprSeqInitContext(Expr_seqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExprSeqInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_seqContext expr_seq() throws RecognitionException {
		Expr_seqContext _localctx = new Expr_seqContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr_seq);
		try {
			_localctx = new ExprSeqInitContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			expr();
			setState(146);
			expr_seq_prime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_seq_primeContext extends ParserRuleContext {
		public Expr_seq_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_seq_prime; }
	 
		public Expr_seq_primeContext() { }
		public void copyFrom(Expr_seq_primeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprSeqFinishContext extends Expr_seq_primeContext {
		public ExprSeqFinishContext(Expr_seq_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExprSeqFinish(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSeqAddContext extends Expr_seq_primeContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_seq_primeContext expr_seq_prime() {
			return getRuleContext(Expr_seq_primeContext.class,0);
		}
		public ExprSeqAddContext(Expr_seq_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExprSeqAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_seq_primeContext expr_seq_prime() throws RecognitionException {
		Expr_seq_primeContext _localctx = new Expr_seq_primeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr_seq_prime);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				_localctx = new ExprSeqAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(T__21);
				setState(149);
				expr();
				setState(150);
				expr_seq_prime();
				}
				break;
			case T__2:
			case T__14:
				_localctx = new ExprSeqFinishContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
	 
		public Expr_listContext() { }
		public void copyFrom(Expr_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprListInitContext extends Expr_listContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_primeContext expr_list_prime() {
			return getRuleContext(Expr_list_primeContext.class,0);
		}
		public ExprListInitContext(Expr_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExprListInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr_list);
		try {
			_localctx = new ExprListInitContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			expr();
			setState(156);
			expr_list_prime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_list_primeContext extends ParserRuleContext {
		public Expr_list_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list_prime; }
	 
		public Expr_list_primeContext() { }
		public void copyFrom(Expr_list_primeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprListAddContext extends Expr_list_primeContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_primeContext expr_list_prime() {
			return getRuleContext(Expr_list_primeContext.class,0);
		}
		public ExprListAddContext(Expr_list_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExprListAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprListFinishContext extends Expr_list_primeContext {
		public ExprListFinishContext(Expr_list_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExprListFinish(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_list_primeContext expr_list_prime() throws RecognitionException {
		Expr_list_primeContext _localctx = new Expr_list_primeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr_list_prime);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				_localctx = new ExprListAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(T__22);
				setState(159);
				expr();
				setState(160);
				expr_list_prime();
				}
				break;
			case T__2:
				_localctx = new ExprListFinishContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rec_fieldContext extends ParserRuleContext {
		public Rec_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rec_field; }
	 
		public Rec_fieldContext() { }
		public void copyFrom(Rec_fieldContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RecFieldContext extends Rec_fieldContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RecFieldContext(Rec_fieldContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rec_fieldContext rec_field() throws RecognitionException {
		Rec_fieldContext _localctx = new Rec_fieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rec_field);
		try {
			_localctx = new RecFieldContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
			setState(166);
			match(T__23);
			setState(167);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rec_field_listContext extends ParserRuleContext {
		public Rec_field_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rec_field_list; }
	 
		public Rec_field_listContext() { }
		public void copyFrom(Rec_field_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RecFieldListInitContext extends Rec_field_listContext {
		public Rec_fieldContext rec_field() {
			return getRuleContext(Rec_fieldContext.class,0);
		}
		public Rec_field_list_primeContext rec_field_list_prime() {
			return getRuleContext(Rec_field_list_primeContext.class,0);
		}
		public RecFieldListInitContext(Rec_field_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecFieldListInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rec_field_listContext rec_field_list() throws RecognitionException {
		Rec_field_listContext _localctx = new Rec_field_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rec_field_list);
		try {
			_localctx = new RecFieldListInitContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			rec_field();
			setState(170);
			rec_field_list_prime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rec_field_list_primeContext extends ParserRuleContext {
		public Rec_field_list_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rec_field_list_prime; }
	 
		public Rec_field_list_primeContext() { }
		public void copyFrom(Rec_field_list_primeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RecFieldListFinishContext extends Rec_field_list_primeContext {
		public RecFieldListFinishContext(Rec_field_list_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecFieldListFinish(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecFieldListAddContext extends Rec_field_list_primeContext {
		public Rec_fieldContext rec_field() {
			return getRuleContext(Rec_fieldContext.class,0);
		}
		public Rec_field_list_primeContext rec_field_list_prime() {
			return getRuleContext(Rec_field_list_primeContext.class,0);
		}
		public RecFieldListAddContext(Rec_field_list_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecFieldListAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rec_field_list_primeContext rec_field_list_prime() throws RecognitionException {
		Rec_field_list_primeContext _localctx = new Rec_field_list_primeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rec_field_list_prime);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				_localctx = new RecFieldListAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(T__22);
				setState(173);
				rec_field();
				setState(174);
				rec_field_list_prime();
				}
				break;
			case T__17:
				_localctx = new RecFieldListFinishContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LvalueInitContext extends LvalueContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Lvalue_primeContext lvalue_prime() {
			return getRuleContext(Lvalue_primeContext.class,0);
		}
		public LvalueInitContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalueInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_lvalue);
		try {
			_localctx = new LvalueInitContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ID);
			setState(180);
			lvalue_prime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lvalue_primeContext extends ParserRuleContext {
		public Lvalue_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue_prime; }
	 
		public Lvalue_primeContext() { }
		public void copyFrom(Lvalue_primeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LvalueSubscriptContext extends Lvalue_primeContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Lvalue_primeContext lvalue_prime() {
			return getRuleContext(Lvalue_primeContext.class,0);
		}
		public LvalueSubscriptContext(Lvalue_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalueSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueAddContext extends Lvalue_primeContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Lvalue_primeContext lvalue_prime() {
			return getRuleContext(Lvalue_primeContext.class,0);
		}
		public LvalueAddContext(Lvalue_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalueAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueFinishContext extends Lvalue_primeContext {
		public LvalueFinishContext(Lvalue_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalueFinish(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lvalue_primeContext lvalue_prime() throws RecognitionException {
		Lvalue_primeContext _localctx = new Lvalue_primeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lvalue_prime);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				_localctx = new LvalueAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(T__24);
				setState(183);
				match(ID);
				setState(184);
				lvalue_prime();
				}
				break;
			case T__18:
				_localctx = new LvalueSubscriptContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(T__18);
				setState(186);
				expr();
				setState(187);
				match(T__19);
				setState(188);
				lvalue_prime();
				}
				break;
			case EOF:
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__19:
			case T__21:
			case T__22:
			case T__23:
			case T__25:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case ID:
			case INT:
			case STR:
				_localctx = new LvalueFinishContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lvalue_call_or_declareContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Lvalue_call_or_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue_call_or_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalue_call_or_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lvalue_call_or_declareContext lvalue_call_or_declare() throws RecognitionException {
		Lvalue_call_or_declareContext _localctx = new Lvalue_call_or_declareContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lvalue_call_or_declare);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(T__9);
				setState(194);
				expr();
				}
				break;
			case EOF:
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__19:
			case T__21:
			case T__22:
			case T__23:
			case T__25:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case ID:
			case INT:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaration_listContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDeclaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(198);
				declaration();
				}
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__28) | (1L << T__29))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public Function_declarationContext function_declaration() {
			return getRuleContext(Function_declarationContext.class,0);
		}
		public Type_declarationContext type_declaration() {
			return getRuleContext(Type_declarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_declaration);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				variable_declaration();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				function_declaration();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				type_declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_declarationContext extends ParserRuleContext {
		public Type_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_declaration; }
	 
		public Type_declarationContext() { }
		public void copyFrom(Type_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecTypeContext extends Type_declarationContext {
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DecTypeContext(Type_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDecType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_declarationContext type_declaration() throws RecognitionException {
		Type_declarationContext _localctx = new Type_declarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type_declaration);
		try {
			_localctx = new DecTypeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__25);
			setState(209);
			type_id();
			setState(210);
			match(T__23);
			setState(211);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdContext extends TypeContext {
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public TypeIdContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecTypeContext extends TypeContext {
		public Type_field_listContext type_field_list() {
			return getRuleContext(Type_field_listContext.class,0);
		}
		public RecTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new TypeIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				type_id();
				}
				break;
			case T__16:
				_localctx = new RecTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__16);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(215);
					type_field_list();
					}
				}

				setState(218);
				match(T__17);
				}
				break;
			case T__26:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(T__26);
				setState(220);
				match(T__20);
				setState(221);
				type_id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_field_listContext extends ParserRuleContext {
		public Type_field_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_field_list; }
	 
		public Type_field_listContext() { }
		public void copyFrom(Type_field_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeFieldListInitContext extends Type_field_listContext {
		public Type_fieldContext type_field() {
			return getRuleContext(Type_fieldContext.class,0);
		}
		public Type_field_list_primeContext type_field_list_prime() {
			return getRuleContext(Type_field_list_primeContext.class,0);
		}
		public TypeFieldListInitContext(Type_field_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTypeFieldListInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_field_listContext type_field_list() throws RecognitionException {
		Type_field_listContext _localctx = new Type_field_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type_field_list);
		try {
			_localctx = new TypeFieldListInitContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			type_field();
			setState(225);
			type_field_list_prime();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_field_list_primeContext extends ParserRuleContext {
		public Type_field_list_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_field_list_prime; }
	 
		public Type_field_list_primeContext() { }
		public void copyFrom(Type_field_list_primeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeFieldListFinishContext extends Type_field_list_primeContext {
		public TypeFieldListFinishContext(Type_field_list_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTypeFieldListFinish(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeFieldListAddContext extends Type_field_list_primeContext {
		public Type_fieldContext type_field() {
			return getRuleContext(Type_fieldContext.class,0);
		}
		public Type_field_list_primeContext type_field_list_prime() {
			return getRuleContext(Type_field_list_primeContext.class,0);
		}
		public TypeFieldListAddContext(Type_field_list_primeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTypeFieldListAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_field_list_primeContext type_field_list_prime() throws RecognitionException {
		Type_field_list_primeContext _localctx = new Type_field_list_primeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type_field_list_prime);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				_localctx = new TypeFieldListAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(T__22);
				setState(228);
				type_field();
				setState(229);
				type_field_list_prime();
				}
				break;
			case T__2:
			case T__17:
				_localctx = new TypeFieldListFinishContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_fieldContext extends ParserRuleContext {
		public Type_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_field; }
	 
		public Type_fieldContext() { }
		public void copyFrom(Type_fieldContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeFieldContext extends Type_fieldContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public TypeFieldContext(Type_fieldContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTypeField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_fieldContext type_field() throws RecognitionException {
		Type_fieldContext _localctx = new Type_fieldContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type_field);
		try {
			_localctx = new TypeFieldContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(ID);
			setState(235);
			match(T__27);
			setState(236);
			type_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Type_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitType_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_idContext type_id() throws RecognitionException {
		Type_idContext _localctx = new Type_idContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_declarationContext extends ParserRuleContext {
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
	 
		public Variable_declarationContext() { }
		public void copyFrom(Variable_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecVarTypeSpecContext extends Variable_declarationContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DecVarTypeSpecContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDecVarTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecVarTypeNotSpecContext extends Variable_declarationContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DecVarTypeNotSpecContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDecVarTypeNotSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variable_declaration);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new DecVarTypeNotSpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(T__28);
				setState(241);
				match(ID);
				setState(242);
				match(T__9);
				setState(243);
				expr();
				}
				break;
			case 2:
				_localctx = new DecVarTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(T__28);
				setState(245);
				match(ID);
				setState(246);
				match(T__27);
				setState(247);
				type_id();
				setState(248);
				match(T__9);
				setState(249);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_declarationContext extends ParserRuleContext {
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
	 
		public Function_declarationContext() { }
		public void copyFrom(Function_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecFunctWithReturnTypeContext extends Function_declarationContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_field_listContext type_field_list() {
			return getRuleContext(Type_field_listContext.class,0);
		}
		public DecFunctWithReturnTypeContext(Function_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDecFunctWithReturnType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecFunctVoidContext extends Function_declarationContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_field_listContext type_field_list() {
			return getRuleContext(Type_field_listContext.class,0);
		}
		public DecFunctVoidContext(Function_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDecFunctVoid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_declaration);
		int _la;
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new DecFunctVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(T__29);
				setState(254);
				match(ID);
				setState(255);
				match(T__1);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(256);
					type_field_list();
					}
				}

				setState(259);
				match(T__2);
				setState(260);
				match(T__23);
				setState(261);
				expr();
				}
				break;
			case 2:
				_localctx = new DecFunctWithReturnTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(T__29);
				setState(263);
				match(ID);
				setState(264);
				match(T__1);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(265);
					type_field_list();
					}
				}

				setState(268);
				match(T__2);
				setState(269);
				match(T__27);
				setState(270);
				type_id();
				setState(271);
				match(T__23);
				setState(272);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operationContext extends ParserRuleContext {
		public Precedence_4Context precedence_4() {
			return getRuleContext(Precedence_4Context.class,0);
		}
		public Binary_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitBinary_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operationContext binary_operation() throws RecognitionException {
		Binary_operationContext _localctx = new Binary_operationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_binary_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			precedence_4();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence_1Context extends ParserRuleContext {
		public List<Negate_instructionContext> negate_instruction() {
			return getRuleContexts(Negate_instructionContext.class);
		}
		public Negate_instructionContext negate_instruction(int i) {
			return getRuleContext(Negate_instructionContext.class,i);
		}
		public Precedence_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence_1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitPrecedence_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence_1Context precedence_1() throws RecognitionException {
		Precedence_1Context _localctx = new Precedence_1Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_precedence_1);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			negate_instruction();
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(279);
					_la = _input.LA(1);
					if ( !(_la==T__30 || _la==T__31) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(280);
					negate_instruction();
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence_2Context extends ParserRuleContext {
		public List<Precedence_1Context> precedence_1() {
			return getRuleContexts(Precedence_1Context.class);
		}
		public Precedence_1Context precedence_1(int i) {
			return getRuleContext(Precedence_1Context.class,i);
		}
		public Precedence_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence_2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitPrecedence_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence_2Context precedence_2() throws RecognitionException {
		Precedence_2Context _localctx = new Precedence_2Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_precedence_2);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			precedence_1();
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(287);
					_la = _input.LA(1);
					if ( !(_la==T__32 || _la==T__33) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(288);
					precedence_1();
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence_3Context extends ParserRuleContext {
		public List<Precedence_2Context> precedence_2() {
			return getRuleContexts(Precedence_2Context.class);
		}
		public Precedence_2Context precedence_2(int i) {
			return getRuleContext(Precedence_2Context.class,i);
		}
		public Precedence_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence_3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitPrecedence_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence_3Context precedence_3() throws RecognitionException {
		Precedence_3Context _localctx = new Precedence_3Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_precedence_3);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			precedence_2();
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(295);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(296);
					precedence_2();
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence_4Context extends ParserRuleContext {
		public List<Precedence_3Context> precedence_3() {
			return getRuleContexts(Precedence_3Context.class);
		}
		public Precedence_3Context precedence_3(int i) {
			return getRuleContext(Precedence_3Context.class,i);
		}
		public Precedence_4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence_4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitPrecedence_4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence_4Context precedence_4() throws RecognitionException {
		Precedence_4Context _localctx = new Precedence_4Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_precedence_4);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			precedence_3();
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(303);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(304);
					precedence_3();
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Negate_instructionContext extends ParserRuleContext {
		public Negate_instructionContext negate_instruction() {
			return getRuleContext(Negate_instructionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public Negate_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negate_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNegate_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negate_instructionContext negate_instruction() throws RecognitionException {
		Negate_instructionContext _localctx = new Negate_instructionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_negate_instruction);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(T__33);
				setState(311);
				negate_instruction();
				}
				break;
			case T__0:
			case T__1:
			case T__3:
			case T__6:
			case T__8:
			case T__11:
			case T__12:
			case T__15:
			case ID:
			case INT:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				instruction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u013e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\6\2@"+
		"\n\2\r\2\16\2A\3\2\3\2\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4}\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\u0085\n\4\3\5\3\5\5\5\u0089\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0092"+
		"\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7\u009c\n\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u00a6\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00b4\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00c2\n\16\3\17\3\17\3\17\5\17\u00c7\n\17\3\20\6\20\u00ca"+
		"\n\20\r\20\16\20\u00cb\3\21\3\21\3\21\5\21\u00d1\n\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\5\23\u00db\n\23\3\23\3\23\3\23\3\23\5\23\u00e1"+
		"\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u00eb\n\25\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u00fe\n\30\3\31\3\31\3\31\3\31\5\31\u0104\n\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\5\31\u010d\n\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0115\n\31\3\32\3\32\3\33\3\33\3\33\7\33\u011c\n\33\f\33\16\33\u011f"+
		"\13\33\3\34\3\34\3\34\7\34\u0124\n\34\f\34\16\34\u0127\13\34\3\35\3\35"+
		"\3\35\7\35\u012c\n\35\f\35\16\35\u012f\13\35\3\36\3\36\3\36\7\36\u0134"+
		"\n\36\f\36\16\36\u0137\13\36\3\37\3\37\3\37\5\37\u013c\n\37\3\37\2\2 "+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\7\3"+
		"\2,.\3\2!\"\3\2#$\4\2\32\32%)\3\2*+\2\u0149\2?\3\2\2\2\4G\3\2\2\2\6\u0084"+
		"\3\2\2\2\b\u0091\3\2\2\2\n\u0093\3\2\2\2\f\u009b\3\2\2\2\16\u009d\3\2"+
		"\2\2\20\u00a5\3\2\2\2\22\u00a7\3\2\2\2\24\u00ab\3\2\2\2\26\u00b3\3\2\2"+
		"\2\30\u00b5\3\2\2\2\32\u00c1\3\2\2\2\34\u00c6\3\2\2\2\36\u00c9\3\2\2\2"+
		" \u00d0\3\2\2\2\"\u00d2\3\2\2\2$\u00e0\3\2\2\2&\u00e2\3\2\2\2(\u00ea\3"+
		"\2\2\2*\u00ec\3\2\2\2,\u00f0\3\2\2\2.\u00fd\3\2\2\2\60\u0114\3\2\2\2\62"+
		"\u0116\3\2\2\2\64\u0118\3\2\2\2\66\u0120\3\2\2\28\u0128\3\2\2\2:\u0130"+
		"\3\2\2\2<\u013b\3\2\2\2>@\5\4\3\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2BC\3\2\2\2CD\7\2\2\3D\3\3\2\2\2EH\5\6\4\2FH\5\62\32\2GE\3\2\2\2GF"+
		"\3\2\2\2H\5\3\2\2\2I\u0085\7\3\2\2J\u0085\7-\2\2KL\7,\2\2LN\7\4\2\2MO"+
		"\5\16\b\2NM\3\2\2\2NO\3\2\2\2OP\3\2\2\2P\u0085\7\5\2\2Q\u0085\7.\2\2R"+
		"S\5\30\r\2ST\5\34\17\2T\u0085\3\2\2\2UW\7\4\2\2VX\5\n\6\2WV\3\2\2\2WX"+
		"\3\2\2\2XY\3\2\2\2Y\u0085\7\5\2\2Z[\5,\27\2[\\\5\b\5\2\\\u0085\3\2\2\2"+
		"]^\7\6\2\2^_\5\4\3\2_`\7\7\2\2`a\5\4\3\2a\u0085\3\2\2\2bc\7\6\2\2cd\5"+
		"\4\3\2de\7\7\2\2ef\5\4\3\2fg\7\b\2\2gh\5\4\3\2h\u0085\3\2\2\2ij\7\t\2"+
		"\2jk\5\4\3\2kl\7\n\2\2lm\5\4\3\2m\u0085\3\2\2\2no\7\13\2\2op\7,\2\2pq"+
		"\7\f\2\2qr\5\4\3\2rs\7\r\2\2st\5\4\3\2tu\7\n\2\2uv\5\4\3\2v\u0085\3\2"+
		"\2\2w\u0085\7\16\2\2xy\7\17\2\2yz\5\36\20\2z|\7\20\2\2{}\5\n\6\2|{\3\2"+
		"\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\21\2\2\177\u0085\3\2\2\2\u0080\u0081\7"+
		"\22\2\2\u0081\u0082\7\4\2\2\u0082\u0083\t\2\2\2\u0083\u0085\7\5\2\2\u0084"+
		"I\3\2\2\2\u0084J\3\2\2\2\u0084K\3\2\2\2\u0084Q\3\2\2\2\u0084R\3\2\2\2"+
		"\u0084U\3\2\2\2\u0084Z\3\2\2\2\u0084]\3\2\2\2\u0084b\3\2\2\2\u0084i\3"+
		"\2\2\2\u0084n\3\2\2\2\u0084w\3\2\2\2\u0084x\3\2\2\2\u0084\u0080\3\2\2"+
		"\2\u0085\7\3\2\2\2\u0086\u0088\7\23\2\2\u0087\u0089\5\24\13\2\u0088\u0087"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0092\7\24\2\2"+
		"\u008b\u008c\7\25\2\2\u008c\u008d\5\4\3\2\u008d\u008e\7\26\2\2\u008e\u008f"+
		"\7\27\2\2\u008f\u0090\5\4\3\2\u0090\u0092\3\2\2\2\u0091\u0086\3\2\2\2"+
		"\u0091\u008b\3\2\2\2\u0092\t\3\2\2\2\u0093\u0094\5\4\3\2\u0094\u0095\5"+
		"\f\7\2\u0095\13\3\2\2\2\u0096\u0097\7\30\2\2\u0097\u0098\5\4\3\2\u0098"+
		"\u0099\5\f\7\2\u0099\u009c\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0096\3\2"+
		"\2\2\u009b\u009a\3\2\2\2\u009c\r\3\2\2\2\u009d\u009e\5\4\3\2\u009e\u009f"+
		"\5\20\t\2\u009f\17\3\2\2\2\u00a0\u00a1\7\31\2\2\u00a1\u00a2\5\4\3\2\u00a2"+
		"\u00a3\5\20\t\2\u00a3\u00a6\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a0\3"+
		"\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\21\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9"+
		"\7\32\2\2\u00a9\u00aa\5\4\3\2\u00aa\23\3\2\2\2\u00ab\u00ac\5\22\n\2\u00ac"+
		"\u00ad\5\26\f\2\u00ad\25\3\2\2\2\u00ae\u00af\7\31\2\2\u00af\u00b0\5\22"+
		"\n\2\u00b0\u00b1\5\26\f\2\u00b1\u00b4\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00ae\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\27\3\2\2\2\u00b5\u00b6\7,\2\2"+
		"\u00b6\u00b7\5\32\16\2\u00b7\31\3\2\2\2\u00b8\u00b9\7\33\2\2\u00b9\u00ba"+
		"\7,\2\2\u00ba\u00c2\5\32\16\2\u00bb\u00bc\7\25\2\2\u00bc\u00bd\5\4\3\2"+
		"\u00bd\u00be\7\26\2\2\u00be\u00bf\5\32\16\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00c2\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c1\u00c0\3\2"+
		"\2\2\u00c2\33\3\2\2\2\u00c3\u00c4\7\f\2\2\u00c4\u00c7\5\4\3\2\u00c5\u00c7"+
		"\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\35\3\2\2\2\u00c8"+
		"\u00ca\5 \21\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\37\3\2\2\2\u00cd\u00d1\5.\30\2\u00ce\u00d1"+
		"\5\60\31\2\u00cf\u00d1\5\"\22\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2"+
		"\2\u00d0\u00cf\3\2\2\2\u00d1!\3\2\2\2\u00d2\u00d3\7\34\2\2\u00d3\u00d4"+
		"\5,\27\2\u00d4\u00d5\7\32\2\2\u00d5\u00d6\5$\23\2\u00d6#\3\2\2\2\u00d7"+
		"\u00e1\5,\27\2\u00d8\u00da\7\23\2\2\u00d9\u00db\5&\24\2\u00da\u00d9\3"+
		"\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e1\7\24\2\2\u00dd"+
		"\u00de\7\35\2\2\u00de\u00df\7\27\2\2\u00df\u00e1\5,\27\2\u00e0\u00d7\3"+
		"\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e1%\3\2\2\2\u00e2\u00e3"+
		"\5*\26\2\u00e3\u00e4\5(\25\2\u00e4\'\3\2\2\2\u00e5\u00e6\7\31\2\2\u00e6"+
		"\u00e7\5*\26\2\u00e7\u00e8\5(\25\2\u00e8\u00eb\3\2\2\2\u00e9\u00eb\3\2"+
		"\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb)\3\2\2\2\u00ec\u00ed"+
		"\7,\2\2\u00ed\u00ee\7\36\2\2\u00ee\u00ef\5,\27\2\u00ef+\3\2\2\2\u00f0"+
		"\u00f1\7,\2\2\u00f1-\3\2\2\2\u00f2\u00f3\7\37\2\2\u00f3\u00f4\7,\2\2\u00f4"+
		"\u00f5\7\f\2\2\u00f5\u00fe\5\4\3\2\u00f6\u00f7\7\37\2\2\u00f7\u00f8\7"+
		",\2\2\u00f8\u00f9\7\36\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\7\f\2\2\u00fb"+
		"\u00fc\5\4\3\2\u00fc\u00fe\3\2\2\2\u00fd\u00f2\3\2\2\2\u00fd\u00f6\3\2"+
		"\2\2\u00fe/\3\2\2\2\u00ff\u0100\7 \2\2\u0100\u0101\7,\2\2\u0101\u0103"+
		"\7\4\2\2\u0102\u0104\5&\24\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\7\5\2\2\u0106\u0107\7\32\2\2\u0107\u0115\5"+
		"\4\3\2\u0108\u0109\7 \2\2\u0109\u010a\7,\2\2\u010a\u010c\7\4\2\2\u010b"+
		"\u010d\5&\24\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u010f\7\5\2\2\u010f\u0110\7\36\2\2\u0110\u0111\5,\27\2\u0111"+
		"\u0112\7\32\2\2\u0112\u0113\5\4\3\2\u0113\u0115\3\2\2\2\u0114\u00ff\3"+
		"\2\2\2\u0114\u0108\3\2\2\2\u0115\61\3\2\2\2\u0116\u0117\5:\36\2\u0117"+
		"\63\3\2\2\2\u0118\u011d\5<\37\2\u0119\u011a\t\3\2\2\u011a\u011c\5<\37"+
		"\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e\65\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0125\5\64\33\2\u0121"+
		"\u0122\t\4\2\2\u0122\u0124\5\64\33\2\u0123\u0121\3\2\2\2\u0124\u0127\3"+
		"\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\67\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u012d\5\66\34\2\u0129\u012a\t\5\2\2\u012a\u012c\5"+
		"\66\34\2\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e9\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0135\58\35\2"+
		"\u0131\u0132\t\6\2\2\u0132\u0134\58\35\2\u0133\u0131\3\2\2\2\u0134\u0137"+
		"\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136;\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0138\u0139\7$\2\2\u0139\u013c\5<\37\2\u013a\u013c\5\6"+
		"\4\2\u013b\u0138\3\2\2\2\u013b\u013a\3\2\2\2\u013c=\3\2\2\2\35AGNW|\u0084"+
		"\u0088\u0091\u009b\u00a5\u00b3\u00c1\u00c6\u00cb\u00d0\u00da\u00e0\u00ea"+
		"\u00fd\u0103\u010c\u0114\u011d\u0125\u012d\u0135\u013b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}