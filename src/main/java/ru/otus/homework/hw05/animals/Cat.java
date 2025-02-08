package ru.otus.homework.hw05.animals;

public class Cat extends Animal{

    public Cat(String name, int speedRun, int endurance) {
        super(name, speedRun, endurance);
    }

    @Override
    public int swim(int distance) {
        System.out.println("Кот плавать не умеет");
        return 0;
    }
}
