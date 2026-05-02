package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class Program extends Node {
    private final List<Statement> statements;

    public Program(List<Statement> statements) {
        this.statements = statements;
    }
    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to program");
        v.visit(this, param);
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
