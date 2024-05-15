package ru.otus.homework.hw05.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
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
