// Generated from expr.g4 by ANTLR 4.9.2

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
		T__38=39, T__39=40, T__40=41, ID=42, INT=43, STR=44, WS=45;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_instruction = 2, RULE_expr_prime = 3, 
		RULE_cond2 = 4, RULE_expr_seq = 5, RULE_expr_seq_prime = 6, RULE_expr_list = 7, 
		RULE_expr_list_prime = 8, RULE_field_list = 9, RULE_field_list_prime = 10, 
		RULE_lvalue = 11, RULE_lvalue_prime = 12, RULE_declaration_list = 13, 
		RULE_declaration = 14, RULE_type_declaration = 15, RULE_type = 16, RULE_type_fields = 17, 
		RULE_type_fields_prime = 18, RULE_type_field = 19, RULE_type_id = 20, 
		RULE_variable_declaration = 21, RULE_function_declaration = 22, RULE_binary_operation = 23, 
		RULE_precedence_1 = 24, RULE_precedence_2 = 25, RULE_precedence_3 = 26, 
		RULE_precedence_4 = 27, RULE_binary_operator_1 = 28, RULE_binary_operator_2 = 29, 
		RULE_binary_operator_3 = 30, RULE_binary_operator_4 = 31, RULE_print = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "instruction", "expr_prime", "cond2", "expr_seq", 
			"expr_seq_prime", "expr_list", "expr_list_prime", "field_list", "field_list_prime", 
			"lvalue", "lvalue_prime", "declaration_list", "declaration", "type_declaration", 
			"type", "type_fields", "type_fields_prime", "type_field", "type_id", 
			"variable_declaration", "function_declaration", "binary_operation", "precedence_1", 
			"precedence_2", "precedence_3", "precedence_4", "binary_operator_1", 
			"binary_operator_2", "binary_operator_3", "binary_operator_4", "print"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'nil'", "'-'", "':='", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'of'", "'if'", "'then'", "'while'", "'do'", "'for'", "'to'", "'break'", 
			"'let'", "'in'", "'end'", "'else'", "';'", "'='", "','", "'.'", "'type'", 
			"'array'", "':'", "'var'", "'function'", "'*'", "'/'", "'+'", "'<>'", 
			"'<'", "'>'", "'<='", "'>='", "'&'", "'|'", "'print('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "ID", "INT", "STR", "WS"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				expr();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__40) | (1L << ID) | (1L << INT) | (1L << STR))) != 0) );
			setState(71);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
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
		public TerminalNode INT() { return getToken(exprParser.INT, 0); }
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public TerminalNode STR() { return getToken(exprParser.STR, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Expr_seqContext expr_seq() {
			return getRuleContext(Expr_seqContext.class,0);
		}
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Field_listContext field_list() {
			return getRuleContext(Field_listContext.class,0);
		}
		public Expr_primeContext expr_prime() {
			return getRuleContext(Expr_primeContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(STR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				lvalue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				match(T__1);
				setState(83);
				expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				lvalue();
				setState(85);
				match(T__2);
				setState(86);
				expr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(88);
				match(ID);
				setState(89);
				match(T__3);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__40) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(90);
					expr_list();
					}
				}

				setState(93);
				match(T__4);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(94);
				match(T__3);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__40) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(95);
					expr_seq();
					}
				}

				setState(98);
				match(T__4);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(99);
				type_id();
				setState(100);
				match(T__5);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(101);
					field_list();
					}
				}

				setState(104);
				match(T__6);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(106);
				type_id();
				setState(107);
				match(T__7);
				setState(108);
				expr();
				setState(109);
				match(T__8);
				setState(110);
				match(T__9);
				setState(111);
				expr();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(113);
				match(T__10);
				setState(114);
				expr();
				setState(115);
				match(T__11);
				setState(116);
				expr();
				setState(118);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(117);
					expr_prime();
					}
					break;
				}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(120);
				match(T__12);
				setState(121);
				expr();
				setState(122);
				match(T__13);
				setState(123);
				expr();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(125);
				match(T__14);
				setState(126);
				match(ID);
				setState(127);
				match(T__2);
				setState(128);
				expr();
				setState(129);
				match(T__15);
				setState(130);
				expr();
				setState(131);
				match(T__13);
				setState(132);
				expr();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(134);
				match(T__16);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(135);
				match(T__17);
				setState(136);
				declaration_list(0);
				setState(137);
				match(T__18);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__40) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(138);
					expr_seq();
					}
				}

				setState(141);
				match(T__19);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(143);
				print();
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

	public static class Expr_primeContext extends ParserRuleContext {
		public Cond2Context cond2() {
			return getRuleContext(Cond2Context.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_prime; }
	}

	public final Expr_primeContext expr_prime() throws RecognitionException {
		Expr_primeContext _localctx = new Expr_primeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr_prime);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				cond2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(T__20);
				setState(148);
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

	public static class Cond2Context extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Cond2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond2; }
	}

	public final Cond2Context cond2() throws RecognitionException {
		Cond2Context _localctx = new Cond2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_cond2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__20);
			setState(152);
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

	public static class Expr_seqContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_seq_primeContext expr_seq_prime() {
			return getRuleContext(Expr_seq_primeContext.class,0);
		}
		public Expr_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_seq; }
	}

	public final Expr_seqContext expr_seq() throws RecognitionException {
		Expr_seqContext _localctx = new Expr_seqContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr_seq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			expr();
			setState(155);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_seq_primeContext expr_seq_prime() {
			return getRuleContext(Expr_seq_primeContext.class,0);
		}
		public Expr_seq_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_seq_prime; }
	}

	public final Expr_seq_primeContext expr_seq_prime() throws RecognitionException {
		Expr_seq_primeContext _localctx = new Expr_seq_primeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr_seq_prime);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(T__21);
				setState(158);
				expr();
				setState(159);
				expr_seq_prime();
				}
				break;
			case T__4:
			case T__19:
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_primeContext expr_list_prime() {
			return getRuleContext(Expr_list_primeContext.class,0);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			expr();
			setState(165);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_primeContext expr_list_prime() {
			return getRuleContext(Expr_list_primeContext.class,0);
		}
		public Expr_list_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list_prime; }
	}

	public final Expr_list_primeContext expr_list_prime() throws RecognitionException {
		Expr_list_primeContext _localctx = new Expr_list_primeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_list_prime);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(T__21);
				setState(168);
				expr();
				setState(169);
				expr_list_prime();
				}
				break;
			case T__4:
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

	public static class Field_listContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Field_list_primeContext field_list_prime() {
			return getRuleContext(Field_list_primeContext.class,0);
		}
		public Field_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_list; }
	}

	public final Field_listContext field_list() throws RecognitionException {
		Field_listContext _localctx = new Field_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_field_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(ID);
			setState(175);
			match(T__22);
			setState(176);
			expr();
			setState(177);
			field_list_prime();
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

	public static class Field_list_primeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Field_list_primeContext field_list_prime() {
			return getRuleContext(Field_list_primeContext.class,0);
		}
		public Field_list_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_list_prime; }
	}

	public final Field_list_primeContext field_list_prime() throws RecognitionException {
		Field_list_primeContext _localctx = new Field_list_primeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_field_list_prime);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__23);
				setState(180);
				match(ID);
				setState(181);
				match(T__22);
				setState(182);
				expr();
				setState(183);
				field_list_prime();
				}
				break;
			case T__6:
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
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Lvalue_primeContext lvalue_prime() {
			return getRuleContext(Lvalue_primeContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_lvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(ID);
			setState(189);
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
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Lvalue_primeContext lvalue_prime() {
			return getRuleContext(Lvalue_primeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Lvalue_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue_prime; }
	}

	public final Lvalue_primeContext lvalue_prime() throws RecognitionException {
		Lvalue_primeContext _localctx = new Lvalue_primeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lvalue_prime);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(T__24);
				setState(192);
				match(ID);
				setState(193);
				lvalue_prime();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(T__7);
				setState(195);
				expr();
				setState(196);
				match(T__8);
				setState(197);
				lvalue_prime();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class Declaration_listContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(203);
			declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Declaration_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
					setState(205);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(206);
					declaration();
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaration);
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				variable_declaration();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				function_declaration();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
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
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Type_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_declaration; }
	}

	public final Type_declarationContext type_declaration() throws RecognitionException {
		Type_declarationContext _localctx = new Type_declarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__25);
			setState(218);
			type_id();
			setState(219);
			match(T__22);
			setState(220);
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
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Type_fieldsContext type_fields() {
			return getRuleContext(Type_fieldsContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		int _la;
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				type_id();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(T__5);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(224);
					type_fields();
					}
				}

				setState(227);
				match(T__6);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(T__26);
				setState(229);
				match(T__9);
				setState(230);
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

	public static class Type_fieldsContext extends ParserRuleContext {
		public Type_fieldContext type_field() {
			return getRuleContext(Type_fieldContext.class,0);
		}
		public Type_fields_primeContext type_fields_prime() {
			return getRuleContext(Type_fields_primeContext.class,0);
		}
		public Type_fieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_fields; }
	}

	public final Type_fieldsContext type_fields() throws RecognitionException {
		Type_fieldsContext _localctx = new Type_fieldsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type_fields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			type_field();
			setState(234);
			type_fields_prime();
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

	public static class Type_fields_primeContext extends ParserRuleContext {
		public Type_fieldContext type_field() {
			return getRuleContext(Type_fieldContext.class,0);
		}
		public Type_fields_primeContext type_fields_prime() {
			return getRuleContext(Type_fields_primeContext.class,0);
		}
		public Type_fields_primeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_fields_prime; }
	}

	public final Type_fields_primeContext type_fields_prime() throws RecognitionException {
		Type_fields_primeContext _localctx = new Type_fields_primeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type_fields_prime);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(T__23);
				setState(237);
				type_field();
				setState(238);
				type_fields_prime();
				}
				break;
			case T__6:
			case T__22:
			case T__27:
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
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Type_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_field; }
	}

	public final Type_fieldContext type_field() throws RecognitionException {
		Type_fieldContext _localctx = new Type_fieldContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(ID);
			setState(244);
			match(T__27);
			setState(245);
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
	}

	public final Type_idContext type_id() throws RecognitionException {
		Type_idContext _localctx = new Type_idContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variable_declaration);
		try {
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				match(T__28);
				setState(250);
				match(ID);
				setState(251);
				match(T__2);
				setState(252);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(T__28);
				setState(254);
				match(ID);
				setState(255);
				match(T__27);
				setState(256);
				type_id();
				setState(257);
				match(T__2);
				setState(258);
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
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_fieldsContext type_fields() {
			return getRuleContext(Type_fieldsContext.class,0);
		}
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_function_declaration);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(T__29);
				setState(263);
				match(ID);
				{
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(264);
					type_fields();
					}
				}

				}
				setState(267);
				match(T__22);
				setState(268);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(T__29);
				setState(270);
				match(ID);
				{
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(271);
					type_fields();
					}
				}

				}
				setState(274);
				match(T__27);
				setState(275);
				type_id();
				setState(276);
				match(T__22);
				setState(277);
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
		public Precedence_1Context precedence_1() {
			return getRuleContext(Precedence_1Context.class,0);
		}
		public Precedence_2Context precedence_2() {
			return getRuleContext(Precedence_2Context.class,0);
		}
		public Precedence_3Context precedence_3() {
			return getRuleContext(Precedence_3Context.class,0);
		}
		public Precedence_4Context precedence_4() {
			return getRuleContext(Precedence_4Context.class,0);
		}
		public Binary_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operation; }
	}

	public final Binary_operationContext binary_operation() throws RecognitionException {
		Binary_operationContext _localctx = new Binary_operationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_binary_operation);
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				precedence_1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				precedence_2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				precedence_3();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(284);
				precedence_4();
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

	public static class Precedence_1Context extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Binary_operator_1Context> binary_operator_1() {
			return getRuleContexts(Binary_operator_1Context.class);
		}
		public Binary_operator_1Context binary_operator_1(int i) {
			return getRuleContext(Binary_operator_1Context.class,i);
		}
		public Precedence_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence_1; }
	}

	public final Precedence_1Context precedence_1() throws RecognitionException {
		Precedence_1Context _localctx = new Precedence_1Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_precedence_1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			instruction();
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(288);
					binary_operator_1();
					setState(289);
					instruction();
					}
					} 
				}
				setState(295);
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

	public static class Precedence_2Context extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Binary_operator_2Context> binary_operator_2() {
			return getRuleContexts(Binary_operator_2Context.class);
		}
		public Binary_operator_2Context binary_operator_2(int i) {
			return getRuleContext(Binary_operator_2Context.class,i);
		}
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
	}

	public final Precedence_2Context precedence_2() throws RecognitionException {
		Precedence_2Context _localctx = new Precedence_2Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_precedence_2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			instruction();
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(297);
					binary_operator_2();
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(298);
						instruction();
						}
						break;
					case 2:
						{
						setState(299);
						precedence_1();
						}
						break;
					}
					}
					} 
				}
				setState(306);
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

	public static class Precedence_3Context extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Binary_operator_3Context> binary_operator_3() {
			return getRuleContexts(Binary_operator_3Context.class);
		}
		public Binary_operator_3Context binary_operator_3(int i) {
			return getRuleContext(Binary_operator_3Context.class,i);
		}
		public List<Precedence_1Context> precedence_1() {
			return getRuleContexts(Precedence_1Context.class);
		}
		public Precedence_1Context precedence_1(int i) {
			return getRuleContext(Precedence_1Context.class,i);
		}
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
	}

	public final Precedence_3Context precedence_3() throws RecognitionException {
		Precedence_3Context _localctx = new Precedence_3Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_precedence_3);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			instruction();
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(308);
					binary_operator_3();
					setState(312);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						setState(309);
						instruction();
						}
						break;
					case 2:
						{
						setState(310);
						precedence_1();
						}
						break;
					case 3:
						{
						setState(311);
						precedence_2();
						}
						break;
					}
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Binary_operator_4Context> binary_operator_4() {
			return getRuleContexts(Binary_operator_4Context.class);
		}
		public Binary_operator_4Context binary_operator_4(int i) {
			return getRuleContext(Binary_operator_4Context.class,i);
		}
		public List<Precedence_1Context> precedence_1() {
			return getRuleContexts(Precedence_1Context.class);
		}
		public Precedence_1Context precedence_1(int i) {
			return getRuleContext(Precedence_1Context.class,i);
		}
		public List<Precedence_2Context> precedence_2() {
			return getRuleContexts(Precedence_2Context.class);
		}
		public Precedence_2Context precedence_2(int i) {
			return getRuleContext(Precedence_2Context.class,i);
		}
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
	}

	public final Precedence_4Context precedence_4() throws RecognitionException {
		Precedence_4Context _localctx = new Precedence_4Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_precedence_4);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			instruction();
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(320);
					binary_operator_4();
					setState(325);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(321);
						instruction();
						}
						break;
					case 2:
						{
						setState(322);
						precedence_1();
						}
						break;
					case 3:
						{
						setState(323);
						precedence_2();
						}
						break;
					case 4:
						{
						setState(324);
						precedence_3();
						}
						break;
					}
					}
					} 
				}
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class Binary_operator_1Context extends ParserRuleContext {
		public Binary_operator_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_1; }
	}

	public final Binary_operator_1Context binary_operator_1() throws RecognitionException {
		Binary_operator_1Context _localctx = new Binary_operator_1Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_binary_operator_1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Binary_operator_2Context extends ParserRuleContext {
		public Binary_operator_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_2; }
	}

	public final Binary_operator_2Context binary_operator_2() throws RecognitionException {
		Binary_operator_2Context _localctx = new Binary_operator_2Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_binary_operator_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__32) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Binary_operator_3Context extends ParserRuleContext {
		public Binary_operator_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_3; }
	}

	public final Binary_operator_3Context binary_operator_3() throws RecognitionException {
		Binary_operator_3Context _localctx = new Binary_operator_3Context(_ctx, getState());
		enterRule(_localctx, 60, RULE_binary_operator_3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Binary_operator_4Context extends ParserRuleContext {
		public Binary_operator_4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_4; }
	}

	public final Binary_operator_4Context binary_operator_4() throws RecognitionException {
		Binary_operator_4Context _localctx = new Binary_operator_4Context(_ctx, getState());
		enterRule(_localctx, 62, RULE_binary_operator_4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__39) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode STR() { return getToken(exprParser.STR, 0); }
		public TerminalNode INT() { return getToken(exprParser.INT, 0); }
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_print);
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(T__40);
				setState(341);
				match(STR);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(INT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				match(ID);
				setState(344);
				match(T__4);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u015e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\6\2F\n\2\r\2\16\2G\3\2\3\2\3\3\3\3\5\3N\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\4\3\4\3\4\5"+
		"\4c\n\4\3\4\3\4\3\4\3\4\5\4i\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4y\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008e\n\4\3\4\3\4\3\4\5\4\u0093"+
		"\n\4\3\5\3\5\3\5\5\5\u0098\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\5\b\u00a5\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00af\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bd\n\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00cb\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u00d2\n\17\f\17\16\17\u00d5\13\17\3\20\3\20"+
		"\3\20\5\20\u00da\n\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u00e4"+
		"\n\22\3\22\3\22\3\22\3\22\5\22\u00ea\n\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00f4\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0107\n\27\3\30\3\30\3\30"+
		"\5\30\u010c\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0113\n\30\3\30\3\30\3"+
		"\30\3\30\3\30\5\30\u011a\n\30\3\31\3\31\3\31\3\31\5\31\u0120\n\31\3\32"+
		"\3\32\3\32\3\32\7\32\u0126\n\32\f\32\16\32\u0129\13\32\3\33\3\33\3\33"+
		"\3\33\5\33\u012f\n\33\7\33\u0131\n\33\f\33\16\33\u0134\13\33\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u013b\n\34\7\34\u013d\n\34\f\34\16\34\u0140\13\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0148\n\35\7\35\u014a\n\35\f\35\16"+
		"\35\u014d\13\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u015c\n\"\3\"\2\3\34#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@B\2\6\3\2!\"\4\2\4\4##\4\2\31\31$(\3\2)*\2\u0173\2"+
		"E\3\2\2\2\4M\3\2\2\2\6\u0092\3\2\2\2\b\u0097\3\2\2\2\n\u0099\3\2\2\2\f"+
		"\u009c\3\2\2\2\16\u00a4\3\2\2\2\20\u00a6\3\2\2\2\22\u00ae\3\2\2\2\24\u00b0"+
		"\3\2\2\2\26\u00bc\3\2\2\2\30\u00be\3\2\2\2\32\u00ca\3\2\2\2\34\u00cc\3"+
		"\2\2\2\36\u00d9\3\2\2\2 \u00db\3\2\2\2\"\u00e9\3\2\2\2$\u00eb\3\2\2\2"+
		"&\u00f3\3\2\2\2(\u00f5\3\2\2\2*\u00f9\3\2\2\2,\u0106\3\2\2\2.\u0119\3"+
		"\2\2\2\60\u011f\3\2\2\2\62\u0121\3\2\2\2\64\u012a\3\2\2\2\66\u0135\3\2"+
		"\2\28\u0141\3\2\2\2:\u014e\3\2\2\2<\u0150\3\2\2\2>\u0152\3\2\2\2@\u0154"+
		"\3\2\2\2B\u015b\3\2\2\2DF\5\4\3\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2HI\3\2\2\2IJ\7\2\2\3J\3\3\2\2\2KN\5\6\4\2LN\5\60\31\2MK\3\2\2\2ML"+
		"\3\2\2\2N\5\3\2\2\2O\u0093\7\3\2\2P\u0093\7-\2\2Q\u0093\7,\2\2R\u0093"+
		"\7.\2\2S\u0093\5\30\r\2TU\7\4\2\2U\u0093\5\4\3\2VW\5\30\r\2WX\7\5\2\2"+
		"XY\5\4\3\2Y\u0093\3\2\2\2Z[\7,\2\2[]\7\6\2\2\\^\5\20\t\2]\\\3\2\2\2]^"+
		"\3\2\2\2^_\3\2\2\2_\u0093\7\7\2\2`b\7\6\2\2ac\5\f\7\2ba\3\2\2\2bc\3\2"+
		"\2\2cd\3\2\2\2d\u0093\7\7\2\2ef\5*\26\2fh\7\b\2\2gi\5\24\13\2hg\3\2\2"+
		"\2hi\3\2\2\2ij\3\2\2\2jk\7\t\2\2k\u0093\3\2\2\2lm\5*\26\2mn\7\n\2\2no"+
		"\5\4\3\2op\7\13\2\2pq\7\f\2\2qr\5\4\3\2r\u0093\3\2\2\2st\7\r\2\2tu\5\4"+
		"\3\2uv\7\16\2\2vx\5\4\3\2wy\5\b\5\2xw\3\2\2\2xy\3\2\2\2y\u0093\3\2\2\2"+
		"z{\7\17\2\2{|\5\4\3\2|}\7\20\2\2}~\5\4\3\2~\u0093\3\2\2\2\177\u0080\7"+
		"\21\2\2\u0080\u0081\7,\2\2\u0081\u0082\7\5\2\2\u0082\u0083\5\4\3\2\u0083"+
		"\u0084\7\22\2\2\u0084\u0085\5\4\3\2\u0085\u0086\7\20\2\2\u0086\u0087\5"+
		"\4\3\2\u0087\u0093\3\2\2\2\u0088\u0093\7\23\2\2\u0089\u008a\7\24\2\2\u008a"+
		"\u008b\5\34\17\2\u008b\u008d\7\25\2\2\u008c\u008e\5\f\7\2\u008d\u008c"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\26\2\2"+
		"\u0090\u0093\3\2\2\2\u0091\u0093\5B\"\2\u0092O\3\2\2\2\u0092P\3\2\2\2"+
		"\u0092Q\3\2\2\2\u0092R\3\2\2\2\u0092S\3\2\2\2\u0092T\3\2\2\2\u0092V\3"+
		"\2\2\2\u0092Z\3\2\2\2\u0092`\3\2\2\2\u0092e\3\2\2\2\u0092l\3\2\2\2\u0092"+
		"s\3\2\2\2\u0092z\3\2\2\2\u0092\177\3\2\2\2\u0092\u0088\3\2\2\2\u0092\u0089"+
		"\3\2\2\2\u0092\u0091\3\2\2\2\u0093\7\3\2\2\2\u0094\u0098\5\n\6\2\u0095"+
		"\u0096\7\27\2\2\u0096\u0098\5\4\3\2\u0097\u0094\3\2\2\2\u0097\u0095\3"+
		"\2\2\2\u0098\t\3\2\2\2\u0099\u009a\7\27\2\2\u009a\u009b\5\4\3\2\u009b"+
		"\13\3\2\2\2\u009c\u009d\5\4\3\2\u009d\u009e\5\16\b\2\u009e\r\3\2\2\2\u009f"+
		"\u00a0\7\30\2\2\u00a0\u00a1\5\4\3\2\u00a1\u00a2\5\16\b\2\u00a2\u00a5\3"+
		"\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\17\3\2\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\5\22\n\2\u00a8\21\3\2\2\2"+
		"\u00a9\u00aa\7\30\2\2\u00aa\u00ab\5\4\3\2\u00ab\u00ac\5\22\n\2\u00ac\u00af"+
		"\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af"+
		"\23\3\2\2\2\u00b0\u00b1\7,\2\2\u00b1\u00b2\7\31\2\2\u00b2\u00b3\5\4\3"+
		"\2\u00b3\u00b4\5\26\f\2\u00b4\25\3\2\2\2\u00b5\u00b6\7\32\2\2\u00b6\u00b7"+
		"\7,\2\2\u00b7\u00b8\7\31\2\2\u00b8\u00b9\5\4\3\2\u00b9\u00ba\5\26\f\2"+
		"\u00ba\u00bd\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\27\3\2\2\2\u00be\u00bf\7,\2\2\u00bf\u00c0\5\32\16\2\u00c0"+
		"\31\3\2\2\2\u00c1\u00c2\7\33\2\2\u00c2\u00c3\7,\2\2\u00c3\u00cb\5\32\16"+
		"\2\u00c4\u00c5\7\n\2\2\u00c5\u00c6\5\4\3\2\u00c6\u00c7\7\13\2\2\u00c7"+
		"\u00c8\5\32\16\2\u00c8\u00cb\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c1\3"+
		"\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\33\3\2\2\2\u00cc"+
		"\u00cd\b\17\1\2\u00cd\u00ce\5\36\20\2\u00ce\u00d3\3\2\2\2\u00cf\u00d0"+
		"\f\3\2\2\u00d0\u00d2\5\36\20\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2"+
		"\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\35\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d6\u00da\5,\27\2\u00d7\u00da\5.\30\2\u00d8\u00da\5 \21\2\u00d9"+
		"\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\37\3\2\2"+
		"\2\u00db\u00dc\7\34\2\2\u00dc\u00dd\5*\26\2\u00dd\u00de\7\31\2\2\u00de"+
		"\u00df\5\"\22\2\u00df!\3\2\2\2\u00e0\u00ea\5*\26\2\u00e1\u00e3\7\b\2\2"+
		"\u00e2\u00e4\5$\23\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00ea\7\t\2\2\u00e6\u00e7\7\35\2\2\u00e7\u00e8\7\f\2\2"+
		"\u00e8\u00ea\5*\26\2\u00e9\u00e0\3\2\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00e6"+
		"\3\2\2\2\u00ea#\3\2\2\2\u00eb\u00ec\5(\25\2\u00ec\u00ed\5&\24\2\u00ed"+
		"%\3\2\2\2\u00ee\u00ef\7\32\2\2\u00ef\u00f0\5(\25\2\u00f0\u00f1\5&\24\2"+
		"\u00f1\u00f4\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00f2"+
		"\3\2\2\2\u00f4\'\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6\u00f7\7\36\2\2\u00f7"+
		"\u00f8\5*\26\2\u00f8)\3\2\2\2\u00f9\u00fa\7,\2\2\u00fa+\3\2\2\2\u00fb"+
		"\u00fc\7\37\2\2\u00fc\u00fd\7,\2\2\u00fd\u00fe\7\5\2\2\u00fe\u0107\5\4"+
		"\3\2\u00ff\u0100\7\37\2\2\u0100\u0101\7,\2\2\u0101\u0102\7\36\2\2\u0102"+
		"\u0103\5*\26\2\u0103\u0104\7\5\2\2\u0104\u0105\5\4\3\2\u0105\u0107\3\2"+
		"\2\2\u0106\u00fb\3\2\2\2\u0106\u00ff\3\2\2\2\u0107-\3\2\2\2\u0108\u0109"+
		"\7 \2\2\u0109\u010b\7,\2\2\u010a\u010c\5$\23\2\u010b\u010a\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7\31\2\2\u010e\u011a\5"+
		"\4\3\2\u010f\u0110\7 \2\2\u0110\u0112\7,\2\2\u0111\u0113\5$\23\2\u0112"+
		"\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7\36"+
		"\2\2\u0115\u0116\5*\26\2\u0116\u0117\7\31\2\2\u0117\u0118\5\4\3\2\u0118"+
		"\u011a\3\2\2\2\u0119\u0108\3\2\2\2\u0119\u010f\3\2\2\2\u011a/\3\2\2\2"+
		"\u011b\u0120\5\62\32\2\u011c\u0120\5\64\33\2\u011d\u0120\5\66\34\2\u011e"+
		"\u0120\58\35\2\u011f\u011b\3\2\2\2\u011f\u011c\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u011f\u011e\3\2\2\2\u0120\61\3\2\2\2\u0121\u0127\5\6\4\2\u0122\u0123"+
		"\5:\36\2\u0123\u0124\5\6\4\2\u0124\u0126\3\2\2\2\u0125\u0122\3\2\2\2\u0126"+
		"\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\63\3\2\2"+
		"\2\u0129\u0127\3\2\2\2\u012a\u0132\5\6\4\2\u012b\u012e\5<\37\2\u012c\u012f"+
		"\5\6\4\2\u012d\u012f\5\62\32\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2"+
		"\u012f\u0131\3\2\2\2\u0130\u012b\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\65\3\2\2\2\u0134\u0132\3\2\2\2\u0135"+
		"\u013e\5\6\4\2\u0136\u013a\5> \2\u0137\u013b\5\6\4\2\u0138\u013b\5\62"+
		"\32\2\u0139\u013b\5\64\33\2\u013a\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u0139\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u0136\3\2\2\2\u013d\u0140\3\2"+
		"\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\67\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0141\u014b\5\6\4\2\u0142\u0147\5@!\2\u0143\u0148\5\6\4\2\u0144"+
		"\u0148\5\62\32\2\u0145\u0148\5\64\33\2\u0146\u0148\5\66\34\2\u0147\u0143"+
		"\3\2\2\2\u0147\u0144\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148"+
		"\u014a\3\2\2\2\u0149\u0142\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014c9\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f"+
		"\t\2\2\2\u014f;\3\2\2\2\u0150\u0151\t\3\2\2\u0151=\3\2\2\2\u0152\u0153"+
		"\t\4\2\2\u0153?\3\2\2\2\u0154\u0155\t\5\2\2\u0155A\3\2\2\2\u0156\u0157"+
		"\7+\2\2\u0157\u015c\7.\2\2\u0158\u015c\7-\2\2\u0159\u015a\7,\2\2\u015a"+
		"\u015c\7\7\2\2\u015b\u0156\3\2\2\2\u015b\u0158\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015cC\3\2\2\2!GM]bhx\u008d\u0092\u0097\u00a4\u00ae\u00bc\u00ca\u00d3"+
		"\u00d9\u00e3\u00e9\u00f3\u0106\u010b\u0112\u0119\u011f\u0127\u012e\u0132"+
		"\u013a\u013e\u0147\u014b\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}