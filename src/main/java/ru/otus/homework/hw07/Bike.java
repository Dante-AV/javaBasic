package ru.otus.homework.hw07;

import java.util.Objects;

public class Bike implements Moveable {
    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (!(Objects.equals(terrainType, TerrainType.SWAMP))) {
            return true;
        } else {
            System.out.println("Велосипед не может передвигаться по типу местности " + terrainType.getName());
            return false;
        }
    }
}
