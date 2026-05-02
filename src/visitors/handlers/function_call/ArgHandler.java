package visitors.handlers.function_call;

import ast.Arg;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ArgHandler implements IHandler<Arg> {
    @Override
    public <T, R> R process(Arg arg, Evaluator eval, T param) {
        arg.accept(eval, null);

        return null;
    }

    public ArgHandler() {}
}