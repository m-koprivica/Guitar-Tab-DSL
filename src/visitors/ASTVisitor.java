package visitors;
import ast.*;

public interface ASTVisitor<T, U> {
    public U visit(Program prog, T param);
    public U visit(Access access, T param);
    public U visit(ArgList argList, T param);
    public U visit(Arg arg, T param);
    public U visit(BarArg barArg, T param);
    public U visit(BarArgs barArgs, T param);
    public U visit(BarDef barDef, T param);
    public U visit(BarExpr barExpr, T param);
    public U visit(BarItem barItem, T param);
    public U visit(BarSequence barSequence, T param);
    public U visit(ChordDef chordDef, T param);
    public U visit(ComposeBody composeBody, T param);
    public U visit(ComposeLine composeLine, T param);
    public U visit(ComposeStmt composeStmt, T param);
    public U visit(DefineStmt defineStmt, T param);
    public U visit(Fret fret, T param);
    public U visit(FunctionCallStmt functionBody, T param);
    public U visit(FunctionDef functionBody, T param);
    public U visit(FunctionBody functionBody, T param);
    public U visit(MutationStmt mutationStmt, T param);
    public U visit(Param p, T param);
    public U visit(ParamList pList, T param);
    public U visit(Pattern pattern, T param);
    public U visit(PatternItem patternItem, T param);
    public U visit(SegmentBody segmentBody, T param);
    public U visit(SegmentDef segmentDef, T param);
    public U visit(SegmentLine segmentLine, T param);
    public U visit(Statement statement, T param);
    public U visit(ValueAccess valueAccess, T param);
}
