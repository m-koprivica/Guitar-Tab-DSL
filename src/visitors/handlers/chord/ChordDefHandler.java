package visitors.handlers.chord;

import ast.ChordDef;
import ast.Fret;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ChordDefHandler implements IHandler<ChordDef> {
    @Override
    public <T, R> R process(ChordDef chordDef, Evaluator eval, T param) {
        if (chordDef.getFrets() != null) {
            for (Fret f : chordDef.getFrets()) {
                f.accept(eval, null);
            }
        }
        return null;
    }

    public ChordDefHandler() {}
}