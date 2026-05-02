package visitors.handlers.bar.pattern;

import ast.Pattern;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class PatternHandler implements IHandler<Pattern> {
    @Override
    public <T, R> R process(Pattern pattern, Evaluator eval, T param) {
        return null;
    }

    public PatternHandler() {}
}