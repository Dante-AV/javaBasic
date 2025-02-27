package ru.otus.homework.hw07;

import static ru.otus.homework.hw07.TerrainType.*;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Джон", 20);
        Car car = new Car(35);
        Bike bike = new Bike();
        Horse horse = new Horse(40);
        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle(70);

        human.sitDown(car);
        human.move(20, FOREST);
        human.move(20, PLAIN);
        human.standUp();
        human.move(10, PLAIN);
        human.sitDown(horse);
        horse.move(30, SWAMP);
        horse.move(30, FOREST);
        horse.move(20, PLAIN);
        human.standUp();
        human.sitDown(bike);
        human.move(15, PLAIN);
        human.move(5, SWAMP);
        human.standUp();
        human.sitDown(allTerrainVehicle);
        human.move(40, SWAMP);

    }
}
