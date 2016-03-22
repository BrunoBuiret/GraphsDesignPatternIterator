package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The actual implementation of a directed graph.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public class Graph implements IDirectedGraph {
    /**
     * The graph's list of nodes.
     */
    protected Set<Node> nodes;

    /**
     * A map to memorize each node's neighbors.
     */
    protected Map<Node, Set<Arc>> arcs;

    /**
     * Initializes a new directed graph.
     */
    public Graph() {
        this.nodes = new HashSet<>();
        this.arcs = new HashMap<>();
    }

    /**
     * Adds a node to the graph.
     *
     * @param _node The node to add.
     */
    @Override
    public void addNode(Node _node) {
        this.nodes.add(_node);
        this.arcs.put(_node, new HashSet<>());
    }

    /**
     * Gets a list of every nodes in the graph.
     *
     * @return The list of nodes.
     */
    @Override
    public List<Node> getAllNodes() {
        return new ArrayList<>(this.nodes);
    }

    /**
     * Gets the number of nodes in the graph.
     *
     * @return The number of nodes.
     */
    @Override
    public int getNbNodes() {
        return this.nodes.size();
    }

    /**
     * Gets a list of every adjacent nodes to one.
     *
     * @param _n The source node.
     * @return The list of adjacent nodes, or <code>null</code> if the node
     * doesn't belong to the graph.
     */
    @Override
    public List<Node> getAdjNodes(Node _n) {
        if (this.nodes.contains(_n)) {
            Set<Arc> itsArcs = this.arcs.get(_n);
            List<Node> adjacentNodes = new ArrayList<>();

            for (Arc arc : itsArcs) {
                adjacentNodes.add(arc.getDestination());
            }

            return adjacentNodes;
        }

        return null;
    }

    /**
     * Tets if <code>_n1</code> and <code>_n2</code> are linked.
     *
     * @param _n1 The first node.
     * @param _n2 The second node.
     * @return  <code>true</code> if the arc exists, <code>false</code>
     * otherwise.
     */
    @Override
    public boolean hasArc(Node _n1, Node _n2) {
        if (this.nodes.contains(_n1) && this.nodes.contains(_n2)) {
            Set<Arc> itsArcs = this.arcs.get(_n1);

            for (Arc arc : itsArcs) {
                if (arc.getDestination().equals(_n2)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Adds an arc between two nodes of the graph.
     *
     * @param _edge The arc to add.
     * @throws IllegalArgumentException Thrown when on the nodes doesn't belong
     * to the graph.
     */
    @Override
    public void addArc(Arc _edge) {
        if (!this.nodes.contains(_edge.getSource()) || !this.nodes.contains(_edge.getDestination())) {
            throw new IllegalArgumentException("One or both of the nodes aren't part of this graph.");
        }

        this.arcs.get(_edge.getSource()).add(_edge);
    }

    /**
     * Gets a node's list of arcs.
     *
     * @param _n The node.
     * @return The list of arcs, or <code>null</code> if the node doesn't belong
     * to the graph.
     */
    @Override
    public List<Arc> getArc(Node _n) {
        if (this.nodes.contains(_n)) {
            return new ArrayList<>(this.arcs.get(_n));
        }

        return null;
    }

    /**
     * Gets a string representation of this graph.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Graph\n");

        // For each node, get its neighbors
        for (Node node : this.nodes) {
            builder.append("[noeud=");
            builder.append(node.getLabel());
            builder.append(" : ");
            builder.append(this.arcs.get(node));
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * Gets an iterator going through the nodes according to the breadth-first
     * search algorithm.
     *
     * @param n The starting node.
     * @return The iterator.
     */
    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return new BreadthFirstSearchIterator(this, n);
    }

    /**
     * Gets an iterator going through the nodes according to the depth-first
     * search algorithm.
     *
     * @param n The starting node.
     * @return The iterator.
     */
    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return new DepthFirstSearchIterator(this, n);
    }
}
