package ast;

import libs.Node;
import visitors.ASTVisitor;

public class BarItem extends Node {

    private final BarArgs barArgs;
    private final String name;

    public BarItem(BarArgs args) {
        this.barArgs = args;
        this.name = null;
    }

    public BarItem(String name) {
        this.barArgs = null;
        this.name = name;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to barItem");
        v.visit(this, param);
    }

    public BarArgs getBarArgs() {
        return barArgs;
    }

    public String getName() {
        return name;
    }
}
