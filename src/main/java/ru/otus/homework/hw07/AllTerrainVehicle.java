package ru.otus.homework.hw07;

public class AllTerrainVehicle implements Moveable, OpportunityToBurn {
    private int petrol;

    public AllTerrainVehicle(int petrol) {
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
        if (expend(distance)) {
            System.out.println("Человек передвигается на вездеходе по типу местности " + terrainType.getTerrain() + ", количество бензина: " + petrol);
            return true;
        } else {
            System.out.println("Вездеход не может передвигаться, количество бензина: " + petrol);
            return false;
        }
    }

}
