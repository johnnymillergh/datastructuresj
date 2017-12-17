package com.jm.exp10and11;

public class KnapsackProblem {
    private float[] weight;
    private float[] value;
    private float capacity;
    private float[] packedItemProportion;
    private float sum;

    public KnapsackProblem(float[] value, float[] weight, int capacity) {
        this.value = value;
        this.weight = weight;
        this.capacity = capacity;
        packedItemProportion = new float[weight.length];
    }

    public void go() {
        float[] valueWeightRatio = new float[weight.length];
        for (int i = 0; i < weight.length; i++) {
            valueWeightRatio[i] = value[i] / weight[i];
        }

        float maxValueWeightRatio;
        int itemIndex = -1;
        int iterator = 0;
        while (true) {
            if (capacity == 0) {
                break;
            }
            maxValueWeightRatio = 0;
            for (int i = 0; i < valueWeightRatio.length; i++) {
                if (valueWeightRatio[i] > maxValueWeightRatio) {
                    maxValueWeightRatio = valueWeightRatio[i];
                    itemIndex = i;
                    valueWeightRatio[i] = 0;
                }
            }
            if (capacity >= weight[itemIndex]) {
//                packedItem[iterator] = itemIndex;
                packedItemProportion[iterator] = 1;
                capacity = capacity - weight[itemIndex];
            } else {
                packedItemProportion[iterator] = capacity / weight[itemIndex];
                capacity = capacity - capacity;
            }
            iterator++;
        }
    }

    public void display() {
        System.out.print("Packed item proportion: ");
        for (float f : packedItemProportion) {
            System.out.print(f + " ");
        }
        System.out.print("\nTotal value: ");
        for (int i = 0; i < packedItemProportion.length; i++) {
            sum += packedItemProportion[i] * value[i];
        }
        System.out.print(sum + "\n");
    }
}
