package ru.otus.homework.hw05;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 2, 20);
        Dog dog = new Dog("Джек", 3, 3, 30);
        Horse horse = new Horse("Джесси", 5, 5, 40);

        cat.run(5);
        cat.info();
        dog.run(10);
        dog.info();
        dog.swim(10);
        dog.info();

        horse.run(10);
        horse.info();
        horse.swim(10);
        horse.info();
    }
}
