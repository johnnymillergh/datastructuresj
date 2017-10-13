package com.jm.exp05;

import javax.swing.tree.TreeNode;
import java.util.Vector;

public class SequentialBinaryTree {
    private Vector<TreeNode> treeElements;

    public SequentialBinaryTree(int initialCapacity, int capacityIncrement) {
        treeElements = new Vector<>(initialCapacity, capacityIncrement);
    }

    public void init() {
        Character dataInput;
        while (true) {
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() != '#') {
                treeElements.addElement(new TreeNode(dataInput));
            } else {
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < treeElements.size(); i++) {
            System.out.print(treeElements.get(i).data + " ");
        }
        System.out.println("<END>");
    }

    public Vector<TreeNode> getTreeElements() {
        return treeElements;
    }

    private class TreeNode {
        private Object data;

        public TreeNode(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
