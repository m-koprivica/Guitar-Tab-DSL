package ast;

import libs.Node;
import libs.enums.ParamType;
import visitors.ASTVisitor;

public class Param extends Node {

    private final ParamType type;
    private final String argName;

    public Param(ParamType type, String argName) {
        this.type = type;
        this.argName = argName;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to param");
        v.visit(this, param);
    }

    public ParamType getType() {
        return type;
    }

    public String getArgName() {
        return argName;
    }
}
