package ast;

import libs.Node;
import libs.interfaces.DefinitionVariant;
import visitors.ASTVisitor;

public class BarDef extends Node implements DefinitionVariant {

    private final BarExpr barExpr;
    private final String barName;

    public BarDef(BarExpr expr, String name) {
        this.barExpr = expr;
        this.barName = name;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to barDef");
        v.visit(this, param);
    }

    public BarExpr getBarExpr() {
        return barExpr;
    }

    public String getBarName() {
        return barName;
    }
}
