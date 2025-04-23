package ru.otus.homework.hw18;

import java.util.ArrayList;

public class Box<T extends Fruit> implements Comparable<Box<? extends Fruit>> {
    ArrayList<T> fruits = new ArrayList<>();

    public Box() {
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double weightOfBox() {
        double weight = 0.0;
        if (!fruits.isEmpty()) {
            for (T fruit : fruits) {
                weight += fruit.getWeight();
            }
        }
        return weight;
    }

    public void transferTo(Box<T> box2) {
        if (!fruits.isEmpty()) {
            for (T fruit : fruits) {
                box2.addFruit(fruit);
            }
            this.fruits.clear();
            System.out.println("Перемещение фруктов выполнено успешно");
        }
    }

    @Override
    public int compareTo(Box<? extends Fruit> box) {
        if ((this.weightOfBox() - box.weightOfBox()) < 0.0001){
            return 0;
        } else if ((this.weightOfBox() - box.weightOfBox()) >0.0001){
            return 1;
        } else{
            return -1;
        }
    }
}
