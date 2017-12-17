package com.jm.exp07;

import com.jm.exp07.adjacent_list.ALGraph;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("<Exp07-01>");
        ALGraph alGraph1 = new ALGraph();
        alGraph1.createGraph();
        alGraph1.display();
        alGraph1.getSimplePath(0, 2);
    }
}
