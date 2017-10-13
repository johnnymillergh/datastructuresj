package com.jm.exp05;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree1 = new BinaryTree("ABD###CE##F##");
        binaryTree1.preorderDisplay();
        System.out.println("Depth: " + binaryTree1.getDepth());
        binaryTree1.reset();
        SequentialBinaryTree sequentialBinaryTree = new SequentialBinaryTree(10, 10);
        sequentialBinaryTree.init();
        sequentialBinaryTree.display();
    }
}
