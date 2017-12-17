package com.jm.exp10and11;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("<Exp10-01>");
        int[] data = {0, -2, 11, -4, 13, -5, -2};
        MaximalSubductionSum maximalSubductionSum = new MaximalSubductionSum(data);
        maximalSubductionSum.go();
        maximalSubductionSum.display();

        System.out.println("<Exp11-01>");
    }
}
