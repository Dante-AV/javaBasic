package ru.otus.homework.hw05;

public abstract class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int endurance;

    public Animal(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

    public Animal(String name, int speedRun, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.endurance = endurance;
    }

    public abstract int run(int distance);

    public abstract int swim(int distance);

    public void info() {
        System.out.println("У животного по имени " + name + " выносливость: " + endurance);
    }
}
