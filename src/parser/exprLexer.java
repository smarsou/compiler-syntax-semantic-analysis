// Generated from expr.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exprLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"ID", "LETTER", "INT", "STR", "ASCII", "DIGIT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'nil'", "'-'", "'('", "')'", "'while'", "'do'", "'for'", "':='", 
			"'to'", "'break'", "'let'", "'in'", "'end'", "'{'", "'}'", "'['", "']'", 
			"'of'", "'if'", "'then'", "'else'", "';'", "'='", "','", "'.'", "'type'", 
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


	public exprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0117\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3"+
		"+\3+\7+\u00ee\n+\f+\16+\u00f1\13+\3,\3,\3-\6-\u00f6\n-\r-\16-\u00f7\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\6.\u0103\n.\r.\16.\u0104\3.\3.\3.\3.\3/\3/\3"+
		"/\3/\3\60\3\60\3\61\6\61\u0112\n\61\r\61\16\61\u0113\3\61\3\61\2\2\62"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y-[.]\2_\2a/\3\2\5\4\2C\\c|\7\2\"#.\61"+
		"<=AAaa\5\2\13\f\17\17\"\"\2\u011c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2a\3"+
		"\2\2\2\3c\3\2\2\2\5g\3\2\2\2\7i\3\2\2\2\tk\3\2\2\2\13m\3\2\2\2\rs\3\2"+
		"\2\2\17v\3\2\2\2\21z\3\2\2\2\23}\3\2\2\2\25\u0080\3\2\2\2\27\u0086\3\2"+
		"\2\2\31\u008a\3\2\2\2\33\u008d\3\2\2\2\35\u0091\3\2\2\2\37\u0093\3\2\2"+
		"\2!\u0095\3\2\2\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009c\3\2\2\2)\u009f"+
		"\3\2\2\2+\u00a4\3\2\2\2-\u00a9\3\2\2\2/\u00ab\3\2\2\2\61\u00ad\3\2\2\2"+
		"\63\u00af\3\2\2\2\65\u00b1\3\2\2\2\67\u00b6\3\2\2\29\u00bc\3\2\2\2;\u00be"+
		"\3\2\2\2=\u00c2\3\2\2\2?\u00cb\3\2\2\2A\u00cd\3\2\2\2C\u00cf\3\2\2\2E"+
		"\u00d1\3\2\2\2G\u00d4\3\2\2\2I\u00d6\3\2\2\2K\u00d8\3\2\2\2M\u00db\3\2"+
		"\2\2O\u00de\3\2\2\2Q\u00e0\3\2\2\2S\u00e2\3\2\2\2U\u00e9\3\2\2\2W\u00f2"+
		"\3\2\2\2Y\u00f5\3\2\2\2[\u00f9\3\2\2\2]\u010a\3\2\2\2_\u010e\3\2\2\2a"+
		"\u0111\3\2\2\2cd\7p\2\2de\7k\2\2ef\7n\2\2f\4\3\2\2\2gh\7/\2\2h\6\3\2\2"+
		"\2ij\7*\2\2j\b\3\2\2\2kl\7+\2\2l\n\3\2\2\2mn\7y\2\2no\7j\2\2op\7k\2\2"+
		"pq\7n\2\2qr\7g\2\2r\f\3\2\2\2st\7f\2\2tu\7q\2\2u\16\3\2\2\2vw\7h\2\2w"+
		"x\7q\2\2xy\7t\2\2y\20\3\2\2\2z{\7<\2\2{|\7?\2\2|\22\3\2\2\2}~\7v\2\2~"+
		"\177\7q\2\2\177\24\3\2\2\2\u0080\u0081\7d\2\2\u0081\u0082\7t\2\2\u0082"+
		"\u0083\7g\2\2\u0083\u0084\7c\2\2\u0084\u0085\7m\2\2\u0085\26\3\2\2\2\u0086"+
		"\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088\u0089\7v\2\2\u0089\30\3\2\2\2\u008a"+
		"\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\32\3\2\2\2\u008d\u008e\7g\2\2\u008e"+
		"\u008f\7p\2\2\u008f\u0090\7f\2\2\u0090\34\3\2\2\2\u0091\u0092\7}\2\2\u0092"+
		"\36\3\2\2\2\u0093\u0094\7\177\2\2\u0094 \3\2\2\2\u0095\u0096\7]\2\2\u0096"+
		"\"\3\2\2\2\u0097\u0098\7_\2\2\u0098$\3\2\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7h\2\2\u009b&\3\2\2\2\u009c\u009d\7k\2\2\u009d\u009e\7h\2\2\u009e"+
		"(\3\2\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7j\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"\u00a3\7p\2\2\u00a3*\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7n\2\2\u00a6"+
		"\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8,\3\2\2\2\u00a9\u00aa\7=\2\2\u00aa"+
		".\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac\60\3\2\2\2\u00ad\u00ae\7.\2\2\u00ae"+
		"\62\3\2\2\2\u00af\u00b0\7\60\2\2\u00b0\64\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2"+
		"\u00b3\7{\2\2\u00b3\u00b4\7r\2\2\u00b4\u00b5\7g\2\2\u00b5\66\3\2\2\2\u00b6"+
		"\u00b7\7c\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7c\2\2"+
		"\u00ba\u00bb\7{\2\2\u00bb8\3\2\2\2\u00bc\u00bd\7<\2\2\u00bd:\3\2\2\2\u00be"+
		"\u00bf\7x\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7t\2\2\u00c1<\3\2\2\2\u00c2"+
		"\u00c3\7h\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7e\2\2"+
		"\u00c6\u00c7\7v\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca"+
		"\7p\2\2\u00ca>\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc@\3\2\2\2\u00cd\u00ce\7"+
		"\61\2\2\u00ceB\3\2\2\2\u00cf\u00d0\7-\2\2\u00d0D\3\2\2\2\u00d1\u00d2\7"+
		">\2\2\u00d2\u00d3\7@\2\2\u00d3F\3\2\2\2\u00d4\u00d5\7>\2\2\u00d5H\3\2"+
		"\2\2\u00d6\u00d7\7@\2\2\u00d7J\3\2\2\2\u00d8\u00d9\7>\2\2\u00d9\u00da"+
		"\7?\2\2\u00daL\3\2\2\2\u00db\u00dc\7@\2\2\u00dc\u00dd\7?\2\2\u00ddN\3"+
		"\2\2\2\u00de\u00df\7(\2\2\u00dfP\3\2\2\2\u00e0\u00e1\7~\2\2\u00e1R\3\2"+
		"\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6"+
		"\7p\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7*\2\2\u00e8T\3\2\2\2\u00e9\u00ef"+
		"\5W,\2\u00ea\u00ee\5W,\2\u00eb\u00ee\5Y-\2\u00ec\u00ee\7a\2\2\u00ed\u00ea"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0V\3\2\2\2\u00f1\u00ef\3\2\2\2"+
		"\u00f2\u00f3\t\2\2\2\u00f3X\3\2\2\2\u00f4\u00f6\5_\60\2\u00f5\u00f4\3"+
		"\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"Z\3\2\2\2\u00f9\u00fa\7\u00e4\2\2\u00fa\u00fb\7\u20ae\2\2\u00fb\u00fc"+
		"\7\u0155\2\2\u00fc\u0102\3\2\2\2\u00fd\u0103\5_\60\2\u00fe\u0103\5W,\2"+
		"\u00ff\u0100\7^\2\2\u0100\u0103\5]/\2\u0101\u0103\t\3\2\2\u0102\u00fd"+
		"\3\2\2\2\u0102\u00fe\3\2\2\2\u0102\u00ff\3\2\2\2\u0102\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0107\7\u00e4\2\2\u0107\u0108\7\u20ae\2\2\u0108\u0109\7\u0155"+
		"\2\2\u0109\\\3\2\2\2\u010a\u010b\5_\60\2\u010b\u010c\5_\60\2\u010c\u010d"+
		"\5_\60\2\u010d^\3\2\2\2\u010e\u010f\4\62;\2\u010f`\3\2\2\2\u0110\u0112"+
		"\t\4\2\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\b\61\2\2\u0116b\3\2\2\2"+
		"\t\2\u00ed\u00ef\u00f7\u0102\u0104\u0113\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}