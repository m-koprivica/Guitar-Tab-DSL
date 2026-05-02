package parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest {

    @Test
    public void testDefineChord() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(
                "Define CHORD \"E\" 0 2 1 3 X 0"
        ));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext p = parser.program();

        GLangParser.ChordDefContext chord = p.statement(0).defineStmt().chordDef();

        assertEquals("\"E\"", chord.NAME().getText());
        assertFret(chord.fret(0), 0);
        assertFret(chord.fret(1), 2);
        assertFret(chord.fret(2), 1);
        assertFret(chord.fret(3), 3);
        assertFret(chord.fret(4), null);
        assertFret(chord.fret(5), 0);
    }

    @Test
    public void testDefineBar() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(
                "Define BAR \"bar1\" (chords=\"E\", pattern=([1+3+2],4,5,4), played=2)"
        ));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();

        GLangParser.BarDefContext bar = program.statement(0).defineStmt().barDef();
        assertEquals("\"bar1\"", bar.NAME().getText());
        GLangParser.BarArgsContext arguments = bar.barExpr().barArgs();

        // "chords" argument
        GLangParser.BarArgContext chordsArg = arguments.barArg(0);
        assertNotNull(chordsArg.CHORDS());
        assertEquals("\"E\"", chordsArg.NAME().getText());

        // "pattern" argument
        GLangParser.BarArgContext patternArg = arguments.barArg(1);
        assertNotNull(patternArg.PATTERN());
        GLangParser.PatternContext pattern = patternArg.pattern();

        GLangParser.PatternItemContext patternCombination = pattern.patternItem(0);
        assertEquals("1", patternCombination.NUMBER(0).getText());
        assertEquals("3", patternCombination.NUMBER(1).getText());
        assertEquals("2", patternCombination.NUMBER(2).getText());

        assertEquals("4", pattern.patternItem(1).NUMBER(0).getText());
        assertEquals("5", pattern.patternItem(2).NUMBER(0).getText());
        assertEquals("4", pattern.patternItem(3).NUMBER(0).getText());

        // "played" argument
        GLangParser.BarArgContext playedArg = arguments.barArg(2);
        assertNotNull(playedArg.PLAYED());
        assertEquals("2", playedArg.NUMBER().getText());
    }

    @Test
    public void testDefineNestedBar() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(
                "Define BAR \"bar2\" (\"bar1\", (chords=\"E\", pattern=([1+3+2],4,5,4), played=2))"
        ));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();

        GLangParser.BarDefContext bar = program.statement(0).defineStmt().barDef();
        assertEquals("\"bar2\"", bar.NAME().getText());
        GLangParser.BarSequenceContext sequence = bar.barExpr().barSequence();

        GLangParser.BarItemContext item = sequence.barItem(0);
        assertEquals("\"bar1\"", item.NAME().getText());
        GLangParser.BarArgsContext arguments = sequence.barItem(1).barArgs();

        // "chords" argument
        GLangParser.BarArgContext chordsArg = arguments.barArg(0);
        assertNotNull(chordsArg.CHORDS());
        assertEquals("\"E\"", chordsArg.NAME().getText());

        // "pattern" argument
        GLangParser.BarArgContext patternArg = arguments.barArg(1);
        assertNotNull(patternArg.PATTERN());
        GLangParser.PatternContext pattern = patternArg.pattern();

        GLangParser.PatternItemContext patternCombination = pattern.patternItem(0);
        assertEquals("1", patternCombination.NUMBER(0).getText());
        assertEquals("3", patternCombination.NUMBER(1).getText());
        assertEquals("2", patternCombination.NUMBER(2).getText());

        assertEquals("4", pattern.patternItem(1).NUMBER(0).getText());
        assertEquals("5", pattern.patternItem(2).NUMBER(0).getText());
        assertEquals("4", pattern.patternItem(3).NUMBER(0).getText());

        // "played" argument
        GLangParser.BarArgContext playedArg = arguments.barArg(2);
        assertNotNull(playedArg.PLAYED());
        assertEquals("2", playedArg.NUMBER().getText());
    }

    @Test
    public void testDefineSegment() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                Define SEGMENT "Intro":
                    bar="first bar"
                    bar="second bar"
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.SegmentDefContext segment = program.statement(0).defineStmt().segmentDef();

        assertEquals("\"Intro\"", segment.NAME().getText());
        assertNull(segment.loopSpec());

        GLangParser.SegmentBodyContext body = segment.segmentBody();
        assertEquals(2, body.segmentLine().size());

        GLangParser.SegmentLineContext line1 = body.segmentLine(0);
        assertNotNull(line1.BAR());
        assertEquals("\"first bar\"", line1.NAME().getText());

        GLangParser.SegmentLineContext line2 = body.segmentLine(1);
        assertNotNull(line2.BAR());
        assertEquals("\"second bar\"", line2.NAME().getText());
    }

    @Test
    public void testDefineSegmentWithLoop() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Define SEGMENT "Intro" Loop 2:
                        bar="bar2"
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.SegmentDefContext segment = program.statement(0).defineStmt().segmentDef();

        assertEquals("\"Intro\"", segment.NAME().getText());
        assertNotNull(segment.loopSpec());
        assertEquals("2", segment.loopSpec().NUMBER().getText());

        GLangParser.SegmentBodyContext body = segment.segmentBody();
        assertEquals(1, body.segmentLine().size());
        GLangParser.SegmentLineContext line = body.segmentLine(0);

        assertEquals("bar", line.BAR().getText());
        assertEquals("\"bar2\"", line.NAME().getText());
    }

    @Test
    public void testMutationStatement() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(
                "\"allTheBars\".chords[4].strings[1] = X"
        ));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();

        GLangParser.MutationStmtContext mutation = program.statement(0).mutationStmt();
        GLangParser.ValueAccessContext valueAccess = mutation.valueAccess();

        assertEquals("\"allTheBars\"", valueAccess.getChild(0).getText());
        assertEquals("chords", valueAccess.access(0).CHORDS().getText());
        assertEquals("4", valueAccess.access(0).NUMBER().getText());
        assertEquals("strings", valueAccess.access(1).STRINGS().getText());
        assertEquals("1", valueAccess.access(1).NUMBER().getText());
        assertFret(mutation.fret(), null);
    }

    @Test
    public void testComposeSimple() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Compose:
                        "Intro"
                        "Outro"
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.ComposeStmtContext compose = program.statement(0).composeStmt();

        GLangParser.ComposeBodyContext body = compose.composeBody();
        assertEquals(2, body.composeLine().size());
        GLangParser.ComposeLineContext line1 = body.composeLine(0);
        assertEquals("\"Intro\"", line1.NAME().getText());
        GLangParser.ComposeLineContext line2 = body.composeLine(1);
        assertEquals("\"Outro\"", line2.NAME().getText());
    }

    @Test
    public void testComposeWithLoop() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Compose:
                        "Intro"
                        Loop 2:
                            "Chorus"
                            "Some more bars"
                        end
                        "Outro"
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.ComposeStmtContext compose = program.statement(0).composeStmt();

        GLangParser.ComposeBodyContext body = compose.composeBody();
        assertEquals(3, body.composeLine().size());

        // "Intro"
        assertEquals("\"Intro\"", body.composeLine(0).NAME().getText());

        // Loop 2: ... end
        GLangParser.ComposeLineContext loopLine = body.composeLine(1);
        assertNotNull(loopLine.LOOP());
        assertEquals("2", loopLine.NUMBER().getText());
        GLangParser.ComposeBodyContext nestedBody = loopLine.composeBody();
        assertEquals(2, nestedBody.composeLine().size());
        assertEquals("\"Chorus\"", nestedBody.composeLine(0).NAME().getText());
        assertEquals("\"Some more bars\"", nestedBody.composeLine(1).NAME().getText());
        assertNotNull(loopLine.END());

        // "Outro"
        assertEquals("\"Outro\"", body.composeLine(2).NAME().getText());
    }

    @Test
    public void testComposeWithNestedLoop() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Compose:
                        Loop 2:
                            "Intro"
                            Loop 4:
                                "Lots of Looping"
                            end
                        end
                        Loop 3:
                            "Mars Bars"
                        end
                        "Outro"
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.ComposeStmtContext compose = program.statement(0).composeStmt();

        GLangParser.ComposeBodyContext body = compose.composeBody();
        assertEquals(3, body.composeLine().size());

        // First Outer Loop
        GLangParser.ComposeLineContext firstLoop = body.composeLine(0);
        assertNotNull(firstLoop.LOOP());
        assertEquals("2", firstLoop.NUMBER().getText());

        GLangParser.ComposeBodyContext firstLoopBody = firstLoop.composeBody();
        assertEquals(2, firstLoopBody.composeLine().size());
        assertEquals("\"Intro\"", firstLoopBody.composeLine(0).NAME().getText());
        // - Inner Loop
        GLangParser.ComposeLineContext innerLoop = firstLoopBody.composeLine(1);
        GLangParser.ComposeBodyContext innerLoopBody = innerLoop.composeBody();
        assertEquals(1, innerLoopBody.composeLine().size());
        assertEquals("\"Lots of Looping\"", innerLoopBody.composeLine(0).NAME().getText());
        assertNotNull(innerLoop.END());
        assertNotNull(firstLoop.END());

        // Second Outer Loop
        GLangParser.ComposeLineContext secondLoop = body.composeLine(1);
        assertNotNull(secondLoop.LOOP());
        assertEquals("3", secondLoop.NUMBER().getText());

        GLangParser.ComposeBodyContext secondLoopBody = secondLoop.composeBody();
        assertEquals(1, secondLoopBody.composeLine().size());
        assertEquals("\"Mars Bars\"", secondLoopBody.composeLine(0).NAME().getText());

        // Outro
        GLangParser.ComposeLineContext lastLine = body.composeLine(2);
        assertEquals("\"Outro\"", lastLine.NAME().getText());
    }


    @Test
    public void testDefineFunction() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Define FUNCTION "Shift" (BAR b, NUMBER s):
                        b.chords[1].strings[s] = 3
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.FunctionDefContext function = program.statement(0).defineStmt().functionDef();
        assertEquals("\"Shift\"", function.NAME().getText());

        GLangParser.ParamListContext params = function.paramList();
        assertEquals(2, params.param().size());

        GLangParser.ParamContext param1 = params.param(0);
        assertNotNull(param1.TYPE_BAR());
        assertEquals("b", param1.ID().getText());

        GLangParser.ParamContext param2 = params.param(1);
        assertNotNull(param2.TYPE_NUMBER());
        assertEquals("s", param2.ID().getText());

        GLangParser.FunctionBodyContext body = function.functionBody();
        assertEquals(1, body.statement().size());
        GLangParser.MutationStmtContext mutation = body.statement(0).mutationStmt();
        GLangParser.ValueAccessContext valueAccess = mutation.valueAccess();
        assertEquals("b", valueAccess.getChild(0).getText());
        assertEquals("chords", valueAccess.access(0).CHORDS().getText());
        assertEquals("1", valueAccess.access(0).NUMBER().getText());
        assertEquals("strings", valueAccess.access(1).STRINGS().getText());
        assertEquals("s", valueAccess.access(1).ID().getText()); // parameter
        assertEquals("3", mutation.fret().NUMBER().getText());
    }

    @Test
    public void testDefineFunctionWithChordMutation() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Define FUNCTION "Change Bar Chord" (BAR b, CHORD c):
                        b.chords[1] = c
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.FunctionDefContext function = program.statement(0).defineStmt().functionDef();
        assertEquals("\"Change Bar Chord\"", function.NAME().getText());

        GLangParser.ParamListContext params = function.paramList();
        assertEquals(2, params.param().size());

        GLangParser.ParamContext param1 = params.param(0);
        assertNotNull(param1.TYPE_BAR());
        assertEquals("b", param1.ID().getText());

        GLangParser.ParamContext param2 = params.param(1);
        assertNotNull(param2.TYPE_CHORD());
        assertEquals("c", param2.ID().getText());

        GLangParser.FunctionBodyContext body = function.functionBody();
        assertEquals(1, body.statement().size());
        GLangParser.MutationStmtContext mutation = body.statement(0).mutationStmt();
        GLangParser.ValueAccessContext valueAccess = mutation.valueAccess();
        assertEquals("b", valueAccess.getChild(0).getText());
        assertEquals("chords", valueAccess.access(0).CHORDS().getText());
        assertEquals("1", valueAccess.access(0).NUMBER().getText());
        assertEquals("c", mutation.ID().getText()); // parameter
    }


    @Test
    public void testFunctionCall() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(
                "\"Shift\"(\"Bar1\", 4)"
        ));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.FunctionCallStmtContext call = program.statement(0).functionCallStmt();
        assertEquals("\"Shift\"", call.NAME().getText());

        GLangParser.ArgListContext args = call.argList();
        assertEquals(2, args.arg().size());
        assertEquals("\"Bar1\"", args.arg(0).NAME().getText());
        assertEquals("4", args.arg(1).NUMBER().getText());
    }

    @Test
    public void testComposeWithMutationAndFunctionCall() {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString("""
                    Compose:
                        "Intro"
                        "bar1".chords[1].strings[2] = 4
                        "Shift"("bar1", 3)
                        Loop 2:
                            "Outro"
                        end
                """));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GLangParser parser = new GLangParser(tokens);
        GLangParser.ProgramContext program = parser.program();
        GLangParser.ComposeStmtContext compose = program.statement(0).composeStmt();

        GLangParser.ComposeBodyContext body = compose.composeBody();
        assertEquals(4, body.composeLine().size());

        // "Intro"
        assertEquals("\"Intro\"", body.composeLine(0).NAME().getText());

        // Mutation Statement
        GLangParser.MutationStmtContext mutation = body.composeLine(1).mutationStmt();
        GLangParser.ValueAccessContext valueAccess = mutation.valueAccess();
        assertEquals("\"bar1\"", valueAccess.getChild(0).getText());
        assertEquals("chords", valueAccess.access(0).CHORDS().getText());
        assertEquals("1", valueAccess.access(0).NUMBER().getText());
        assertEquals("strings", valueAccess.access(1).STRINGS().getText());
        assertEquals("2", valueAccess.access(1).NUMBER().getText());
        assertFret(mutation.fret(), 4);

        // Function Call Statement
        GLangParser.FunctionCallStmtContext call = body.composeLine(2).functionCallStmt();
        assertEquals("\"Shift\"", call.NAME().getText());
        assertEquals(2, call.argList().arg().size());
        assertEquals("\"bar1\"", call.argList().arg(0).NAME().getText());
        assertEquals("3", call.argList().arg(1).NUMBER().getText());

        // Loop
        GLangParser.ComposeLineContext loop = body.composeLine(3);
        assertEquals("Loop", loop.LOOP().getText());
        assertEquals("2", loop.NUMBER().getText());
        GLangParser.ComposeBodyContext nested = loop.composeBody();
        assertEquals(1, nested.composeLine().size());
        assertEquals("\"Outro\"", nested.composeLine(0).NAME().getText());
    }


    // Helpers
    private void assertFret(GLangParser.FretContext fret, Integer expected) {
        if (expected == null) {
            assertNotNull(fret.X(), "Expected X fret");
        } else {
            assertNotNull(fret.NUMBER(), "Expected number fret");
            assertEquals(expected, Integer.parseInt(fret.NUMBER().getText()));
        }
    }
}