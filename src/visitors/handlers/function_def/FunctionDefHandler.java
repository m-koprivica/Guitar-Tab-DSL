package visitors.handlers.function_def;

import ast.FunctionDef;
import libs.exceptions.InvalidFunctionNameException;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class FunctionDefHandler implements IHandler<FunctionDef> {
    @Override
    public <T, R> R process(FunctionDef functionDef, Evaluator eval, T param) {
        String functionName = functionDef.getFunctionName();
        if (eval.state().memoryContains(functionName)) {
            throw new InvalidFunctionNameException("Function name can't be the same as another defined object");
        }
        functionDef.getFunctionBody().accept(eval, param);
        functionDef.getParamList().accept(eval, param);
        return null;
    }

    public FunctionDefHandler() {}
}