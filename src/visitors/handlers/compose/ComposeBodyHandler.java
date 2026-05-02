package visitors.handlers.compose;

import ast.ComposeBody;
import ast.ComposeLine;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ComposeBodyHandler implements IHandler<ComposeBody> {
    @Override
    public <T, R> R process(ComposeBody composeBody, Evaluator eval, T param) {
        for (ComposeLine line : composeBody.getComposeLines()) {
            line.accept(eval, null);
        }
        return null;
    }

    public ComposeBodyHandler() {}
}