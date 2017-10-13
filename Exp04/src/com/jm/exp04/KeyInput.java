package com.jm.exp04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyInput {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    public static int readInt() {
        int i = 0;
        try {
            i = Integer.parseInt(readString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    public static float readFloat() {
        float f = 0.0f;
        try {
            f = Float.parseFloat(readString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static double readDouble() {
        double d = 0.0;
        try {
            d = Double.parseDouble(readString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return d;
    }

    public static String readString() {
        String s = "";
        try {
            s = br.readLine();
            if (s.length() == 0)
                s = br.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public static boolean readBoolean() {
        if (readString().toUpperCase().equals("TRUE"))
            return true;
        else
            return false;
    }

    public static char readChar() {
        try {
            return readString().charAt(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ' ';
    }

    public static void main(String args[]) {
        System.out.print("Please input an integer number:");
        System.out.println("Your input is " + KeyInput.readInt());
        System.out.print("Please input a float number:");
        System.out.println("Your input is " + KeyInput.readFloat());
        System.out.print("Please input a double number:");
        System.out.println("Your input is " + KeyInput.readDouble());
        System.out.print("Please input a string:");
        System.out.println("Your input is " + KeyInput.readString());
        System.out.print("Please input a boolean value:");
        System.out.println("Your input is " + KeyInput.readBoolean());
        System.out.print("Please input a char:");
        System.out.println("Your input is " + KeyInput.readChar());
    }
}
