package ru.otus.homework.hw06;

public class Plate {
    private final int maxAmountFood;
    private int currentAmountFood;

    public Plate(int maxAmountFood, int currentAmountFood) {
        this.maxAmountFood = maxAmountFood;
        this.currentAmountFood = currentAmountFood;
    }

    public void addFood() {
        if (currentAmountFood < maxAmountFood) {
            currentAmountFood = maxAmountFood;
            System.out.println("В тарелку добавили еды. Теперь в тарелке " + maxAmountFood);
        } else {
            System.out.println("В тарелку не добавлено еды, в тарелке еды много: " + maxAmountFood);
        }
    }

    public boolean removeFood(int appetite) {
        if (currentAmountFood >= 0 && currentAmountFood >= appetite) {
            currentAmountFood = currentAmountFood - appetite;
            System.out.println("В тарелке осталось " + currentAmountFood + " еды");
            return true;
        } else {
            return false;
        }
    }
}
