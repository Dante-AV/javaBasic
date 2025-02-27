package ru.otus.homework.hw07;

public class Horse implements Moveable, OpportunityToBurn {
    private int strength;

    public Horse(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Лошадь не может передвигаться по местности " + terrainType.getTerrain() + ", силы у лошади: " + strength);
            return false;
        }
        if (expend(distance)) {
            System.out.println("Человек едет на лошади по типу местности " + terrainType.getTerrain() + ", силы у лошади = " + strength);
            return true;
        }
        System.out.println("Лошадь не может передвигаться, силы у лошади = " + strength);
        return false;
    }

    @Override
    public boolean expend(int distance) {
        if (strength - distance >= 0) {
            this.strength = strength - distance;
            return true;
        } else {
            this.strength = 0;
            return false;
        }
    }
}
