package ru.otus.homework.hw05;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public int run(int distance) {
        int time = distance / speedRun;
        endurance = endurance - distance;
        System.out.println("\n" + "Лошадь по имени " + name + " бежит");
        if (endurance - distance > 0) {
            System.out.println("Лошадь по имени " + name + " пробежало " + distance + "м. за время " + time + "сек. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            System.out.println("У лошади по имени " + name + "появилось состояние усталости");
            return -1;
        }
    }

    @Override
    public int swim(int distance) {
        int time = distance / speedSwim;
        endurance = endurance - distance * 4;
        System.out.println("\n" + "Лошадь по имени " + name + " плывет");
        if (endurance > 0) {
            System.out.println("Лошадь по имени " + name + " проплыло " + distance + "м. за время " + time + "сек. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            System.out.println("У лошади по имени " + name + " появилось состояние усталости, проплыть не удалось");
            return -1;
        }
    }
}
