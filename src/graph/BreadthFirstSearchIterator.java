package graph;

/**
 * The breadth-first search algorithm.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public class BreadthFirstSearchIterator extends AbstractSearchIterator {
    /**
     * Creates a new iterator implementing the breadth-first search algorithm.
     *
     * @param graph The graph.
     * @param startingNode The starting node.
     */
    public BreadthFirstSearchIterator(IGraph graph, Node startingNode) {
        super(graph, startingNode, new BreadthFirstContainer());
    }
}
