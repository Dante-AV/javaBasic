package ru.otus.homework.hw11;

public class SortArray {
    public static void bubbleSort(int[] array) {
        int arr;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    arr = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = arr;
                }
            }
        }
    }

    public static void quickSort(int[] array, int first, int last) {
        if (first < last) {
            int pi = partition(array, first, last);

            quickSort(array, first, pi - 1);
            quickSort(array, pi + 1, last);
        }
    }

    private static int partition(int[] array, int first, int last) {
        int pivot = array[last];
        int i = (first - 1);
        for (int j = first; j < last; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[last];
        array[last] = temp;

        return i + 1;
    }
}
