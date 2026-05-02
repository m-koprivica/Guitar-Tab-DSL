package visitors.handlers.bar;

import ast.BarArg;
import ast.BarArgs;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class BarArgsHandler implements IHandler<BarArgs> {
    @Override
    public <T, R> R process(BarArgs barArgs, Evaluator eval, T param) {
        for (BarArg arg: barArgs.getBarArgs()) {
            arg.accept(eval, null);
        }
        return null;
    }

    public BarArgsHandler() {}
}