// Generated from /Users/admin/IdeaProjects/Project1Group7/src/parser/GLangParser.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GLangParser}.
 */
public interface GLangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#defineStmt}.
	 * @param ctx the parse tree
	 */
	void enterDefineStmt(GLangParser.DefineStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#defineStmt}.
	 * @param ctx the parse tree
	 */
	void exitDefineStmt(GLangParser.DefineStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#chordDef}.
	 * @param ctx the parse tree
	 */
	void enterChordDef(GLangParser.ChordDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#chordDef}.
	 * @param ctx the parse tree
	 */
	void exitChordDef(GLangParser.ChordDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#fret}.
	 * @param ctx the parse tree
	 */
	void enterFret(GLangParser.FretContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#fret}.
	 * @param ctx the parse tree
	 */
	void exitFret(GLangParser.FretContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#barDef}.
	 * @param ctx the parse tree
	 */
	void enterBarDef(GLangParser.BarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#barDef}.
	 * @param ctx the parse tree
	 */
	void exitBarDef(GLangParser.BarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#barExpr}.
	 * @param ctx the parse tree
	 */
	void enterBarExpr(GLangParser.BarExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#barExpr}.
	 * @param ctx the parse tree
	 */
	void exitBarExpr(GLangParser.BarExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#barArgs}.
	 * @param ctx the parse tree
	 */
	void enterBarArgs(GLangParser.BarArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#barArgs}.
	 * @param ctx the parse tree
	 */
	void exitBarArgs(GLangParser.BarArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#barArg}.
	 * @param ctx the parse tree
	 */
	void enterBarArg(GLangParser.BarArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#barArg}.
	 * @param ctx the parse tree
	 */
	void exitBarArg(GLangParser.BarArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#barSequence}.
	 * @param ctx the parse tree
	 */
	void enterBarSequence(GLangParser.BarSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#barSequence}.
	 * @param ctx the parse tree
	 */
	void exitBarSequence(GLangParser.BarSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#barItem}.
	 * @param ctx the parse tree
	 */
	void enterBarItem(GLangParser.BarItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#barItem}.
	 * @param ctx the parse tree
	 */
	void exitBarItem(GLangParser.BarItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(GLangParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(GLangParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#patternItem}.
	 * @param ctx the parse tree
	 */
	void enterPatternItem(GLangParser.PatternItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#patternItem}.
	 * @param ctx the parse tree
	 */
	void exitPatternItem(GLangParser.PatternItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#segmentDef}.
	 * @param ctx the parse tree
	 */
	void enterSegmentDef(GLangParser.SegmentDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#segmentDef}.
	 * @param ctx the parse tree
	 */
	void exitSegmentDef(GLangParser.SegmentDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#loopSpec}.
	 * @param ctx the parse tree
	 */
	void enterLoopSpec(GLangParser.LoopSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#loopSpec}.
	 * @param ctx the parse tree
	 */
	void exitLoopSpec(GLangParser.LoopSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#segmentBody}.
	 * @param ctx the parse tree
	 */
	void enterSegmentBody(GLangParser.SegmentBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#segmentBody}.
	 * @param ctx the parse tree
	 */
	void exitSegmentBody(GLangParser.SegmentBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#segmentLine}.
	 * @param ctx the parse tree
	 */
	void enterSegmentLine(GLangParser.SegmentLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#segmentLine}.
	 * @param ctx the parse tree
	 */
	void exitSegmentLine(GLangParser.SegmentLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#composeStmt}.
	 * @param ctx the parse tree
	 */
	void enterComposeStmt(GLangParser.ComposeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#composeStmt}.
	 * @param ctx the parse tree
	 */
	void exitComposeStmt(GLangParser.ComposeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#composeBody}.
	 * @param ctx the parse tree
	 */
	void enterComposeBody(GLangParser.ComposeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#composeBody}.
	 * @param ctx the parse tree
	 */
	void exitComposeBody(GLangParser.ComposeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#composeLine}.
	 * @param ctx the parse tree
	 */
	void enterComposeLine(GLangParser.ComposeLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#composeLine}.
	 * @param ctx the parse tree
	 */
	void exitComposeLine(GLangParser.ComposeLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#mutationStmt}.
	 * @param ctx the parse tree
	 */
	void enterMutationStmt(GLangParser.MutationStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#mutationStmt}.
	 * @param ctx the parse tree
	 */
	void exitMutationStmt(GLangParser.MutationStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#valueAccess}.
	 * @param ctx the parse tree
	 */
	void enterValueAccess(GLangParser.ValueAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#valueAccess}.
	 * @param ctx the parse tree
	 */
	void exitValueAccess(GLangParser.ValueAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#access}.
	 * @param ctx the parse tree
	 */
	void enterAccess(GLangParser.AccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#access}.
	 * @param ctx the parse tree
	 */
	void exitAccess(GLangParser.AccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(GLangParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(GLangParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(GLangParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(GLangParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(GLangParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(GLangParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GLangParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GLangParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#functionCallStmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStmt(GLangParser.FunctionCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#functionCallStmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStmt(GLangParser.FunctionCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(GLangParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(GLangParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLangParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GLangParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLangParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GLangParser.ArgContext ctx);
}