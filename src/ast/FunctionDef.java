package ast;

import libs.Node;
import libs.interfaces.DefinitionVariant;
import visitors.ASTVisitor;

public class FunctionDef extends Node implements DefinitionVariant {

    private final String functionName;
    private final ParamList paramList;
    private final FunctionBody functionBody;

    public FunctionDef(String name, ParamList list, FunctionBody body) {
        this.functionName = name;
        this.paramList = list;
        this.functionBody = body;
    }
    @Override
    public <T, U> void accept(ASTVisitor<T, U> v, T param) {
        System.out.println("accepted visitor to functionDef");
        v.visit(this, param);
    }

    public String getFunctionName() {
        return functionName;
    }

    public ParamList getParamList() {
        return paramList;
    }

    public FunctionBody getFunctionBody() {
        return functionBody;
    }
}
