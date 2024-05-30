package ru.otus.homework.hw08;

public class AppArrayDataException extends RuntimeException {
    private final int number;

    public int getElementInArray() {
        return number;
    }

    public AppArrayDataException(String message, int num) {
        super(message);
        number = num;
    }
}
