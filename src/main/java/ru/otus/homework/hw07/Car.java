package ru.otus.homework.hw07;

import java.util.Objects;

public class Car implements Moveable, OpportunityToBurn {
    private int petrol;

    public Car(int petrol) {
        this.petrol = petrol;
    }


    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (Objects.equals(terrainType, TerrainType.PLAIN)) {
            if (expend(distance)) {
                System.out.println("Человек едет на машине по типу местности " + terrainType.getName() + ", количество бензина - " + petrol);
                return true;
            } else {
                System.out.println("Машина не может передвигаться, количество бензина = " + petrol);
                return false;
            }
        }
        System.out.println("Машина не может передвигаться по типу местности " + terrainType.getName());
        return false;
    }

    @Override
    public boolean expend(int distance) {
        if (petrol - distance >= 0) {
            this.petrol = petrol - distance;
            return true;
        } else {
            this.petrol = distance - (petrol - (petrol - distance));
            return false;
        }
    }
}
