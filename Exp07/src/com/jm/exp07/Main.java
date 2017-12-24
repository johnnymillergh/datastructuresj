package com.jm.exp07;

import com.jm.exp07.adjacent_list.ALGraph;
import com.jm.exp07.adjacent_matrix.AMGraph;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println("<Exp07-01>");
//        ALGraph alGraph1 = new ALGraph();
//        alGraph1.createGraph();
//        alGraph1.display();
//        alGraph1.getSimplePath(0, 4);

        System.out.println("<Exp07-02>");
        List<Vertex> vertexs = new ArrayList<Vertex>();
        Vertex a = new Vertex("A", 0);
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        vertexs.add(a);
        vertexs.add(b);
        vertexs.add(c);
        vertexs.add(d);
        vertexs.add(e);
        vertexs.add(f);
        int[][] edges = {
                {Integer.MAX_VALUE,6,3,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {6,Integer.MAX_VALUE,2,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {3,2,Integer.MAX_VALUE,3,4,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,5,3,Integer.MAX_VALUE,5,3},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,4,5,Integer.MAX_VALUE,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3,5,Integer.MAX_VALUE}

        };
        Graph graph = new Graph(vertexs, edges);
        graph.printGraph();
        graph.search();
    }
}
