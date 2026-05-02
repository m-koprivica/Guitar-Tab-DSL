package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class ComposeBody extends Node {

    private final List<ComposeLine> composeLines;

    public ComposeBody(List<ComposeLine> lines) {
        this.composeLines = lines;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to composeBody");
        v.visit(this, param);
    }

    public List<ComposeLine> getComposeLines() {
        return composeLines;
    }
}
