package com.jm.exp08;

public interface IGraph {
    void create();

    int getVertexAmount();

    int getArcAmount();

    Object getVertex() throws Exception;

    int locateVertex();

    int firstAdjacentVertex() throws Exception;

    int nextAdjacentVertex() throws Exception;

}
