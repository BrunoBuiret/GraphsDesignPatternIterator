package graph;

/**
 * The depth-first search algorithm.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public class DepthFirstSearchIterator extends AbstractSearchIterator {
    /**
     * Creates a new iterator implementing the depth-first search algorithm.
     *
     * @param graph The graph.
     * @param startingNode The starting node.
     */
    public DepthFirstSearchIterator(IGraph graph, Node startingNode) {
        super(graph, startingNode, new DepthFirstContainer());
    }
}
