package visitors.handlers.function_def;

import ast.Param;
import libs.exceptions.InvalidParamNameException;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ParamHandler implements IHandler<Param> {
    @Override
    public <T, R> R process(Param p, Evaluator eval, T param) {
        if (eval.state().memoryContains(p.getArgName())) {
            throw new InvalidParamNameException("Parameter names cannot be the same as any defined objects");
        }
        return null;
    }

    public ParamHandler() {}
}