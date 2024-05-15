package ru.otus.homework.hw05.animals;

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

    public int run(int distance) {
        int time = distance / speedRun;
        endurance = endurance - distance;
        System.out.println("\n" + "Животное по имени " + name + " бежит");
        if (endurance - distance > 0) {
            System.out.println("Животное по имени " + name + " пробежало " + distance + "м. за время " + time + "сек. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            System.out.println("У животного по имени " + name + "появилось состояние усталости");
            return -1;
        }
    }

    public abstract int swim(int distance);

    public void info() {
        System.out.println("У животного по имени " + name + " выносливость: " + endurance);
    }
}
