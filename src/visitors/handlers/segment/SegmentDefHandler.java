package visitors.handlers.segment;

import ast.SegmentBody;
import ast.SegmentDef;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class SegmentDefHandler implements IHandler<SegmentDef> {
    @Override
    public <T, R> R process(SegmentDef segmentDef, Evaluator eval, T param) {
        SegmentBody segmentBody = segmentDef.getSegmentBody();
        segmentBody.accept(eval, null);

        return null;
    }

    public SegmentDefHandler() {}
}