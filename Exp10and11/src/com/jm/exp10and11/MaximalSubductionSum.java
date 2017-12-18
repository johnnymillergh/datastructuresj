package com.jm.exp10and11;

public class MaximalSubductionSum {
    private int[] data;
    private int[] workArray;
    private int maximalSum;
    private int[] bestIndex = new int[2];

    public MaximalSubductionSum(int[] data) {
        this.data = data;
        workArray = new int[data.length];
        workArray[0] = 0;
    }

    public void go() {
        int i = 0, j, bestI = 0, bestJ = 0;
        for (j = 1; j < data.length; j++) {
            if (workArray[j - 1] <= 0) {
                workArray[j] = data[j];
                i++;
                if (data[j] > 0) {
                    maximalSum = data[j];
                    bestI = i;
                    bestJ = j;
                }
            } else {
                workArray[j] = workArray[j - 1] + data[j];
                if (workArray[j] > maximalSum) {
                    maximalSum = workArray[j];
                    bestJ = j;
                }
            }
        }
        bestIndex[0] = bestI;
        bestIndex[1] = bestJ;
    }

    public void display() {
        System.out.println("Best index: " + bestIndex[0] + " to " + bestIndex[1]);
        System.out.println("Maximal subduction sum: " + maximalSum);
    }
}
