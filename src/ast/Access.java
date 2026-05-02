package ast;

import libs.Node;
import libs.enums.AccessType;
import visitors.ASTVisitor;

public class Access extends Node {

    private final AccessType type;
    private Integer accessIndex;
    private final String accessParam; // for use with functions

    public Access(AccessType type, Integer index) {
        this.type = type;
        this.accessIndex = index - 1;

        this.accessParam = null;
    }

    public Access(AccessType type, String param) {
        this.type = type;
        this.accessParam = param;

        this.accessIndex = null;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to access");
        v.visit(this, param);
    }

    public AccessType getType() {
        return type;
    }

    public Integer getAccessIndex() {
        return accessIndex;
    }

    public void setAccessIndex(Integer newValue) { this.accessIndex = newValue; }

    public String getAccessParam() {
        return accessParam;
    }
}