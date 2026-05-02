package ast;

import libs.Node;
import libs.enums.StatementType;
import libs.interfaces.StatementVariant;
import visitors.ASTVisitor;

public class Statement extends Node {

    private final StatementType type;
    private final StatementVariant statementBody;

    public Statement(StatementType type, StatementVariant statementBody) {
        this.type = type;
        this.statementBody = statementBody;
    }



    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to statement");
        v.visit(this, param);
    }

    public StatementType getType() {
        return type;
    }

    public StatementVariant getStatementBody() {
        return statementBody;
    }
}
