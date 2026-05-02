package visitors.handlers.segment;

import ast.*;
import libs.Node;
import libs.enums.DefinitionType;
import libs.exceptions.InvalidBarArgException;
import libs.exceptions.InvalidBarItemException;
import libs.exceptions.InvalidSegmentLineException;
import org.antlr.v4.runtime.misc.Pair;
import visitors.Evaluator;
import visitors.handlers.IHandler;

import java.util.ArrayList;
import java.util.List;


public class SegmentLineHandler implements IHandler<SegmentLine> {
    @Override
    public <T, R> R process(SegmentLine segmentLine, Evaluator eval, T param) {
        List<StringBuilder> lines;
        if (param instanceof List<?> listParam) {
            lines = (List<StringBuilder>) listParam;
        } else {
            // nothing to do without builders
            return null;
        }

        switch (segmentLine.getType()) {
            case MUTATION -> {
                MutationStmt mutationStmt = segmentLine.getMutationStmt();
                mutationStmt.accept(eval, null);
            }
            case LOOP -> {
                SegmentBody loop = segmentLine.getLoopBody();
                loop.accept(eval, null);
            }
            case BAR -> {
                String barName = segmentLine.getBarName();
                if (!eval.state().memoryContains(barName, DefinitionType.BAR)) {
                    throw new InvalidSegmentLineException("Bar must be defined before use in Segment");
                }

                this.renderBar(eval.state().getFromMemory(barName), eval, lines);
            }
        }

        return null;
    }

    public SegmentLineHandler() {}

    private void renderBar(Pair<DefinitionType, Node> pair, Evaluator eval, List<StringBuilder> renderers) {
        ChordDef barChord = null;
        Integer playedCount = 1;
        Pattern pattern = null;

        BarDef barDef = (BarDef) pair.b;

        BarSequence barSequence = null;
        BarArgs barArgs = null;

        if (barDef.getBarExpr() == null) {
            throw new InvalidBarItemException("BarExpr can't be null");
        }

        if (barDef.getBarExpr().getBarArgs() != null) {
            barArgs = barDef.getBarExpr().getBarArgs();
        }
        if (barDef.getBarExpr().getBarSequence() != null) {
            barSequence = barDef.getBarExpr().getBarSequence();
        }

        if (barSequence != null) {
            List<BarItem> barItems = barSequence.getBarItems();
            for (BarItem barItem : barItems) {
                BarDef barSequenceDef = null;
                if (barItem.getName() != null) {
                    barSequenceDef = (BarDef) eval.state().getFromMemory(barItem.getName()).b;
                } else {
                    barSequenceDef = new BarDef(new BarExpr(barItem.getBarArgs(), null), "temp");
                }
                this.renderBar(new Pair<>(DefinitionType.BAR, barSequenceDef), eval, renderers);
            }
            return;
        }

        assert barArgs != null;
        for (BarArg barArg : barArgs.getBarArgs()) {
            if (barArg instanceof BarChordArg) {
                barChord = (ChordDef) eval.state().getFromMemory(((BarChordArg) barArg).getName()).b;
            } else if (barArg instanceof BarPlayedArg) {
                playedCount = ((BarPlayedArg) barArg).getNumber();
            } else if (barArg instanceof BarPatternArg) {
                pattern = ((BarPatternArg) barArg).getPattern();
            }
        }

        if (barChord == null) {
            throw new InvalidBarArgException("Bars must have a chord");
        }


        while (playedCount != 0) {
            if (pattern == null) {
                this.renderBasicBar(barChord, renderers);
            } else {
                this.renderPatternBar(barChord, pattern, renderers);
            }
            playedCount--;
        }

        for (int i = 0; i < 6; i++) {
            String toRender = "--|";
            renderers.get(i).append(toRender);
        }

        return;
    }

    private void renderBasicBar(ChordDef barChord, List<StringBuilder> renderers) {
        for (int i = 0; i < 6; i++) {
            String toRender = "";
            if (barChord.getFrets().get(i).getFretNumber() != null) {
                toRender = barChord.getFrets().get(i).getStringRepresentation();
            } else if (barChord.getFrets().get(i).getMute() == true) {
                toRender = "--x";
            } else if (barChord.getFrets().get(i).getSkipped() == true) {
                toRender = "---";
            }
            renderers.get(i).append(toRender);
        }
    }

    private void renderPatternBar(ChordDef barChord, Pattern pattern, List<StringBuilder> renderers) {
        List<PatternItem> patternItems = pattern.getPatternItems();

        for (PatternItem patternItem : patternItems) {
            for (int i = 0; i < 6; i++) {
                List<Integer> stringNumbers = new ArrayList<>();
                for (String string : patternItem.getStringList()) {
                    stringNumbers.add(Integer.parseInt(string) - 1);
                }

                if (stringNumbers.contains(i)) {
                    renderers.get(i).append(barChord.getFrets().get(i).getStringRepresentation());
                } else {
                    renderers.get(i).append("---");
                }
            }
        }
    }

}
