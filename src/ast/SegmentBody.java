package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class SegmentBody extends Node {

    private final List<SegmentLine> segmentLines;

    public SegmentBody(List<SegmentLine> lines) {
        this.segmentLines = lines;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to segmentBody");
        v.visit(this, param);
    }

    public List<SegmentLine> getSegmentLines() {
        return segmentLines;
    }
}
