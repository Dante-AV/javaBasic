package ru.otus.homework.hw06;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        System.out.println("Кот " + name + " ест");
        if (plate.removeFood(appetite)) {
            this.satiety = true;
        }
    }

    public void printInfo() {
        if (isSatiety()) {
            System.out.println("Кот " + name + " сыт");
        } else {
            System.out.println("Коту " + name + " мало еды");
        }
    }

}
