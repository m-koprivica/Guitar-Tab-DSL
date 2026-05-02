package visitors.handlers.function_call;

import ast.Arg;
import ast.ArgList;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ArgListHandler implements IHandler<ArgList> {
    @Override
    public <T, R> R process(ArgList argList, Evaluator eval, T param) {
        if (argList == null) return null;
        for (Arg a : argList.getArgList()) {
            a.accept(eval, null);
        }

        return null;
    }

    public ArgListHandler() {}
}