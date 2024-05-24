package ru.otus.homework.hw07;

public class Car implements Moveable, OpportunityToBurn {
    private int petrol;

    public Car(int petrol) {
        this.petrol = petrol;
    }


    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType != TerrainType.PLAIN) {
            System.out.println("Машина не может передвигаться по типу местности " + terrainType.getName());
            return false;
        }
        if (expend(distance)) {
            System.out.println("Человек едет на машине по типу местности " + terrainType.getName() + ", количество бензина - " + petrol);
            return true;
        }
        System.out.println("Машина не может передвигаться, количество бензина = " + petrol);
        return false;
    }

    @Override
    public boolean expend(int distance) {
        if (petrol - distance >= 0) {
            this.petrol = petrol - distance;
            return true;
        } else {
            this.petrol = 0;
            return false;
        }
    }
}
