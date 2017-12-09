package com.jm.exp08;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        AMGraph graph1 = new AMGraph();
        graph1.create();
        graph1.display();
        graph1.primAlgorithm(graph1.getVertex(0));

        AMGraph graph2 = new AMGraph();
        graph2.create();
        graph2.display();
        graph2.kruskalAlgorithm();
    }
}
