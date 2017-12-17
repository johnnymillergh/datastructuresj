package com.jm.exp07.adjacent_list;

public class VNode {
    private Object data;
    private ArcNode firstArc;

    public VNode() {
        this(null, null);
    }

    public VNode(Object data) {
        this.data = data;
    }

    public VNode(Object data, ArcNode firstArc) {
        this.data = data;
        this.firstArc = firstArc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArcNode getFirstArc() {
        return firstArc;
    }

    public void setFirstArc(ArcNode firstArc) {
        this.firstArc = firstArc;
    }
}
