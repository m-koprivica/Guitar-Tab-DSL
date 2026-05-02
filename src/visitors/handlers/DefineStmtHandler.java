package visitors.handlers;

import ast.*;
import libs.enums.DefinitionType;
import libs.interfaces.DefinitionVariant;
import org.antlr.v4.runtime.misc.Pair;
import visitors.Evaluator;

public class DefineStmtHandler implements IHandler<DefineStmt> {
    @Override
    public <T, R> R process(DefineStmt defineStmt, Evaluator eval, T param) {
        DefinitionVariant definitionBody = defineStmt.getDefinitionBody();
        if (definitionBody instanceof ChordDef chordDef) {
            String chordName = chordDef.getChordName();
            chordDef.accept(eval, null);
            eval.state().addToMemory(chordName, new Pair<>(DefinitionType.CHORD,chordDef));
        } else if (definitionBody instanceof BarDef barDef) {
            String barName = barDef.getBarName();
            barDef.accept(eval, null);
            eval.state().addToMemory(barName, new Pair<>(DefinitionType.BAR, barDef));
        } else if (definitionBody instanceof SegmentDef segmentDef) {
            String segmentName = segmentDef.getSegmentName();
            segmentDef.accept(eval, null);
            eval.state().addToMemory(segmentName, new Pair<>(DefinitionType.SEGMENT, segmentDef));
        } else if (definitionBody instanceof FunctionDef functionDef) {
            String functionName = functionDef.getFunctionName();
            functionDef.accept(eval, null);
            eval.state().addToMemory(functionName, new Pair<>(DefinitionType.FUNCTION, functionDef));
        }

        return null;
    }

    public DefineStmtHandler() {}
}