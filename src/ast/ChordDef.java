package ast;

import libs.Node;
import libs.interfaces.DefinitionVariant;
import visitors.ASTVisitor;

import java.util.List;

public class ChordDef extends Node implements DefinitionVariant {

    private final String chordName;

    private final List<Fret> frets;

    public ChordDef(String name, List<Fret> frets) {
        this.chordName = name;
        this.frets = frets;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to chordDef");
        v.visit(this, param);
    }

    public String getChordName() {
        return chordName;
    }

    public List<Fret> getFrets() {
        return frets;
    }
}
