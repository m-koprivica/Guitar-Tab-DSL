package visitors.handlers.compose;

import ast.ComposeBody;
import ast.ComposeLine;
import ast.ComposeStmt;
import visitors.Evaluator;
import visitors.handlers.IHandler;

import java.util.ArrayList;
import java.util.List;

public class ComposeStmtHandler implements IHandler<ComposeStmt> {
    private static final int BARS_PER_LINE = 5;

    public ComposeStmtHandler() {}

    @Override
    public <T, R> R process(ComposeStmt composeStmt, Evaluator eval, T param) {
        // Build 6 string builders, one per string in order (1..6)
        List<StringBuilder> lines = new ArrayList<>();
        for (int i = 0; i < 6; i++) lines.add(new StringBuilder());

        ComposeBody body = composeStmt.getComposeBody();
        if (body != null) {
            for (ComposeLine line : body.getComposeLines()) {
                // Pass to line handler
                line.accept(eval, lines);
            }
        }

        printWrappedLines(lines, eval);
        return null;
    }

    public void printWrappedLines(List<StringBuilder> lines, Evaluator eval){
        //Convert to plain strings
        int numStrings = lines.size();
        String[] contents = new String[numStrings];
        boolean allEmpty = true;

        for (int i = 0; i < numStrings; i++){
            contents[i] = lines.get(i).toString();
            if(!contents[i].isEmpty()){
                allEmpty = false;
            }
        }

        if(allEmpty){
            for(int i = 0; i < numStrings; i++){
                String content = "-".repeat(19);
                eval.getOutput().print((i+1) + "|" + content + "|");
            }
            eval.getOutput().println();
            eval.getOutput().flush();
            return;
        }

        String[][] parts = new String[numStrings][];
        int[] barsPerString = new int[numStrings];
        int maxBars = 0;

        for(int i = 0; i < numStrings; i++){
            String content = contents[i];
            String[] split = content.split("\\|", -1);

            int bars = split.length;
            if(content.endsWith("|")){
                bars -= 1;
            }

            parts[i] = split;
            barsPerString[i] = Math.max(bars, 0);
            if(barsPerString[i] > maxBars){
                maxBars = barsPerString[i];
            }
        }

        for(int start = 0; start < maxBars; start += BARS_PER_LINE){
            int end = Math.min(start + BARS_PER_LINE, maxBars);

            for(int stringIndex = 0; stringIndex < numStrings; stringIndex++){
                StringBuilder rowContent = new StringBuilder();

                int availableBars = barsPerString[stringIndex];
                for(int bar = start; bar < end; bar++){
                    if(bar < availableBars){
                        rowContent.append(parts[stringIndex][bar]).append("|");
                    }
                }

                String finalRow = rowContent.toString();

                if(finalRow.isEmpty()){
                    finalRow = "-".repeat(19);
                }

                eval.getOutput().println((stringIndex + 1) + "|" + finalRow + "|");
            }

            eval.getOutput().println();
        }

        eval.getOutput().flush();
    }
}
