package ast;

import libs.Node;
import visitors.ASTVisitor;

public class BarExpr extends Node {

    private final BarArgs barArgs;
    private final BarSequence barSequence;

    public BarExpr(BarArgs args, BarSequence sequence) {
        this.barArgs = args;
        this.barSequence = sequence;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to barExpr");
        v.visit(this, param);
    }

    public BarArgs getBarArgs() {
        return barArgs;
    }

    public BarSequence getBarSequence() {
        return barSequence;
    }
}
