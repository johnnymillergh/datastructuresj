package com.jm.exp08;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private List<Integer> parent;

    public DisjointSet(int elementAmount) {
        parent = new ArrayList<>();
        for (int i = 0; i < elementAmount; i++) {
            parent.add(i);
        }
    }

    public void makeSet(Object x) {
    }

    public int findRoot(int x) {
        if (!parent.get(x).equals(x)) {
            findRoot(parent.get(x));
        }
        return parent.get(x);
    }

    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot == yRoot) {
            return;
        }
        for (int i = 0; i < parent.size(); i++) {
            if (parent.get(i) == yRoot) {
                parent.set(i, xRoot);
            }
        }
        parent.set(y, xRoot);
    }

    public List<Integer> getParent() {
        return parent;
    }

    public void setParent(List<Integer> parent) {
        this.parent = parent;
    }

    private class Node {

    }

//    public static void main(String[] args) {
//        DisjointSet set = new DisjointSet(6);
//        set.union(0, 4);
//        set.union(0, 1);
//        System.out.println(set.parent);
//    }
}
