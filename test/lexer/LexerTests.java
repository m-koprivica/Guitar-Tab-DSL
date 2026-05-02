package lexer;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import parser.GLangLexer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LexerTests {
    private List<Integer> tokenTypesString(String input) {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(input));
        List<Integer> types = new ArrayList<>();
        for(Token token : lexer.getAllTokens()){
            types.add(token.getType());
        }
        return types;
    }

    private void assertTokenTypes(List<Integer> actual, int... expected){
        List<Integer> exp = new ArrayList<>();
        for(int e : expected){
            exp.add(e);
        }
        assertEquals(exp, actual);
    }

    @Test
    public void keywordTest(){
        assertTokenTypes(
                tokenTypesString("Define Compose Loop"),
                GLangLexer.DEFINE,
                GLangLexer.COMPOSE,
                GLangLexer.LOOP
        );

        assertTokenTypes(
                tokenTypesString("Intro Example Shift"),
                GLangLexer.ID,
                GLangLexer.ID,
                GLangLexer.ID
        );

        assertTokenTypes(
                tokenTypesString("CHORD BAR SEGMENT FUNCTION NUMBER"),
                GLangLexer.TYPE_CHORD,
                GLangLexer.TYPE_BAR,
                GLangLexer.TYPE_SEGMENT,
                GLangLexer.TYPE_FUNCTION,
                GLangLexer.TYPE_NUMBER
        );
    }

    @Test
    public void nameInQuotes(){
        assertTokenTypes(
                tokenTypesString("\"Example\""),
                GLangLexer.NAME
        );
    }

    @Test
    public void mutableStates(){
        assertTokenTypes(
                tokenTypesString("Example.chords[1].strings[2]=0"),
                GLangLexer.ID,
                GLangLexer.DOT,
                GLangLexer.CHORDS,
                GLangLexer.LBRACK,
                GLangLexer.NUMBER,
                GLangLexer.RBRACK,
                GLangLexer.DOT,
                GLangLexer.STRINGS,
                GLangLexer.LBRACK,
                GLangLexer.NUMBER,
                GLangLexer.RBRACK,
                GLangLexer.EQUALS,
                GLangLexer.NUMBER
        );
    }

    @Test
    public void testLoop(){
        assertTokenTypes(
                tokenTypesString("Loop 2:\n\"Segment\"\nend"),
                GLangLexer.LOOP,
                GLangLexer.NUMBER,
                GLangLexer.COLON,
                GLangLexer.NEWLINE,
                GLangLexer.NAME,
                GLangLexer.NEWLINE,
                GLangLexer.END
        );
    }

    @Test
    public void whiteSpaceTests(){
        assertTokenTypes(
                tokenTypesString("Define    BAR Example \n"),
                GLangLexer.DEFINE,
                GLangLexer.TYPE_BAR,
                GLangLexer.ID,
                GLangLexer.NEWLINE
        );
    }

    @Test
    public void indentationTests(){
        assertTokenTypes(
                tokenTypesString("""
                        Compose:
                            Loop 2:
                                "Chorus"
                                "Another Segment"
                            end
                            "some bars"
                        """),
                GLangLexer.COMPOSE,
                GLangLexer.COLON,
                GLangLexer.NEWLINE,
                GLangLexer.LOOP,
                GLangLexer.NUMBER,
                GLangLexer.COLON,
                GLangLexer.NEWLINE,
                GLangLexer.NAME,
                GLangLexer.NEWLINE,
                GLangLexer.NAME,
                GLangLexer.NEWLINE,
                GLangLexer.END,
                GLangLexer.NEWLINE,
                GLangLexer.NAME,
                GLangLexer.NEWLINE
            );
    }

}