package ast;

import libs.Node;
import libs.enums.SegmentLineType;
import visitors.ASTVisitor;

public class SegmentLine extends Node {

    private final SegmentLineType type;

    private final MutationStmt mutationStmt;

    private final Integer loopNumber;
    private final SegmentBody loopBody;

    private final String barName;

    public SegmentLine(MutationStmt mutationStmt) {
        this.type = SegmentLineType.MUTATION;
        this.mutationStmt = mutationStmt;

        this.loopNumber = null;
        this.loopBody = null;

        this.barName = null;
    }

    public SegmentLine(Integer loopNumber, SegmentBody loopBody) {
        this.type = SegmentLineType.LOOP;
        this.loopNumber = loopNumber;
        this.loopBody = loopBody;

        this.mutationStmt = null;

        this.barName = null;
    }

    public SegmentLine(String barName) {
        this.type = SegmentLineType.BAR;
        this.barName = barName;

        this.mutationStmt = null;

        this.loopNumber = null;
        this.loopBody = null;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to segmentLine");
        v.visit(this, param);
    }

    public SegmentLineType getType() {
        return type;
    }

    public MutationStmt getMutationStmt() {
        return mutationStmt;
    }

    public SegmentBody getLoopBody() {
        return loopBody;
    }

    public Integer getLoopNumber() {
        return loopNumber;
    }

    public String getBarName() {
        return barName;
    }
}
