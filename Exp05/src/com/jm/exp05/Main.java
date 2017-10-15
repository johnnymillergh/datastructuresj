package com.jm.exp05;

public class Main {

    public static void main(String[] args) throws Exception {
//        BinaryTree binaryTree1 = new BinaryTree("ABD###CE##F##");
//        binaryTree1.preorderDisplay();
//        System.out.println("Depth: " + binaryTree1.getDepth());
//        binaryTree1.reset();
        SequentialBinaryTree sequentialBinaryTree = new SequentialBinaryTree("ABCDEFGH0000000", 10, 10);
        sequentialBinaryTree.display();
        sequentialBinaryTree.iterativePreorderTraverse();
        System.out.println("<END>");
    }
}
