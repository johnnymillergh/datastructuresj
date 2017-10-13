package com.jm.exp05;

public class BinaryTree {
    BinaryTreeNode root;

    private static int index = 0;

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
        return false;
    }

    public int getDepth() {

        return 0;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}
