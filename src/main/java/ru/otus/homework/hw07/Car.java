package ru.otus.homework.hw07;

public class Car implements Moveable, OpportunityToBurn {
    private int petrol;

    public Car(int petrol) {
        this.petrol = petrol;
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

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.FOREST || terrainType == TerrainType.SWAMP) {
            System.out.println("Машина не может передвигаться по местности " + terrainType.getTerrain() + ", бензина осталось: " + petrol);
            return false;
        }
        if (expend(distance)) {
            System.out.println("Человек едет на машине по типу местности " + terrainType.getTerrain() + ", количество бензина: " + petrol);
            return true;
        } else {
            System.out.println("Машина не может ехать, количество бензина: " + petrol);
            return false;
        }
    }
}
