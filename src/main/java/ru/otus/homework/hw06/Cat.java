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

    public void printInfo(Plate plate) {
        if (isSatiety()) {
            System.out.println("Кот " + name + " сыт. В тарелке осталось " + plate.getCurrentFoodQuanity() + " кусков еды");
        } else {
            System.out.println("Коту " + name + " мало еды, в тарелке " + plate.getCurrentFoodQuanity() + " кусков еды");
        }
    }
}
