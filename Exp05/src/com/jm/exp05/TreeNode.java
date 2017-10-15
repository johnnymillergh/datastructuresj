package com.jm.exp05;

public class TreeNode {
    private Object data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode() {
    }

    public TreeNode(Object data) {
        this.data = data;
    }

    public TreeNode(Object data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
