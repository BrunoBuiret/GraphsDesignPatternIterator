package graph;

import java.util.Stack;

/**
 * A stack is required to implement the depth-first search algorithm.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public class DepthFirstContainer extends AbstractSearchContainer {
    /**
     * The actual container.
     */
    protected Stack<Node> stack;

    /**
     * Creates a new container to be used by the depth-first search algorithm.
     */
    public DepthFirstContainer() {
        this.stack = new Stack<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Node node) {
        this.stack.push(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node get() {
        return this.stack.pop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
