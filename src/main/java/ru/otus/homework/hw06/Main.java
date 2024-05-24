package ru.otus.homework.hw06;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 25),
                new Cat("Pushok", 20),
                new Cat("Felix", 30),
                new Cat("Oskar", 40)};

        Plate plate = new Plate(55, 55);

        for (var cat : cats) {
            cat.eat(plate);
            cat.printInfo();
            plate.addFood();
        }

    }
}
