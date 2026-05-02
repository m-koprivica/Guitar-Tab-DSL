package visitors;

import ast.*;
import visitors.handlers.*;
import visitors.handlers.bar.*;
import visitors.handlers.bar.pattern.PatternHandler;
import visitors.handlers.bar.pattern.PatternItemHandler;
import visitors.handlers.chord.ChordDefHandler;
import visitors.handlers.chord.FretHandler;
import visitors.handlers.compose.ComposeBodyHandler;
import visitors.handlers.compose.ComposeLineHandler;
import visitors.handlers.compose.ComposeStmtHandler;
import visitors.handlers.function_call.ArgHandler;
import visitors.handlers.function_call.ArgListHandler;
import visitors.handlers.function_call.FunctionCallStmtHandler;
import visitors.handlers.function_def.FunctionBodyHandler;
import visitors.handlers.function_def.FunctionDefHandler;
import visitors.handlers.function_def.ParamHandler;
import visitors.handlers.function_def.ParamListHandler;
import visitors.handlers.AccessHandler;
import visitors.handlers.mutation.MutationStmtHandler;
import visitors.handlers.mutation.ValueAccessHandler;
import visitors.handlers.segment.SegmentBodyHandler;
import visitors.handlers.segment.SegmentDefHandler;
import visitors.handlers.segment.SegmentLineHandler;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Evaluator implements ASTVisitor<Object, Void> {

    private PrintStream logger = System.out;
    private PrintStream output = System.out;

    public void redirectOutput(String filename) throws FileNotFoundException {
        output = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)));
    }


    private String reflectName(Object node) {
        if (node == null) return null;
        String[] candidates = {"getName", "getId", "getLabel", "getIdentifier", "getTitle",
                "getAccessedItemName", "getCalledFunctionName", "getNewValue", "getName", "name",
                "calledFunctionName", "accessedItemName", "newValue"};
        for (String mName : candidates) {
            try {
                Method m = node.getClass().getMethod(mName);
                Object val = m.invoke(node);
                if (val != null) return String.valueOf(val);
            } catch (NoSuchMethodException ignored) {
            } catch (Exception ignored) {
            }
        }
        try {
            for (Field f : node.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                Object val = f.get(node);
                if (val != null && (val instanceof String || val instanceof Number || val instanceof Enum<?>)) {
                    return String.valueOf(val);
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    // Helper to build a label with optional reflected name
    public String labelFor(Object node) {
        String name = reflectName(node);
        String base = node == null ? "null" : node.getClass().getSimpleName();
        return name == null ? base : base + " (" + name + ")";
    }


    private EvaluatorState eval_state = new EvaluatorState();

    public EvaluatorState state() {return eval_state;}
    public void reset() {eval_state = new EvaluatorState();}





    /** REGION - VISITOR PATTERN **/
    /* Everything from here on is functionally identical
     *
     * To see the functionality of a specific visitor, go to it's corresponding handler in handlers/
     */



    /**
     * Top level node of program
     */
    @Override
    public Void visit(Program prog, Object param) {
        logger.println("saw the top of program");
        eval_state.enterNode(new EvaluatorState.AstElement(prog, labelFor(prog)));

        Handlers.getHandler(ProgramHandler.class)
                .process(prog, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(Access access, Object param) {
        logger.println("saw an access");
        eval_state.enterNode(new EvaluatorState.AstElement(access, labelFor(access)));

        Handlers.getHandler(AccessHandler.class)
                .process(access, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(ArgList argList, Object param) {
        logger.println("saw an argList");
        eval_state.enterNode(new EvaluatorState.AstElement(argList, labelFor(argList)));

        Handlers.getHandler(ArgListHandler.class)
                .process(argList, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(Arg arg, Object param) {
        logger.println("saw an arg");
        eval_state.enterNode(new EvaluatorState.AstElement(arg, labelFor(arg)));

        Handlers.getHandler(ArgHandler.class)
                .process(arg, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(BarArg barArg, Object param) {
        logger.println("saw a barArg");
        eval_state.enterNode(new EvaluatorState.AstElement(barArg, labelFor(barArg)));

        Handlers.getHandler(BarArgHandler.class)
                .process(barArg, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(BarArgs barArgs, Object param) {
        logger.println("saw barArgs ");
        eval_state.enterNode(new EvaluatorState.AstElement(barArgs, labelFor(barArgs)));

        Handlers.getHandler(BarArgsHandler.class)
                .process(barArgs, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(BarDef barDef, Object param) {
        logger.println("saw a barDef");
        eval_state.enterNode(new EvaluatorState.AstElement(barDef, labelFor(barDef)));

        Handlers.getHandler(BarDefHandler.class)
                .process(barDef, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(BarExpr barExpr, Object param) {
        logger.println("saw a barExpr");
        eval_state.enterNode(new EvaluatorState.AstElement(barExpr, labelFor(barExpr)));

        Handlers.getHandler(BarExprHandler.class)
                .process(barExpr, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(BarItem barItem, Object param) {
        logger.println("saw a barItem");
        eval_state.enterNode(new EvaluatorState.AstElement(barItem, labelFor(barItem)));

        Handlers.getHandler(BarItemHandler.class)
                .process(barItem, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(BarSequence barSequence, Object param) {
        logger.println("saw a barSequence");
        eval_state.enterNode(new EvaluatorState.AstElement(barSequence, labelFor(barSequence)));

        Handlers.getHandler(BarSequenceHandler.class)
                .process(barSequence, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(ChordDef chordDef, Object param) {
        logger.println("saw a chordDef");
        eval_state.enterNode(new EvaluatorState.AstElement(chordDef, labelFor(chordDef)));

        Handlers.getHandler(ChordDefHandler.class)
                .process(chordDef, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(ComposeBody composeBody, Object param) {
        logger.println("saw a composeBody");
        eval_state.enterNode(new EvaluatorState.AstElement(composeBody, labelFor(composeBody)));

        Handlers.getHandler(ComposeBodyHandler.class)
                .process(composeBody, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(ComposeLine composeLine, Object param) {
        logger.println("saw a composeLine");
        eval_state.enterNode(new EvaluatorState.AstElement(composeLine, labelFor(composeLine)));

        Handlers.getHandler(ComposeLineHandler.class)
                .process(composeLine, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(ComposeStmt composeStmt, Object param) {
        logger.println("saw a composeStmt");
        eval_state.enterNode(new EvaluatorState.AstElement(composeStmt, labelFor(composeStmt)));

        Handlers.getHandler(ComposeStmtHandler.class)
                .process(composeStmt, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(DefineStmt defineStmt, Object param) {
        logger.println("saw a defineStmt");
        eval_state.enterNode(new EvaluatorState.AstElement(defineStmt, labelFor(defineStmt)));

        Handlers.getHandler(DefineStmtHandler.class)
                .process(defineStmt, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(Fret fret, Object param) {
        logger.println("saw a fret");
        eval_state.enterNode(new EvaluatorState.AstElement(fret, labelFor(fret)));

        Handlers.getHandler(FretHandler.class)
                .process(fret, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCall, Object param) {
        logger.println("saw a functionCallStmt");
        eval_state.enterNode(new EvaluatorState.AstElement(functionCall, labelFor(functionCall)));

        Handlers.getHandler(FunctionCallStmtHandler.class)
                .process(functionCall, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(FunctionDef functionDef, Object param) {
        logger.println("saw a functionDef");
        eval_state.enterNode(new EvaluatorState.AstElement(functionDef, labelFor(functionDef)));

        Handlers.getHandler(FunctionDefHandler.class)
                .process(functionDef, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(FunctionBody functionBody, Object param) {
        logger.println("saw a functionBody");
        eval_state.enterNode(new EvaluatorState.AstElement(functionBody, labelFor(functionBody)));

        Handlers.getHandler(FunctionBodyHandler.class)
                .process(functionBody, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(MutationStmt mutationStmt, Object param) {
        logger.println("saw a mutationStmt");
        eval_state.enterNode(new EvaluatorState.AstElement(mutationStmt, labelFor(mutationStmt)));

        Handlers.getHandler(MutationStmtHandler.class)
                .process(mutationStmt, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(Param p, Object param) {
        logger.println("saw a param");
        eval_state.enterNode(new EvaluatorState.AstElement(p, labelFor(p)));

        Handlers.getHandler(ParamHandler.class)
                .process(p, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(ParamList pList, Object param) {
        logger.println("saw a paramList");
        eval_state.enterNode(new EvaluatorState.AstElement(pList, labelFor(pList)));

        Handlers.getHandler(ParamListHandler.class)
                .process(pList, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(Pattern pattern, Object param) {
        logger.println("saw a pattern");
        eval_state.enterNode(new EvaluatorState.AstElement(pattern, labelFor(pattern)));

        Handlers.getHandler(PatternHandler.class)
                .process(pattern, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(PatternItem patternItem, Object param) {
        logger.println("saw a PatternItem");
        eval_state.enterNode(new EvaluatorState.AstElement(patternItem, labelFor(patternItem)));

        Handlers.getHandler(PatternItemHandler.class)
                .process(patternItem, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(SegmentBody segmentBody, Object param) {
        logger.println("saw a segmentBody");
        eval_state.enterNode(new EvaluatorState.AstElement(segmentBody, labelFor(segmentBody)));

        Handlers.getHandler(SegmentBodyHandler.class)
                .process(segmentBody, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(SegmentDef segmentDef, Object param) {
        logger.println("saw a segmentDef");
        eval_state.enterNode(new EvaluatorState.AstElement(segmentDef, labelFor(segmentDef)));

        Handlers.getHandler(SegmentDefHandler.class)
                .process(segmentDef, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(SegmentLine segmentLine, Object param) {
        logger.println("saw a segmentLine");
        eval_state.enterNode(new EvaluatorState.AstElement(segmentLine, labelFor(segmentLine)));

        Handlers.getHandler(SegmentLineHandler.class)
                .process(segmentLine, this, param);

        eval_state.exitNode();
        return null;
    }

    @Override
    public Void visit(Statement statement, Object param) {
        logger.println("saw a statement");

        Handlers.getHandler(StatementHandler.class)
                .process(statement, this, param);

        return null;
    }

    @Override
    public Void visit(ValueAccess valueAccess, Object param) {
        logger.println("saw a valueAccess");
        eval_state.enterNode(new EvaluatorState.AstElement(valueAccess, labelFor(valueAccess)));

        Handlers.getHandler(ValueAccessHandler.class)
                .process(valueAccess, this, param);

        eval_state.exitNode();
        return null;
    }

    public PrintStream getOutput() {
        return output;
    }

    public void setOutput(PrintStream output){
        this.output = output;
    }
}
