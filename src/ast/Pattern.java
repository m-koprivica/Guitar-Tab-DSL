package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class Pattern extends Node {

    private final List<PatternItem> patternItems;

    public Pattern(List<PatternItem> items) {
        this.patternItems = items;
    }
    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to pattern");
        v.visit(this, param);
    }

    public List<PatternItem> getPatternItems() {
        return patternItems;
    }
}
