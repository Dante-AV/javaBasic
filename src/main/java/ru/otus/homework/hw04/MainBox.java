package ru.otus.homework.hw04;

public class MainBox {
    public static void main(String[] args) {
        var newBox = new Box(20, 20, 20, "White");

        // Печать информации о коробке и изменение цвета
        newBox.printBoxInfo();
        newBox.changeColor("Black");
        newBox.printBoxInfo();

        //Сложить предмет в коробку(коробка закрыта/коробка открыта/в коробке уже лежит предмет)
        newBox.closeBox();
        newBox.putItem("Мяч");
        newBox.printBoxInfo();
        newBox.openBox();
        newBox.putItem("Яблоко");
        newBox.printBoxInfo();
        newBox.putItem("Груша");
        newBox.printBoxInfo();

        //Выкинуть предмет из коробки(коробка закрыта/коробка открыта/в коробке нет ни одного предмета)
        newBox.closeBox();
        newBox.throwOutItem();
        newBox.printBoxInfo();
        newBox.openBox();
        newBox.throwOutItem();
        newBox.printBoxInfo();
        newBox.throwOutItem();
        newBox.printBoxInfo();
    }
}