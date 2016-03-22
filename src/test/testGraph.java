package test;

import graph.Arc;
import graph.DoubleLabel;
import graph.Graph;
import graph.IDirectedGraph;
import graph.IUndirectedGraph;
import graph.IntegerLabel;
import graph.Node;
import graph.StringLabel;
import graph.UndirectedGraph;

public class testGraph {
    public static void main(String[] args) {
        // Directed graph
        Node n1 = new Node(new IntegerLabel(1));
        Node n2 = new Node(new IntegerLabel(2));
        Node n3 = new Node(new IntegerLabel(3));
        Node n4 = new Node(new StringLabel("A"));

        Arc a1 = new Arc(n1, n2, new DoubleLabel(0.1));
        Arc a1reversed = new Arc(n2, n1, new IntegerLabel(2));
        Arc a2 = new Arc(n2, n3, null);
        Arc a2reversed = new Arc(n3, n2, null);
        Arc a3 = new Arc(n1, n3, null);

        IDirectedGraph g1 = new Graph();
        g1.addNode(n1);
        g1.addNode(n2);
        g1.addNode(n3);
        g1.addNode(n4);
        g1.addArc(a1);
        g1.addArc(a1reversed);
        g1.addArc(a2);
        g1.addArc(a2reversed);
        g1.addArc(a3);
        
        System.out.println("Graph orienté");
        System.out.println(g1);
        System.out.println(g1.hasArc(n1, n2) + " " + g1.hasArc(n2, n4));
        System.out.println(g1.getAdjNodes(n3));
        System.out.println(g1.getArc(n2));
        
        // Undirected graph
        Node m1 = new Node(new StringLabel("A"));
        Node m2 = new Node(new StringLabel("B"));
        Node m3 = new Node(new StringLabel("C"));
        Node m4 = new Node(new StringLabel("D"));
        Node m5 = new Node(new StringLabel("E"));
        
        IUndirectedGraph g2 = new UndirectedGraph();
        g2.addNode(m1);
        g2.addNode(m2);
        g2.addNode(m3);
        g2.addNode(m4);
        g2.addNode(m5);
        g2.addEdge(m1, m2);
        g2.addEdge(m3, m5);
        g2.addEdge(m4, m2);
        g2.addEdge(m4, m3);
        
        System.out.println("Graph non orienté");
        System.out.println(g2);
        System.out.println(g2.hasEdge(m1, m2) + " " + g1.hasArc(m2, m5));
        System.out.println(g2.getAdjNodes(m3));
    }
}
