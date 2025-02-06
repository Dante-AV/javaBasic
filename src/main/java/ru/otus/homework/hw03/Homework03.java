package ru.otus.homework.hw03;

import java.util.Arrays;

public class Homework03 {
    public static void main(String[] args) {
        System.out.println(sumOfPositiveElements(new int[][]{{-1, 2, -3}, {4, -5, 6}}));
        squareOfSymbols(4);

        int[][] array = new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        diagonalElementsinArray(array);
        print(array);

        System.out.println(findMax(new int[][]{{0, 2, 3, 4}, {1, 2, 30, 4}}));
        System.out.println(sumElements(new int[][]{{1, 2, 3, 4}, {10, 20, 30, 40}}));
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

    public static void squareOfSymbols(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
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
                max = Math.max(max, array[i][j]);
            }
        }
        return max;
    }

    public static int sumElements(int[][] array) {
        if (array.length < 2) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }
        return sum;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}