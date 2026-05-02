package visitors.handlers.compose;

import ast.*;
import libs.Node;
import libs.enums.DefinitionType;
import org.antlr.v4.runtime.misc.Pair;
import visitors.Evaluator;
import visitors.handlers.IHandler;

import java.util.List;

public class ComposeLineHandler implements IHandler<ComposeLine> {
    @Override
    public <T, R> R process(ComposeLine composeLine, Evaluator eval, T param) {
        List<StringBuilder> lines;
        if (param instanceof List<?> listParam) {
            lines = (List<StringBuilder>) listParam;
        } else {
            return null;
        }

        switch (composeLine.getType()) {
            case SEGMENT -> {
                String segmentName = composeLine.getSegmentName();
                if (!eval.state().memoryContains(segmentName)) {
                    throw new RuntimeException("Segment must be defined before composing");
                }
                Pair<DefinitionType, Node> pair = eval.state().getFromMemory(segmentName);

                if (!pair.a.equals(DefinitionType.SEGMENT))
                    throw new RuntimeException("Variable \"" + segmentName + "\" is not a Segment");

                SegmentDef seg = (SegmentDef) pair.b;
                // Pass to segment body handler
                seg.getSegmentBody().accept(eval, lines);
                break;
            }
            case LOOP -> {
                int count = composeLine.getLoopNumber();
                ComposeBody loopBody = composeLine.getLoopBody();
                for (int i = 0; i < count; i++) {
                    for (ComposeLine inner : loopBody.getComposeLines()) {
                        inner.accept(eval, lines);
                    }
                }
                break;
            }
            case MUTATION -> {
                MutationStmt mutationStmt = composeLine.getMutationStmt();
                mutationStmt.accept(eval, null);
                break;
            }
            case FUNCTION -> {
                FunctionCallStmt functionCallStmt = composeLine.getFunctionCallStmt();
                functionCallStmt.accept(eval, null);
                break;
            }
        }
        return null;
    }

    public ComposeLineHandler() {}
}