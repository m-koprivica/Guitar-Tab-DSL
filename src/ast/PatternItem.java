package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class PatternItem extends Node {

    // haha, list<string>. cuz it's listing the strings you play.
    private final List<String> stringList;

    public PatternItem(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to patternItem");
        v.visit(this, param);
    }

    public List<String> getStringList() {
        return stringList;
    }
}
