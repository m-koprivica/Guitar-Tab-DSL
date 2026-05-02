package ast;

import libs.Node;
import libs.enums.DefinitionType;
import libs.interfaces.DefinitionVariant;
import libs.interfaces.StatementVariant;
import visitors.ASTVisitor;

public class DefineStmt extends Node implements StatementVariant {

    private final DefinitionType type;
    private final DefinitionVariant definitionBody;

    public DefineStmt(DefinitionType type, DefinitionVariant definitionBody) {
        this.type = type;
        this.definitionBody = definitionBody;
    }

    public DefinitionType getType() {
        return type;
    }

    public DefinitionVariant getDefinitionBody() {
        return definitionBody;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to defineStmt");
        v.visit(this, param);
    }
}
