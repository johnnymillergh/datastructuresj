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
        return vertexAmount;
    }

    @Override
    public int getArcAmount() {
        return arcAmount;
    }

    @Override
    public Object getVertex(int index) throws Exception {
        if (index < 0 || index >= vertexAmount) {
            throw new Exception("The vertex No. " + index + " does not exist.");
        }
        return vertexes[index];
    }

    @Override
    public int locateVertex(Object vertex) {
        for (int i = 0; i < vertexAmount; i++) {
            if (vertexes[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int firstAdjacentVertex(int v) throws Exception {
        if (v < 0 || v >= vertexAmount) {
            throw new Exception("The vertex No. " + v + " does not exist.");
        }
        for (int i = 0; i < vertexAmount; i++) {
            if (arcs[v][i] != 0 && arcs[v][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int nextAdjacentVertex(int v, int w) throws Exception {
        return 0;
    }

    public void display() {
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = 0; j < vertexAmount; j++) {
                if (arcs[i][j] == INFINITY) {
                    System.out.print("* ");
                } else {
                    System.out.print(arcs[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
