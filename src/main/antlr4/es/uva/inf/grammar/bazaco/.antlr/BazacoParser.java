// Generated from c:\Users\Propietario\Documents\DOCUMENTOS-TFG\MVN-Bazaco\mvnbazaco\src\main\antlr4\es\u005Cuva\inf\grammar\bazaco\Bazaco.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BazacoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, CommentOrEncoding=45, 
		Group=46, Star=47, Div=48, Less=49, LessEqual=50, Greater=51, GreaterEqual=52, 
		Equal=53, TwoEqual=54, NotEqual=55, Exclamation=56, DataEquationOp=57, 
		StringAssignOp=58, Id=59, Ex=60, FloatingConstNumber=61, FractionalConstant=62, 
		ExponentPart=63, DigitSeq=64, StringLiteral=65, StringConst=66, Keyword=67, 
		Whitespace=68, Backslash=69, INFO_UNIT=70, OtherCaracter=71;
	public static final int
		RULE_file = 0, RULE_model = 1, RULE_symbolWithDoc = 2, RULE_symbolWithDocDefinition = 3, 
		RULE_subscriptRange = 4, RULE_subscriptSequence = 5, RULE_subscriptMappingList = 6, 
		RULE_subscriptMapping = 7, RULE_equation = 8, RULE_lhs = 9, RULE_subscriptCopy = 10, 
		RULE_unchangeableConstant = 11, RULE_dataEquation = 12, RULE_lookupDefinition = 13, 
		RULE_constraint = 14, RULE_realityCheck = 15, RULE_stringAssign = 16, 
		RULE_macroDefinition = 17, RULE_expr = 18, RULE_exprAllowSign = 19, RULE_call = 20, 
		RULE_macroHeader = 21, RULE_macroArguments = 22, RULE_exprList = 23, RULE_subscriptValueList = 24, 
		RULE_indexList = 25, RULE_subscript = 26, RULE_lookup = 27, RULE_lookupRange = 28, 
		RULE_lookupPointList = 29, RULE_referenceLine = 30, RULE_lookupPoint = 31, 
		RULE_constantLine = 32, RULE_constList = 33, RULE_numberList = 34, RULE_graphs = 35, 
		RULE_graph = 36, RULE_title = 37, RULE_xaxis = 38, RULE_yaxis = 39, RULE_xmin = 40, 
		RULE_xmax = 41, RULE_nolegend = 42, RULE_scale = 43, RULE_graphvar = 44, 
		RULE_gvar = 45, RULE_ymin = 46, RULE_ymax = 47, RULE_linewidthgraph = 48, 
		RULE_metadata = 49, RULE_sketchInfo = 50, RULE_versionCode = 51, RULE_viewNumber = 52, 
		RULE_viewSettings = 53, RULE_objectList = 54, RULE_objectParam = 55, RULE_points = 56, 
		RULE_viewX = 57, RULE_viewInfo = 58, RULE_sketches = 59, RULE_subscriptId = 60, 
		RULE_constVensim = 61, RULE_integerConst = 62, RULE_floatingConst = 63, 
		RULE_unitsDoc = 64;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "model", "symbolWithDoc", "symbolWithDocDefinition", "subscriptRange", 
			"subscriptSequence", "subscriptMappingList", "subscriptMapping", "equation", 
			"lhs", "subscriptCopy", "unchangeableConstant", "dataEquation", "lookupDefinition", 
			"constraint", "realityCheck", "stringAssign", "macroDefinition", "expr", 
			"exprAllowSign", "call", "macroHeader", "macroArguments", "exprList", 
			"subscriptValueList", "indexList", "subscript", "lookup", "lookupRange", 
			"lookupPointList", "referenceLine", "lookupPoint", "constantLine", "constList", 
			"numberList", "graphs", "graph", "title", "xaxis", "yaxis", "xmin", "xmax", 
			"nolegend", "scale", "graphvar", "gvar", "ymin", "ymax", "linewidthgraph", 
			"metadata", "sketchInfo", "versionCode", "viewNumber", "viewSettings", 
			"objectList", "objectParam", "points", "viewX", "viewInfo", "sketches", 
			"subscriptId", "constVensim", "integerConst", "floatingConst", "unitsDoc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'('", "'-'", "')'", "'->'", "','", "':IGNORE:'", "':EXCEPT:'", 
			"'<->'", "':THE CONDITION:'", "':IMPLIES:'", "':TEST INPUT:'", "':MACRO:'", 
			"':END OF MACRO:'", "'^'", "'+'", "':AND:'", "':OR:'", "'DELAYP('", "'TABBED ARRAY('", 
			"'['", "']'", "';'", "':GRAPH'", "':TITLE'", "':X-AXIS'", "':Y-AXIS'", 
			"':X-MIN'", "':X-MAX'", "':NO-LEGEND'", "'0'", "'1'", "':SCALE'", "':VAR'", 
			"':Y-MIN'", "':Y-MAX'", "':LINE-WIDTH'", "':L\u007F<%^E!@'", "'---///'", 
			"'Sketch information - do not modify anything except names'", "'V300  Do not put anything below this section - it will be ignored'", 
			"'*View'", "'$'", "'|'", null, null, "'*'", "'/'", "'<'", "'<='", "'>'", 
			"'>='", "'='", "'=='", "'<>'", "'!'", "':='", "':IS:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "CommentOrEncoding", 
			"Group", "Star", "Div", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"Equal", "TwoEqual", "NotEqual", "Exclamation", "DataEquationOp", "StringAssignOp", 
			"Id", "Ex", "FloatingConstNumber", "FractionalConstant", "ExponentPart", 
			"DigitSeq", "StringLiteral", "StringConst", "Keyword", "Whitespace", 
			"Backslash", "INFO_UNIT", "OtherCaracter"
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
	public String getGrammarFileName() { return "Bazaco.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BazacoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BazacoParser.EOF, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			model();
			setState(131);
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

	public static class ModelContext extends ParserRuleContext {
		public SketchesContext sketches() {
			return getRuleContext(SketchesContext.class,0);
		}
		public MetadataContext metadata() {
			return getRuleContext(MetadataContext.class,0);
		}
		public List<SymbolWithDocContext> symbolWithDoc() {
			return getRuleContexts(SymbolWithDocContext.class);
		}
		public SymbolWithDocContext symbolWithDoc(int i) {
			return getRuleContext(SymbolWithDocContext.class,i);
		}
		public List<MacroDefinitionContext> macroDefinition() {
			return getRuleContexts(MacroDefinitionContext.class);
		}
		public MacroDefinitionContext macroDefinition(int i) {
			return getRuleContext(MacroDefinitionContext.class,i);
		}
		public List<GraphsContext> graphs() {
			return getRuleContexts(GraphsContext.class);
		}
		public GraphsContext graphs(int i) {
			return getRuleContext(GraphsContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==Id) {
				{
				setState(135);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Id:
					{
					setState(133);
					symbolWithDoc();
					}
					break;
				case T__12:
					{
					setState(134);
					macroDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			sketches();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(141);
				graphs();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			metadata();
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

	public static class SymbolWithDocContext extends ParserRuleContext {
		public SymbolWithDocDefinitionContext symbolWithDocDefinition() {
			return getRuleContext(SymbolWithDocDefinitionContext.class,0);
		}
		public UnitsDocContext unitsDoc() {
			return getRuleContext(UnitsDocContext.class,0);
		}
		public SymbolWithDocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolWithDoc; }
	}

	public final SymbolWithDocContext symbolWithDoc() throws RecognitionException {
		SymbolWithDocContext _localctx = new SymbolWithDocContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_symbolWithDoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			symbolWithDocDefinition();
			setState(150);
			unitsDoc();
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

	public static class SymbolWithDocDefinitionContext extends ParserRuleContext {
		public LookupDefinitionContext lookupDefinition() {
			return getRuleContext(LookupDefinitionContext.class,0);
		}
		public SubscriptRangeContext subscriptRange() {
			return getRuleContext(SubscriptRangeContext.class,0);
		}
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public UnchangeableConstantContext unchangeableConstant() {
			return getRuleContext(UnchangeableConstantContext.class,0);
		}
		public DataEquationContext dataEquation() {
			return getRuleContext(DataEquationContext.class,0);
		}
		public StringAssignContext stringAssign() {
			return getRuleContext(StringAssignContext.class,0);
		}
		public SubscriptCopyContext subscriptCopy() {
			return getRuleContext(SubscriptCopyContext.class,0);
		}
		public RealityCheckContext realityCheck() {
			return getRuleContext(RealityCheckContext.class,0);
		}
		public SymbolWithDocDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolWithDocDefinition; }
	}

	public final SymbolWithDocDefinitionContext symbolWithDocDefinition() throws RecognitionException {
		SymbolWithDocDefinitionContext _localctx = new SymbolWithDocDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_symbolWithDocDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(152);
				lookupDefinition();
				}
				break;
			case 2:
				{
				setState(153);
				subscriptRange();
				}
				break;
			case 3:
				{
				setState(154);
				equation();
				}
				break;
			case 4:
				{
				setState(155);
				constraint();
				}
				break;
			case 5:
				{
				setState(156);
				unchangeableConstant();
				}
				break;
			case 6:
				{
				setState(157);
				dataEquation();
				}
				break;
			case 7:
				{
				setState(158);
				stringAssign();
				}
				break;
			case 8:
				{
				setState(159);
				subscriptCopy();
				}
				break;
			case 9:
				{
				setState(160);
				realityCheck();
				}
				break;
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

	public static class SubscriptRangeContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public SubscriptSequenceContext subscriptSequence() {
			return getRuleContext(SubscriptSequenceContext.class,0);
		}
		public SubscriptValueListContext subscriptValueList() {
			return getRuleContext(SubscriptValueListContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public SubscriptMappingListContext subscriptMappingList() {
			return getRuleContext(SubscriptMappingListContext.class,0);
		}
		public SubscriptRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptRange; }
	}

	public final SubscriptRangeContext subscriptRange() throws RecognitionException {
		SubscriptRangeContext _localctx = new SubscriptRangeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_subscriptRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(Id);
			setState(164);
			match(T__0);
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(165);
				subscriptSequence();
				}
				break;
			case 2:
				{
				setState(166);
				subscriptValueList();
				}
				break;
			case 3:
				{
				setState(167);
				call();
				}
				break;
			}
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(170);
				subscriptMappingList();
				}
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

	public static class SubscriptSequenceContext extends ParserRuleContext {
		public Token start;
		public Token end;
		public List<TerminalNode> Id() { return getTokens(BazacoParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(BazacoParser.Id, i);
		}
		public SubscriptSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptSequence; }
	}

	public final SubscriptSequenceContext subscriptSequence() throws RecognitionException {
		SubscriptSequenceContext _localctx = new SubscriptSequenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subscriptSequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__1);
			setState(174);
			((SubscriptSequenceContext)_localctx).start = match(Id);
			setState(175);
			match(T__2);
			setState(176);
			((SubscriptSequenceContext)_localctx).end = match(Id);
			setState(177);
			match(T__3);
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

	public static class SubscriptMappingListContext extends ParserRuleContext {
		public List<SubscriptMappingContext> subscriptMapping() {
			return getRuleContexts(SubscriptMappingContext.class);
		}
		public SubscriptMappingContext subscriptMapping(int i) {
			return getRuleContext(SubscriptMappingContext.class,i);
		}
		public SubscriptMappingListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptMappingList; }
	}

	public final SubscriptMappingListContext subscriptMappingList() throws RecognitionException {
		SubscriptMappingListContext _localctx = new SubscriptMappingListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subscriptMappingList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__4);
			setState(180);
			subscriptMapping();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(181);
				match(T__5);
				setState(182);
				subscriptMapping();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SubscriptMappingContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public IndexListContext indexList() {
			return getRuleContext(IndexListContext.class,0);
		}
		public SubscriptMappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptMapping; }
	}

	public final SubscriptMappingContext subscriptMapping() throws RecognitionException {
		SubscriptMappingContext _localctx = new SubscriptMappingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_subscriptMapping);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(Id);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__1);
				setState(190);
				match(Id);
				setState(191);
				match(T__0);
				setState(192);
				indexList();
				setState(193);
				match(T__3);
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

	public static class EquationContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode Equal() { return getToken(BazacoParser.Equal, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstListContext constList() {
			return getRuleContext(ConstListContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_equation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			lhs();
			setState(198);
			match(Equal);
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(199);
				expr(0);
				}
				break;
			case 2:
				{
				setState(200);
				constList();
				}
				break;
			}
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(203);
				match(T__6);
				setState(204);
				exprList();
				}
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

	public static class LhsContext extends ParserRuleContext {
		public SubscriptContext indexes;
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public TerminalNode Keyword() { return getToken(BazacoParser.Keyword, 0); }
		public List<SubscriptContext> subscript() {
			return getRuleContexts(SubscriptContext.class);
		}
		public SubscriptContext subscript(int i) {
			return getRuleContext(SubscriptContext.class,i);
		}
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(Id);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(208);
				((LhsContext)_localctx).indexes = subscript();
				}
			}

			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Keyword) {
				{
				setState(211);
				match(Keyword);
				}
			}

			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(214);
				match(T__7);
				setState(215);
				subscript();
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(216);
					match(T__5);
					setState(217);
					subscript();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class SubscriptCopyContext extends ParserRuleContext {
		public Token copy;
		public Token original;
		public List<TerminalNode> Id() { return getTokens(BazacoParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(BazacoParser.Id, i);
		}
		public SubscriptCopyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptCopy; }
	}

	public final SubscriptCopyContext subscriptCopy() throws RecognitionException {
		SubscriptCopyContext _localctx = new SubscriptCopyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_subscriptCopy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			((SubscriptCopyContext)_localctx).copy = match(Id);
			setState(226);
			match(T__8);
			setState(227);
			((SubscriptCopyContext)_localctx).original = match(Id);
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

	public static class UnchangeableConstantContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode TwoEqual() { return getToken(BazacoParser.TwoEqual, 0); }
		public ConstListContext constList() {
			return getRuleContext(ConstListContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode Keyword() { return getToken(BazacoParser.Keyword, 0); }
		public UnchangeableConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unchangeableConstant; }
	}

	public final UnchangeableConstantContext unchangeableConstant() throws RecognitionException {
		UnchangeableConstantContext _localctx = new UnchangeableConstantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unchangeableConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			lhs();
			setState(230);
			match(TwoEqual);
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__15:
			case FloatingConstNumber:
			case DigitSeq:
			case StringConst:
				{
				setState(231);
				constList();
				}
				break;
			case Id:
				{
				setState(232);
				call();
				}
				break;
			case Keyword:
				{
				setState(233);
				match(Keyword);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DataEquationContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode DataEquationOp() { return getToken(BazacoParser.DataEquationOp, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstListContext constList() {
			return getRuleContext(ConstListContext.class,0);
		}
		public DataEquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataEquation; }
	}

	public final DataEquationContext dataEquation() throws RecognitionException {
		DataEquationContext _localctx = new DataEquationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dataEquation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			lhs();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DataEquationOp) {
				{
				setState(237);
				match(DataEquationOp);
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(238);
					expr(0);
					}
					break;
				case 2:
					{
					setState(239);
					constList();
					}
					break;
				}
				}
			}

			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(244);
				match(T__6);
				setState(245);
				exprList();
				}
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

	public static class LookupDefinitionContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public LookupContext lookup() {
			return getRuleContext(LookupContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public NumberListContext numberList() {
			return getRuleContext(NumberListContext.class,0);
		}
		public LookupDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupDefinition; }
	}

	public final LookupDefinitionContext lookupDefinition() throws RecognitionException {
		LookupDefinitionContext _localctx = new LookupDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lookupDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			lhs();
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(249);
				lookup();
				}
				break;
			case 2:
				{
				{
				setState(250);
				match(T__1);
				setState(253);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Id:
					{
					setState(251);
					call();
					}
					break;
				case T__2:
				case T__15:
				case FloatingConstNumber:
				case DigitSeq:
					{
					setState(252);
					numberList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(255);
				match(T__3);
				}
				}
				break;
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

	public static class ConstraintContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			lhs();
			setState(260);
			match(T__9);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << Star) | (1L << Id) | (1L << FloatingConstNumber))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DigitSeq - 64)) | (1L << (StringConst - 64)) | (1L << (Keyword - 64)))) != 0)) {
				{
				setState(261);
				expr(0);
				}
			}

			setState(264);
			match(T__10);
			setState(265);
			expr(0);
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

	public static class RealityCheckContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RealityCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realityCheck; }
	}

	public final RealityCheckContext realityCheck() throws RecognitionException {
		RealityCheckContext _localctx = new RealityCheckContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_realityCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			lhs();
			setState(268);
			match(T__11);
			setState(269);
			expr(0);
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

	public static class StringAssignContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode StringAssignOp() { return getToken(BazacoParser.StringAssignOp, 0); }
		public TerminalNode StringConst() { return getToken(BazacoParser.StringConst, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public StringAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringAssign; }
	}

	public final StringAssignContext stringAssign() throws RecognitionException {
		StringAssignContext _localctx = new StringAssignContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stringAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			lhs();
			setState(272);
			match(StringAssignOp);
			setState(273);
			match(StringConst);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(274);
				match(T__6);
				setState(275);
				exprList();
				}
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

	public static class MacroDefinitionContext extends ParserRuleContext {
		public MacroHeaderContext macroHeader() {
			return getRuleContext(MacroHeaderContext.class,0);
		}
		public List<SymbolWithDocContext> symbolWithDoc() {
			return getRuleContexts(SymbolWithDocContext.class);
		}
		public SymbolWithDocContext symbolWithDoc(int i) {
			return getRuleContext(SymbolWithDocContext.class,i);
		}
		public MacroDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroDefinition; }
	}

	public final MacroDefinitionContext macroDefinition() throws RecognitionException {
		MacroDefinitionContext _localctx = new MacroDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_macroDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__12);
			setState(279);
			macroHeader();
			setState(281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				symbolWithDoc();
				}
				}
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Id );
			setState(285);
			match(T__13);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstContext extends ExprContext {
		public ConstVensimContext constVensim() {
			return getRuleContext(ConstVensimContext.class,0);
		}
		public ConstContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class KeywordContext extends ExprContext {
		public TerminalNode Keyword() { return getToken(BazacoParser.Keyword, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public KeywordContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprOperationContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Star() { return getToken(BazacoParser.Star, 0); }
		public TerminalNode Div() { return getToken(BazacoParser.Div, 0); }
		public TerminalNode Less() { return getToken(BazacoParser.Less, 0); }
		public TerminalNode Greater() { return getToken(BazacoParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(BazacoParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(BazacoParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(BazacoParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(BazacoParser.NotEqual, 0); }
		public ExprOperationContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SignExprContext extends ExprContext {
		public ExprAllowSignContext exprAllowSign() {
			return getRuleContext(ExprAllowSignContext.class,0);
		}
		public SignExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class WildCardContext extends ExprContext {
		public TerminalNode Star() { return getToken(BazacoParser.Star, 0); }
		public WildCardContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LookupArgContext extends ExprContext {
		public LookupContext lookup() {
			return getRuleContext(LookupContext.class,0);
		}
		public LookupArgContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new ConstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(288);
				constVensim();
				}
				break;
			case 2:
				{
				_localctx = new KeywordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(Keyword);
				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(290);
					expr(0);
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new LookupArgContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				lookup();
				}
				break;
			case 4:
				{
				_localctx = new WildCardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				match(Star);
				}
				break;
			case 5:
				{
				_localctx = new SignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2 || _la==T__15) {
					{
					{
					setState(295);
					_la = _input.LA(1);
					if ( !(_la==T__2 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(301);
				exprAllowSign();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprOperationContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(304);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(305);
					((ExprOperationContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << Star) | (1L << Div) | (1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual) | (1L << Equal) | (1L << NotEqual))) != 0)) ) {
						((ExprOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(306);
					expr(7);
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class ExprAllowSignContext extends ParserRuleContext {
		public ExprAllowSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAllowSign; }
	 
		public ExprAllowSignContext() { }
		public void copyFrom(ExprAllowSignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DelayPArgContext extends ExprAllowSignContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public DelayPArgContext(ExprAllowSignContext ctx) { copyFrom(ctx); }
	}
	public static class TabbedArrayContext extends ExprAllowSignContext {
		public List<ConstVensimContext> constVensim() {
			return getRuleContexts(ConstVensimContext.class);
		}
		public ConstVensimContext constVensim(int i) {
			return getRuleContext(ConstVensimContext.class,i);
		}
		public TabbedArrayContext(ExprAllowSignContext ctx) { copyFrom(ctx); }
	}
	public static class VarContext extends ExprAllowSignContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public SubscriptContext subscript() {
			return getRuleContext(SubscriptContext.class,0);
		}
		public VarContext(ExprAllowSignContext ctx) { copyFrom(ctx); }
	}
	public static class ParensContext extends ExprAllowSignContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprAllowSignContext ctx) { copyFrom(ctx); }
	}
	public static class CallExprContext extends ExprAllowSignContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CallExprContext(ExprAllowSignContext ctx) { copyFrom(ctx); }
	}

	public final ExprAllowSignContext exprAllowSign() throws RecognitionException {
		ExprAllowSignContext _localctx = new ExprAllowSignContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprAllowSign);
		int _la;
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new CallExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				call();
				}
				break;
			case 2:
				_localctx = new DelayPArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				match(T__18);
				setState(314);
				expr(0);
				setState(315);
				match(T__5);
				setState(316);
				expr(0);
				setState(317);
				match(T__0);
				setState(318);
				match(Id);
				setState(319);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				match(Id);
				setState(323);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(322);
					subscript();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new TabbedArrayContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(325);
				match(T__19);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & ((1L << (T__2 - 3)) | (1L << (T__15 - 3)) | (1L << (FloatingConstNumber - 3)) | (1L << (DigitSeq - 3)) | (1L << (StringConst - 3)))) != 0)) {
					{
					{
					setState(326);
					constVensim();
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(332);
				match(T__3);
				}
				break;
			case 5:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(333);
				match(T__1);
				setState(334);
				expr(0);
				setState(335);
				match(T__3);
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

	public static class CallContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public SubscriptContext subscript() {
			return getRuleContext(SubscriptContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(Id);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(340);
				subscript();
				}
			}

			setState(343);
			match(T__1);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << Star) | (1L << Id) | (1L << FloatingConstNumber))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DigitSeq - 64)) | (1L << (StringConst - 64)) | (1L << (Keyword - 64)))) != 0)) {
				{
				setState(344);
				exprList();
				}
			}

			setState(347);
			match(T__3);
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

	public static class MacroHeaderContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public MacroArgumentsContext macroArguments() {
			return getRuleContext(MacroArgumentsContext.class,0);
		}
		public MacroHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroHeader; }
	}

	public final MacroHeaderContext macroHeader() throws RecognitionException {
		MacroHeaderContext _localctx = new MacroHeaderContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_macroHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(Id);
			setState(350);
			match(T__1);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << Star) | (1L << Id) | (1L << FloatingConstNumber))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DigitSeq - 64)) | (1L << (StringConst - 64)) | (1L << (Keyword - 64)))) != 0)) {
				{
				setState(351);
				macroArguments();
				}
			}

			setState(354);
			match(T__3);
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

	public static class MacroArgumentsContext extends ParserRuleContext {
		public List<ExprListContext> exprList() {
			return getRuleContexts(ExprListContext.class);
		}
		public ExprListContext exprList(int i) {
			return getRuleContext(ExprListContext.class,i);
		}
		public MacroArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroArguments; }
	}

	public final MacroArgumentsContext macroArguments() throws RecognitionException {
		MacroArgumentsContext _localctx = new MacroArgumentsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_macroArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			exprList();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(357);
				match(T__0);
				setState(358);
				exprList();
				}
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			expr(0);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(362);
				match(T__5);
				setState(363);
				expr(0);
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SubscriptValueListContext extends ParserRuleContext {
		public List<SubscriptIdContext> subscriptId() {
			return getRuleContexts(SubscriptIdContext.class);
		}
		public SubscriptIdContext subscriptId(int i) {
			return getRuleContext(SubscriptIdContext.class,i);
		}
		public List<SubscriptSequenceContext> subscriptSequence() {
			return getRuleContexts(SubscriptSequenceContext.class);
		}
		public SubscriptSequenceContext subscriptSequence(int i) {
			return getRuleContext(SubscriptSequenceContext.class,i);
		}
		public SubscriptValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptValueList; }
	}

	public final SubscriptValueListContext subscriptValueList() throws RecognitionException {
		SubscriptValueListContext _localctx = new SubscriptValueListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_subscriptValueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(369);
				subscriptId();
				}
				break;
			case T__1:
				{
				setState(370);
				subscriptSequence();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(373);
				match(T__5);
				setState(376);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Id:
					{
					setState(374);
					subscriptId();
					}
					break;
				case T__1:
					{
					setState(375);
					subscriptSequence();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class IndexListContext extends ParserRuleContext {
		public List<SubscriptIdContext> subscriptId() {
			return getRuleContexts(SubscriptIdContext.class);
		}
		public SubscriptIdContext subscriptId(int i) {
			return getRuleContext(SubscriptIdContext.class,i);
		}
		public IndexListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexList; }
	}

	public final IndexListContext indexList() throws RecognitionException {
		IndexListContext _localctx = new IndexListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_indexList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			subscriptId();
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(384);
				match(T__5);
				setState(385);
				subscriptId();
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SubscriptContext extends ParserRuleContext {
		public IndexListContext indexList() {
			return getRuleContext(IndexListContext.class,0);
		}
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
	}

	public final SubscriptContext subscript() throws RecognitionException {
		SubscriptContext _localctx = new SubscriptContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_subscript);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(T__20);
			setState(392);
			indexList();
			setState(393);
			match(T__21);
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

	public static class LookupContext extends ParserRuleContext {
		public LookupPointListContext lookupPointList() {
			return getRuleContext(LookupPointListContext.class,0);
		}
		public LookupRangeContext lookupRange() {
			return getRuleContext(LookupRangeContext.class,0);
		}
		public LookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookup; }
	}

	public final LookupContext lookup() throws RecognitionException {
		LookupContext _localctx = new LookupContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_lookup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(T__1);
			{
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(396);
				lookupRange();
				}
			}

			setState(399);
			lookupPointList();
			}
			setState(401);
			match(T__3);
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

	public static class LookupRangeContext extends ParserRuleContext {
		public List<LookupPointContext> lookupPoint() {
			return getRuleContexts(LookupPointContext.class);
		}
		public LookupPointContext lookupPoint(int i) {
			return getRuleContext(LookupPointContext.class,i);
		}
		public ReferenceLineContext referenceLine() {
			return getRuleContext(ReferenceLineContext.class,0);
		}
		public LookupRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupRange; }
	}

	public final LookupRangeContext lookupRange() throws RecognitionException {
		LookupRangeContext _localctx = new LookupRangeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_lookupRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(T__20);
			setState(404);
			lookupPoint();
			setState(405);
			match(T__2);
			setState(406);
			lookupPoint();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(407);
				referenceLine();
				}
			}

			setState(410);
			match(T__21);
			setState(411);
			match(T__5);
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

	public static class LookupPointListContext extends ParserRuleContext {
		public List<LookupPointContext> lookupPoint() {
			return getRuleContexts(LookupPointContext.class);
		}
		public LookupPointContext lookupPoint(int i) {
			return getRuleContext(LookupPointContext.class,i);
		}
		public LookupPointListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupPointList; }
	}

	public final LookupPointListContext lookupPointList() throws RecognitionException {
		LookupPointListContext _localctx = new LookupPointListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_lookupPointList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			lookupPoint();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(414);
				match(T__5);
				setState(415);
				lookupPoint();
				}
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ReferenceLineContext extends ParserRuleContext {
		public LookupPointListContext lookupPointList() {
			return getRuleContext(LookupPointListContext.class,0);
		}
		public ReferenceLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceLine; }
	}

	public final ReferenceLineContext referenceLine() throws RecognitionException {
		ReferenceLineContext _localctx = new ReferenceLineContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_referenceLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__5);
			setState(422);
			lookupPointList();
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

	public static class LookupPointContext extends ParserRuleContext {
		public List<ConstVensimContext> constVensim() {
			return getRuleContexts(ConstVensimContext.class);
		}
		public ConstVensimContext constVensim(int i) {
			return getRuleContext(ConstVensimContext.class,i);
		}
		public LookupPointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupPoint; }
	}

	public final LookupPointContext lookupPoint() throws RecognitionException {
		LookupPointContext _localctx = new LookupPointContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lookupPoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(T__1);
			setState(425);
			constVensim();
			setState(426);
			match(T__5);
			setState(427);
			constVensim();
			setState(428);
			match(T__3);
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

	public static class ConstantLineContext extends ParserRuleContext {
		public List<ConstVensimContext> constVensim() {
			return getRuleContexts(ConstVensimContext.class);
		}
		public ConstVensimContext constVensim(int i) {
			return getRuleContext(ConstVensimContext.class,i);
		}
		public ConstantLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantLine; }
	}

	public final ConstantLineContext constantLine() throws RecognitionException {
		ConstantLineContext _localctx = new ConstantLineContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_constantLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(430);
			constVensim();
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(431);
				match(T__5);
				setState(432);
				constVensim();
				}
				}
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ConstListContext extends ParserRuleContext {
		public List<ConstantLineContext> constantLine() {
			return getRuleContexts(ConstantLineContext.class);
		}
		public ConstantLineContext constantLine(int i) {
			return getRuleContext(ConstantLineContext.class,i);
		}
		public ConstListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constList; }
	}

	public final ConstListContext constList() throws RecognitionException {
		ConstListContext _localctx = new ConstListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_constList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			constantLine();
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(439);
						match(T__22);
						setState(440);
						constantLine();
						}
						} 
					}
					setState(445);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				setState(446);
				match(T__22);
				}
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

	public static class NumberListContext extends ParserRuleContext {
		public List<IntegerConstContext> integerConst() {
			return getRuleContexts(IntegerConstContext.class);
		}
		public IntegerConstContext integerConst(int i) {
			return getRuleContext(IntegerConstContext.class,i);
		}
		public List<FloatingConstContext> floatingConst() {
			return getRuleContexts(FloatingConstContext.class);
		}
		public FloatingConstContext floatingConst(int i) {
			return getRuleContext(FloatingConstContext.class,i);
		}
		public NumberListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberList; }
	}

	public final NumberListContext numberList() throws RecognitionException {
		NumberListContext _localctx = new NumberListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_numberList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(449);
				integerConst();
				}
				break;
			case 2:
				{
				setState(450);
				floatingConst();
				}
				break;
			}
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(453);
				match(T__5);
				setState(456);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(454);
					integerConst();
					}
					break;
				case 2:
					{
					setState(455);
					floatingConst();
					}
					break;
				}
				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class GraphsContext extends ParserRuleContext {
		public GraphContext graph() {
			return getRuleContext(GraphContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public ScaleContext scale() {
			return getRuleContext(ScaleContext.class,0);
		}
		public XaxisContext xaxis() {
			return getRuleContext(XaxisContext.class,0);
		}
		public YaxisContext yaxis() {
			return getRuleContext(YaxisContext.class,0);
		}
		public XminContext xmin() {
			return getRuleContext(XminContext.class,0);
		}
		public XmaxContext xmax() {
			return getRuleContext(XmaxContext.class,0);
		}
		public NolegendContext nolegend() {
			return getRuleContext(NolegendContext.class,0);
		}
		public List<GraphvarContext> graphvar() {
			return getRuleContexts(GraphvarContext.class);
		}
		public GraphvarContext graphvar(int i) {
			return getRuleContext(GraphvarContext.class,i);
		}
		public GraphsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphs; }
	}

	public final GraphsContext graphs() throws RecognitionException {
		GraphsContext _localctx = new GraphsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_graphs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			graph();
			setState(464);
			title();
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(465);
				xaxis();
				}
			}

			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(468);
				yaxis();
				}
			}

			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(471);
				xmin();
				}
			}

			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(474);
				xmax();
				}
			}

			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(477);
				nolegend();
				}
			}

			setState(480);
			scale();
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(481);
				graphvar();
				}
				}
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class GraphContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_graph);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(T__23);
			setState(488);
			match(Id);
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

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(T__24);
			setState(491);
			match(Id);
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

	public static class XaxisContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public XaxisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xaxis; }
	}

	public final XaxisContext xaxis() throws RecognitionException {
		XaxisContext _localctx = new XaxisContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_xaxis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			match(T__25);
			setState(494);
			match(Id);
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

	public static class YaxisContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public YaxisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yaxis; }
	}

	public final YaxisContext yaxis() throws RecognitionException {
		YaxisContext _localctx = new YaxisContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_yaxis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(T__26);
			setState(497);
			match(Id);
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

	public static class XminContext extends ParserRuleContext {
		public TerminalNode DigitSeq() { return getToken(BazacoParser.DigitSeq, 0); }
		public XminContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmin; }
	}

	public final XminContext xmin() throws RecognitionException {
		XminContext _localctx = new XminContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_xmin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(T__27);
			setState(500);
			match(DigitSeq);
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

	public static class XmaxContext extends ParserRuleContext {
		public TerminalNode DigitSeq() { return getToken(BazacoParser.DigitSeq, 0); }
		public XmaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmax; }
	}

	public final XmaxContext xmax() throws RecognitionException {
		XmaxContext _localctx = new XmaxContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_xmax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(T__28);
			setState(503);
			match(DigitSeq);
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

	public static class NolegendContext extends ParserRuleContext {
		public NolegendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nolegend; }
	}

	public final NolegendContext nolegend() throws RecognitionException {
		NolegendContext _localctx = new NolegendContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_nolegend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(T__29);
			setState(506);
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

	public static class ScaleContext extends ParserRuleContext {
		public ScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scale; }
	}

	public final ScaleContext scale() throws RecognitionException {
		ScaleContext _localctx = new ScaleContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_scale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(T__32);
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

	public static class GraphvarContext extends ParserRuleContext {
		public GvarContext gvar() {
			return getRuleContext(GvarContext.class,0);
		}
		public List<YminContext> ymin() {
			return getRuleContexts(YminContext.class);
		}
		public YminContext ymin(int i) {
			return getRuleContext(YminContext.class,i);
		}
		public List<YmaxContext> ymax() {
			return getRuleContexts(YmaxContext.class);
		}
		public YmaxContext ymax(int i) {
			return getRuleContext(YmaxContext.class,i);
		}
		public List<LinewidthgraphContext> linewidthgraph() {
			return getRuleContexts(LinewidthgraphContext.class);
		}
		public LinewidthgraphContext linewidthgraph(int i) {
			return getRuleContext(LinewidthgraphContext.class,i);
		}
		public GraphvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphvar; }
	}

	public final GraphvarContext graphvar() throws RecognitionException {
		GraphvarContext _localctx = new GraphvarContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_graphvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			gvar();
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(511);
				ymin();
				}
				}
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(517);
				ymax();
				}
				}
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(523);
				linewidthgraph();
				}
				}
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class GvarContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public GvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gvar; }
	}

	public final GvarContext gvar() throws RecognitionException {
		GvarContext _localctx = new GvarContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_gvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(T__33);
			setState(530);
			match(Id);
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

	public static class YminContext extends ParserRuleContext {
		public YminContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ymin; }
	}

	public final YminContext ymin() throws RecognitionException {
		YminContext _localctx = new YminContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_ymin);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(T__34);
			setState(536);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(533);
					matchWildcard();
					}
					} 
				}
				setState(538);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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

	public static class YmaxContext extends ParserRuleContext {
		public YmaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ymax; }
	}

	public final YmaxContext ymax() throws RecognitionException {
		YmaxContext _localctx = new YmaxContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_ymax);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			match(T__35);
			setState(543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(540);
					matchWildcard();
					}
					} 
				}
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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

	public static class LinewidthgraphContext extends ParserRuleContext {
		public LinewidthgraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linewidthgraph; }
	}

	public final LinewidthgraphContext linewidthgraph() throws RecognitionException {
		LinewidthgraphContext _localctx = new LinewidthgraphContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_linewidthgraph);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(T__36);
			setState(550);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(547);
					matchWildcard();
					}
					} 
				}
				setState(552);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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

	public static class MetadataContext extends ParserRuleContext {
		public MetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata; }
	}

	public final MetadataContext metadata() throws RecognitionException {
		MetadataContext _localctx = new MetadataContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_metadata);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(T__37);
			setState(557);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(554);
					matchWildcard();
					}
					} 
				}
				setState(559);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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

	public static class SketchInfoContext extends ParserRuleContext {
		public SketchInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sketchInfo; }
	}

	public final SketchInfoContext sketchInfo() throws RecognitionException {
		SketchInfoContext _localctx = new SketchInfoContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_sketchInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(T__38);
			setState(561);
			match(T__39);
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

	public static class VersionCodeContext extends ParserRuleContext {
		public VersionCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionCode; }
	}

	public final VersionCodeContext versionCode() throws RecognitionException {
		VersionCodeContext _localctx = new VersionCodeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_versionCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(T__40);
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

	public static class ViewNumberContext extends ParserRuleContext {
		public TerminalNode DigitSeq() { return getToken(BazacoParser.DigitSeq, 0); }
		public ViewNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewNumber; }
	}

	public final ViewNumberContext viewNumber() throws RecognitionException {
		ViewNumberContext _localctx = new ViewNumberContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_viewNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(T__41);
			setState(566);
			match(DigitSeq);
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

	public static class ViewSettingsContext extends ParserRuleContext {
		public ViewSettingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewSettings; }
	}

	public final ViewSettingsContext viewSettings() throws RecognitionException {
		ViewSettingsContext _localctx = new ViewSettingsContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_viewSettings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(T__42);
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

	public static class ObjectListContext extends ParserRuleContext {
		public List<ObjectParamContext> objectParam() {
			return getRuleContexts(ObjectParamContext.class);
		}
		public ObjectParamContext objectParam(int i) {
			return getRuleContext(ObjectParamContext.class,i);
		}
		public ObjectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectList; }
	}

	public final ObjectListContext objectList() throws RecognitionException {
		ObjectListContext _localctx = new ObjectListContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_objectList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(570);
				objectParam();
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(571);
					match(T__5);
					}
				}

				}
				}
				setState(576); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Ex || _la==DigitSeq );
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

	public static class ObjectParamContext extends ParserRuleContext {
		public TerminalNode DigitSeq() { return getToken(BazacoParser.DigitSeq, 0); }
		public TerminalNode Ex() { return getToken(BazacoParser.Ex, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public ObjectParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectParam; }
	}

	public final ObjectParamContext objectParam() throws RecognitionException {
		ObjectParamContext _localctx = new ObjectParamContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_objectParam);
		try {
			setState(581);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(578);
				match(DigitSeq);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				match(Ex);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(580);
				points();
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

	public static class PointsContext extends ParserRuleContext {
		public List<TerminalNode> DigitSeq() { return getTokens(BazacoParser.DigitSeq); }
		public TerminalNode DigitSeq(int i) {
			return getToken(BazacoParser.DigitSeq, i);
		}
		public PointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_points; }
	}

	public final PointsContext points() throws RecognitionException {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_points);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(DigitSeq);
			setState(590); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(584);
					match(T__43);
					setState(585);
					match(T__1);
					setState(586);
					match(DigitSeq);
					setState(587);
					match(T__5);
					setState(588);
					match(DigitSeq);
					setState(589);
					match(T__3);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(592); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(594);
			match(T__43);
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

	public static class ViewXContext extends ParserRuleContext {
		public ViewXContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewX; }
	}

	public final ViewXContext viewX() throws RecognitionException {
		ViewXContext _localctx = new ViewXContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_viewX);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(596);
					matchWildcard();
					}
					} 
				}
				setState(601);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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

	public static class ViewInfoContext extends ParserRuleContext {
		public SketchInfoContext sketchInfo() {
			return getRuleContext(SketchInfoContext.class,0);
		}
		public VersionCodeContext versionCode() {
			return getRuleContext(VersionCodeContext.class,0);
		}
		public ViewNumberContext viewNumber() {
			return getRuleContext(ViewNumberContext.class,0);
		}
		public ViewXContext viewX() {
			return getRuleContext(ViewXContext.class,0);
		}
		public ViewInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewInfo; }
	}

	public final ViewInfoContext viewInfo() throws RecognitionException {
		ViewInfoContext _localctx = new ViewInfoContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_viewInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			sketchInfo();
			setState(603);
			versionCode();
			setState(604);
			viewNumber();
			setState(605);
			viewX();
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

	public static class SketchesContext extends ParserRuleContext {
		public List<ViewInfoContext> viewInfo() {
			return getRuleContexts(ViewInfoContext.class);
		}
		public ViewInfoContext viewInfo(int i) {
			return getRuleContext(ViewInfoContext.class,i);
		}
		public SketchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sketches; }
	}

	public final SketchesContext sketches() throws RecognitionException {
		SketchesContext _localctx = new SketchesContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_sketches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38) {
				{
				{
				setState(607);
				viewInfo();
				}
				}
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SubscriptIdContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(BazacoParser.Id, 0); }
		public TerminalNode Exclamation() { return getToken(BazacoParser.Exclamation, 0); }
		public SubscriptIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptId; }
	}

	public final SubscriptIdContext subscriptId() throws RecognitionException {
		SubscriptIdContext _localctx = new SubscriptIdContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_subscriptId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			match(Id);
			setState(615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Exclamation) {
				{
				setState(614);
				match(Exclamation);
				}
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

	public static class ConstVensimContext extends ParserRuleContext {
		public IntegerConstContext integerConst() {
			return getRuleContext(IntegerConstContext.class,0);
		}
		public FloatingConstContext floatingConst() {
			return getRuleContext(FloatingConstContext.class,0);
		}
		public TerminalNode StringConst() { return getToken(BazacoParser.StringConst, 0); }
		public ConstVensimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constVensim; }
	}

	public final ConstVensimContext constVensim() throws RecognitionException {
		ConstVensimContext _localctx = new ConstVensimContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_constVensim);
		try {
			setState(620);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				integerConst();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(618);
				floatingConst();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(619);
				match(StringConst);
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

	public static class IntegerConstContext extends ParserRuleContext {
		public TerminalNode DigitSeq() { return getToken(BazacoParser.DigitSeq, 0); }
		public IntegerConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerConst; }
	}

	public final IntegerConstContext integerConst() throws RecognitionException {
		IntegerConstContext _localctx = new IntegerConstContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_integerConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__15) {
				{
				{
				setState(622);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(628);
			match(DigitSeq);
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

	public static class FloatingConstContext extends ParserRuleContext {
		public TerminalNode FloatingConstNumber() { return getToken(BazacoParser.FloatingConstNumber, 0); }
		public FloatingConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingConst; }
	}

	public final FloatingConstContext floatingConst() throws RecognitionException {
		FloatingConstContext _localctx = new FloatingConstContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_floatingConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__15) {
				{
				{
				setState(630);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(636);
			match(FloatingConstNumber);
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

	public static class UnitsDocContext extends ParserRuleContext {
		public Token units;
		public Token comment;
		public Token supplementary;
		public List<TerminalNode> INFO_UNIT() { return getTokens(BazacoParser.INFO_UNIT); }
		public TerminalNode INFO_UNIT(int i) {
			return getToken(BazacoParser.INFO_UNIT, i);
		}
		public UnitsDocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitsDoc; }
	}

	public final UnitsDocContext unitsDoc() throws RecognitionException {
		UnitsDocContext _localctx = new UnitsDocContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_unitsDoc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			((UnitsDocContext)_localctx).units = match(INFO_UNIT);
			setState(639);
			((UnitsDocContext)_localctx).comment = match(INFO_UNIT);
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INFO_UNIT) {
				{
				setState(640);
				((UnitsDocContext)_localctx).supplementary = match(INFO_UNIT);
				}
			}

			setState(643);
			match(T__43);
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
		case 18:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3I\u0288\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\3\3\3\7\3\u008a\n\3\f\3\16"+
		"\3\u008d\13\3\3\3\3\3\7\3\u0091\n\3\f\3\16\3\u0094\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a4\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\5\6\u00ab\n\6\3\6\5\6\u00ae\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\7\b\u00ba\n\b\f\b\16\b\u00bd\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u00c6\n\t\3\n\3\n\3\n\3\n\5\n\u00cc\n\n\3\n\3\n\5\n\u00d0\n\n\3\13"+
		"\3\13\5\13\u00d4\n\13\3\13\5\13\u00d7\n\13\3\13\3\13\3\13\3\13\7\13\u00dd"+
		"\n\13\f\13\16\13\u00e0\13\13\5\13\u00e2\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00ed\n\r\3\16\3\16\3\16\3\16\5\16\u00f3\n\16\5\16\u00f5"+
		"\n\16\3\16\3\16\5\16\u00f9\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u0100\n"+
		"\17\3\17\3\17\5\17\u0104\n\17\3\20\3\20\3\20\5\20\u0109\n\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u0117\n\22\3\23"+
		"\3\23\3\23\6\23\u011c\n\23\r\23\16\23\u011d\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\5\24\u0126\n\24\3\24\3\24\3\24\7\24\u012b\n\24\f\24\16\24\u012e\13"+
		"\24\3\24\5\24\u0131\n\24\3\24\3\24\3\24\7\24\u0136\n\24\f\24\16\24\u0139"+
		"\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0146"+
		"\n\25\3\25\3\25\7\25\u014a\n\25\f\25\16\25\u014d\13\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0154\n\25\3\26\3\26\5\26\u0158\n\26\3\26\3\26\5\26\u015c"+
		"\n\26\3\26\3\26\3\27\3\27\3\27\5\27\u0163\n\27\3\27\3\27\3\30\3\30\3\30"+
		"\5\30\u016a\n\30\3\31\3\31\3\31\7\31\u016f\n\31\f\31\16\31\u0172\13\31"+
		"\3\32\3\32\5\32\u0176\n\32\3\32\3\32\3\32\5\32\u017b\n\32\7\32\u017d\n"+
		"\32\f\32\16\32\u0180\13\32\3\33\3\33\3\33\7\33\u0185\n\33\f\33\16\33\u0188"+
		"\13\33\3\34\3\34\3\34\3\34\3\35\3\35\5\35\u0190\n\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\5\36\u019b\n\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\7\37\u01a3\n\37\f\37\16\37\u01a6\13\37\3 \3 \3 \3!\3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\7\"\u01b4\n\"\f\"\16\"\u01b7\13\"\3#\3#\3#\7#\u01bc\n#\f"+
		"#\16#\u01bf\13#\3#\5#\u01c2\n#\3$\3$\5$\u01c6\n$\3$\3$\3$\5$\u01cb\n$"+
		"\7$\u01cd\n$\f$\16$\u01d0\13$\3%\3%\3%\5%\u01d5\n%\3%\5%\u01d8\n%\3%\5"+
		"%\u01db\n%\3%\5%\u01de\n%\3%\5%\u01e1\n%\3%\3%\7%\u01e5\n%\f%\16%\u01e8"+
		"\13%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		",\3-\3-\3.\3.\7.\u0203\n.\f.\16.\u0206\13.\3.\7.\u0209\n.\f.\16.\u020c"+
		"\13.\3.\7.\u020f\n.\f.\16.\u0212\13.\3/\3/\3/\3\60\3\60\7\60\u0219\n\60"+
		"\f\60\16\60\u021c\13\60\3\61\3\61\7\61\u0220\n\61\f\61\16\61\u0223\13"+
		"\61\3\62\3\62\7\62\u0227\n\62\f\62\16\62\u022a\13\62\3\63\3\63\7\63\u022e"+
		"\n\63\f\63\16\63\u0231\13\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3"+
		"\67\3\67\38\38\58\u023f\n8\68\u0241\n8\r8\168\u0242\39\39\39\59\u0248"+
		"\n9\3:\3:\3:\3:\3:\3:\3:\6:\u0251\n:\r:\16:\u0252\3:\3:\3;\7;\u0258\n"+
		";\f;\16;\u025b\13;\3<\3<\3<\3<\3<\3=\7=\u0263\n=\f=\16=\u0266\13=\3>\3"+
		">\5>\u026a\n>\3?\3?\3?\5?\u026f\n?\3@\7@\u0272\n@\f@\16@\u0275\13@\3@"+
		"\3@\3A\7A\u027a\nA\fA\16A\u027d\13A\3A\3A\3B\3B\3B\5B\u0284\nB\3B\3B\3"+
		"B\7\u021a\u0221\u0228\u022f\u0259\3&C\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\2\5\4\2\5\5\22\22\6\2\5\5\21\24\61\6799\3\2!\"\2\u029f\2\u0084"+
		"\3\2\2\2\4\u008b\3\2\2\2\6\u0097\3\2\2\2\b\u00a3\3\2\2\2\n\u00a5\3\2\2"+
		"\2\f\u00af\3\2\2\2\16\u00b5\3\2\2\2\20\u00c5\3\2\2\2\22\u00c7\3\2\2\2"+
		"\24\u00d1\3\2\2\2\26\u00e3\3\2\2\2\30\u00e7\3\2\2\2\32\u00ee\3\2\2\2\34"+
		"\u00fa\3\2\2\2\36\u0105\3\2\2\2 \u010d\3\2\2\2\"\u0111\3\2\2\2$\u0118"+
		"\3\2\2\2&\u0130\3\2\2\2(\u0153\3\2\2\2*\u0155\3\2\2\2,\u015f\3\2\2\2."+
		"\u0166\3\2\2\2\60\u016b\3\2\2\2\62\u0175\3\2\2\2\64\u0181\3\2\2\2\66\u0189"+
		"\3\2\2\28\u018d\3\2\2\2:\u0195\3\2\2\2<\u019f\3\2\2\2>\u01a7\3\2\2\2@"+
		"\u01aa\3\2\2\2B\u01b0\3\2\2\2D\u01b8\3\2\2\2F\u01c5\3\2\2\2H\u01d1\3\2"+
		"\2\2J\u01e9\3\2\2\2L\u01ec\3\2\2\2N\u01ef\3\2\2\2P\u01f2\3\2\2\2R\u01f5"+
		"\3\2\2\2T\u01f8\3\2\2\2V\u01fb\3\2\2\2X\u01fe\3\2\2\2Z\u0200\3\2\2\2\\"+
		"\u0213\3\2\2\2^\u0216\3\2\2\2`\u021d\3\2\2\2b\u0224\3\2\2\2d\u022b\3\2"+
		"\2\2f\u0232\3\2\2\2h\u0235\3\2\2\2j\u0237\3\2\2\2l\u023a\3\2\2\2n\u0240"+
		"\3\2\2\2p\u0247\3\2\2\2r\u0249\3\2\2\2t\u0259\3\2\2\2v\u025c\3\2\2\2x"+
		"\u0264\3\2\2\2z\u0267\3\2\2\2|\u026e\3\2\2\2~\u0273\3\2\2\2\u0080\u027b"+
		"\3\2\2\2\u0082\u0280\3\2\2\2\u0084\u0085\5\4\3\2\u0085\u0086\7\2\2\3\u0086"+
		"\3\3\2\2\2\u0087\u008a\5\6\4\2\u0088\u008a\5$\23\2\u0089\u0087\3\2\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0092\5x=\2\u008f"+
		"\u0091\5H%\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2"+
		"\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096"+
		"\5d\63\2\u0096\5\3\2\2\2\u0097\u0098\5\b\5\2\u0098\u0099\5\u0082B\2\u0099"+
		"\7\3\2\2\2\u009a\u00a4\5\34\17\2\u009b\u00a4\5\n\6\2\u009c\u00a4\5\22"+
		"\n\2\u009d\u00a4\5\36\20\2\u009e\u00a4\5\30\r\2\u009f\u00a4\5\32\16\2"+
		"\u00a0\u00a4\5\"\22\2\u00a1\u00a4\5\26\f\2\u00a2\u00a4\5 \21\2\u00a3\u009a"+
		"\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009c\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3"+
		"\u009e\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\t\3\2\2\2\u00a5\u00a6\7=\2\2\u00a6\u00aa"+
		"\7\3\2\2\u00a7\u00ab\5\f\7\2\u00a8\u00ab\5\62\32\2\u00a9\u00ab\5*\26\2"+
		"\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ad"+
		"\3\2\2\2\u00ac\u00ae\5\16\b\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2"+
		"\u00ae\13\3\2\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b1\7=\2\2\u00b1\u00b2\7"+
		"\5\2\2\u00b2\u00b3\7=\2\2\u00b3\u00b4\7\6\2\2\u00b4\r\3\2\2\2\u00b5\u00b6"+
		"\7\7\2\2\u00b6\u00bb\5\20\t\2\u00b7\u00b8\7\b\2\2\u00b8\u00ba\5\20\t\2"+
		"\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\17\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c6\7=\2\2\u00bf"+
		"\u00c0\7\4\2\2\u00c0\u00c1\7=\2\2\u00c1\u00c2\7\3\2\2\u00c2\u00c3\5\64"+
		"\33\2\u00c3\u00c4\7\6\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00be\3\2\2\2\u00c5"+
		"\u00bf\3\2\2\2\u00c6\21\3\2\2\2\u00c7\u00c8\5\24\13\2\u00c8\u00cb\7\67"+
		"\2\2\u00c9\u00cc\5&\24\2\u00ca\u00cc\5D#\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca"+
		"\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00ce\7\t\2\2\u00ce\u00d0\5\60\31\2"+
		"\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\23\3\2\2\2\u00d1\u00d3"+
		"\7=\2\2\u00d2\u00d4\5\66\34\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2"+
		"\u00d4\u00d6\3\2\2\2\u00d5\u00d7\7E\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00e1\3\2\2\2\u00d8\u00d9\7\n\2\2\u00d9\u00de\5\66\34\2"+
		"\u00da\u00db\7\b\2\2\u00db\u00dd\5\66\34\2\u00dc\u00da\3\2\2\2\u00dd\u00e0"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\25\3\2\2"+
		"\2\u00e3\u00e4\7=\2\2\u00e4\u00e5\7\13\2\2\u00e5\u00e6\7=\2\2\u00e6\27"+
		"\3\2\2\2\u00e7\u00e8\5\24\13\2\u00e8\u00ec\78\2\2\u00e9\u00ed\5D#\2\u00ea"+
		"\u00ed\5*\26\2\u00eb\u00ed\7E\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2"+
		"\2\2\u00ec\u00eb\3\2\2\2\u00ed\31\3\2\2\2\u00ee\u00f4\5\24\13\2\u00ef"+
		"\u00f2\7;\2\2\u00f0\u00f3\5&\24\2\u00f1\u00f3\5D#\2\u00f2\u00f0\3\2\2"+
		"\2\u00f2\u00f1\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f7\7\t\2\2\u00f7\u00f9\5\60\31\2"+
		"\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\33\3\2\2\2\u00fa\u0103"+
		"\5\24\13\2\u00fb\u0104\58\35\2\u00fc\u00ff\7\4\2\2\u00fd\u0100\5*\26\2"+
		"\u00fe\u0100\5F$\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0102\7\6\2\2\u0102\u0104\3\2\2\2\u0103\u00fb\3\2\2\2\u0103"+
		"\u00fc\3\2\2\2\u0104\35\3\2\2\2\u0105\u0106\5\24\13\2\u0106\u0108\7\f"+
		"\2\2\u0107\u0109\5&\24\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\7\r\2\2\u010b\u010c\5&\24\2\u010c\37\3\2\2"+
		"\2\u010d\u010e\5\24\13\2\u010e\u010f\7\16\2\2\u010f\u0110\5&\24\2\u0110"+
		"!\3\2\2\2\u0111\u0112\5\24\13\2\u0112\u0113\7<\2\2\u0113\u0116\7D\2\2"+
		"\u0114\u0115\7\t\2\2\u0115\u0117\5\60\31\2\u0116\u0114\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117#\3\2\2\2\u0118\u0119\7\17\2\2\u0119\u011b\5,\27\2\u011a"+
		"\u011c\5\6\4\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\7\20\2\2\u0120"+
		"%\3\2\2\2\u0121\u0122\b\24\1\2\u0122\u0131\5|?\2\u0123\u0125\7E\2\2\u0124"+
		"\u0126\5&\24\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0131\3\2"+
		"\2\2\u0127\u0131\58\35\2\u0128\u0131\7\61\2\2\u0129\u012b\t\2\2\2\u012a"+
		"\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0131\5(\25\2\u0130"+
		"\u0121\3\2\2\2\u0130\u0123\3\2\2\2\u0130\u0127\3\2\2\2\u0130\u0128\3\2"+
		"\2\2\u0130\u012c\3\2\2\2\u0131\u0137\3\2\2\2\u0132\u0133\f\b\2\2\u0133"+
		"\u0134\t\3\2\2\u0134\u0136\5&\24\t\u0135\u0132\3\2\2\2\u0136\u0139\3\2"+
		"\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\'\3\2\2\2\u0139\u0137"+
		"\3\2\2\2\u013a\u0154\5*\26\2\u013b\u013c\7\25\2\2\u013c\u013d\5&\24\2"+
		"\u013d\u013e\7\b\2\2\u013e\u013f\5&\24\2\u013f\u0140\7\3\2\2\u0140\u0141"+
		"\7=\2\2\u0141\u0142\7\6\2\2\u0142\u0154\3\2\2\2\u0143\u0145\7=\2\2\u0144"+
		"\u0146\5\66\34\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0154\3"+
		"\2\2\2\u0147\u014b\7\26\2\2\u0148\u014a\5|?\2\u0149\u0148\3\2\2\2\u014a"+
		"\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2"+
		"\2\2\u014d\u014b\3\2\2\2\u014e\u0154\7\6\2\2\u014f\u0150\7\4\2\2\u0150"+
		"\u0151\5&\24\2\u0151\u0152\7\6\2\2\u0152\u0154\3\2\2\2\u0153\u013a\3\2"+
		"\2\2\u0153\u013b\3\2\2\2\u0153\u0143\3\2\2\2\u0153\u0147\3\2\2\2\u0153"+
		"\u014f\3\2\2\2\u0154)\3\2\2\2\u0155\u0157\7=\2\2\u0156\u0158\5\66\34\2"+
		"\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b"+
		"\7\4\2\2\u015a\u015c\5\60\31\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2"+
		"\u015c\u015d\3\2\2\2\u015d\u015e\7\6\2\2\u015e+\3\2\2\2\u015f\u0160\7"+
		"=\2\2\u0160\u0162\7\4\2\2\u0161\u0163\5.\30\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7\6\2\2\u0165-\3\2\2\2"+
		"\u0166\u0169\5\60\31\2\u0167\u0168\7\3\2\2\u0168\u016a\5\60\31\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a/\3\2\2\2\u016b\u0170\5&\24\2"+
		"\u016c\u016d\7\b\2\2\u016d\u016f\5&\24\2\u016e\u016c\3\2\2\2\u016f\u0172"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\61\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0176\5z>\2\u0174\u0176\5\f\7\2\u0175\u0173\3\2\2"+
		"\2\u0175\u0174\3\2\2\2\u0176\u017e\3\2\2\2\u0177\u017a\7\b\2\2\u0178\u017b"+
		"\5z>\2\u0179\u017b\5\f\7\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u0177\3\2\2\2\u017d\u0180\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017e\u017f\3\2\2\2\u017f\63\3\2\2\2\u0180\u017e\3\2\2\2\u0181\u0186"+
		"\5z>\2\u0182\u0183\7\b\2\2\u0183\u0185\5z>\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\65\3\2\2"+
		"\2\u0188\u0186\3\2\2\2\u0189\u018a\7\27\2\2\u018a\u018b\5\64\33\2\u018b"+
		"\u018c\7\30\2\2\u018c\67\3\2\2\2\u018d\u018f\7\4\2\2\u018e\u0190\5:\36"+
		"\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192"+
		"\5<\37\2\u0192\u0193\3\2\2\2\u0193\u0194\7\6\2\2\u01949\3\2\2\2\u0195"+
		"\u0196\7\27\2\2\u0196\u0197\5@!\2\u0197\u0198\7\5\2\2\u0198\u019a\5@!"+
		"\2\u0199\u019b\5> \2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c"+
		"\3\2\2\2\u019c\u019d\7\30\2\2\u019d\u019e\7\b\2\2\u019e;\3\2\2\2\u019f"+
		"\u01a4\5@!\2\u01a0\u01a1\7\b\2\2\u01a1\u01a3\5@!\2\u01a2\u01a0\3\2\2\2"+
		"\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5=\3"+
		"\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01a8\7\b\2\2\u01a8\u01a9\5<\37\2\u01a9"+
		"?\3\2\2\2\u01aa\u01ab\7\4\2\2\u01ab\u01ac\5|?\2\u01ac\u01ad\7\b\2\2\u01ad"+
		"\u01ae\5|?\2\u01ae\u01af\7\6\2\2\u01afA\3\2\2\2\u01b0\u01b5\5|?\2\u01b1"+
		"\u01b2\7\b\2\2\u01b2\u01b4\5|?\2\u01b3\u01b1\3\2\2\2\u01b4\u01b7\3\2\2"+
		"\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6C\3\2\2\2\u01b7\u01b5"+
		"\3\2\2\2\u01b8\u01c1\5B\"\2\u01b9\u01ba\7\31\2\2\u01ba\u01bc\5B\"\2\u01bb"+
		"\u01b9\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2"+
		"\2\2\u01be\u01c0\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c2\7\31\2\2\u01c1"+
		"\u01bd\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2E\3\2\2\2\u01c3\u01c6\5~@\2\u01c4"+
		"\u01c6\5\u0080A\2\u01c5\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01ce"+
		"\3\2\2\2\u01c7\u01ca\7\b\2\2\u01c8\u01cb\5~@\2\u01c9\u01cb\5\u0080A\2"+
		"\u01ca\u01c8\3\2\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01c7"+
		"\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"G\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d2\5J&\2\u01d2\u01d4\5L\'\2\u01d3"+
		"\u01d5\5N(\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2"+
		"\2\u01d6\u01d8\5P)\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01da"+
		"\3\2\2\2\u01d9\u01db\5R*\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dd\3\2\2\2\u01dc\u01de\5T+\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2"+
		"\2\u01de\u01e0\3\2\2\2\u01df\u01e1\5V,\2\u01e0\u01df\3\2\2\2\u01e0\u01e1"+
		"\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e6\5X-\2\u01e3\u01e5\5Z.\2\u01e4"+
		"\u01e3\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2"+
		"\2\2\u01e7I\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\7\32\2\2\u01ea\u01eb"+
		"\7=\2\2\u01ebK\3\2\2\2\u01ec\u01ed\7\33\2\2\u01ed\u01ee\7=\2\2\u01eeM"+
		"\3\2\2\2\u01ef\u01f0\7\34\2\2\u01f0\u01f1\7=\2\2\u01f1O\3\2\2\2\u01f2"+
		"\u01f3\7\35\2\2\u01f3\u01f4\7=\2\2\u01f4Q\3\2\2\2\u01f5\u01f6\7\36\2\2"+
		"\u01f6\u01f7\7B\2\2\u01f7S\3\2\2\2\u01f8\u01f9\7\37\2\2\u01f9\u01fa\7"+
		"B\2\2\u01faU\3\2\2\2\u01fb\u01fc\7 \2\2\u01fc\u01fd\t\4\2\2\u01fdW\3\2"+
		"\2\2\u01fe\u01ff\7#\2\2\u01ffY\3\2\2\2\u0200\u0204\5\\/\2\u0201\u0203"+
		"\5^\60\2\u0202\u0201\3\2\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205\u020a\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u0209\5`"+
		"\61\2\u0208\u0207\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a"+
		"\u020b\3\2\2\2\u020b\u0210\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u020f\5b"+
		"\62\2\u020e\u020d\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211[\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0214\7$\2\2\u0214"+
		"\u0215\7=\2\2\u0215]\3\2\2\2\u0216\u021a\7%\2\2\u0217\u0219\13\2\2\2\u0218"+
		"\u0217\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u021b\3\2\2\2\u021a\u0218\3\2"+
		"\2\2\u021b_\3\2\2\2\u021c\u021a\3\2\2\2\u021d\u0221\7&\2\2\u021e\u0220"+
		"\13\2\2\2\u021f\u021e\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u0222\3\2\2\2"+
		"\u0221\u021f\3\2\2\2\u0222a\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0228\7"+
		"\'\2\2\u0225\u0227\13\2\2\2\u0226\u0225\3\2\2\2\u0227\u022a\3\2\2\2\u0228"+
		"\u0229\3\2\2\2\u0228\u0226\3\2\2\2\u0229c\3\2\2\2\u022a\u0228\3\2\2\2"+
		"\u022b\u022f\7(\2\2\u022c\u022e\13\2\2\2\u022d\u022c\3\2\2\2\u022e\u0231"+
		"\3\2\2\2\u022f\u0230\3\2\2\2\u022f\u022d\3\2\2\2\u0230e\3\2\2\2\u0231"+
		"\u022f\3\2\2\2\u0232\u0233\7)\2\2\u0233\u0234\7*\2\2\u0234g\3\2\2\2\u0235"+
		"\u0236\7+\2\2\u0236i\3\2\2\2\u0237\u0238\7,\2\2\u0238\u0239\7B\2\2\u0239"+
		"k\3\2\2\2\u023a\u023b\7-\2\2\u023bm\3\2\2\2\u023c\u023e\5p9\2\u023d\u023f"+
		"\7\b\2\2\u023e\u023d\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0241\3\2\2\2\u0240"+
		"\u023c\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2"+
		"\2\2\u0243o\3\2\2\2\u0244\u0248\7B\2\2\u0245\u0248\7>\2\2\u0246\u0248"+
		"\5r:\2\u0247\u0244\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0246\3\2\2\2\u0248"+
		"q\3\2\2\2\u0249\u0250\7B\2\2\u024a\u024b\7.\2\2\u024b\u024c\7\4\2\2\u024c"+
		"\u024d\7B\2\2\u024d\u024e\7\b\2\2\u024e\u024f\7B\2\2\u024f\u0251\7\6\2"+
		"\2\u0250\u024a\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253"+
		"\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255\7.\2\2\u0255s\3\2\2\2\u0256\u0258"+
		"\13\2\2\2\u0257\u0256\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u025a\3\2\2\2"+
		"\u0259\u0257\3\2\2\2\u025au\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u025d\5"+
		"f\64\2\u025d\u025e\5h\65\2\u025e\u025f\5j\66\2\u025f\u0260\5t;\2\u0260"+
		"w\3\2\2\2\u0261\u0263\5v<\2\u0262\u0261\3\2\2\2\u0263\u0266\3\2\2\2\u0264"+
		"\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265y\3\2\2\2\u0266\u0264\3\2\2\2"+
		"\u0267\u0269\7=\2\2\u0268\u026a\7:\2\2\u0269\u0268\3\2\2\2\u0269\u026a"+
		"\3\2\2\2\u026a{\3\2\2\2\u026b\u026f\5~@\2\u026c\u026f\5\u0080A\2\u026d"+
		"\u026f\7D\2\2\u026e\u026b\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026d\3\2"+
		"\2\2\u026f}\3\2\2\2\u0270\u0272\t\2\2\2\u0271\u0270\3\2\2\2\u0272\u0275"+
		"\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0276\u0277\7B\2\2\u0277\177\3\2\2\2\u0278\u027a\t\2\2"+
		"\2\u0279\u0278\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2\2\2\u027b\u027c"+
		"\3\2\2\2\u027c\u027e\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u027f\7?\2\2\u027f"+
		"\u0081\3\2\2\2\u0280\u0281\7H\2\2\u0281\u0283\7H\2\2\u0282\u0284\7H\2"+
		"\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286"+
		"\7.\2\2\u0286\u0083\3\2\2\2J\u0089\u008b\u0092\u00a3\u00aa\u00ad\u00bb"+
		"\u00c5\u00cb\u00cf\u00d3\u00d6\u00de\u00e1\u00ec\u00f2\u00f4\u00f8\u00ff"+
		"\u0103\u0108\u0116\u011d\u0125\u012c\u0130\u0137\u0145\u014b\u0153\u0157"+
		"\u015b\u0162\u0169\u0170\u0175\u017a\u017e\u0186\u018f\u019a\u01a4\u01b5"+
		"\u01bd\u01c1\u01c5\u01ca\u01ce\u01d4\u01d7\u01da\u01dd\u01e0\u01e6\u0204"+
		"\u020a\u0210\u021a\u0221\u0228\u022f\u023e\u0242\u0247\u0252\u0259\u0264"+
		"\u0269\u026e\u0273\u027b\u0283";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}