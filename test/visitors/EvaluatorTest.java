package visitors;


//import ast.*;
import libs.Node;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;
import parser.GLangLexer;
import parser.GLangParser;
import parser.ParseTreeToAST;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluatorTest {
    private static final String fp = "test/visitors/";
    /**
     * Compares outputs via check of sequentialness.
     *
     * Ignores space in between chords/plucks, checking only for sequence equality
     *
     */
    private static void assertSequence(String expected, String actual) {
        assertEquals(buildTimeline(expected), buildTimeline(actual));
    }

    private static void assertNotSequence(String unexpected, String actual) {
        assertNotEquals(buildTimeline(unexpected), buildTimeline(actual));
    }

    private static void runFile(String filename) {
        GLangLexer lexer;
        String inputFP = fp + "in/";
        String outputFP = fp + "out/";
        try {
            lexer = new GLangLexer(CharStreams.fromFileName(inputFP + filename + ".g"));
        } catch (IOException e) {
            fail("IOException thrown trying to read file - check filename.");
            return;
        }

        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);

        GLangParser parser = new GLangParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        Evaluator evaluator = new Evaluator();
        try {
            evaluator.redirectOutput(outputFP + filename + ".out");
        } catch (FileNotFoundException f) {
            fail("Could not create output file");
        }
        parsedProgram.accept(evaluator, null);
    }

    private static String loadExpected(String filename) {
        try {
            return Files.readString(Paths.get(fp + "expected/" + filename + ".exp"));
        } catch (IOException e) {
            fail("Could not load .exp file");
            return null;
        }
    }

    private static String loadActual(String filename) {
        try {
            return Files.readString(Paths.get(fp + "out/" + filename + ".out"));
        } catch (IOException e) {
            fail("Could not load .out file");
            return null;
        }
    }

    @Test
    public void emptyFormatTest() {
        String testName = "emptyFormatTest";

        runFile(testName);
        String expected = loadExpected(testName);
        String actual = loadActual(testName);


        assertEquals(expected, actual);
    }


    @Test
    public void simpleTest() {
        String testName = "simpleTest";

        runFile(testName);
        String expected = loadExpected(testName);
        String actual = loadActual(testName);


        assertSequence(expected, actual);
    }

    @Test
    public void stateChangeTest() {
        String testName = "stateChangeTest";
        runFile(testName);
        assertSequence(loadExpected(testName), loadActual(testName));
    }

    @Test
    public void funcTest() {
        String testName = "funcTest";
        runFile(testName);
        assertSequence(loadExpected(testName), loadActual(testName));
    }

    @Test
    public void sequencingSanityTest() {
        assertSequence(loadExpected("sanity1"), loadActual("sanity1"));
        assertSequence(loadExpected("sanity2"), loadActual("sanity2"));
        assertSequence(loadExpected("sanity3"), loadActual("sanity3"));
        assertSequence(loadExpected("sanity4"), loadActual("sanity4"));

        assertNotSequence(loadExpected("sanity5"), loadActual("sanity5"));
        assertNotSequence(loadExpected("sanity6"), loadActual("sanity6"));

        //Multi-bar
        assertSequence(loadExpected("sanity7"), loadActual("sanity7"));
        assertSequence(loadExpected("sanity8"), loadActual("sanity8"));

        assertNotSequence(loadExpected("sanity9"), loadActual("sanity9"));
    }

    private static List<List<String>> buildTimeline(String tab) {

        String[] lines = tab.split("\\R");

        List<NoteEvent> allEvents = new ArrayList<>();
        Pattern tokenPattern = Pattern.compile("X|\\d+");

        for (int stringIndex = 0; stringIndex < lines.length; stringIndex++) {

            String line = lines[stringIndex];
            int pipe = line.indexOf('|');
            if (pipe >= 0) {
                line = line.substring(pipe + 1);
            }

            Matcher matcher = tokenPattern.matcher(line);

            while (matcher.find()) {
                int position = matcher.start();
                String token = matcher.group();

                allEvents.add(new NoteEvent(position, stringIndex, token));
            }
        }

        // Sort by position first, then string index
        allEvents.sort(Comparator
                .comparingInt((NoteEvent e) -> e.position)
                .thenComparingInt(e -> e.stringIndex));

        // Group into timeline events
        List<List<String>> timeline = new ArrayList<>();
        Integer currentPos = null;
        List<String> currentGroup = null;

        for (NoteEvent e : allEvents) {
            if (!Objects.equals(currentPos, e.position)) {
                currentGroup = new ArrayList<>();
                timeline.add(currentGroup);
                currentPos = e.position;
            }
            currentGroup.add(e.stringIndex + ":" + e.value);
        }

        return timeline;
    }

    private static class NoteEvent {
        int position;
        int stringIndex;
        String value;

        NoteEvent(int position, int stringIndex, String value) {
            this.position = position;
            this.stringIndex = stringIndex;
            this.value = value;
        }
    }
}
