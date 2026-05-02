package visitors.handlers.chord;

import ast.Fret;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class FretHandler implements IHandler<Fret> {
    @Override
    public <T, R> R process(Fret fret, Evaluator eval, T param) {
        return null;
    }

    public FretHandler() {}
}