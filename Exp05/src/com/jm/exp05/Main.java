package com.jm.exp05;

public class Main {

    public static void main(String[] args) throws Exception {
        // Exp05-01
        System.out.println("<Exp05-01>");
        System.out.print("Pre-order: ");
        String preorderSequence = KeyInput.readString(); // ABD###CE##F##
        BinaryTree binaryTree1 = new BinaryTree(preorderSequence);
        System.out.print("Pre-order traversal (Recursive call): ");
        binaryTree1.preorderDisplay();
        System.out.println("Depth: " + binaryTree1.getDepth());
        binaryTree1.reset();

        // Exp05-02
        System.out.println("<Exp05-02>");
        System.out.print("Level order: ");
        String treeString = KeyInput.readString(); // ABCDEF
        SequentialBinaryTree sequentialBinaryTree = new SequentialBinaryTree(treeString, 10, 10);
        System.out.print("Level traversal: ");
        sequentialBinaryTree.display();
        System.out.print("Pre-order (Non-recursive call): ");
        sequentialBinaryTree.iterativePreorderTraverse();
    }
}
