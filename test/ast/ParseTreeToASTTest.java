package ast;

import libs.enums.AccessType;
import libs.enums.DefinitionType;
import libs.enums.ParamType;
import libs.enums.StatementType;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;
import parser.GLangLexer;
import parser.GLangParser;
import parser.ParseTreeToAST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParseTreeToASTTest {
    private GLangParser getParseTree(String input) {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(input));
        TokenStream tokens = new CommonTokenStream(lexer);
        return new GLangParser(tokens);
    }

    @Test
    void testChord() {
        // Sanity test
        GLangParser parser = getParseTree("Define CHORD \"E\" 0 2 2 1 0 0 \n");

        ParseTreeToAST visitor = new ParseTreeToAST();
        Program p = (Program) parser.program().accept(visitor);

        assertNotNull(p);
        assertEquals(1, p.getStatements().size());
        assertEquals(StatementType.DEFINE, p.getStatements().getFirst().getType());
        assertEquals(DefinitionType.CHORD, ((DefineStmt) p.getStatements().getFirst().getStatementBody()).getType());
    }

    @Test
    void testBar() {
        GLangParser parser = getParseTree("Define CHORD \"E\" 0 2 2 1 0 0 \n" +
                "Define BAR \"EEE\" (chords=\"E\", played=3, pattern=(1, 2, 3, 4, 5, 6))\n");

        ParseTreeToAST visitor = new ParseTreeToAST();
        Program p = (Program) parser.program().accept(visitor);

        assertNotNull(p);
        assertEquals(2, p.getStatements().size());

        assertEquals(StatementType.DEFINE, p.getStatements().getFirst().getType());
        assertEquals(StatementType.DEFINE, p.getStatements().get(1).getType());

        DefineStmt chordDef = (DefineStmt) p.getStatements().getFirst().getStatementBody();
        DefineStmt barDef = (DefineStmt) p.getStatements().getLast().getStatementBody();

        assertEquals(DefinitionType.CHORD, chordDef.getType());
        assertEquals(DefinitionType.BAR, barDef.getType());

        BarArgs barArgs = ((BarDef) barDef.getDefinitionBody()).getBarExpr().getBarArgs();
        assertEquals(3, barArgs.getBarArgs().size());
        assertInstanceOf(BarChordArg.class, barArgs.getBarArgs().getFirst());
        assertInstanceOf(BarPlayedArg.class, barArgs.getBarArgs().get(1));
        assertInstanceOf(BarPatternArg.class, barArgs.getBarArgs().get(2));

    }

    @Test
    void testSegment() {
        GLangParser parser = getParseTree("Define CHORD \"E\" 0 2 2 1 0 0 \n" +
                "Define BAR \"EEE\" (chords=\"E\", played=3)\n" +
                "Define BAR \"FFF\" (chords=\"E\", pattern=(1, 2, 3, 4, 5, 6))\n" +
                "Define SEGMENT \"EEEFFF\":\n" +
                "\tbar=\"EEE\"\n\tbar=\"FFF\"\n");

        ParseTreeToAST visitor = new ParseTreeToAST();
        Program p = (Program) parser.program().accept(visitor);

        assertNotNull(p);
        assertEquals(4, p.getStatements().size());

        DefineStmt segmentDef = (DefineStmt) p.getStatements().getLast().getStatementBody();
        assertEquals(DefinitionType.SEGMENT, segmentDef.getType());

        SegmentBody segmentBody = ((SegmentDef) segmentDef.getDefinitionBody()).getSegmentBody();
        assertEquals(2, segmentBody.getSegmentLines().size());
        assertEquals("\"EEE\"", segmentBody.getSegmentLines().getFirst().getBarName());
        assertEquals("\"FFF\"", segmentBody.getSegmentLines().getLast().getBarName());
    }

    @Test
    void testMutate() {
        GLangParser parser = getParseTree("\"barName\".chords[1].strings[5] = 4\n");

        ParseTreeToAST visitor = new ParseTreeToAST();
        Program p = (Program) parser.program().accept(visitor);

        assertNotNull(p);
        assertEquals(1, p.getStatements().size());
        assertEquals(StatementType.MUTATE, p.getStatements().getFirst().getType());

        MutationStmt mutateStmt = (MutationStmt) p.getStatements().getFirst().getStatementBody();
        ValueAccess valueAccess = mutateStmt.getValueAccess();

        assertEquals("\"barName\"", valueAccess.getAccessedItemName());

        assertEquals(2, valueAccess.getAccesses().size());
        assertEquals(0, valueAccess.getAccesses().getFirst().getAccessIndex());
        assertEquals(AccessType.CHORDS, valueAccess.getAccesses().getFirst().getType());
        assertEquals(4, valueAccess.getAccesses().getLast().getAccessIndex());
        assertEquals(AccessType.STRINGS, valueAccess.getAccesses().getLast().getType());

        assertEquals(4, mutateStmt.getNewValue());
    }

    @Test
    void testFunctionDefinition() {
        GLangParser parser = getParseTree("""
                Define FUNCTION "Shift" (BAR b, NUMBER s):
                	b.chords[1].strings[s]=3
                """);

        ParseTreeToAST visitor = new ParseTreeToAST();
        Program p = (Program) parser.program().accept(visitor);

        assertNotNull(p);
        assertEquals(1, p.getStatements().size());

        DefineStmt definitionStmt = (DefineStmt) p.getStatements().getFirst().getStatementBody();
        FunctionDef functionDef = (FunctionDef) definitionStmt.getDefinitionBody();

        assertEquals("\"Shift\"", functionDef.getFunctionName());
        Param firstParam = functionDef.getParamList().getParams().getFirst();
        Param secondParam = functionDef.getParamList().getParams().getLast();
        assertEquals("b", firstParam.getArgName());
        assertEquals("s", secondParam.getArgName());
        assertEquals(ParamType.BAR, firstParam.getType());
        assertEquals(ParamType.NUMBER, secondParam.getType());

        FunctionBody functionBody = functionDef.getFunctionBody();
        List<Statement> statements = functionBody.getStatements();
        assertEquals(1, statements.size());

        MutationStmt mutationStmt = (MutationStmt) statements.getFirst().getStatementBody();
        List<Access> accesses = mutationStmt.getValueAccess().getAccesses();
        assertEquals("b", mutationStmt.getValueAccess().getAccessedItemName());
        Access firstAccess = accesses.getFirst();
        Access secondAccess = accesses.getLast();

        assertEquals(AccessType.CHORDS, firstAccess.getType());
        assertEquals(0, firstAccess.getAccessIndex());

        assertEquals(AccessType.STRINGS, secondAccess.getType());
        assertEquals("s", secondAccess.getAccessParam());
    }
}
