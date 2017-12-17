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
        float[] value = {3, 5, 1, 2};
        float[] weight = {4, 8, 3, 10};
        KnapsackProblem knapsackProblem = new KnapsackProblem(value, weight, 20);
        knapsackProblem.go();
        knapsackProblem.display();
    }
}
