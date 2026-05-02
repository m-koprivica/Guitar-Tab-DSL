package visitors.handlers.segment;

import ast.SegmentBody;
import ast.SegmentLine;
import visitors.Evaluator;
import visitors.handlers.IHandler;

import java.util.List;

public class SegmentBodyHandler implements IHandler<SegmentBody> {
    @Override
    public <T, R> R process(SegmentBody segmentBody, Evaluator eval, T param) {
        List<SegmentLine> segmentLines = segmentBody.getSegmentLines();
        for (SegmentLine line: segmentLines) {
            line.accept(eval, param);
        }

        return null;
    }

    public SegmentBodyHandler() {}
}