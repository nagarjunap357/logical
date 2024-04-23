package org.example.ds.graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");

        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("C","B");
        g.printGraph();

//        g.removeEdge("A","B");
//        g.printGraph();

        g.removeVertex("C");
        g.printGraph();

    }
}
