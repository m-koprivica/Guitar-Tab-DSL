package visitors.handlers.bar;

import ast.BarItem;
import ast.BarSequence;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class BarSequenceHandler implements IHandler<BarSequence> {
    @Override
    public <T, R> R process(BarSequence barSequence, Evaluator eval, T param) {
        for (BarItem item : barSequence.getBarItems()) {
            item.accept(eval, null);
        }
        return null;
    }

    public BarSequenceHandler() {}
}