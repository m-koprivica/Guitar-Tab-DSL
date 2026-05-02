package ast;

import libs.Node;
import visitors.ASTVisitor;

public abstract class BarArg extends Node {

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to BarArg");
        v.visit(this, param);
    }
}
