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
        System.out.println("\n" + "Животное по имени " + name + " бежит");
        if (endurance - distance > 0) {
            endurance = endurance - distance;
            int time = distance / speedRun;
            System.out.println("Животное по имени " + name + " пробежало " + distance + "м. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            endurance = 0;
            System.out.println("У животного с именем " + name + " появилось состоние усталости");
            return -1;
        }
    }

    public void info() {
        System.out.println("У животного по имени " + name + " выносливость " + endurance);
    }

    public abstract int swim(int distance);
}
