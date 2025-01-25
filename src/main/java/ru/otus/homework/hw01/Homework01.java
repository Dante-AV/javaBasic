package ru.otus.homework.hw01;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        System.out.println("Введите число от 1 до 5");
        Scanner scanner = new Scanner(System.in);
        int num;

        while (scanner.hasNextInt()) {
            Random random = new Random();
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    greetings();
                    break;
                case 2:
                    checkSign((int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10));
                    break;
                case 3:
                    selectColor();
                    break;
                case 4:
                    compareNumbers();
                    break;
                case 5:
                    addOrSubtractAndPrint((int) (Math.random() * 10), (int) (Math.random() * 10), random.nextBoolean());
                    break;
                default:
                    System.out.println("Некорректное значение. Введите число от 1 до 5");
                    break;
            }
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println(a + b + c > 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void selectColor() {
        int data = (int) (Math.random() * 100);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println(increment ? initValue + delta : initValue - delta);
    }
}