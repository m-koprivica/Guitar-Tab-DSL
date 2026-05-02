package visitors.handlers.bar.pattern;

import ast.PatternItem;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class PatternItemHandler implements IHandler<PatternItem> {

    @Override
    public <T, R> R process(PatternItem patternItem, Evaluator eval, T param) {
        return null;
    }

    public PatternItemHandler() {}
}