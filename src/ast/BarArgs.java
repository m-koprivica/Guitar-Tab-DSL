package ast;

import libs.Node;
import libs.exceptions.InvalidBarArgException;
import visitors.ASTVisitor;

import java.util.List;

public class BarArgs extends Node {

    private final List<BarArg> barArgs;

    public BarArgs(List<BarArg> args) {
        this.barArgs = args;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to barArgs");
        v.visit(this, param);
    }

    public List<BarArg> getBarArgs() {
        return barArgs;
    }

    public BarChordArg getBarChordArg() {
        for (BarArg barArg : barArgs) {
            if (barArg instanceof BarChordArg barChordArg) {
                return barChordArg;
            }
        }
        throw new InvalidBarArgException("Chord must be included as a Bar Arg");
    }
}