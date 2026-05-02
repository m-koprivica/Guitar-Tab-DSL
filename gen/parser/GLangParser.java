// Generated from /Users/admin/IdeaProjects/Project1Group7/src/parser/GLangParser.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEFINE=1, COMPOSE=2, LOOP=3, END=4, TYPE_CHORD=5, TYPE_BAR=6, TYPE_SEGMENT=7, 
		TYPE_FUNCTION=8, TYPE_NUMBER=9, CHORDS=10, STRINGS=11, PATTERN=12, PLAYED=13, 
		BAR=14, LPAREN=15, RPAREN=16, LBRACK=17, RBRACK=18, COLON=19, COMMA=20, 
		DOT=21, DASH=22, PLUS=23, EQUALS=24, NUMBER=25, X=26, NAME=27, ID=28, 
		NEWLINE=29, WS=30, COMMENT=31;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_defineStmt = 2, RULE_chordDef = 3, 
		RULE_fret = 4, RULE_barDef = 5, RULE_barExpr = 6, RULE_barArgs = 7, RULE_barArg = 8, 
		RULE_barSequence = 9, RULE_barItem = 10, RULE_pattern = 11, RULE_patternItem = 12, 
		RULE_segmentDef = 13, RULE_loopSpec = 14, RULE_segmentBody = 15, RULE_segmentLine = 16, 
		RULE_composeStmt = 17, RULE_composeBody = 18, RULE_composeLine = 19, RULE_mutationStmt = 20, 
		RULE_valueAccess = 21, RULE_access = 22, RULE_functionDef = 23, RULE_functionBody = 24, 
		RULE_paramList = 25, RULE_param = 26, RULE_functionCallStmt = 27, RULE_argList = 28, 
		RULE_arg = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "defineStmt", "chordDef", "fret", "barDef", "barExpr", 
			"barArgs", "barArg", "barSequence", "barItem", "pattern", "patternItem", 
			"segmentDef", "loopSpec", "segmentBody", "segmentLine", "composeStmt", 
			"composeBody", "composeLine", "mutationStmt", "valueAccess", "access", 
			"functionDef", "functionBody", "paramList", "param", "functionCallStmt", 
			"argList", "arg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Define'", "'Compose'", null, null, "'CHORD'", "'BAR'", "'SEGMENT'", 
			"'FUNCTION'", "'NUMBER'", "'chords'", "'strings'", "'pattern'", "'played'", 
			"'bar'", "'('", "')'", "'['", "']'", "':'", "','", "'.'", "'-'", "'+'", 
			"'='", null, "'X'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DEFINE", "COMPOSE", "LOOP", "END", "TYPE_CHORD", "TYPE_BAR", "TYPE_SEGMENT", 
			"TYPE_FUNCTION", "TYPE_NUMBER", "CHORDS", "STRINGS", "PATTERN", "PLAYED", 
			"BAR", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COLON", "COMMA", "DOT", 
			"DASH", "PLUS", "EQUALS", "NUMBER", "X", "NAME", "ID", "NEWLINE", "WS", 
			"COMMENT"
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
	public String getGrammarFileName() { return "GLangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GLangParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(GLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GLangParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(60);
						match(NEWLINE);
						}
						}
						setState(65);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(66);
					statement();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(72);
				match(NEWLINE);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DefineStmtContext defineStmt() {
			return getRuleContext(DefineStmtContext.class,0);
		}
		public ComposeStmtContext composeStmt() {
			return getRuleContext(ComposeStmtContext.class,0);
		}
		public MutationStmtContext mutationStmt() {
			return getRuleContext(MutationStmtContext.class,0);
		}
		public FunctionCallStmtContext functionCallStmt() {
			return getRuleContext(FunctionCallStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				defineStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				composeStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				mutationStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				functionCallStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefineStmtContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(GLangParser.DEFINE, 0); }
		public ChordDefContext chordDef() {
			return getRuleContext(ChordDefContext.class,0);
		}
		public BarDefContext barDef() {
			return getRuleContext(BarDefContext.class,0);
		}
		public SegmentDefContext segmentDef() {
			return getRuleContext(SegmentDefContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public DefineStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterDefineStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitDefineStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitDefineStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineStmtContext defineStmt() throws RecognitionException {
		DefineStmtContext _localctx = new DefineStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defineStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(DEFINE);
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_CHORD:
				{
				setState(87);
				chordDef();
				}
				break;
			case TYPE_BAR:
				{
				setState(88);
				barDef();
				}
				break;
			case TYPE_SEGMENT:
				{
				setState(89);
				segmentDef();
				}
				break;
			case TYPE_FUNCTION:
				{
				setState(90);
				functionDef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ChordDefContext extends ParserRuleContext {
		public TerminalNode TYPE_CHORD() { return getToken(GLangParser.TYPE_CHORD, 0); }
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public List<FretContext> fret() {
			return getRuleContexts(FretContext.class);
		}
		public FretContext fret(int i) {
			return getRuleContext(FretContext.class,i);
		}
		public ChordDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chordDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterChordDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitChordDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitChordDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordDefContext chordDef() throws RecognitionException {
		ChordDefContext _localctx = new ChordDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_chordDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(TYPE_CHORD);
			setState(94);
			match(NAME);
			setState(95);
			fret();
			setState(96);
			fret();
			setState(97);
			fret();
			setState(98);
			fret();
			setState(99);
			fret();
			setState(100);
			fret();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FretContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GLangParser.NUMBER, 0); }
		public TerminalNode X() { return getToken(GLangParser.X, 0); }
		public TerminalNode DASH() { return getToken(GLangParser.DASH, 0); }
		public FretContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterFret(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitFret(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitFret(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FretContext fret() throws RecognitionException {
		FretContext _localctx = new FretContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fret);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 104857600L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class BarDefContext extends ParserRuleContext {
		public TerminalNode TYPE_BAR() { return getToken(GLangParser.TYPE_BAR, 0); }
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public BarExprContext barExpr() {
			return getRuleContext(BarExprContext.class,0);
		}
		public BarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterBarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitBarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitBarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarDefContext barDef() throws RecognitionException {
		BarDefContext _localctx = new BarDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_barDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(TYPE_BAR);
			setState(105);
			match(NAME);
			setState(106);
			barExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BarExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(GLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLangParser.RPAREN, 0); }
		public BarArgsContext barArgs() {
			return getRuleContext(BarArgsContext.class,0);
		}
		public BarSequenceContext barSequence() {
			return getRuleContext(BarSequenceContext.class,0);
		}
		public BarExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterBarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitBarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitBarExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarExprContext barExpr() throws RecognitionException {
		BarExprContext _localctx = new BarExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_barExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(LPAREN);
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHORDS:
			case PATTERN:
			case PLAYED:
				{
				setState(109);
				barArgs();
				}
				break;
			case LPAREN:
			case NAME:
				{
				setState(110);
				barSequence();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(113);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BarArgsContext extends ParserRuleContext {
		public List<BarArgContext> barArg() {
			return getRuleContexts(BarArgContext.class);
		}
		public BarArgContext barArg(int i) {
			return getRuleContext(BarArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLangParser.COMMA, i);
		}
		public BarArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterBarArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitBarArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitBarArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarArgsContext barArgs() throws RecognitionException {
		BarArgsContext _localctx = new BarArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_barArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			barArg();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				barArg();
				}
				}
				setState(122);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BarArgContext extends ParserRuleContext {
		public TerminalNode CHORDS() { return getToken(GLangParser.CHORDS, 0); }
		public TerminalNode EQUALS() { return getToken(GLangParser.EQUALS, 0); }
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode PATTERN() { return getToken(GLangParser.PATTERN, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode PLAYED() { return getToken(GLangParser.PLAYED, 0); }
		public TerminalNode NUMBER() { return getToken(GLangParser.NUMBER, 0); }
		public BarArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterBarArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitBarArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitBarArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarArgContext barArg() throws RecognitionException {
		BarArgContext _localctx = new BarArgContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_barArg);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHORDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(CHORDS);
				setState(124);
				match(EQUALS);
				setState(125);
				match(NAME);
				}
				break;
			case PATTERN:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(PATTERN);
				setState(127);
				match(EQUALS);
				setState(128);
				pattern();
				}
				break;
			case PLAYED:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(PLAYED);
				setState(130);
				match(EQUALS);
				setState(131);
				match(NUMBER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BarSequenceContext extends ParserRuleContext {
		public List<BarItemContext> barItem() {
			return getRuleContexts(BarItemContext.class);
		}
		public BarItemContext barItem(int i) {
			return getRuleContext(BarItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLangParser.COMMA, i);
		}
		public BarSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterBarSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitBarSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitBarSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarSequenceContext barSequence() throws RecognitionException {
		BarSequenceContext _localctx = new BarSequenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_barSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			barItem();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(135);
				match(COMMA);
				setState(136);
				barItem();
				}
				}
				setState(141);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BarItemContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode LPAREN() { return getToken(GLangParser.LPAREN, 0); }
		public BarArgsContext barArgs() {
			return getRuleContext(BarArgsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GLangParser.RPAREN, 0); }
		public BarItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterBarItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitBarItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitBarItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarItemContext barItem() throws RecognitionException {
		BarItemContext _localctx = new BarItemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_barItem);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(NAME);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(LPAREN);
				setState(144);
				barArgs();
				setState(145);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(GLangParser.LPAREN, 0); }
		public List<PatternItemContext> patternItem() {
			return getRuleContexts(PatternItemContext.class);
		}
		public PatternItemContext patternItem(int i) {
			return getRuleContext(PatternItemContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(GLangParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLangParser.COMMA, i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(LPAREN);
			setState(150);
			patternItem();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(151);
				match(COMMA);
				setState(152);
				patternItem();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PatternItemContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GLangParser.NUMBER, i);
		}
		public TerminalNode LBRACK() { return getToken(GLangParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(GLangParser.RBRACK, 0); }
		public List<TerminalNode> PLUS() { return getTokens(GLangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(GLangParser.PLUS, i);
		}
		public PatternItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterPatternItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitPatternItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitPatternItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternItemContext patternItem() throws RecognitionException {
		PatternItemContext _localctx = new PatternItemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_patternItem);
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(NUMBER);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(LBRACK);
				setState(162);
				match(NUMBER);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS) {
					{
					{
					setState(163);
					match(PLUS);
					setState(164);
					match(NUMBER);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
				match(RBRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SegmentDefContext extends ParserRuleContext {
		public TerminalNode TYPE_SEGMENT() { return getToken(GLangParser.TYPE_SEGMENT, 0); }
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode COLON() { return getToken(GLangParser.COLON, 0); }
		public SegmentBodyContext segmentBody() {
			return getRuleContext(SegmentBodyContext.class,0);
		}
		public LoopSpecContext loopSpec() {
			return getRuleContext(LoopSpecContext.class,0);
		}
		public SegmentDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segmentDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterSegmentDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitSegmentDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitSegmentDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentDefContext segmentDef() throws RecognitionException {
		SegmentDefContext _localctx = new SegmentDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_segmentDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(TYPE_SEGMENT);
			setState(174);
			match(NAME);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOOP) {
				{
				setState(175);
				loopSpec();
				}
			}

			setState(178);
			match(COLON);
			setState(179);
			segmentBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoopSpecContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(GLangParser.LOOP, 0); }
		public TerminalNode NUMBER() { return getToken(GLangParser.NUMBER, 0); }
		public LoopSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterLoopSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitLoopSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitLoopSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopSpecContext loopSpec() throws RecognitionException {
		LoopSpecContext _localctx = new LoopSpecContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_loopSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(LOOP);
			setState(182);
			match(NUMBER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SegmentBodyContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(GLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GLangParser.NEWLINE, i);
		}
		public List<SegmentLineContext> segmentLine() {
			return getRuleContexts(SegmentLineContext.class);
		}
		public SegmentLineContext segmentLine(int i) {
			return getRuleContext(SegmentLineContext.class,i);
		}
		public SegmentBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segmentBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterSegmentBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitSegmentBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitSegmentBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentBodyContext segmentBody() throws RecognitionException {
		SegmentBodyContext _localctx = new SegmentBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_segmentBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(184);
					match(NEWLINE);
					setState(185);
					segmentLine();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(188); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class SegmentLineContext extends ParserRuleContext {
		public TerminalNode BAR() { return getToken(GLangParser.BAR, 0); }
		public TerminalNode EQUALS() { return getToken(GLangParser.EQUALS, 0); }
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public SegmentLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segmentLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterSegmentLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitSegmentLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitSegmentLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentLineContext segmentLine() throws RecognitionException {
		SegmentLineContext _localctx = new SegmentLineContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_segmentLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(BAR);
			setState(191);
			match(EQUALS);
			setState(192);
			match(NAME);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComposeStmtContext extends ParserRuleContext {
		public TerminalNode COMPOSE() { return getToken(GLangParser.COMPOSE, 0); }
		public TerminalNode COLON() { return getToken(GLangParser.COLON, 0); }
		public ComposeBodyContext composeBody() {
			return getRuleContext(ComposeBodyContext.class,0);
		}
		public ComposeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterComposeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitComposeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitComposeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComposeStmtContext composeStmt() throws RecognitionException {
		ComposeStmtContext _localctx = new ComposeStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_composeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(COMPOSE);
			setState(195);
			match(COLON);
			setState(196);
			composeBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComposeBodyContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(GLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GLangParser.NEWLINE, i);
		}
		public List<ComposeLineContext> composeLine() {
			return getRuleContexts(ComposeLineContext.class);
		}
		public ComposeLineContext composeLine(int i) {
			return getRuleContext(ComposeLineContext.class,i);
		}
		public ComposeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterComposeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitComposeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitComposeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComposeBodyContext composeBody() throws RecognitionException {
		ComposeBodyContext _localctx = new ComposeBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_composeBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(198);
					match(NEWLINE);
					setState(199);
					composeLine();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(202); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComposeLineContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode LOOP() { return getToken(GLangParser.LOOP, 0); }
		public TerminalNode NUMBER() { return getToken(GLangParser.NUMBER, 0); }
		public TerminalNode COLON() { return getToken(GLangParser.COLON, 0); }
		public ComposeBodyContext composeBody() {
			return getRuleContext(ComposeBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(GLangParser.END, 0); }
		public TerminalNode NEWLINE() { return getToken(GLangParser.NEWLINE, 0); }
		public MutationStmtContext mutationStmt() {
			return getRuleContext(MutationStmtContext.class,0);
		}
		public FunctionCallStmtContext functionCallStmt() {
			return getRuleContext(FunctionCallStmtContext.class,0);
		}
		public ComposeLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composeLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterComposeLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitComposeLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitComposeLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComposeLineContext composeLine() throws RecognitionException {
		ComposeLineContext _localctx = new ComposeLineContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_composeLine);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(LOOP);
				setState(206);
				match(NUMBER);
				setState(207);
				match(COLON);
				setState(208);
				composeBody();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(209);
					match(NEWLINE);
					}
				}

				setState(212);
				match(END);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				mutationStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				functionCallStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MutationStmtContext extends ParserRuleContext {
		public ValueAccessContext valueAccess() {
			return getRuleContext(ValueAccessContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(GLangParser.EQUALS, 0); }
		public TerminalNode PLUS() { return getToken(GLangParser.PLUS, 0); }
		public TerminalNode DASH() { return getToken(GLangParser.DASH, 0); }
		public FretContext fret() {
			return getRuleContext(FretContext.class,0);
		}
		public TerminalNode ID() { return getToken(GLangParser.ID, 0); }
		public MutationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutationStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterMutationStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitMutationStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitMutationStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MutationStmtContext mutationStmt() throws RecognitionException {
		MutationStmtContext _localctx = new MutationStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_mutationStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			valueAccess();
			setState(219);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DASH:
			case NUMBER:
			case X:
				{
				setState(220);
				fret();
				}
				break;
			case ID:
				{
				setState(221);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueAccessContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode ID() { return getToken(GLangParser.ID, 0); }
		public List<TerminalNode> DOT() { return getTokens(GLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GLangParser.DOT, i);
		}
		public List<AccessContext> access() {
			return getRuleContexts(AccessContext.class);
		}
		public AccessContext access(int i) {
			return getRuleContext(AccessContext.class,i);
		}
		public ValueAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterValueAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitValueAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitValueAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueAccessContext valueAccess() throws RecognitionException {
		ValueAccessContext _localctx = new ValueAccessContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_valueAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(227); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(225);
				match(DOT);
				setState(226);
				access();
				}
				}
				setState(229); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class AccessContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(GLangParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(GLangParser.RBRACK, 0); }
		public TerminalNode CHORDS() { return getToken(GLangParser.CHORDS, 0); }
		public TerminalNode STRINGS() { return getToken(GLangParser.STRINGS, 0); }
		public TerminalNode NUMBER() { return getToken(GLangParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(GLangParser.ID, 0); }
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !(_la==CHORDS || _la==STRINGS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(232);
			match(LBRACK);
			setState(233);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(234);
			match(RBRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefContext extends ParserRuleContext {
		public TerminalNode TYPE_FUNCTION() { return getToken(GLangParser.TYPE_FUNCTION, 0); }
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode LPAREN() { return getToken(GLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLangParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(GLangParser.COLON, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(TYPE_FUNCTION);
			setState(237);
			match(NAME);
			setState(238);
			match(LPAREN);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 736L) != 0)) {
				{
				setState(239);
				paramList();
				}
			}

			setState(242);
			match(RPAREN);
			setState(243);
			match(COLON);
			setState(244);
			functionBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(GLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GLangParser.NEWLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(246);
					match(NEWLINE);
					setState(247);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(250); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLangParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			param();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(253);
				match(COMMA);
				setState(254);
				param();
				}
				}
				setState(259);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GLangParser.ID, 0); }
		public TerminalNode TYPE_CHORD() { return getToken(GLangParser.TYPE_CHORD, 0); }
		public TerminalNode TYPE_BAR() { return getToken(GLangParser.TYPE_BAR, 0); }
		public TerminalNode TYPE_SEGMENT() { return getToken(GLangParser.TYPE_SEGMENT, 0); }
		public TerminalNode TYPE_NUMBER() { return getToken(GLangParser.TYPE_NUMBER, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 736L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(261);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallStmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode LPAREN() { return getToken(GLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLangParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterFunctionCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitFunctionCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitFunctionCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStmtContext functionCallStmt() throws RecognitionException {
		FunctionCallStmtContext _localctx = new FunctionCallStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_functionCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(NAME);
			setState(264);
			match(LPAREN);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER || _la==NAME) {
				{
				setState(265);
				argList();
				}
			}

			setState(268);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLangParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			arg();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(271);
				match(COMMA);
				setState(272);
				arg();
				}
				}
				setState(277);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GLangParser.NAME, 0); }
		public TerminalNode NUMBER() { return getToken(GLangParser.NUMBER, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLangParserListener ) ((GLangParserListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLangParserVisitor ) return ((GLangParserVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==NAME) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0119\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0005"+
		"\u0000>\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0000\u0005\u0000D\b\u0000"+
		"\n\u0000\f\u0000G\t\u0000\u0001\u0000\u0005\u0000J\b\u0000\n\u0000\f\u0000"+
		"M\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001U\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\\\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"w\b\u0007\n\u0007\f\u0007z\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0085\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u008a\b\t\n\t\f\t\u008d\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u0094\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u009a\b\u000b\n\u000b\f\u000b\u009d\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00a6\b\f\n\f\f"+
		"\f\u00a9\t\f\u0001\f\u0003\f\u00ac\b\f\u0001\r\u0001\r\u0001\r\u0003\r"+
		"\u00b1\b\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0004\u000f\u00bb\b\u000f\u000b\u000f\f\u000f"+
		"\u00bc\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0004\u0012\u00c9"+
		"\b\u0012\u000b\u0012\f\u0012\u00ca\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00d3\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00d9\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00df\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0004\u0015\u00e4\b\u0015\u000b\u0015\f\u0015"+
		"\u00e5\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00f1\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0004"+
		"\u0018\u00f9\b\u0018\u000b\u0018\f\u0018\u00fa\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0100\b\u0019\n\u0019\f\u0019\u0103\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u010b\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u0112\b\u001c\n\u001c\f\u001c\u0115\t\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:\u0000\u0007\u0002\u0000\u0016\u0016\u0019\u001a\u0001\u0000\u0016\u0018"+
		"\u0001\u0000\u001b\u001c\u0001\u0000\n\u000b\u0002\u0000\u0019\u0019\u001c"+
		"\u001c\u0002\u0000\u0005\u0007\t\t\u0002\u0000\u0019\u0019\u001b\u001b"+
		"\u011a\u0000E\u0001\u0000\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004"+
		"V\u0001\u0000\u0000\u0000\u0006]\u0001\u0000\u0000\u0000\bf\u0001\u0000"+
		"\u0000\u0000\nh\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000e"+
		"s\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012\u0086"+
		"\u0001\u0000\u0000\u0000\u0014\u0093\u0001\u0000\u0000\u0000\u0016\u0095"+
		"\u0001\u0000\u0000\u0000\u0018\u00ab\u0001\u0000\u0000\u0000\u001a\u00ad"+
		"\u0001\u0000\u0000\u0000\u001c\u00b5\u0001\u0000\u0000\u0000\u001e\u00ba"+
		"\u0001\u0000\u0000\u0000 \u00be\u0001\u0000\u0000\u0000\"\u00c2\u0001"+
		"\u0000\u0000\u0000$\u00c8\u0001\u0000\u0000\u0000&\u00d8\u0001\u0000\u0000"+
		"\u0000(\u00da\u0001\u0000\u0000\u0000*\u00e0\u0001\u0000\u0000\u0000,"+
		"\u00e7\u0001\u0000\u0000\u0000.\u00ec\u0001\u0000\u0000\u00000\u00f8\u0001"+
		"\u0000\u0000\u00002\u00fc\u0001\u0000\u0000\u00004\u0104\u0001\u0000\u0000"+
		"\u00006\u0107\u0001\u0000\u0000\u00008\u010e\u0001\u0000\u0000\u0000:"+
		"\u0116\u0001\u0000\u0000\u0000<>\u0005\u001d\u0000\u0000=<\u0001\u0000"+
		"\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"BD\u0003\u0002\u0001\u0000C?\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000"+
		"\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FK\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000HJ\u0005\u001d\u0000\u0000IH\u0001"+
		"\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000NO\u0005\u0000\u0000\u0001O\u0001\u0001\u0000\u0000\u0000PU\u0003"+
		"\u0004\u0002\u0000QU\u0003\"\u0011\u0000RU\u0003(\u0014\u0000SU\u0003"+
		"6\u001b\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000U\u0003\u0001\u0000\u0000"+
		"\u0000V[\u0005\u0001\u0000\u0000W\\\u0003\u0006\u0003\u0000X\\\u0003\n"+
		"\u0005\u0000Y\\\u0003\u001a\r\u0000Z\\\u0003.\u0017\u0000[W\u0001\u0000"+
		"\u0000\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[Z\u0001"+
		"\u0000\u0000\u0000\\\u0005\u0001\u0000\u0000\u0000]^\u0005\u0005\u0000"+
		"\u0000^_\u0005\u001b\u0000\u0000_`\u0003\b\u0004\u0000`a\u0003\b\u0004"+
		"\u0000ab\u0003\b\u0004\u0000bc\u0003\b\u0004\u0000cd\u0003\b\u0004\u0000"+
		"de\u0003\b\u0004\u0000e\u0007\u0001\u0000\u0000\u0000fg\u0007\u0000\u0000"+
		"\u0000g\t\u0001\u0000\u0000\u0000hi\u0005\u0006\u0000\u0000ij\u0005\u001b"+
		"\u0000\u0000jk\u0003\f\u0006\u0000k\u000b\u0001\u0000\u0000\u0000lo\u0005"+
		"\u000f\u0000\u0000mp\u0003\u000e\u0007\u0000np\u0003\u0012\t\u0000om\u0001"+
		"\u0000\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qr\u0005\u0010\u0000\u0000r\r\u0001\u0000\u0000\u0000sx\u0003\u0010\b"+
		"\u0000tu\u0005\u0014\u0000\u0000uw\u0003\u0010\b\u0000vt\u0001\u0000\u0000"+
		"\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000y\u000f\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000"+
		"{|\u0005\n\u0000\u0000|}\u0005\u0018\u0000\u0000}\u0085\u0005\u001b\u0000"+
		"\u0000~\u007f\u0005\f\u0000\u0000\u007f\u0080\u0005\u0018\u0000\u0000"+
		"\u0080\u0085\u0003\u0016\u000b\u0000\u0081\u0082\u0005\r\u0000\u0000\u0082"+
		"\u0083\u0005\u0018\u0000\u0000\u0083\u0085\u0005\u0019\u0000\u0000\u0084"+
		"{\u0001\u0000\u0000\u0000\u0084~\u0001\u0000\u0000\u0000\u0084\u0081\u0001"+
		"\u0000\u0000\u0000\u0085\u0011\u0001\u0000\u0000\u0000\u0086\u008b\u0003"+
		"\u0014\n\u0000\u0087\u0088\u0005\u0014\u0000\u0000\u0088\u008a\u0003\u0014"+
		"\n\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u0013\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008e\u0094\u0005\u001b\u0000\u0000\u008f\u0090\u0005\u000f\u0000"+
		"\u0000\u0090\u0091\u0003\u000e\u0007\u0000\u0091\u0092\u0005\u0010\u0000"+
		"\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u008e\u0001\u0000\u0000"+
		"\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0094\u0015\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005\u000f\u0000\u0000\u0096\u009b\u0003\u0018\f\u0000"+
		"\u0097\u0098\u0005\u0014\u0000\u0000\u0098\u009a\u0003\u0018\f\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009e\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0005\u0010\u0000\u0000\u009f\u0017\u0001\u0000\u0000\u0000\u00a0"+
		"\u00ac\u0005\u0019\u0000\u0000\u00a1\u00a2\u0005\u0011\u0000\u0000\u00a2"+
		"\u00a7\u0005\u0019\u0000\u0000\u00a3\u00a4\u0005\u0017\u0000\u0000\u00a4"+
		"\u00a6\u0005\u0019\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9"+
		"\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005\u0012\u0000\u0000\u00ab"+
		"\u00a0\u0001\u0000\u0000\u0000\u00ab\u00a1\u0001\u0000\u0000\u0000\u00ac"+
		"\u0019\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0007\u0000\u0000\u00ae"+
		"\u00b0\u0005\u001b\u0000\u0000\u00af\u00b1\u0003\u001c\u000e\u0000\u00b0"+
		"\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0013\u0000\u0000\u00b3"+
		"\u00b4\u0003\u001e\u000f\u0000\u00b4\u001b\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0005\u0003\u0000\u0000\u00b6\u00b7\u0005\u0019\u0000\u0000\u00b7"+
		"\u001d\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u001d\u0000\u0000\u00b9"+
		"\u00bb\u0003 \u0010\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bd\u001f\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0005\u000e\u0000\u0000\u00bf\u00c0\u0005\u0018\u0000\u0000\u00c0\u00c1"+
		"\u0005\u001b\u0000\u0000\u00c1!\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"\u0002\u0000\u0000\u00c3\u00c4\u0005\u0013\u0000\u0000\u00c4\u00c5\u0003"+
		"$\u0012\u0000\u00c5#\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u001d\u0000"+
		"\u0000\u00c7\u00c9\u0003&\u0013\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb%\u0001\u0000\u0000\u0000\u00cc"+
		"\u00d9\u0005\u001b\u0000\u0000\u00cd\u00ce\u0005\u0003\u0000\u0000\u00ce"+
		"\u00cf\u0005\u0019\u0000\u0000\u00cf\u00d0\u0005\u0013\u0000\u0000\u00d0"+
		"\u00d2\u0003$\u0012\u0000\u00d1\u00d3\u0005\u001d\u0000\u0000\u00d2\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0004\u0000\u0000\u00d5\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d9\u0003(\u0014\u0000\u00d7\u00d9\u0003"+
		"6\u001b\u0000\u00d8\u00cc\u0001\u0000\u0000\u0000\u00d8\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\'\u0001\u0000\u0000\u0000\u00da\u00db\u0003*\u0015"+
		"\u0000\u00db\u00de\u0007\u0001\u0000\u0000\u00dc\u00df\u0003\b\u0004\u0000"+
		"\u00dd\u00df\u0005\u001c\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de\u00dd\u0001\u0000\u0000\u0000\u00df)\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e3\u0007\u0002\u0000\u0000\u00e1\u00e2\u0005\u0015\u0000\u0000\u00e2"+
		"\u00e4\u0003,\u0016\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e6+\u0001\u0000\u0000\u0000\u00e7\u00e8\u0007"+
		"\u0003\u0000\u0000\u00e8\u00e9\u0005\u0011\u0000\u0000\u00e9\u00ea\u0007"+
		"\u0004\u0000\u0000\u00ea\u00eb\u0005\u0012\u0000\u0000\u00eb-\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0005\b\u0000\u0000\u00ed\u00ee\u0005\u001b\u0000"+
		"\u0000\u00ee\u00f0\u0005\u000f\u0000\u0000\u00ef\u00f1\u00032\u0019\u0000"+
		"\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0010\u0000\u0000"+
		"\u00f3\u00f4\u0005\u0013\u0000\u0000\u00f4\u00f5\u00030\u0018\u0000\u00f5"+
		"/\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u001d\u0000\u0000\u00f7\u00f9"+
		"\u0003\u0002\u0001\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fb1\u0001\u0000\u0000\u0000\u00fc\u0101\u0003"+
		"4\u001a\u0000\u00fd\u00fe\u0005\u0014\u0000\u0000\u00fe\u0100\u00034\u001a"+
		"\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u01023\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0007\u0005\u0000\u0000\u0105\u0106\u0005\u001c\u0000\u0000"+
		"\u01065\u0001\u0000\u0000\u0000\u0107\u0108\u0005\u001b\u0000\u0000\u0108"+
		"\u010a\u0005\u000f\u0000\u0000\u0109\u010b\u00038\u001c\u0000\u010a\u0109"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u0010\u0000\u0000\u010d7\u0001"+
		"\u0000\u0000\u0000\u010e\u0113\u0003:\u001d\u0000\u010f\u0110\u0005\u0014"+
		"\u0000\u0000\u0110\u0112\u0003:\u001d\u0000\u0111\u010f\u0001\u0000\u0000"+
		"\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000"+
		"\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u01149\u0001\u0000\u0000\u0000"+
		"\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0117\u0007\u0006\u0000\u0000"+
		"\u0117;\u0001\u0000\u0000\u0000\u0019?EKT[ox\u0084\u008b\u0093\u009b\u00a7"+
		"\u00ab\u00b0\u00bc\u00ca\u00d2\u00d8\u00de\u00e5\u00f0\u00fa\u0101\u010a"+
		"\u0113";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}