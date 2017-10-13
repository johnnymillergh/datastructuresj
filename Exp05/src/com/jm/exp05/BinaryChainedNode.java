package com.jm.exp05;

public class BinaryChainedNode {
    private Object data;
    private BinaryChainedNode leftChild;
    private BinaryChainedNode rightChild;

    public BinaryChainedNode() {
    }

    public BinaryChainedNode(Object data) {
        this.data = data;
    }

    public BinaryChainedNode(Object data, BinaryChainedNode leftChild, BinaryChainedNode rightChild) {
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

    public BinaryChainedNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryChainedNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryChainedNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryChainedNode rightChild) {
        this.rightChild = rightChild;
    }
}
