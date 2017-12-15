package com.jm.exp06.operation;

import com.jm.exp06.huffmantree.SequentialStack;
import com.jm.exp06.io.HuffmanTreeHelper;
import com.jm.exp06.huffmantree.SequentialHuffmanTree;

import java.util.Vector;

public class Encoder {
    SequentialHuffmanTree huffmanTree;
    HuffmanTreeHelper helper;
    StringBuffer encodedContent;
    SequentialStack stack;

    public Encoder(SequentialHuffmanTree huffmanTree, HuffmanTreeHelper helper) {
        this.huffmanTree = huffmanTree;
        this.helper = helper;
        stack = new SequentialStack(100);
        encodedContent = new StringBuffer("");
    }

    public void encode() {
        String content = helper.getContent();
        Vector<SequentialHuffmanTree.Node> nodes = huffmanTree.getNodes();
        SequentialHuffmanTree.Node tempNode;
        char leafCharacter;
        int childIndex;
        int parentIndex;

        for (int i = 0; i < content.length(); i++) {
            leafCharacter = content.charAt(i);
            childIndex = huffmanTree.findLeafNodeByData(leafCharacter);
            tempNode = nodes.get(childIndex);
            while (true) {
                parentIndex = tempNode.getParentIndex();
                if (parentIndex != 0) {
                    tempNode = nodes.get(parentIndex);
                    if (childIndex == tempNode.getLeftChildIndex()) {
                        try {
                            stack.push(new Integer(0));
                            childIndex = parentIndex;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (childIndex == tempNode.getRightChildIndex()) {
                        try {
                            stack.push(new Integer(1));
                            childIndex = parentIndex;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (parentIndex == 0) {
                    tempNode = nodes.get(nodes.size() - 1);
                    if (childIndex == tempNode.getLeftChildIndex()) try {
                        stack.push(new Integer(0));
                        childIndex = parentIndex;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    else if (childIndex == tempNode.getRightChildIndex()) {
                        try {
                            stack.push(new Integer(1));
                            childIndex = parentIndex;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }

            // Get reversed code bu popping stack.
            while (true) {
                if (!stack.isEmpty()) {
                    try {
                        encodedContent.append(stack.pop());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
            if (i == content.length() - 1) {
                System.out.println("Encoded character " + (i + 1) + " times.");
            }
        }
    }

    public void displayEncodedContent() {
        System.out.println("Encoded content length: " + encodedContent.length());
        System.out.println("Cypher text (0-100): " + encodedContent.substring(0, 100));
    }

    public StringBuffer getEncodedContent() {
        return encodedContent;
    }
}
