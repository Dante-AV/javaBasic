package ru.otus.homework.hw14;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        var time = System.currentTimeMillis();
        double[] array = new double[100000000];

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        thread1.start();

        System.out.println(System.currentTimeMillis() - time);

    }
}
