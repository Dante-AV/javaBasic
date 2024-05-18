package ru.otus.homework.hw06;

public class Plate {


    private final int maxFoodQuanity;
    private int currentFoodQuanity;


    public int getCurrentFoodQuanity() {
        return currentFoodQuanity;
    }

    public Plate(int maxFoodQuanity, int currentFoodQuanity) {
        this.maxFoodQuanity = maxFoodQuanity;
        this.currentFoodQuanity = currentFoodQuanity;
    }

    public void addFood() {
        if (currentFoodQuanity < maxFoodQuanity) {
            currentFoodQuanity = maxFoodQuanity;
            System.out.println("В тарелку добавили еды. Теперь в тарелке " + maxFoodQuanity + " еды");
        } else {
            System.out.println("В тарелке максимальное количество еды - " + maxFoodQuanity);
        }
    }

    public boolean removeFood(int appetite) {
        if (currentFoodQuanity - appetite >= 0) {
            currentFoodQuanity = currentFoodQuanity - appetite;
            return true;
        } else {
            return false;
        }
    }
}
