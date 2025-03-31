package ru.otus.homework.hw14;

public class MyThread implements Runnable {
    Thread thread;
    static FillArray fillArray = new FillArray();
    double[] array;
    double[] result;
    int index;

    public MyThread(int index, double[] array) {
        thread = new Thread(this);
        this.index = index;
        this.array = array;
    }

    @Override
    public void run() {
        result = fillArray.newArray(index, array);
    }
}

