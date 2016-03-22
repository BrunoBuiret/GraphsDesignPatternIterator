package graph;

import java.util.Iterator;
import java.util.List;

/**
 * The actual implementation of an undirected graph.
 *
 * @author Bruno Buiret <bruno.buiret@etu.univ-lyon1.fr>
 */
public class UndirectedGraph implements IUndirectedGraph {
    /**
     * A directed graph so as to reuse already implemented code.
     */
    protected Graph directedGraph;

    /**
     * Initializes a new undirected graph.
     */
    public UndirectedGraph() {
        this.directedGraph = new Graph();
    }

    /**
     * Adds a node to the graph.
     *
     * @param _node The node to add.
     * @see graph.Graph#addNode(graph.Node)
     */
    @Override
    public void addNode(Node _node) {
        this.directedGraph.addNode(_node);
    }

    /**
     * Gets a list of every nodes in the graph.
     *
     * @return The list of nodes.
     * @see graph.Graph#getAdjNodes(graph.Node)
     */
    @Override
    public List<Node> getAllNodes() {
        return this.directedGraph.getAllNodes();
    }

    /**
     * Gets the number of nodes in the graph.
     *
     * @return The number of nodes.
     * @see graph.Graph#getNbNodes()
     */
    @Override
    public int getNbNodes() {
        return this.directedGraph.getNbNodes();
    }

    /**
     * Gets a list of every adjacent nodes to one.
     *
     * @param _n The source node.
     * @return The list of adjacent nodes.
     * @see graph.Graph#getAdjNodes(graph.Node)
     */
    @Override
    public List<Node> getAdjNodes(Node _n) {
        return this.directedGraph.getAdjNodes(_n);
    }

    /**
     * Adds an edge between two nodes of the graph.
     *
     * @param _node1 The first node.
     * @param _node2 The second node.
     * @see graph.Graph#addArc(graph.Arc)
     */
    @Override
    public void addEdge(Node _node1, Node _node2) {
        this.directedGraph.addArc(new Arc(_node1, _node2, null));
        this.directedGraph.addArc(new Arc(_node2, _node1, null));
    }

    /**
     * Tests if an edge exists between two nodes.
     *
     * @param _node1 The first node.
     * @param _node2 The second node.
     * @return <code>true</code> if the edge exists, <code>false</code>
     * otherwise.
     * @see graph.Graph#hasArc(graph.Node, graph.Node)
     */
    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return this.directedGraph.hasArc(_node1, _node2);
    }

    /**
     * Gets a string representation of this graph.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return this.directedGraph.toString();
    }

    /**
     * Gets an iterator going through the nodes according to the breadth-first
     * search algorithm.
     *
     * @param n The starting node.
     * @return The iterator.
     * @see graph.Graph#creerBFSIterator(graph.Node)
     */
    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return this.directedGraph.creerBFSIterator(n);
    }

    /**
     * Gets an iterator going through the nodes according to the depth-first
     * search algorithm.
     *
     * @param n The starting node.
     * @return The iterator.
     * @see graph.Graph#creerDFSIterator(graph.Node)
     */
    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return new DepthFirstSearchIterator(this, n);
    }
}
