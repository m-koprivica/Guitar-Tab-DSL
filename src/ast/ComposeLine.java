package ast;

import libs.Node;
import libs.enums.ComposeLineType;
import visitors.ASTVisitor;

public class ComposeLine extends Node {

    private final ComposeLineType type;

    private final String segmentName;

    private final Integer loopNumber;
    private final ComposeBody loopBody;

    private final MutationStmt mutationStmt;
    private final FunctionCallStmt functionCallStmt;

    public ComposeLine(String name) {
        this.type = ComposeLineType.SEGMENT;
        this.segmentName = name;

        this.loopNumber = null;
        this.loopBody = null;
        this.mutationStmt = null;
        this.functionCallStmt = null;
    }

    public ComposeLine(Integer number, ComposeBody body) {
        this.type = ComposeLineType.LOOP;
        this.loopNumber = number;
        this.loopBody = body;

        this.segmentName = null;
        this.mutationStmt = null;
        this.functionCallStmt = null;
    }

    public ComposeLine(MutationStmt mutationStmt) {
        this.type = ComposeLineType.MUTATION;
        this.mutationStmt = mutationStmt;

        this.segmentName = null;
        this.loopNumber = null;
        this.loopBody = null;
        this.functionCallStmt = null;
    }

    public ComposeLine(FunctionCallStmt functionCallStmt) {
        this.type = ComposeLineType.FUNCTION;
        this.functionCallStmt = functionCallStmt;

        this.segmentName = null;
        this.loopNumber = null;
        this.loopBody = null;
        this.mutationStmt = null;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to composeLine");
        v.visit(this, param);
    }

    public ComposeLineType getType() {
        return type;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public Integer getLoopNumber() {
        return loopNumber;
    }

    public ComposeBody getLoopBody() {
        return loopBody;
    }

    public MutationStmt getMutationStmt() { return mutationStmt; }

    public FunctionCallStmt getFunctionCallStmt() { return functionCallStmt; }
}
