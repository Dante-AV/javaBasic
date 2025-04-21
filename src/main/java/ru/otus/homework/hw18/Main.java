package ru.otus.homework.hw18;

public class Main {
    public static void main(String[] args) {
        Box<Orange> boxOrange = new Box<>();
        Box<Apple> boxApple = new Box<>();
        Box<Fruit> boxFruit = new Box<>();

        boxOrange.addFruit(new Orange(4));
        boxOrange.addFruit(new Orange(2));
        boxApple.addFruit(new Apple(1));
        boxApple.addFruit(new Apple(1));

        boxFruit.addFruit(new Apple(2));
        boxFruit.addFruit(new Orange(4));

        System.out.println("Вес коробки с апельсинами = " + boxOrange.weightOfBox());
        System.out.println("Вес коробки с яблоками = " + boxApple.weightOfBox());
        System.out.println("Вес коробки со всеми фруктами = " + boxFruit.weightOfBox());

        System.out.println("Вес коробки с апельсинами равен весу коробки с яблоками? " + boxOrange.compareTo(boxApple));
        System.out.println("Вес коробки с яблоками равен весу коробки со всеми фруктами? " + boxFruit.compareTo(boxApple));

        Box<Orange> newOrangeBox = new Box<>();

        boxOrange.transferTo(newOrangeBox);
        System.out.println("Вес коробки с апельсинами после пересыпания = " + boxOrange.weightOfBox());
        System.out.println("Вес коробки с апельсинами, куда пересыпали апельсины = " + newOrangeBox.weightOfBox());
        System.out.println("Вес коробки с яблоками = " + boxApple.weightOfBox());
        System.out.println("Вес коробки со всеми фруктами = " + boxFruit.weightOfBox());
    }
}
