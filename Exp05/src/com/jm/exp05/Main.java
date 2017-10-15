package com.jm.exp05;

public class Main {

    public static void main(String[] args) throws Exception {
        // Exp05-01
        System.out.println("<Exp05-01>");
        BinaryTree binaryTree1 = new BinaryTree("ABD###CE##F##");
        binaryTree1.preorderDisplay();
        System.out.println("Depth: " + binaryTree1.getDepth());
        binaryTree1.reset();

        // Exp05-02
        System.out.println("<Exp05-02>");
        SequentialBinaryTree sequentialBinaryTree = new SequentialBinaryTree("ABCDEFGH", 10, 10);
        sequentialBinaryTree.display();
        sequentialBinaryTree.iterativePreorderTraverse();
    }
}
