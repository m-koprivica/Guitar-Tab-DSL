package libs;

import visitors.ASTVisitor;

public abstract class Node {
    abstract public <T,U> void accept(ASTVisitor<T, U> v, T param);
}