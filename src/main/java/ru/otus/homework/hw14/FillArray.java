package ru.otus.homework.hw14;

public class FillArray {
    public double[] newArray(int index, double[] array) {

        int start = index * array.length / 4;
        int end = (index + 1) * array.length / 4;

        for (int i = start; i < end; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return array;
    }
}
