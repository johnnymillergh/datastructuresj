package com.jm.exp08;

public interface IGraph {
    void createGraph();

    int getVertexNumber();

    int getArcNumber();

    Object getVertex() throws Exception;

    int locateVertex();

    int firstAdjacentVertex() throws Exception;

    int nextAdjacentVertex() throws Exception;

}
