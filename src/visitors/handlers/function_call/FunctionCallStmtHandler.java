package visitors.handlers.function_call;

import ast.*;
import libs.Node;
import libs.enums.DefinitionType;
import libs.enums.StatementType;
import org.antlr.v4.runtime.misc.Pair;
import visitors.Evaluator;
import visitors.handlers.IHandler;

import java.util.*;

public class FunctionCallStmtHandler implements IHandler<FunctionCallStmt> {
    public FunctionCallStmtHandler() {}

    @Override
    public <T, R> R process(FunctionCallStmt functionCallStmt, Evaluator eval, T param) {
        // Get name of function being called
        String fnName = functionCallStmt.getCalledFunctionName();
        if (!eval.state().memoryContains(fnName) || !eval.state().memoryContains(fnName, DefinitionType.FUNCTION)) {
            throw new RuntimeException("Function must be defined before call: " + fnName);
        }

        // Look up in memory and get FunctionDef
        Pair<DefinitionType, Node> fnPair = eval.state().getFromMemory(fnName);
        FunctionDef func = (FunctionDef) fnPair.b;
        ParamList paramList = func.getParamList();
        ArgList argList = functionCallStmt.getArgList();

        List<Arg> args = argList == null ? List.of() : argList.getArgList();
        List<Param> params = paramList == null ? List.of() : paramList.getParams();

        if (params.size() != args.size()) {
            throw new RuntimeException("Function call param mismatch for " + fnName);
        }

        // Keep track of previous bindings so we can restore after call.
        Map<String, Pair<DefinitionType, Node>> overwrittenDefs = new HashMap<>();
        Map<String, Object> overwrittenParams = new HashMap<>();
        List<String> addedDefKeys = new ArrayList<>();
        List<String> addedParamKeys = new ArrayList<>();

        // Perform binding
        for (int i = 0; i < params.size(); i++) {
            Param p = params.get(i);
            Arg a = args.get(i);

            switch (p.getType()) {
                case BAR -> {
                    String paramName = p.getArgName();
                    String argName = a.getName();
                    if (argName == null) throw new RuntimeException("BAR parameter must be a BAR name");
                    if (!eval.state().memoryContains(argName) || !eval.state().memoryContains(argName, DefinitionType.BAR)) {
                        throw new RuntimeException("Referenced BAR does not exist: " + argName);
                    }
                    Pair<DefinitionType, Node> sourcePair = eval.state().getFromMemory(argName);
                    Pair<DefinitionType, Node> newPair = new Pair<>(DefinitionType.BAR, sourcePair.b);

                    if (eval.state().memoryContains(paramName)) {
                        overwrittenDefs.put(paramName, eval.state().getFromMemory(paramName));
                        eval.state().modifyMemoryValue(paramName, newPair);
                    } else {
                        eval.state().addToMemory(paramName, newPair);
                        addedDefKeys.add(paramName);
                    }
                }
                case CHORD -> {
                    String paramName = p.getArgName();
                    String argName = a.getName();
                    if (argName == null) throw new RuntimeException("CHORD parameter must be a CHORD name");
                    if (!eval.state().memoryContains(argName) || !eval.state().memoryContains(argName, DefinitionType.CHORD)) {
                        throw new RuntimeException("Referenced CHORD does not exist: " + argName);
                    }
                    Pair<DefinitionType, Node> sourcePair = eval.state().getFromMemory(argName);
                    Pair<DefinitionType, Node> newPair = new Pair<>(DefinitionType.CHORD, sourcePair.b);

                    if (eval.state().memoryContains(paramName)) {
                        overwrittenDefs.put(paramName, eval.state().getFromMemory(paramName));
                        eval.state().modifyMemoryValue(paramName, newPair);
                    } else {
                        eval.state().addToMemory(paramName, newPair);
                        addedDefKeys.add(paramName);
                    }
                }
                case SEGMENT -> {
                    String paramName = p.getArgName();
                    String argName = a.getName();
                    if (argName == null) throw new RuntimeException("SEGMENT parameter must be a SEGMENT name");
                    if (!eval.state().memoryContains(argName) || !eval.state().memoryContains(argName, DefinitionType.SEGMENT)) {
                        throw new RuntimeException("Referenced SEGMENT does not exist: " + argName);
                    }
                    Pair<DefinitionType, Node> sourcePair = eval.state().getFromMemory(argName);
                    Pair<DefinitionType, Node> newPair = new Pair<>(DefinitionType.SEGMENT, sourcePair.b);

                    if (eval.state().memoryContains(paramName)) {
                        overwrittenDefs.put(paramName, eval.state().getFromMemory(paramName));
                        eval.state().modifyMemoryValue(paramName, newPair);
                    } else {
                        eval.state().addToMemory(paramName, newPair);
                        addedDefKeys.add(paramName);
                    }
                }
                case NUMBER -> {
                    String paramName = p.getArgName();
                    Integer value = a.getNumber();
                    if (value == null) throw new RuntimeException("NUMBER parameter must be a number");

                    FunctionBody body = func.getFunctionBody();
                    for (Statement statement : body.getStatements()) {
                        if (statement.getType() == StatementType.MUTATE) {
                            MutationStmt mutationStmt = (MutationStmt) statement.getStatementBody();
                            List<Access> accesses = mutationStmt.getValueAccess().getAccesses();
                            for (Access access : accesses) {
                                if (Objects.equals(access.getAccessParam(), paramName)) {
                                    access.setAccessIndex(value - 1); // we're 0 indexed, but users are 1 indexed
                                }
                            }
                        }
                    }
                    addedParamKeys.add(paramName);
                }
                default -> throw new RuntimeException("Unhandled param type in function call");
            }
        }

        // Execute function body
        FunctionBody body = func.getFunctionBody();
        if (body != null) {
            body.accept(eval, null);
        }

        for (String added : addedParamKeys) {
            assert body != null;
            for (Statement statement : body.getStatements()) {
                if (statement.getType() == StatementType.MUTATE) {
                    MutationStmt mutationStmt = (MutationStmt) statement.getStatementBody();
                    List<Access> accesses = mutationStmt.getValueAccess().getAccesses();
                    for (Access access : accesses) {
                        if (Objects.equals(access.getAccessParam(), added)) {
                            access.setAccessIndex(null);
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, Pair<DefinitionType, Node>> e : overwrittenDefs.entrySet()) {
            eval.state().modifyMemoryValue(e.getKey(), e.getValue());
        }

        return null;
    }
}