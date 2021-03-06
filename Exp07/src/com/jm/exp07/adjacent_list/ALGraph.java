package com.jm.exp07.adjacent_list;

import com.jm.exp07.GraphCategory;
import com.jm.exp07.IGraph;
import com.jm.exp07.KeyInput;
import com.jm.exp07.SequentialStack;

import java.util.HashMap;
import java.util.Map;

public class ALGraph implements IGraph {
    private GraphCategory category;
    private int vertexAmount;
    private int arcAmount;
    private VNode[] vertexes;
    private boolean[] visited;

    public ALGraph() {
    }

    public ALGraph(GraphCategory category, int vertexAmount, int arcAmount, VNode[] vertexes) {
        this.category = category;
        this.vertexAmount = vertexAmount;
        this.arcAmount = arcAmount;
        this.vertexes = vertexes;
    }

    public void createGraph() {
        System.out.print("Enter the category of the graph: \n" +
                "    (UndirectedGraph,\n" +
                "    DirectedGraph,\n" +
                "    UndirectedNetwork,\n" +
                "    DirectedNetwork): ");
//        String str = KeyInput.readString();
        String str = "UndirectedGraph";
        GraphCategory category = GraphCategory.valueOf(str);
        switch (category) {
            case UndirectedGraph:
                createUndirectedGraph();
                break;
            case DirectedGraph:
                break;
            case UndirectedNetwork:
                break;
            case DirectedNetwork:
        }
    }

    private void createUndirectedGraph() {
        System.out.print("Enter vertexes amount: ");
        vertexAmount = KeyInput.readInt();
        System.out.print("Enter arc amount: ");
        arcAmount = KeyInput.readInt();
        vertexes = new VNode[vertexAmount];
        visited = new boolean[vertexAmount];
        System.out.println("Enter the identification of the vertex of the graph: ");
        for (int i = 0; i < vertexAmount; i++) {
            System.out.print("Vertex No. " + (i + 1) + ": ");
            vertexes[i] = new VNode(KeyInput.readString());
        }
        System.out.println("Enter the each arc of the graph: ");
        for (int i = 0; i < 2 * arcAmount; i++) {
            int v1 = KeyInput.readInt();
            int v2 = KeyInput.readInt();
            addArc(v1, v2);
        }
    }

    private void addArc(int v1, int v2) {
        // Fore-extrapolation method.
        ArcNode arcNode = new ArcNode(v2);
        arcNode.setNextArc(vertexes[v1].getFirstArc());
        vertexes[v1].setFirstArc(arcNode);
    }

    public void getSimplePath(int v1, int v2) {
        SequentialStack stack = new SequentialStack(15);
        depthFirstSearch(v1, v2, stack);
        while (true) {
            if (!stack.isEmpty()) {
                try {
                    System.out.print(" <- " + stack.pop());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }

    private void depthFirstSearch(int v1, int v2, SequentialStack stack) {
        try {
            stack.push(vertexes[v1].getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArcNode nextAdjacentNode = vertexes[v1].getFirstArc();
        while (!stack.isEmpty()) {
            String stackTop = (String) stack.peek();
            if (stackTop.compareTo((String) vertexes[v2].getData()) == 0) {
                // if start vertex and end vertex is the same one
                break;
            } else {
                try {
                    stack.push(vertexes[nextAdjacentNode.getAdjVertex()].getData());
                    nextAdjacentNode = vertexes[nextAdjacentNode.getAdjVertex()].getFirstArc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayPath(SequentialStack stack) {
        StringBuilder sb = new StringBuilder();

        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }

    @Override
    public void create() {

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
    public Object getVertex(int v) throws Exception {
        if (v < 0 && v >= vertexAmount)
            throw new Exception("Vertex No. " + v + "doesn't exist.");
        return vertexes[v].getData();
    }

    @Override
    public int locateVertex(Object vertex) {
        for (int i = 0; i < vertexAmount; i++) {
            if (vertexes[1].getData().equals(vertex)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int firstAdjacentVertex(int v) throws Exception {
        return 0;
    }

    @Override
    public int nextAdjacentVertex(int v, int w) throws Exception {
        return 0;
    }

    @Override
    public int[] findVertexesByArc(int weightOfArc) {
        return new int[0];
    }

    public GraphCategory getCategory() {
        return category;
    }

    public VNode[] getVertexes() {
        return vertexes;
    }

    public void display() {
        System.out.println("Adjacency list:");
        for (int i = 0; i < vertexAmount; i++) {
            VNode v = vertexes[i];
            System.out.print(v.getData() + " ");
            for (ArcNode arc = v.getFirstArc(); arc != null; arc = arc.getNextArc()) {
                try {
                    System.out.print("->" + getVertex(arc.getAdjVertex()) + ((arc.getWeight() == 0) ? "" : arc.getWeight()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}
