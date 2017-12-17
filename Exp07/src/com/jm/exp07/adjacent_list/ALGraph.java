package com.jm.exp07.adjacent_list;

import com.jm.exp07.GraphCategory;
import com.jm.exp07.IGraph;
import com.jm.exp07.KeyInput;

public class ALGraph implements IGraph {
    private GraphCategory category;
    private int vertexAmount;
    private int arcAmount;
    private VNode[] vertex;

    public ALGraph(GraphCategory category, int vertexAmount, int arcAmount, VNode[] vertex) {
        this.category = category;
        this.vertexAmount = vertexAmount;
        this.arcAmount = arcAmount;
        this.vertex = vertex;
    }

    public void createGraph() {
        System.out.print("Enter the category of the graph: \n" +
                "    (UndirectedGraph,\n" +
                "    DirectedGraph,\n" +
                "    UndirectedNetwork,\n" +
                "    DirectedNetwork): ");
        String str = KeyInput.readString();
//        String str = "UndirectedGraph";
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
        return null;
    }

    @Override
    public int locateVertex(Object vertex) {
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

    public VNode[] getVertex() {
        return vertex;
    }
}
