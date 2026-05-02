package visitors.handlers.bar;

import ast.BarArg;
import ast.BarChordArg;
import libs.exceptions.InvalidBarArgException;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class BarArgHandler implements IHandler<BarArg> {
    @Override
    public <T, R> R process(BarArg barArg, Evaluator eval, T param) {
        if (barArg instanceof BarChordArg barChordArg) {
            if (!eval.state().memoryContains(barChordArg.getName())) {
                throw new InvalidBarArgException("Chord must be defined before use in Bar");
            }
        }
        return null;
    }

    public BarArgHandler() {}
}