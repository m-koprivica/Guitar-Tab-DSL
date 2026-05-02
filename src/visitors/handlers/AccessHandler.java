package visitors.handlers;

import ast.Access;
import visitors.Evaluator;

public class AccessHandler implements IHandler<Access> {
    @Override
    public <T, R> R process(Access access, Evaluator eval, T param) {
        return null;
    }

    public AccessHandler() {}
}