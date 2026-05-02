package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.Objects;

public class Fret extends Node {

    private Integer fretNumber;
    private Boolean isMute;   // means render as "X"
    private Boolean isSkipped; // means render as "-"

    public Fret(Integer fretNumber) {
        this.fretNumber = fretNumber;
        this.isMute = false;
        this.isSkipped = false;
    }

    public Fret(String fretStatus) {
        this.fretNumber = null;
        if (Objects.equals(fretStatus, "X")) {
            this.isMute = true;
            this.isSkipped = false;
        } else if (Objects.equals(fretStatus, "-")) {
            this.isMute = false;
            this.isSkipped = true;
        } else {
            throw new RuntimeException("invalid fret input");
        }
    }


    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to fret");
        v.visit(this, param);
    }

    public Integer getFretNumber() {
        return fretNumber;
    }

    public void setFretNumber(Integer newFretNumber) {
        this.fretNumber = newFretNumber;
        this.isSkipped = false;
        this.isMute = false;
    }

    public Boolean getMute() {
        return isMute;
    }

    public Boolean getSkipped() {
        return isSkipped;
    }

    public String getStringRepresentation() {
        if (isMute) {
            return "--x";
        } else if (isSkipped) {
            return "---";
        } else if (fretNumber <= 9) {
            return "--" + fretNumber;
        } else {
            return "-" + fretNumber;
        }
    }
}