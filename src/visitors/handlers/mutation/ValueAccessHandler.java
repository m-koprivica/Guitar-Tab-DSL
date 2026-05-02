package visitors.handlers.mutation;

import ast.ValueAccess;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ValueAccessHandler implements IHandler<ValueAccess> {
    @Override
    public <T, R> R process(ValueAccess valueAccess, Evaluator eval, T param) {
        return null;
    }

    public ValueAccessHandler() {}
}