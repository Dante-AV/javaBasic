package ru.otus.homework.hw02;

import java.util.Arrays;

public class Homework02 {
    public static void main(String[] args) {
        printText(5, "Homework");
        printSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        fillArray(1, new int[6]);
        incrementElements(2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        compareAndPrint(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        sumArrays(new int[]{1, 2, 3}, new int[]{2, 2}, new int[]{1, 1, 1, 1, 1});
        reverseElements(new int[]{1, 2, 3, 4, 5});
        sortElements(new int[]{1, 2, 3, 4, 5});
        compareSumElements(new int[]{2, 2, 1, 1, 2});
    }

    public static void printText(int num, String str) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public static void printSum(int[] array) {
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
        System.out.println(Arrays.toString(array));
    }

    public static void incrementElements(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += num;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void compareAndPrint(int[] array) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum1 += array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            sum2 += array[i];
        }
        System.out.println(sum1 > sum2 ? "Сумма элементов из первой половины массива больше" : "Сумма элементов из второй половины массива больше");
    }

    public static void sumArrays(int[] arr1, int[] arr2, int[] arr3) {
        int maxLength = Math.max(Math.max(arr1.length, arr2.length), arr3.length);
        int[] arr4 = new int[maxLength];

        for (int i = 0; i < arr4.length; i++) {
            if (i < arr1.length) {
                arr4[i] += arr1[i];
            }
            if (i < arr2.length) {
                arr4[i] += arr2[i];
            }
            if (i < arr3.length) {
                arr4[i] += arr3[i];
            }
        }
        System.out.println(Arrays.toString(arr4));
    }

    public static void sortElements(int[] array) {
        String str;
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            str = "Да";
        } else {
            str = "Нет";
        }
        System.out.println("Является ли массив возрастающей последовательностью? " + str);
    }

    public static void reverseElements(int[] array) {
        int num;
        for (int i = 0, j = array.length - 1; i <= array.length / 2; i++, j--) {
            num = array[i];
            array[i] = array[j];
            array[j] = num;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void compareSumElements(int[] array) {
        int totalSum = 0;

        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }

        int leftSum = array[0];
        int rightSum = totalSum - array[0];

        for (int i = 0; i < array.length; i++) {
            if (leftSum == rightSum) {
                System.out.println("Точка в массиве найдена, индекс элемента = " + i);
                return;
            } else {
                leftSum += array[i];
                rightSum -= array[i];
            }
        }
        System.out.println("Точки в массиве нет");
    }
}