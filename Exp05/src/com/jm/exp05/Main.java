package com.jm.exp05;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree1 = new BinaryTree("ABD###CE##F##");
        binaryTree1.preorderDisplay();
        System.out.println("Depth: " + binaryTree1.getDepth());
        binaryTree1.reset();
        BinaryTree binaryTree2 = new BinaryTree("ABDG####CE##F##");
        binaryTree2.reset();
        BinaryTree binaryTree3 = new BinaryTree("A##");
        binaryTree3.reset();
        System.out.println("isEmpty: " + binaryTree3.isEmpty());
    }
}
