package ast;

import libs.Node;
import libs.interfaces.DefinitionVariant;
import visitors.ASTVisitor;

public class SegmentDef extends Node implements DefinitionVariant {

    private final String segmentName;
    private final SegmentBody segmentBody;

    public SegmentDef(String name, SegmentBody body) {
        this.segmentName = name;
        this.segmentBody = body;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to segmentDef");
        v.visit(this, param);
    }

    public String getSegmentName() {
        return segmentName;
    }

    public SegmentBody getSegmentBody() {
        return segmentBody;
    }
}
