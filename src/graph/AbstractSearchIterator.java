package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * The basis for the breadth-first and depth-first search algorithms.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public abstract class AbstractSearchIterator implements Iterator {
    /**
     * A reference to the graph.
     */
    protected IGraph graph;

    /**
     * A reference to the container to be used.
     */
    protected AbstractSearchContainer container;

    /**
     * A set of nodes which have already been visited.
     */
    protected Set<Node> visitedNodes;

    /**
     * Creates a new abstract search iterator.
     *
     * @param graph A reference to the graph.
     * @param startingNode A reference to the node to start from.
     * @param container A reference to the container to be used.
     */
    public AbstractSearchIterator(IGraph graph, Node startingNode, AbstractSearchContainer container) {
        this.graph = graph;
        this.container = container;
        this.container.add(startingNode);
        this.visitedNodes = new HashSet<>();
        this.visitedNodes.add(startingNode);
    }

    /**
     * Tests if the graph still has unvisited nodes.
     *
     * @return <code>true</code> if it does, <code>false</code> otherwise.
     */
    @Override
    public boolean hasNext() {
        return !this.container.isEmpty();
    }

    /**
     * Gets the next unvisited node from the graph.
     *
     * @return The next unvisited node.
     */
    @Override
    public Node next() {
        Node currentNode = this.container.get();

        if (currentNode != null) {
            List<Node> adjacentNodes = this.graph.getAdjNodes(currentNode);

            for (Node adjacentNode : adjacentNodes) {
                if (!this.visitedNodes.contains(adjacentNode)) {
                    this.visitedNodes.add(adjacentNode);
                    this.container.add(adjacentNode);
                }
            }
        }

        return currentNode;
    }

    /**
     * Resets the iterator by clearing the list of visited nodes so as to allow
     * another process.
     */
    public void reset() {
        this.visitedNodes.clear();
    }
}
