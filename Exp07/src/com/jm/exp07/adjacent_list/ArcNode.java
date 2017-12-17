package com.jm.exp07.adjacent_list;

public class ArcNode {
    private int adjVertex;
    private int weight;
    private ArcNode nextArc;

    public ArcNode() {
        this(-1, 0, null);
    }

    public ArcNode(int adjVertex) {
        this(adjVertex, 0, null);
    }

    public ArcNode(int adjVertex, int weight) {
        this(adjVertex, weight, null);
    }

    public ArcNode(int adjVertex, int weight, ArcNode nextArc) {
        this.adjVertex = adjVertex;
        this.weight = weight;
        this.nextArc = nextArc;
    }

    public int getAdjVertex() {
        return adjVertex;
    }

    public void setAdjVertex(int adjVertex) {
        this.adjVertex = adjVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArcNode getNextArc() {
        return nextArc;
    }

    public void setNextArc(ArcNode nextArc) {
        this.nextArc = nextArc;
    }
}
