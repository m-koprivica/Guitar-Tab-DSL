package visitors.handlers;

import libs.Node;
import visitors.Evaluator;

/**
 * Interface for all the evaluation handlers
 *
 * Handlers are stateless singletons, taking in Evaluator and a param as their context
 */
public interface IHandler<N extends Node> {
    /**
     * Process a node with a given state and generic parameter.
     *
     * @param node  the Node we will be handling. Only one type for a given handler
     * @param eval  the current state of the evaluation
     * @param param a generic parameter that may or may not be used by the handler for additional information
     */
    public abstract <T, R> R process(N node, Evaluator eval, T param);
}
