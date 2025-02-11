package ru.otus.homework.hw05;

import ru.otus.homework.hw05.animals.Cat;
import ru.otus.homework.hw05.animals.Dog;
import ru.otus.homework.hw05.animals.Horse;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 3, 5);
        Dog dog = new Dog("Шарик", 5, 7, 9);
        Horse horse = new Horse("Джек", 10, 10, 20);

        cat.run(2);
        cat.info();
        cat.swim(2);

        dog.run(5);
        dog.info();
        dog.swim(2);
        dog.info();

        horse.run(15);
        horse.info();
        horse.swim(2);
        horse.info();
    }
}
