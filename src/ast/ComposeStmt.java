package ast;

import libs.Node;
import libs.interfaces.StatementVariant;
import visitors.ASTVisitor;

public class ComposeStmt extends Node implements StatementVariant {

    private final ComposeBody composeBody;

    public ComposeStmt(ComposeBody body) {
        this.composeBody = body;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to composeStmt");
        v.visit(this, param);
    }

    public ComposeBody getComposeBody() {
        return composeBody;
    }
}
