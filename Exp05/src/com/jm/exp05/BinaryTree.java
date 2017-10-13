package com.jm.exp05;

public class BinaryTree {
    BinaryTreeNode root;
    private static int index = 0;
    private static int depthOfLeftOffspring;
    private static int depthOfRightOffspring;

    public BinaryTree(String preOrderSequence) {
        char nodeCharacter = preOrderSequence.charAt(index);
        index++;
        if (nodeCharacter != '#') {
            root = new BinaryTreeNode(Character.valueOf(nodeCharacter));
            root.setLeftChild(new BinaryTree(preOrderSequence).getRoot());
            root.setRightChild(new BinaryTree(preOrderSequence).getRoot());
        } else {
            root = null;
        }
    }

    public void destroy() {
        root = null;
    }

    public void clear() {
        root.setLeftChild(null);
        root.setRightChild(null);
    }

    public boolean isEmpty() {
        return root.getLeftChild() == null || root.getRightChild() == null;
    }

    public int getDepth() {
        recursiveGetDepthOfLeftOffspring(root);
        recursiveGetDepthOfRightOffspring(root);
        if (depthOfLeftOffspring >= depthOfRightOffspring) {
            return depthOfLeftOffspring;
        } else {
            return depthOfRightOffspring;
        }
    }

    private void recursiveGetDepthOfLeftOffspring(BinaryTreeNode node) {
        if (node != null) {
            depthOfLeftOffspring++;
            recursiveGetDepthOfLeftOffspring(node.getLeftChild());
        }
    }

    private void recursiveGetDepthOfRightOffspring(BinaryTreeNode node) {
        if (node != null) {
            depthOfRightOffspring++;
            recursiveGetDepthOfRightOffspring(node.getRightChild());
        }
    }

    public void preorderDisplay() {
        recursivePreorderDisplay(root);
    }

    private void recursivePreorderDisplay(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            recursivePreorderDisplay(node.getLeftChild());
            recursivePreorderDisplay(node.getRightChild());
        } else {
            System.out.print("# ");
        }
    }

    public void reset() {
        setIndex(0);
        setDepthOfLeftOffspring(0);
        setDepthOfRightOffspring(0);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    private static void setIndex(int index) {
        BinaryTree.index = index;
    }

    private static void setDepthOfLeftOffspring(int depthOfLeftOffspring) {
        BinaryTree.depthOfLeftOffspring = depthOfLeftOffspring;
    }

    private static void setDepthOfRightOffspring(int depthOfRightOffspring) {
        BinaryTree.depthOfRightOffspring = depthOfRightOffspring;
    }
}
