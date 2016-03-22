package graph;

/**
 * An abstract container to be extended for the graph search algorithms.
 * 
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public abstract class AbstractSearchContainer {
    /**
     * Adds an item to the container.
     * 
     * @param node The node to add.
     */
    public abstract void add(Node node);
    
    /**
     * Gets the first node of the container.
     * 
     * @return The first node.
     */
    public abstract Node get();
    
    /**
     * Tests if the container is empty.
     * 
     * @return <code>true</code> if the container is empty, <code>false</code>
     * otherwise.
     */
    public abstract boolean isEmpty();
}
