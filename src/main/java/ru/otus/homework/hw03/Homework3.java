package ru.otus.homework.hw03;

import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
        int sumElements = sumOfPositiveElements(new int[][]{{-1, -2, 3}, {1, -2, 3}});
        System.out.println(sumElements);

        printSquare(4);

        int[][] array = new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        diagonalElementsinArray(array);
        print(array);

        int maxElement = findMax(new int[][]{{-1, 999, 3}, {1, -2, 3}});
        System.out.println(maxElement);

        int sum = sumElementsRow(new int[][]{{-1, 999, 3}});
        System.out.println(sum);
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalElementsinArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 0;
            array[i][array.length - i - 1] = 0;
        }
    }


    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                max = Math.max(array[i][j], max);
            }
        }
        return max;
    }

    public static int sumElementsRow(int[][] array) {
        if (array.length < 2) {
            return -1;
        }

        int sum = 0;
        for (int j = 0; j < array[1].length; j++) {
            sum += array[1][j];
        }
        return sum;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
