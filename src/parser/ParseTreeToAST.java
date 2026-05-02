package parser;

import ast.*;
import libs.Node;
import libs.enums.*;
import libs.exceptions.*;
import libs.interfaces.DefinitionVariant;
import libs.interfaces.StatementVariant;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ParseTreeToAST extends GLangParserBaseVisitor<Node> {

    @Override
    public Program visitProgram(GLangParser.ProgramContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (GLangParser.StatementContext statement : ctx.statement()) {
            statements.add(visitStatement(statement));
        }
        return new Program(statements);
    }

    @Override
    public Statement visitStatement(GLangParser.StatementContext ctx) throws InvalidStatementException {
        StatementVariant statementBody;
        if (ctx.defineStmt() != null) {
            statementBody = visitDefineStmt(ctx.defineStmt());
            return new Statement(StatementType.DEFINE, statementBody);
        } else if (ctx.composeStmt() != null) {
            statementBody = visitComposeStmt(ctx.composeStmt());
            return new Statement(StatementType.COMPOSE, statementBody);
        } else if (ctx.mutationStmt() != null) {
            statementBody = visitMutationStmt(ctx.mutationStmt());
            return new Statement(StatementType.MUTATE, statementBody);
        } else if (ctx.functionCallStmt() != null) {
            statementBody = visitFunctionCallStmt(ctx.functionCallStmt());
            return new Statement(StatementType.FUNCTION, statementBody);
        } else {
            throw new InvalidStatementException("Statement must either be a " +
                    "DEFINE, a COMPOSE, a Function Call, or a Mutation");
        }
    }

    @Override
    public DefineStmt visitDefineStmt(GLangParser.DefineStmtContext ctx) throws InvalidDefinitionException {
        DefinitionVariant definitionBody;
        if (ctx.barDef() != null) {
            definitionBody = visitBarDef(ctx.barDef());
            return new DefineStmt(DefinitionType.BAR, definitionBody);
        } else if (ctx.functionDef() != null) {
            definitionBody = visitFunctionDef(ctx.functionDef());
            return new DefineStmt(DefinitionType.FUNCTION, definitionBody);
        } else if (ctx.chordDef() != null) {
            definitionBody = visitChordDef(ctx.chordDef());
            return new DefineStmt(DefinitionType.CHORD, definitionBody);
        } else if (ctx.segmentDef() != null) {
            definitionBody = visitSegmentDef(ctx.segmentDef());
            return new DefineStmt(DefinitionType.SEGMENT, definitionBody);
        } else {
            throw new InvalidDefinitionException("Definition must be for one of " +
                    "CHORD, BAR, SEGMENT, or FUNCTION");
        }
    }

    @Override
    public ChordDef visitChordDef(GLangParser.ChordDefContext ctx) {
        String chordName = ctx.NAME().getText();
        List<Fret> frets = new ArrayList<>();
        for (GLangParser.FretContext fretContext : ctx.fret()) {
            frets.add(visitFret(fretContext));
        }
        return new ChordDef(chordName, frets);
    }

    @Override
    public Fret visitFret(GLangParser.FretContext ctx) {
        if (ctx.NUMBER() != null) {
            return new Fret(Integer.parseInt(ctx.NUMBER().getText()));
        }
        if (ctx.X() != null) {
            return new Fret(ctx.X().getText());
        }
        if (ctx.DASH() != null) {
            return new Fret(ctx.DASH().getText());
        }
        throw new InvalidFretException("A Fret must contain either a number, an X, or a -");
    }

    @Override
    public BarDef visitBarDef(GLangParser.BarDefContext ctx) {
        BarExpr barExpr = visitBarExpr(ctx.barExpr());
        String barName = ctx.NAME().getText();
        return new BarDef(barExpr, barName);
    }

    @Override
    public BarExpr visitBarExpr(GLangParser.BarExprContext ctx) {
        BarArgs barArgs = null;
        BarSequence barSequence = null;
        if (ctx.barArgs() != null) {
            barArgs = visitBarArgs(ctx.barArgs());
        }
        if (ctx.barSequence() != null) {
            barSequence = visitBarSequence(ctx.barSequence());
        }
        return new BarExpr(barArgs, barSequence);
    }

    @Override
    public BarArgs visitBarArgs(GLangParser.BarArgsContext ctx) {
        List<BarArg> args = new ArrayList<>();
        for (GLangParser.BarArgContext argContext : ctx.barArg()) {
            args.add(visitBarArg(argContext));
        }
        return new BarArgs(args);
    }

    @Override
    public BarArg visitBarArg(GLangParser.BarArgContext ctx) {
        if (ctx.CHORDS() != null) {
            return new BarChordArg(ctx.NAME());
        } else if (ctx.PATTERN() != null) {
            Pattern pattern = visitPattern(ctx.pattern());
            return new BarPatternArg(pattern);
        } else if (ctx.PLAYED() != null) {
            return new BarPlayedArg(ctx.NUMBER());
        } else {
            throw new InvalidBarArgException("Bar Arg must be one of CHORDS, PATTERN, or PLAYED");
        }
    }

    @Override
    public BarSequence visitBarSequence(GLangParser.BarSequenceContext ctx) {
        List<BarItem> barItems = new ArrayList<>();
        for (GLangParser.BarItemContext item : ctx.barItem()) {
            BarItem barItem = visitBarItem(item);
            barItems.add(barItem);
        }
        return new BarSequence(barItems);
    }

    @Override
    public BarItem visitBarItem(GLangParser.BarItemContext ctx) throws InvalidBarItemException {
        if (ctx.barArgs() != null) {
            BarArgs barArgs = visitBarArgs(ctx.barArgs());
            return new BarItem(barArgs);
        } else if (ctx.NAME() != null) {
            return new BarItem(ctx.NAME().getText());
        } else {
            throw new InvalidBarItemException("Bar Item must be either a list of BarArgs or a NAME");
        }
    }

    // this one as well might be a candidate for falling back to default
    @Override
    public Pattern visitPattern(GLangParser.PatternContext ctx) {
        List<PatternItem> patternItems = new ArrayList<>();
        for (GLangParser.PatternItemContext patternItemContext : ctx.patternItem()) {
            PatternItem patternItem = visitPatternItem(patternItemContext);
            patternItems.add(patternItem);
        }
        return new Pattern(patternItems);
    }

    @Override
    public PatternItem visitPatternItem(GLangParser.PatternItemContext ctx) {
        List<String> guitarStrings = new ArrayList<>();
        for(TerminalNode number : ctx.NUMBER()) {
            guitarStrings.add(number.getText());
        }
        return new PatternItem(guitarStrings);
    }

    @Override
    public SegmentDef visitSegmentDef(GLangParser.SegmentDefContext ctx) {
        String segmentName = ctx.NAME().getText();
        SegmentBody segmentBody = visitSegmentBody(ctx.segmentBody());
        return new SegmentDef(segmentName, segmentBody);
    }

    @Override
    public SegmentBody visitSegmentBody(GLangParser.SegmentBodyContext ctx) {
        List<SegmentLine> segmentLines = new ArrayList<>();
        for (GLangParser.SegmentLineContext lineContext : ctx.segmentLine()) {
            segmentLines.add(visitSegmentLine(lineContext));
        }
        return new SegmentBody(segmentLines);
    }

    @Override
    public SegmentLine visitSegmentLine(GLangParser.SegmentLineContext ctx) throws InvalidSegmentLineException {
        return new SegmentLine(ctx.NAME().getText());
    }

    @Override
    public ComposeStmt visitComposeStmt(GLangParser.ComposeStmtContext ctx) {
        ComposeBody composeBody = visitComposeBody(ctx.composeBody());
        return new ComposeStmt(composeBody);
    }

    @Override
    public ComposeBody visitComposeBody(GLangParser.ComposeBodyContext ctx) {
        List<ComposeLine> composeLines = new ArrayList<>();
        for (GLangParser.ComposeLineContext lineContext : ctx.composeLine()) {
            composeLines.add(visitComposeLine(lineContext));
        }
        return new ComposeBody(composeLines);
    }

    @Override
    public ComposeLine visitComposeLine(GLangParser.ComposeLineContext ctx) throws InvalidComposeLineException {
        // a compose line is either the name of a segment
        // or a loop statement with a composeBody after it
        if (ctx.NAME() != null) {
            return new ComposeLine(ctx.NAME().getText());
        } else if (ctx.NUMBER() != null) {
            ComposeBody loopBody = visitComposeBody(ctx.composeBody());
            return new ComposeLine(Integer.parseInt(ctx.NUMBER().getText()), loopBody);
        } else if (ctx.mutationStmt() != null) {
            MutationStmt mutationStmt = visitMutationStmt(ctx.mutationStmt());
            return new ComposeLine(mutationStmt);
        } else if (ctx.functionCallStmt() != null) {
            FunctionCallStmt functionCallStmt = visitFunctionCallStmt(ctx.functionCallStmt());
            return new ComposeLine(functionCallStmt);
        } else {
            throw new InvalidComposeLineException("Compose Line must be either the name of a Segment " +
                    "or a Loop Spec");
        }
    }

    @Override
    public MutationStmt visitMutationStmt(GLangParser.MutationStmtContext ctx) {
        ValueAccess valueAccess = visitValueAccess(ctx.valueAccess());
        Integer newValue = Integer.parseInt(ctx.fret().getText());
        MutationStatementType type;
        if (ctx.EQUALS() != null) {
            type = MutationStatementType.SET;
        } else if (ctx.PLUS() != null) {
            type = MutationStatementType.PLUS;
        } else if (ctx.DASH() != null) {
            type = MutationStatementType.MINUS;
        } else {
            throw new InvalidMutationStatementException("Mutations can only be assignments, additions, or subtractions");
        }
        return new MutationStmt(valueAccess, newValue, type);
    }

    @Override
    public ValueAccess visitValueAccess(GLangParser.ValueAccessContext ctx) {
        String accessedItemName = ctx.NAME() != null ? ctx.NAME().getText() : ctx.ID().getText();
        List<Access> accesses = new ArrayList<>();
        for (GLangParser.AccessContext accessContext : ctx.access()) {
            accesses.add(visitAccess(accessContext));
        }
        return new ValueAccess(accessedItemName, accesses);
    }

    @Override
    public Access visitAccess(GLangParser.AccessContext ctx) throws InvalidAccessException{
        AccessType type;
        if (ctx.CHORDS() != null) {
            type = AccessType.CHORDS;
        } else if (ctx.STRINGS() != null) {
            type = AccessType.STRINGS;
        } else {
            throw new InvalidAccessException("Only Chords and Strings can be accessed");
        }

        int accessIndex;
        String accessParam;
        if (ctx.ID() != null) {
            accessParam = ctx.ID().getText();
            return new Access(type, accessParam);
        } else {
            accessIndex = Integer.parseInt(ctx.NUMBER().getText());
            return new Access(type, accessIndex);
        }
    }

    @Override
    public FunctionDef visitFunctionDef(GLangParser.FunctionDefContext ctx) {
        String functionName = ctx.NAME().getText();
        ParamList paramList = null;
        if (ctx.paramList() != null) {
            paramList = visitParamList(ctx.paramList());
        }
        FunctionBody functionBody = visitFunctionBody(ctx.functionBody());
        return new FunctionDef(functionName, paramList, functionBody);
    }

    @Override
    public FunctionBody visitFunctionBody(GLangParser.FunctionBodyContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (GLangParser.StatementContext statementContext : ctx.statement()) {
            statements.add(visitStatement(statementContext));
        }
        return new FunctionBody(statements);
    }

    @Override
    public ParamList visitParamList(GLangParser.ParamListContext ctx) {
        List<Param> params = new ArrayList<>();
        for (GLangParser.ParamContext paramContext : ctx.param()) {
            params.add(visitParam(paramContext));
        }
        return new ParamList(params);
    }

    @Override
    public Param visitParam(GLangParser.ParamContext ctx) throws InvalidParamTypeException {
        ParamType type;
        if (ctx.TYPE_BAR() != null) {
            type = ParamType.BAR;
        } else if (ctx.TYPE_CHORD() != null) {
            type = ParamType.CHORD;
        } else if (ctx.TYPE_NUMBER() != null) {
            type = ParamType.NUMBER;
        } else if (ctx.TYPE_SEGMENT() != null) {
            type = ParamType.SEGMENT;
        } else {
            throw new InvalidParamTypeException("Function parameters must be one of " +
                    "BAR, CHORD, NUMBER, or SEGMENT");
        }

        String argName = ctx.ID().getText();
        return new Param(type, argName);
    }

    @Override
    public FunctionCallStmt visitFunctionCallStmt(GLangParser.FunctionCallStmtContext ctx) {
        String calledFunctionName = ctx.NAME().getText();
        ArgList argList = visitArgList(ctx.argList());
        return new FunctionCallStmt(calledFunctionName, argList);
    }

    @Override
    public ArgList visitArgList(GLangParser.ArgListContext ctx) {
        List<Arg> argList = new ArrayList<>();
        for (GLangParser.ArgContext argContext : ctx.arg()) {
            argList.add(visitArg(argContext));
        }
        return new ArgList(argList);
    }

    @Override
    public Arg visitArg(GLangParser.ArgContext ctx) throws InvalidFunctionArgException {
        if (ctx.NAME() != null) {
            return new Arg(ctx.NAME().getText());
        } else if (ctx.NUMBER() != null) {
            return new Arg(Integer.parseInt(ctx.NUMBER().getText()));
        } else {
            throw new InvalidFunctionArgException("Function Arg must be either the Name of a construct " +
                    "or a number");
        }
    }
}
