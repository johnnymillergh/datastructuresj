package com.jm.exp08;

public interface IGraph {
    void create();

    int getVertexAmount();

    int getArcAmount();

    Object getVertex(int v) throws Exception;

    int locateVertex(Object vertex);

    int firstAdjacentVertex(int v) throws Exception;

    int nextAdjacentVertex(int v, int w) throws Exception;

}
