package visitors.handlers.bar;

import ast.BarDef;
import ast.BarExpr;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class BarDefHandler implements IHandler<BarDef> {
    @Override
    public <T, R> R process(BarDef barDef, Evaluator eval, T param) {
        BarExpr barExpr = barDef.getBarExpr();

        barExpr.accept(eval, null);
        return null;
    }

    public BarDefHandler() {}
}