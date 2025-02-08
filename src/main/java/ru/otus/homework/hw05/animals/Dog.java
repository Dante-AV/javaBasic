package ru.otus.homework.hw05.animals;

public class Dog extends Animal {
    public Dog(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public int swim(int distance) {
        System.out.println("\n" + "Собака по имени " + name + " плывет");
        endurance = endurance - distance * 2;
        if (endurance > 0) {
            int time = distance / speedRun;
            System.out.println("Собавка по имени " + name + " проплыла " + distance + "м. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            System.out.println("У собаки с именем " + name + " появилось состоние усталости");
            return -1;
        }
    }
}
