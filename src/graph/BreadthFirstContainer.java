package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A queue is required to implement the breadth-first search algorithm.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public class BreadthFirstContainer extends AbstractSearchContainer {
    /**
     * The actual container.
     */
    protected Queue<Node> queue;

    /**
     * Creates a new container to be used by the breadth-first search algorithm.
     */
    public BreadthFirstContainer() {
        this.queue = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Node node) {
        this.queue.offer(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node get() {
        return this.queue.poll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
