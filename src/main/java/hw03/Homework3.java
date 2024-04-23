package hw03;

public class Homework3 {
    public static void main(String[] args) {
        int sumElements = sumOfPositiveElements(new int[][]{{-1, -2, 3}, {1, -2, 3}});
        System.out.println(sumElements);
        printSquare(4);
        diagonalElementsinArray(new int[6][6]);
        int maxElement = findMax(new int[][]{{-1, 999, 3}, {1, -2, 3}});
        System.out.println(maxElement);
        int sum = sumElementsRow(new int[][]{{-1, 999, 3}, {-1, 9, 3, 10}});
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
        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = '*';
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalElementsinArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i == j) ? 0 : i + j;
                array[i][array.length - i - 1] = 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                max = Math.max(array[i][j], max);
            }
        }
        return max;
    }

    public static int sumElementsRow(int[][] array) {
        int sum = 0;
        if (array[1].length == 0) {
            return -1;
        } else {
            for (int j = 0; j < array[1].length; j++) {
                sum += array[1][j];
            }
        }
        return sum;
    }
}
