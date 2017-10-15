package com.jm.exp05;

public class BinaryTree {
    TreeNode root;
    private static int index;
    private static int depthOfLeftOffspring;
    private static int depthOfRightOffspring;

    public BinaryTree(String preOrderSequence) {
        char nodeCharacter = preOrderSequence.charAt(index);
        index++;
        if (nodeCharacter != '#') {
            root = new TreeNode(Character.valueOf(nodeCharacter));
            root.setLeftChild(new BinaryTree(preOrderSequence).getRoot());
            root.setRightChild(new BinaryTree(preOrderSequence).getRoot());
        } else {
            root = null;
        }
    }

    public int getDepth() {
        getDepthOfLeftOffspring(root);
        getDepthOfRightOffspring(root);
        if (depthOfLeftOffspring >= depthOfRightOffspring) {
            return depthOfLeftOffspring;
        } else {
            return depthOfRightOffspring;
        }
    }

    private void getDepthOfLeftOffspring(TreeNode node) {
        if (node != null) {
            depthOfLeftOffspring++;
            getDepthOfLeftOffspring(node.getLeftChild());
        }
    }

    private void getDepthOfRightOffspring(TreeNode node) {
        if (node != null) {
            depthOfRightOffspring++;
            getDepthOfRightOffspring(node.getRightChild());
        }
    }

    public void preorderDisplay() {
        recursivePreorderDisplay(root);
        System.out.println("<END>");
    }

    private void recursivePreorderDisplay(TreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            recursivePreorderDisplay(node.getLeftChild());
            recursivePreorderDisplay(node.getRightChild());
        } else {
            System.out.print("# ");
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


    public void reset() {
        setIndex(0);
        setDepthOfLeftOffspring(0);
        setDepthOfRightOffspring(0);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
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
