package com.jm.exp06.operation;

import com.jm.exp06.io.HuffmanTreeHelper;
import com.jm.exp06.huffmantree.SequentialHuffmanTree;

public class Encoder {
    SequentialHuffmanTree huffmanTree;
    HuffmanTreeHelper helper;
    String encodedContent;

    public Encoder(SequentialHuffmanTree huffmanTree, HuffmanTreeHelper helper) {
        this.huffmanTree = huffmanTree;
        this.helper = helper;
    }

    public void encode() {

    }
}
