package com.jm.exp08;

import java.security.Key;

public class Graph implements IGraph {

    public final static int INFINITY = Integer.MAX_VALUE;
    private GraphCategory category;
    private int vertexAmount, arcAmount;
    private Object[] vertexes;
    private int[][] arcs;

    public Graph() {
        this(null, 0, 0, null, null);
    }

    public Graph(GraphCategory category, int vertexAmount, int arcAmount, Object[] vertexes, int[][] arcs) {
        this.category = category;
        this.vertexAmount = vertexAmount;
        this.arcAmount = arcAmount;
        this.vertexes = vertexes;
        this.arcs = arcs;
    }

    @Override
    public void create() {
        System.out.print("Enter the category of the graph: \n" +
                "    (UndirectedGraph,\n" +
                "    DirectedGraph,\n" +
                "    UndirectedNetwork,\n" +
                "    DirectedNetwork): ");
        String str = KeyInput.readString();
        GraphCategory category = GraphCategory.valueOf(str);
        switch (category) {
            case UndirectedGraph:
                createUndirectedGraph();
                break;
            case DirectedGraph:
                break;
            case UndirectedNetwork:
                createUndirectedNetwork();
                break;
            case DirectedNetwork:
        }
    }

    private void createUndirectedNetwork() {
        int tempAmount = 0;
        System.out.print("Enter the amount of vertex(es): ");
        vertexAmount = KeyInput.readInt();
        System.out.print("Enter the amount of arc(s): ");
        arcAmount = KeyInput.readInt();
        vertexes = new Object[vertexAmount];
        System.out.println("Enter the identification of the vertex of the graph: ");
        for (int i = 0; i < vertexAmount; i++) {
            System.out.print("Vertex No. " + (i + 1) + ": ");
            vertexes[i] = KeyInput.readString();
        }
        // Initial the adjacent matrix
        arcs = new int[vertexAmount][vertexAmount];
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = 0; j < vertexAmount; j++) {
                arcs[i][j] = INFINITY;
            }
        }
        System.out.println("Enter the each vertex of the graph: ");
        for (int i = 0; i < arcAmount; i++) {
            int a = KeyInput.readInt();
            int b = KeyInput.readInt();
            arcs[a][b] = arcs[b][a] = KeyInput.readInt();
        }
    }

    private void createUndirectedGraph() {

    }

    @Override
    public int getVertexAmount() {
        return 0;
    }

    @Override
    public int getArcAmount() {
        return 0;
    }

    @Override
    public Object getVertex() throws Exception {
        return null;
    }

    @Override
    public int locateVertex() {
        return 0;
    }

    @Override
    public int firstAdjacentVertex() throws Exception {
        return 0;
    }

    @Override
    public int nextAdjacentVertex() throws Exception {
        return 0;
    }
}
