package com.jm.exp10and11;

public class KnapsackProblem {
    private int[] weight;
    private int[] value;
    private int capacity;
    private int[] itemNumber;
    private float[] proportion;
    private float sum;

    public KnapsackProblem(int[] weight, int[] value, int capacity) {
        this.weight = weight;
        this.value = value;
        this.capacity = capacity;
        itemNumber = new int[weight.length];
        proportion = new float[weight.length];
    }

    public void go() {
        float[] valueWeightRatio = new float[weight.length];
        for (int i = 0; i < weight.length; i++) {
            valueWeightRatio[i] = value[i] / weight[i];
        }
    }
}
