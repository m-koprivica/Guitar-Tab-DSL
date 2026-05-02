package ast;

import libs.Node;
import visitors.ASTVisitor;

public class Arg extends Node {

    private final String name;
    private final Integer number;

    public Arg(String name) {
        this.name = name;
        this.number = null;
    }

    public Arg(Integer number) {
        this.name = null;
        this.number = number;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to arg");
        v.visit(this, param);
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }
}
