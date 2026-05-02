package ast;

import libs.Node;
import libs.interfaces.StatementVariant;
import visitors.ASTVisitor;

public class FunctionCallStmt extends Node implements StatementVariant {

    private final String calledFunctionName;
    private final ArgList argList;

    public FunctionCallStmt(String name, ArgList argList) {
        this.calledFunctionName = name;
        this.argList = argList;
    }

    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to functionCallStmt");
        v.visit(this, param);
    }

    public String getCalledFunctionName() {
        return calledFunctionName;
    }

    public ArgList getArgList() {
        return argList;
    }
}
