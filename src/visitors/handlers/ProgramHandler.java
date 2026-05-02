package visitors.handlers;

import ast.Program;
import ast.Statement;
import visitors.Evaluator;

public class ProgramHandler implements IHandler<Program> {
    @Override
    public <T, R> R process(Program prog, Evaluator eval, T param) {
        for (Statement statement : prog.getStatements()) {
            statement.accept(eval, null);
        }
        return null; //no info needs to go back up
    }

    public ProgramHandler() {}
}