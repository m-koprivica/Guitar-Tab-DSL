package visitors.handlers;

import ast.*;
import libs.interfaces.StatementVariant;
import visitors.Evaluator;

public class StatementHandler implements IHandler<Statement> {
    @Override
    public <T, R> R process(Statement statement, Evaluator eval, T param) {
        StatementVariant statementBody = statement.getStatementBody();
        switch (statement.getType()) {
            case DEFINE:
                assert statementBody instanceof DefineStmt;
                DefineStmt defineStmt = (DefineStmt) statementBody;
                defineStmt.accept(eval, null);
                break;
            case COMPOSE:
                assert statementBody instanceof ComposeStmt;
                ComposeStmt composeStmt = (ComposeStmt) statementBody;
                composeStmt.accept(eval, null);
                break;
            case MUTATE:
                assert statementBody instanceof MutationStmt;
                MutationStmt mutationStmt = (MutationStmt) statementBody;
                mutationStmt.accept(eval, null);
                break;
            case FUNCTION:
                assert statementBody instanceof FunctionCallStmt;
                FunctionCallStmt functionCallStmt = (FunctionCallStmt) statementBody;
                functionCallStmt.accept(eval, null);
                break;
        }

        return null;
    }

    public StatementHandler() {}
}