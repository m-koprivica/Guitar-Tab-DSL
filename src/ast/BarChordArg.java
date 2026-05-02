package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

public class BarChordArg extends BarArg {
    private final String name;

    public BarChordArg(TerminalNode name) {
        this.name = name.getText();
    }

    public String getName() {
        return name;
    }
}
