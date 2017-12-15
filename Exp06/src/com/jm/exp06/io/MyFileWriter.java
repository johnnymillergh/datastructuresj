package com.jm.exp06.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    String fileName;
    StringBuffer content;

    public MyFileWriter(String fileName, StringBuffer content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void write() {
        String str = content.toString();
        System.out.println("str length: " + str.length());
        byte bt[] = new byte[1024];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream("C:/Users/Johnny/Desktop/"+fileName);
            try {
                in.write(bt, 0, bt.length);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
