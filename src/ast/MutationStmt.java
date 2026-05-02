package ast;

import libs.Node;
import libs.enums.MutationStatementType;
import libs.interfaces.StatementVariant;
import visitors.ASTVisitor;

public class MutationStmt extends Node implements StatementVariant {

    private final ValueAccess valueAccess;
    private final Integer newValue;
    private final MutationStatementType type;

    public MutationStmt(ValueAccess valueAccess, Integer newValue, MutationStatementType type) {
        this.valueAccess = valueAccess;
        this.newValue = newValue;
        this.type = type;
    }
    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to mutationStmt");
        v.visit(this, param);
    }

    public ValueAccess getValueAccess() {
        return valueAccess;
    }

    public Integer getNewValue() {
        return newValue;
    }

    public MutationStatementType getType() { return type; }
}
