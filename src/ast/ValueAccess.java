package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class ValueAccess extends Node {

    private final String accessedItemName;
    private final List<Access> accesses;

    public ValueAccess(String name, List<Access> accesses) {
        this.accessedItemName = name;
        this.accesses = accesses;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to valueAccess");
        v.visit(this, param);
    }

    public String getAccessedItemName() {
        return accessedItemName;
    }

    public List<Access> getAccesses() {
        return accesses;
    }
}
