package ru.otus.homework.hw20;

import java.util.concurrent.*;

public class Main {
    Boolean flagA = false;
    Boolean flagB = false;
    Boolean flagC = true;
    int counterA = 0;
    int counterB = 0;
    int counterC = 0;

    public static void main(String[] args) {
        Main main = new Main();
        ExecutorService serv = Executors.newFixedThreadPool(3);
        serv.execute(() -> {
            while (main.counterA < 5) {
                main.printLetterA();
            }
        });
        serv.execute(() -> {
            while (main.counterB < 5) {
                main.printLetterB();
            }
        });
        serv.execute(() -> {
            while (main.counterC < 5) {
                main.printLetterC();
            }
        });
        serv.shutdown();
    }

    public void printLetterA() {
        synchronized (this) {
            if (flagC) {
                System.out.print("A");
                counterA++;
                flagA = true;
                flagC = false;
            }
        }
    }

    public void printLetterB() {
        synchronized (this) {
            if (flagA) {
                System.out.print("B");
                counterB++;
                flagB = true;
                flagA = false;
            }
        }
    }

    public void printLetterC() {
        synchronized (this) {
            if (flagB) {
                System.out.print("C");
                counterC++;
                flagC = true;
                flagA = false;
                flagB = false;
            }
        }
    }
}
