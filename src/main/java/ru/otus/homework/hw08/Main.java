package ru.otus.homework.hw08;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            int result = sumElements(array);
            System.out.println(result);
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage() + e.getElementInArray());
        }
    }

    public static int sumElements(String[][] array) {
        int num = 0;
        int sum = 0;
        for (String[] row : array) {
            if (row.length != 4) {
                throw new AppArraySizeException("Массив другого размера, не 4х4");
            } else {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        try {
                            if (array[i][j] == null) {
                                throw new AppArrayDataException(String.format("Null в ячейке [%d][%d]", i, j), array[i][j].indexOf(array[i][j]));
                            }
                            num = Integer.parseInt(array[i][j]);
                            sum += num;
                        } catch (NumberFormatException e) {
                            throw new AppArrayDataException("Некорректные данные лежат в ячейке под номером ", num);
                        }
                    }
                }
            }
        }
        return sum;
    }
}
