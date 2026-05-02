package visitors.handlers.function_def;

import ast.FunctionBody;
import ast.Statement;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class FunctionBodyHandler implements IHandler<FunctionBody> {
    public FunctionBodyHandler() {}

    @Override
    public <T, R> R process(FunctionBody functionBody, Evaluator eval, T param) {
        for (Statement statement : functionBody.getStatements()) {
            statement.accept(eval, param);
        }
        return null;
    }
}