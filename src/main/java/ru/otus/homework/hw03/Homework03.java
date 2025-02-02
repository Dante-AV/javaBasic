package ru.otus.homework.hw03;

public class Homework03 {
    public static void main(String[] args) {
        System.out.println(sumOfPositiveElements(new int[][]{{-1, 2, -3}, {4, -5, 6}}));
        squareOfSymbols(4);
        diagonalElementsinArray(new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}});
        findMax(new int[][]{{0, 2, 3, 4}, {1, 2, 30, 4}});
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
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalElementsinArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][i] = 0;
                array[i][array.length - i - 1] = 0;
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                max = Math.max(max, array[i][j]);
            }
        }
        System.out.println(max);
    }

    public static int sumElements(int[][] array) {
        if (array.length < 2) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < array[1].length; i++) {
            sum += array[array.length - 1][i];
        }
        return sum;
    }
}