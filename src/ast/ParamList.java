package ast;

import libs.Node;
import visitors.ASTVisitor;

import java.util.List;

public class ParamList extends Node {

    private List<Param> params;

    public ParamList(List<Param> params) {
        this.params = params;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to paramList");
        v.visit(this, param);
    }

    public List<Param> getParams() {
        return params;
    }
}
