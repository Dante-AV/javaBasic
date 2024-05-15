package ru.otus.homework.hw05.animals;

public class Dog extends Animal {
    public Dog(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }


    @Override
    public int swim(int distance) {
        int time = distance / speedSwim;
        endurance = endurance - distance * 2;
        System.out.println("\n" + "Собака по имени " + name + " плывет");
        if (endurance > 0) {
            System.out.println("Собака по имени " + name + " проплыло " + distance + "м. за время " + time + "сек. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            System.out.println("У собаки по имени " + name + " появилось состояние усталости, проплыть не удалось");
            return -1;
        }
    }
}
