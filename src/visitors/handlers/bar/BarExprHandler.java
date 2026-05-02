package visitors.handlers.bar;

import ast.BarArgs;
import ast.BarExpr;
import ast.BarSequence;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class BarExprHandler implements IHandler<BarExpr> {
    @Override
    public <T, R> R process(BarExpr barExpr, Evaluator eval, T param) {
        BarSequence barSequence = barExpr.getBarSequence();
        BarArgs barArgs = barExpr.getBarArgs();

        if (barSequence != null) {
            barSequence.accept(eval, null);
        }
        if (barArgs != null) {
            barArgs.accept(eval, null);
        }
        return null;
    }

    public BarExprHandler() {}
}