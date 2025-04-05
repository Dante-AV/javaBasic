package ru.otus.homework.hw14;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        var time = System.currentTimeMillis();
        double[] array = new double[100000000];

        MyThread[] threads = new MyThread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new MyThread(i, array);
            threads[i].thread.start();
        }

        for (MyThread t : threads) {
            t.thread.join();
        }

        System.out.println(System.currentTimeMillis() - time);
    }
}
