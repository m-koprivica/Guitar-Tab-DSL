package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class ArgList extends Node {

    private final List<Arg> argList;

    public ArgList(List<Arg> list) {
        this.argList = list;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to argList");
        v.visit(this, param);
    }

    public List<Arg> getArgList() {
        return argList;
    }
}
