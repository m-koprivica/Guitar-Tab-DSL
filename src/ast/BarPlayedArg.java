package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

public class BarPlayedArg extends BarArg {
    private final Integer number;

    public BarPlayedArg(TerminalNode number) {
        this.number = Integer.parseInt(number.getText());
    }

    public Integer getNumber() {
        return number;
    }
}
