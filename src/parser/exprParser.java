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
		T__38=39, T__39=40, ID=41, INT=42, STR=43, WS=44;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_expr_prime = 2, RULE_cond2 = 3, 
		RULE_exp = 4, RULE_binary_operator = 5, RULE_expr_seq = 6, RULE_expr_seq_prime = 7, 
		RULE_expr_list = 8, RULE_expr_list_prime = 9, RULE_field_list = 10, RULE_field_list_prime = 11, 
		RULE_lvalue = 12, RULE_lvalue_prime = 13, RULE_declaration_list = 14, 
		RULE_declaration = 15, RULE_type_declaration = 16, RULE_type = 17, RULE_type_fields = 18, 
		RULE_type_fields_prime = 19, RULE_type_field = 20, RULE_type_id = 21, 
		RULE_variable_declaration = 22, RULE_function_declaration = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "expr_prime", "cond2", "exp", "binary_operator", "expr_seq", 
			"expr_seq_prime", "expr_list", "expr_list_prime", "field_list", "field_list_prime", 
			"lvalue", "lvalue_prime", "declaration_list", "declaration", "type_declaration", 
			"type", "type_fields", "type_fields_prime", "type_field", "type_id", 
			"variable_declaration", "function_declaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'nil'", "'-'", "':='", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'of'", "'if'", "'then'", "'while'", "'do'", "'for'", "'to'", "'break'", 
			"'let'", "'in'", "'end'", "'else'", "'+'", "'*'", "'/'", "'='", "'<>'", 
			"'<'", "'>'", "'<='", "'>='", "'&'", "'|'", "';'", "','", "'.'", "'type'", 
			"'array'", "':'", "'var'", "'function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "ID", "INT", "STR", "WS"
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
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				expr();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << ID) | (1L << INT) | (1L << STR))) != 0) );
			setState(53);
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				exp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				lvalue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				match(T__1);
				setState(59);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				lvalue();
				setState(61);
				match(T__2);
				setState(62);
				expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				match(ID);
				setState(65);
				match(T__3);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(66);
					expr_list();
					}
				}

				setState(69);
				match(T__4);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				match(T__3);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(71);
					expr_seq();
					}
				}

				setState(74);
				match(T__4);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(75);
				type_id();
				setState(76);
				match(T__5);
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(77);
					field_list();
					}
				}

				setState(80);
				match(T__6);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				type_id();
				setState(83);
				match(T__7);
				setState(84);
				expr();
				setState(85);
				match(T__8);
				setState(86);
				match(T__9);
				setState(87);
				expr();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(89);
				match(T__10);
				setState(90);
				expr();
				setState(91);
				match(T__11);
				setState(92);
				expr();
				setState(93);
				expr_prime();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(95);
				match(T__12);
				setState(96);
				expr();
				setState(97);
				match(T__13);
				setState(98);
				expr();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(100);
				match(T__14);
				setState(101);
				match(ID);
				setState(102);
				match(T__2);
				setState(103);
				expr();
				setState(104);
				match(T__15);
				setState(105);
				expr();
				setState(106);
				match(T__13);
				setState(107);
				expr();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(109);
				match(T__16);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(110);
				match(T__17);
				setState(111);
				declaration_list(0);
				setState(112);
				match(T__18);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << ID) | (1L << INT) | (1L << STR))) != 0)) {
					{
					setState(113);
					expr_seq();
					}
				}

				setState(116);
				match(T__19);
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
		enterRule(_localctx, 4, RULE_expr_prime);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				cond2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(T__20);
				setState(122);
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
		enterRule(_localctx, 6, RULE_cond2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__20);
			setState(126);
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

	public static class ExpContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(exprParser.INT, 0); }
		public TerminalNode ID() { return getToken(exprParser.ID, 0); }
		public TerminalNode STR() { return getToken(exprParser.STR, 0); }
		public Binary_operatorContext binary_operator() {
			return getRuleContext(Binary_operatorContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exp);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(STR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << STR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(132);
				binary_operator();
				setState(133);
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

	public static class Binary_operatorContext extends ParserRuleContext {
		public Binary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator; }
	}

	public final Binary_operatorContext binary_operator() throws RecognitionException {
		Binary_operatorContext _localctx = new Binary_operatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_expr_seq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			expr();
			setState(140);
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
		enterRule(_localctx, 14, RULE_expr_seq_prime);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(T__32);
				setState(143);
				expr();
				setState(144);
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
		enterRule(_localctx, 16, RULE_expr_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			expr();
			setState(150);
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
		enterRule(_localctx, 18, RULE_expr_list_prime);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(T__32);
				setState(153);
				expr();
				setState(154);
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
		enterRule(_localctx, 20, RULE_field_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(ID);
			setState(160);
			match(T__24);
			setState(161);
			expr();
			setState(162);
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
		enterRule(_localctx, 22, RULE_field_list_prime);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__33);
				setState(165);
				match(ID);
				setState(166);
				match(T__24);
				setState(167);
				expr();
				setState(168);
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
		enterRule(_localctx, 24, RULE_lvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ID);
			setState(174);
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
		enterRule(_localctx, 26, RULE_lvalue_prime);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(T__34);
				setState(177);
				match(ID);
				setState(178);
				lvalue_prime();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__7);
				setState(180);
				expr();
				setState(181);
				match(T__8);
				setState(182);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(188);
			declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Declaration_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
					setState(190);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(191);
					declaration();
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 30, RULE_declaration);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				variable_declaration();
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				function_declaration();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
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
		enterRule(_localctx, 32, RULE_type_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__35);
			setState(203);
			type_id();
			setState(204);
			match(T__24);
			setState(205);
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
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				type_id();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(T__5);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(209);
					type_fields();
					}
				}

				setState(212);
				match(T__6);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				match(T__36);
				setState(214);
				match(T__9);
				setState(215);
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
		enterRule(_localctx, 36, RULE_type_fields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			type_field();
			setState(219);
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
		enterRule(_localctx, 38, RULE_type_fields_prime);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(T__33);
				setState(222);
				type_field();
				setState(223);
				type_fields_prime();
				}
				break;
			case T__6:
			case T__24:
			case T__37:
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
		enterRule(_localctx, 40, RULE_type_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(ID);
			setState(229);
			match(T__37);
			setState(230);
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
		enterRule(_localctx, 42, RULE_type_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
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
		enterRule(_localctx, 44, RULE_variable_declaration);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__38);
				setState(235);
				match(ID);
				setState(236);
				match(T__2);
				setState(237);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(T__38);
				setState(239);
				match(ID);
				setState(240);
				match(T__37);
				setState(241);
				type_id();
				setState(242);
				match(T__2);
				setState(243);
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
		enterRule(_localctx, 46, RULE_function_declaration);
		int _la;
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(T__39);
				setState(248);
				match(ID);
				{
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(249);
					type_fields();
					}
				}

				}
				setState(252);
				match(T__24);
				setState(253);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(T__39);
				setState(255);
				match(ID);
				{
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(256);
					type_fields();
					}
				}

				}
				setState(259);
				match(T__37);
				setState(260);
				type_id();
				setState(261);
				match(T__24);
				setState(262);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\6\2\64\n\2\r\2\16\2\65\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3F\n\3\3\3\3\3\3\3\5\3K\n\3\3\3\3\3\3\3\3\3\5\3Q\n\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"u\n\3\3\3\3\3\5\3y\n\3\3\4\3\4\3\4\5\4~\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6\u008a\n\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0096\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00a0\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ae\n\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bc\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00c3\n\20\f\20\16\20\u00c6\13\20\3\21\3\21"+
		"\3\21\5\21\u00cb\n\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u00d5"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u00db\n\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00e5\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00f8\n\30\3\31\3\31\3\31"+
		"\5\31\u00fd\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u0104\n\31\3\31\3\31\3"+
		"\31\3\31\3\31\5\31\u010b\n\31\3\31\2\3\36\32\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\2\4\3\2+-\4\2\4\4\30\"\2\u011a\2\63\3\2\2\2\4"+
		"x\3\2\2\2\6}\3\2\2\2\b\177\3\2\2\2\n\u0089\3\2\2\2\f\u008b\3\2\2\2\16"+
		"\u008d\3\2\2\2\20\u0095\3\2\2\2\22\u0097\3\2\2\2\24\u009f\3\2\2\2\26\u00a1"+
		"\3\2\2\2\30\u00ad\3\2\2\2\32\u00af\3\2\2\2\34\u00bb\3\2\2\2\36\u00bd\3"+
		"\2\2\2 \u00ca\3\2\2\2\"\u00cc\3\2\2\2$\u00da\3\2\2\2&\u00dc\3\2\2\2(\u00e4"+
		"\3\2\2\2*\u00e6\3\2\2\2,\u00ea\3\2\2\2.\u00f7\3\2\2\2\60\u010a\3\2\2\2"+
		"\62\64\5\4\3\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2"+
		"\66\67\3\2\2\2\678\7\2\2\38\3\3\2\2\29y\7\3\2\2:y\5\n\6\2;y\5\32\16\2"+
		"<=\7\4\2\2=y\5\4\3\2>?\5\32\16\2?@\7\5\2\2@A\5\4\3\2Ay\3\2\2\2BC\7+\2"+
		"\2CE\7\6\2\2DF\5\22\n\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2Gy\7\7\2\2HJ\7\6"+
		"\2\2IK\5\16\b\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2Ly\7\7\2\2MN\5,\27\2NP\7"+
		"\b\2\2OQ\5\26\f\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7\t\2\2Sy\3\2\2\2TU"+
		"\5,\27\2UV\7\n\2\2VW\5\4\3\2WX\7\13\2\2XY\7\f\2\2YZ\5\4\3\2Zy\3\2\2\2"+
		"[\\\7\r\2\2\\]\5\4\3\2]^\7\16\2\2^_\5\4\3\2_`\5\6\4\2`y\3\2\2\2ab\7\17"+
		"\2\2bc\5\4\3\2cd\7\20\2\2de\5\4\3\2ey\3\2\2\2fg\7\21\2\2gh\7+\2\2hi\7"+
		"\5\2\2ij\5\4\3\2jk\7\22\2\2kl\5\4\3\2lm\7\20\2\2mn\5\4\3\2ny\3\2\2\2o"+
		"y\7\23\2\2pq\7\24\2\2qr\5\36\20\2rt\7\25\2\2su\5\16\b\2ts\3\2\2\2tu\3"+
		"\2\2\2uv\3\2\2\2vw\7\26\2\2wy\3\2\2\2x9\3\2\2\2x:\3\2\2\2x;\3\2\2\2x<"+
		"\3\2\2\2x>\3\2\2\2xB\3\2\2\2xH\3\2\2\2xM\3\2\2\2xT\3\2\2\2x[\3\2\2\2x"+
		"a\3\2\2\2xf\3\2\2\2xo\3\2\2\2xp\3\2\2\2y\5\3\2\2\2z~\5\b\5\2{|\7\27\2"+
		"\2|~\5\4\3\2}z\3\2\2\2}{\3\2\2\2~\7\3\2\2\2\177\u0080\7\27\2\2\u0080\u0081"+
		"\5\4\3\2\u0081\t\3\2\2\2\u0082\u008a\7,\2\2\u0083\u008a\7+\2\2\u0084\u008a"+
		"\7-\2\2\u0085\u0086\t\2\2\2\u0086\u0087\5\f\7\2\u0087\u0088\5\4\3\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0083\3\2\2\2\u0089\u0084\3\2"+
		"\2\2\u0089\u0085\3\2\2\2\u008a\13\3\2\2\2\u008b\u008c\t\3\2\2\u008c\r"+
		"\3\2\2\2\u008d\u008e\5\4\3\2\u008e\u008f\5\20\t\2\u008f\17\3\2\2\2\u0090"+
		"\u0091\7#\2\2\u0091\u0092\5\4\3\2\u0092\u0093\5\20\t\2\u0093\u0096\3\2"+
		"\2\2\u0094\u0096\3\2\2\2\u0095\u0090\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\21\3\2\2\2\u0097\u0098\5\4\3\2\u0098\u0099\5\24\13\2\u0099\23\3\2\2\2"+
		"\u009a\u009b\7#\2\2\u009b\u009c\5\4\3\2\u009c\u009d\5\24\13\2\u009d\u00a0"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009a\3\2\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\25\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2\u00a3\7\33\2\2\u00a3\u00a4\5\4\3"+
		"\2\u00a4\u00a5\5\30\r\2\u00a5\27\3\2\2\2\u00a6\u00a7\7$\2\2\u00a7\u00a8"+
		"\7+\2\2\u00a8\u00a9\7\33\2\2\u00a9\u00aa\5\4\3\2\u00aa\u00ab\5\30\r\2"+
		"\u00ab\u00ae\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ae\31\3\2\2\2\u00af\u00b0\7+\2\2\u00b0\u00b1\5\34\17\2\u00b1"+
		"\33\3\2\2\2\u00b2\u00b3\7%\2\2\u00b3\u00b4\7+\2\2\u00b4\u00bc\5\34\17"+
		"\2\u00b5\u00b6\7\n\2\2\u00b6\u00b7\5\4\3\2\u00b7\u00b8\7\13\2\2\u00b8"+
		"\u00b9\5\34\17\2\u00b9\u00bc\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b2\3"+
		"\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\35\3\2\2\2\u00bd"+
		"\u00be\b\20\1\2\u00be\u00bf\5 \21\2\u00bf\u00c4\3\2\2\2\u00c0\u00c1\f"+
		"\3\2\2\u00c1\u00c3\5 \21\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c7\u00cb\5.\30\2\u00c8\u00cb\5\60\31\2\u00c9\u00cb\5\"\22\2\u00ca"+
		"\u00c7\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb!\3\2\2\2"+
		"\u00cc\u00cd\7&\2\2\u00cd\u00ce\5,\27\2\u00ce\u00cf\7\33\2\2\u00cf\u00d0"+
		"\5$\23\2\u00d0#\3\2\2\2\u00d1\u00db\5,\27\2\u00d2\u00d4\7\b\2\2\u00d3"+
		"\u00d5\5&\24\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00db\7\t\2\2\u00d7\u00d8\7\'\2\2\u00d8\u00d9\7\f\2\2\u00d9"+
		"\u00db\5,\27\2\u00da\u00d1\3\2\2\2\u00da\u00d2\3\2\2\2\u00da\u00d7\3\2"+
		"\2\2\u00db%\3\2\2\2\u00dc\u00dd\5*\26\2\u00dd\u00de\5(\25\2\u00de\'\3"+
		"\2\2\2\u00df\u00e0\7$\2\2\u00e0\u00e1\5*\26\2\u00e1\u00e2\5(\25\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e3\3\2"+
		"\2\2\u00e5)\3\2\2\2\u00e6\u00e7\7+\2\2\u00e7\u00e8\7(\2\2\u00e8\u00e9"+
		"\5,\27\2\u00e9+\3\2\2\2\u00ea\u00eb\7+\2\2\u00eb-\3\2\2\2\u00ec\u00ed"+
		"\7)\2\2\u00ed\u00ee\7+\2\2\u00ee\u00ef\7\5\2\2\u00ef\u00f8\5\4\3\2\u00f0"+
		"\u00f1\7)\2\2\u00f1\u00f2\7+\2\2\u00f2\u00f3\7(\2\2\u00f3\u00f4\5,\27"+
		"\2\u00f4\u00f5\7\5\2\2\u00f5\u00f6\5\4\3\2\u00f6\u00f8\3\2\2\2\u00f7\u00ec"+
		"\3\2\2\2\u00f7\u00f0\3\2\2\2\u00f8/\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa\u00fc"+
		"\7+\2\2\u00fb\u00fd\5&\24\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\7\33\2\2\u00ff\u010b\5\4\3\2\u0100\u0101\7"+
		"*\2\2\u0101\u0103\7+\2\2\u0102\u0104\5&\24\2\u0103\u0102\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\7(\2\2\u0106\u0107\5,\27"+
		"\2\u0107\u0108\7\33\2\2\u0108\u0109\5\4\3\2\u0109\u010b\3\2\2\2\u010a"+
		"\u00f9\3\2\2\2\u010a\u0100\3\2\2\2\u010b\61\3\2\2\2\27\65EJPtx}\u0089"+
		"\u0095\u009f\u00ad\u00bb\u00c4\u00ca\u00d4\u00da\u00e4\u00f7\u00fc\u0103"+
		"\u010a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}