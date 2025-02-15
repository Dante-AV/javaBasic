package ru.otus.homework.hw06;


public class Main {
    public static void main(String[] args) {

        Cat[] cats = {new Cat("Барсик", 25),
                new Cat("Пушок", 20),
                new Cat("Феликс", 30),
                new Cat("Оскар", 40)};

        Plate plate = new Plate(50, 50);

        for (var cat : cats) {
            cat.eat(plate);
            cat.printInfo();
            plate.addFood();
        }
    }
}
