package visitors.handlers.mutation;

import ast.*;
import libs.Node;
import libs.enums.AccessType;
import libs.enums.MutationStatementType;
import libs.exceptions.InvalidAccessException;
import visitors.Evaluator;
import visitors.EvaluatorState;
import visitors.handlers.IHandler;

import java.util.ArrayList;
import java.util.List;

public class MutationStmtHandler implements IHandler<MutationStmt> {
    @Override
    public <T, R> R process(MutationStmt mutationStmt, Evaluator eval, T param) {
        ValueAccess valueAccess = mutationStmt.getValueAccess();
        Integer newValue = mutationStmt.getNewValue();
        MutationStatementType type = mutationStmt.getType();

        List<EvaluatorState.EvalTree<EvaluatorState.SyntaxElement>> stack = new ArrayList<>(eval.state().getStack());
        for (EvaluatorState.EvalTree<EvaluatorState.SyntaxElement> e : stack) {
            if (e.getValue().label().contains("FunctionDef")) {
                return null;
            }
        }

        valueAccess.accept(eval, param);

        String itemName = valueAccess.getAccessedItemName();
        Node accessedItem = eval.state().getFromMemory(itemName).b;

        List<Access> accesses = valueAccess.getAccesses();
        if (accessedItem instanceof ChordDef chordDef) {
            this.handleChordAccess(chordDef, accesses, newValue, type);
        } else if (accessedItem instanceof BarDef barDef) {
            this.handleBarAccess(barDef, accesses, eval, newValue, type);
        }


        return null;
    }

    public MutationStmtHandler() {}

    private void handleChordAccess(ChordDef chordDef, List<Access> accesses, Integer newValue, MutationStatementType type) {
        Access access = accesses.get(0);

        if (accesses.get(0).getType() != AccessType.STRINGS) {
            throw new InvalidAccessException("Need to access strings on a chord");
        }

        if (type == MutationStatementType.SET) {
            chordDef.getFrets().get(access.getAccessIndex()).setFretNumber(newValue);
        } else if (type == MutationStatementType.PLUS) {
            Integer currVal = chordDef.getFrets().get(access.getAccessIndex()).getFretNumber();
            if (currVal == null) return;
            chordDef.getFrets().get(access.getAccessIndex()).setFretNumber(currVal + newValue);
        } else if (type == MutationStatementType.MINUS) {
            Integer currVal = chordDef.getFrets().get(access.getAccessIndex()).getFretNumber();
            if (currVal == null) return;
            chordDef.getFrets().get(access.getAccessIndex()).setFretNumber(Math.max(0, currVal - newValue));
        }
    }

    private void handleBarAccess(BarDef barDef, List<Access> accesses, Evaluator eval, Integer newValue, MutationStatementType type) {
        BarExpr barExpr = barDef.getBarExpr();

        BarArgs barArgs = barExpr.getBarArgs();
        BarSequence barSequence = barExpr.getBarSequence();
        Access barAccess = accesses.get(0);
        Integer accessIndex = barAccess.getAccessIndex();

        ChordDef chordToAccess;
        if (barSequence != null) {
            chordToAccess = this.findChordToAccess(barSequence, eval, accessIndex, 0);
        } else {
            chordToAccess = (ChordDef) eval.state().getFromMemory(barArgs.getBarChordArg().getName()).b;
        }
        List<Access> newAccesses = accesses.subList(1, accesses.size());
        handleChordAccess(chordToAccess, newAccesses, newValue, type);
    }

    private ChordDef findChordToAccess(BarSequence barSequence, Evaluator eval, Integer accessIndex, Integer currIndex) {
        for (BarItem barItem : barSequence.getBarItems()) {
            String name = barItem.getName();
            BarArgs barArgs = barItem.getBarArgs();

            if (name != null) {
                BarDef barDef = (BarDef) eval.state().getFromMemory(name).b;

                BarArgs currBarArgs = barDef.getBarExpr().getBarArgs();
                BarSequence currBarSequence = barDef.getBarExpr().getBarSequence();

                if (currBarArgs != null) {
                    if (currIndex.equals(accessIndex)) {
                        return (ChordDef) eval.state().getFromMemory(currBarArgs.getBarChordArg().getName()).b;
                    }
                    currIndex += 1;
                }

                if (currBarSequence != null) {
                    ChordDef sequenceCheck = findChordToAccess(currBarSequence, eval, accessIndex, currIndex);
                    if (sequenceCheck != null) return sequenceCheck;
                    currIndex += currBarSequence.getBarItems().size();
                }
            } else if (barArgs != null) {
                if (currIndex.equals(accessIndex)) {
                    return (ChordDef) eval.state().getFromMemory(barArgs.getBarChordArg().getName()).b;
                }
                currIndex += 1;
            }
        }

        return null;
    }
}
