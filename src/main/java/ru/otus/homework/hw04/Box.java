package ru.otus.homework.hw04;

public class Box {
    private final int length;
    private final int width;
    private final int height;
    public String color;
    private String item;
    private boolean isOpenBox;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void changeColor(String color) {
        setColor(color);
        System.out.println("Цвет коробки изменен на " + color);
    }

    public void openBox() {
        this.isOpenBox = true;
        System.out.println("Коробку открыли");
    }

    public void closeBox() {
        this.isOpenBox = false;
        System.out.println("Коробку закрыли");
    }

    public void printBoxInfo() {
        System.out.println("Длина коробки: " + length + " Ширина коробки: " + width + " Высота коробки: " + height + " Цвет коробки: " + color + (isOpenBox ? ". Коробка открыта" : ". Коробка закрыта") + (this.item != null ? ". В коробке лежит " + this.item : ". В коробке нет предмета") + "\n");
    }

    public void putItem(String item) {
        if (isOpenBox && item == null) {
            setItem(item);
        } else {
            System.out.println(isOpenBox ? "В коробку нельзя положить новый предмет " + item + ".В коробке уже лежит предмет - " + this.item : "В коробку нельзя положить предмет " + item + ", коробка закрыта ");
        }
    }

    public void throwOutItem() {
        if (isOpenBox && item != null) {
            System.out.println("Из коробки выкинули предмет " + item);
            item = null;
        } else {
            System.out.println(isOpenBox ? "Из коробки нельзя выкинуть предмет, потому что в коробке нет ни одного предмета" : "Из коробки нельзя выкинуть " + item + ", потому что коробка закрыта");
        }
    }
}
