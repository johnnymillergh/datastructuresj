package com.jm.exp06.io;

import java.io.*;

public class MyFileWriter {
    String fileName;
    StringBuffer content;

    public MyFileWriter(String fileName) {
        this.fileName = fileName;
    }

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

    public void write(Object o) {
        try {
            FileOutputStream outStream = new FileOutputStream("C:/Users/Johnny/Desktop/" + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
            objectOutputStream.writeObject(o);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
