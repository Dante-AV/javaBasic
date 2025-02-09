package ru.otus.homework.hw05.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public int swim(int distance) {
        System.out.println("\n" + "Лошадь по имени " + name + " плывет");
        if (endurance - distance * 4 > 0) {
            endurance = endurance - distance * 4;
            int time = distance / speedRun;
            System.out.println("Лошадь по имени " + name + " проплыла " + distance + "м. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            endurance = 0;
            System.out.println("У лошади с именем " + name + " появилось состоние усталости");
            return -1;
        }
    }
}
