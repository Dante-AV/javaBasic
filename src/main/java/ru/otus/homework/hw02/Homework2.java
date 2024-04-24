package ru.otus.homework.hw02;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        printLine(10, "Новая строка");
        sumElements(new int[]{1, 5, 6, 7, 9, 10, 8, 2});
        fillArray(1, new int[10]);
        incrementOperation(1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        compareAndPrint(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        /*
        sumArrays - ДЗ из презентации
        Реализуйте метод, принимающий на вход набор целочисленных массивов, и получающий новый массив равный сумме входящих;
        Пример: { 1, 2, 3 }
                 + { 2, 2 }
                 + { 1, 1, 1, 1, 1}
                 = { 4, 5, 4, 1, 1 }
        */
        sumArrays(new int[]{1, 2, 3}, new int[]{2, 2}, new int[]{1, 1, 1, 1, 1});
        /*
        Реализуйте метод, “переворачивающий” входящий массив
        Пример: { 1 2 3 4 } => { 4 3 2 1 }
         */
        reverseArray(new int[]{1, 2, 3, 4, 5});
    }

    public static void printLine(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void sumElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }

    public static void fillArray(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
        }
        System.out.print(Arrays.toString(array));
        System.out.println();
    }

    public static void incrementOperation(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += num;
            System.out.println(array[i]);
        }
    }

    public static void compareAndPrint(int[] array) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum += array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            sum2 += array[i];
        }

        System.out.println(sum > sum2 ? "Сумма элементов из первой половины массива больше" : "Сумма элементов из второй половины массива больше");
    }

    public static void sumArrays(int[] arr1, int[] arr2, int[] arr3) {
        int maxLength = Math.max(arr3.length, Math.max(arr1.length, arr2.length));
        int[] newArray = new int[maxLength];

        for (int i = 0; i < newArray.length; i++) {
            if (i < arr1.length) {
                newArray[i] += arr1[i];
            }
            if (i < arr2.length) {
                newArray[i] += arr2[i];
            }
            if (i < arr3.length) {
                newArray[i] += arr3[i];
            }
        }
        System.out.print(Arrays.toString(newArray) + "\n");
    }

    public static void reverseArray(int[] array) {
        int min;
        for (int i = 0, j = array.length - 1; i <= array.length / 2; i++, j--) {
            min = array[i];
            array[i] = array[j];
            array[j] = min;
        }
        System.out.println(Arrays.toString(array));
    }
}
