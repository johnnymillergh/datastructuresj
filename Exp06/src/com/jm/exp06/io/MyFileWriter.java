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
        String contentString = content.toString();
        System.out.println("contentString length: " + contentString.length());
        try {
            FileWriter writer = new FileWriter("C:/Users/Johnny/Desktop/" + fileName);
            writer.write(contentString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        byte[] bytes = new byte[1024];
//        bytes = contentString.getBytes();
//        try {
//            FileOutputStream in = new FileOutputStream("C:/Users/Johnny/Desktop/"+fileName);
//            try {
//                in.write(bytes, 0, bytes.length);
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
