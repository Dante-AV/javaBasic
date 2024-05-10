package ru.otus.homework.hw05;

public class Cat extends Animal {
    public Cat(String name, int speedRun, int endurance) {
        super(name, speedRun, endurance);
    }

    @Override
    public int run(int distance) {
        int time = distance / speedRun;
        endurance = endurance - distance;
        System.out.println("\n" + "Кот по имени " + name + " бежит");
        if (endurance - distance > 0) {
            System.out.println("Кот по имени " + name + " пробежало " + distance + "м. за время " + time + "сек. со скоростью " + speedRun + "м/c");
            return time;
        } else {
            System.out.println("У кота по имени " + name + "появилось состояние усталости");
            return -1;
        }
    }

    @Override
    public int swim(int distance) {
        System.out.println("Кот плавать не умеет \n");
        return 0;
    }
}
