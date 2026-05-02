package ast;

public class BarPatternArg extends BarArg {
    private final Pattern pattern;

    public BarPatternArg(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
