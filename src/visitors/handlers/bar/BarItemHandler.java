package visitors.handlers.bar;

import ast.BarArgs;
import ast.BarItem;
import libs.exceptions.InvalidBarArgException;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class BarItemHandler implements IHandler<BarItem> {
    @Override
    public <T, R> R process(BarItem barItem, Evaluator eval, T param) {
        String barName = barItem.getName();
        BarArgs barArgs = barItem.getBarArgs();

        // BarItem is either the name of a bar, or a sequence of barArgs
        // implication being a bar can be a combination of smaller bars
        if (barName != null) {
            if (!eval.state().memoryContains(barName)) {
                throw new InvalidBarArgException("Bar must be defined before use");
            }
        } else if (barArgs != null) {
            barArgs.accept(eval, null);
        }
        return null;
    }

    public BarItemHandler() {}
}