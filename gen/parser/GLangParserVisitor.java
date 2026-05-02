// Generated from /Users/admin/IdeaProjects/Project1Group7/src/parser/GLangParser.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GLangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#defineStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineStmt(GLangParser.DefineStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#chordDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChordDef(GLangParser.ChordDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#fret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFret(GLangParser.FretContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#barDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarDef(GLangParser.BarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#barExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarExpr(GLangParser.BarExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#barArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarArgs(GLangParser.BarArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#barArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarArg(GLangParser.BarArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#barSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarSequence(GLangParser.BarSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#barItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarItem(GLangParser.BarItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(GLangParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#patternItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternItem(GLangParser.PatternItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#segmentDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegmentDef(GLangParser.SegmentDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#loopSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopSpec(GLangParser.LoopSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#segmentBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegmentBody(GLangParser.SegmentBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#segmentLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegmentLine(GLangParser.SegmentLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#composeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposeStmt(GLangParser.ComposeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#composeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposeBody(GLangParser.ComposeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#composeLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposeLine(GLangParser.ComposeLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#mutationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutationStmt(GLangParser.MutationStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#valueAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueAccess(GLangParser.ValueAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(GLangParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(GLangParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(GLangParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(GLangParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(GLangParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#functionCallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStmt(GLangParser.FunctionCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(GLangParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLangParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(GLangParser.ArgContext ctx);
}