package visitors;

import libs.Node;
import libs.enums.DefinitionType;
import libs.exceptions.InvalidDefinitionException;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class EvaluatorState {
    // Constructor
    public EvaluatorState() {
        stack.push(root);
    }

    private final Map<String, Pair<DefinitionType, Node>> memory = new HashMap<>();

    public boolean memoryContains(String key) {
        return memory.containsKey(key);
    }

    public boolean memoryContains(String key, DefinitionType type) {
        return memory.get(key).a.equals(type);
    }

    public void addToMemory(String id, Pair<DefinitionType, Node> val) {
        if (memory.containsKey(id)) throw new InvalidDefinitionException("Cannot use the same name to define twice: " + id);

        memory.put(id, val);
    }

    public void modifyMemoryValue(String id, Pair<DefinitionType, Node> newVal) {memory.replace(id, newVal);}

    public Pair<DefinitionType, Node> getFromMemory(String id) {return memory.get(id);}

    // Syntax element interface
    public interface SyntaxElement {
        String label();
    }

    // Wrap an AST node with both a human-readable label and the original payload
    public static class AstElement implements SyntaxElement {
        private final Object node;
        private final String label;
        public AstElement(Object node, String label) {
            this.node = node;
            this.label = label;
        }
        public Object getNode() { return node; }
        @Override public String label() { return label; }
        @Override public String toString() { return label; }
    }

    // Evaluation tree class
    public static class EvalTree<T> {
        private final T value;
        private final List<EvalTree<T>> children = new ArrayList<>();
        public EvalTree(T value) { this.value = value; }
        public T getValue() { return value; }
        public List<EvalTree<T>> getChildren() { return children; }
        public EvalTree<T> addChild(T childValue) {
            EvalTree<T> child = new EvalTree<>(childValue);
            children.add(child);
            return child;
        }
        @Override public String toString() { return value.toString(); }
    }

    // Root of evaluation tree and stack for building it.
    private final EvalTree<SyntaxElement> root = new EvalTree<>(new AstElement(null, "EvaluationRoot"));
    private final Deque<EvalTree<SyntaxElement>> stack = new ArrayDeque<>();



    // Getter
    public EvalTree<SyntaxElement> getEvaluationTree() {
        return root;
    }

    // Enter / exit helpers (accepts prebuilt SyntaxElement or plain label).
    public void enterNode(SyntaxElement elem) {
        EvalTree<SyntaxElement> node = new EvalTree<>(elem);
        stack.peek().getChildren().add(node);
        stack.push(node);
    }

    public void enterNode(String label) {
        enterNode(new AstElement(null, label));
    }

    public void exitNode() {
        if (stack.size() > 1) stack.pop();
    }

    public Deque<EvalTree<SyntaxElement>> getStack() {
        return stack;
    }
}