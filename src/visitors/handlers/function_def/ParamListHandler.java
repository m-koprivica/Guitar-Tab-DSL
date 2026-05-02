package visitors.handlers.function_def;

import ast.Param;
import ast.ParamList;
import visitors.Evaluator;
import visitors.handlers.IHandler;

public class ParamListHandler implements IHandler<ParamList> {
    @Override
    public <T, R> R process(ParamList plist, Evaluator eval, T param) {
        for (Param functionParam : plist.getParams()) {
            functionParam.accept(eval, param);
        }
        return null;
    }

    public ParamListHandler() {}
}