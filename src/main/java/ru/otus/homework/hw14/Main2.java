package ru.otus.homework.hw14;

public class Main2 {
    public static void main(String[] args) {
        var time = System.currentTimeMillis();
        double[] array = new double[100000000];

        MyThread.createAndStart(0, array);
        MyThread.createAndStart(1, array);
        MyThread.createAndStart(2, array);
        MyThread.createAndStart(3, array);

        System.out.println(System.currentTimeMillis() - time);
    }
}
