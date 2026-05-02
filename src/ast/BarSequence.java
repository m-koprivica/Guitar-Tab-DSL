package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class BarSequence extends Node {

    private final List<BarItem> barItems;

    public BarSequence(List<BarItem> items) {
        this.barItems = items;
    }
    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to barSequence");
        v.visit(this, param);
    }

    public List<BarItem> getBarItems() {
        return barItems;
    }
}
