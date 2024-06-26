package ru.otus.homework.hw07;


public class Horse implements Moveable, OpportunityToBurn {
    int force;

    public Horse(int force) {
        this.force = force;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Лошадь не может передвигаться по типу местности " + terrainType.getName());
            return false;
        }
        if (expend(distance)) {
            System.out.println("Человек едет на лошади по типу местности " + terrainType.getName() + ", силы у лошади = " + force);
            return true;
        }
        System.out.println("Лошадь не может передвигаться, силы у лошади = " + force);
        return false;
    }

    @Override
    public boolean expend(int distance) {
        if (force - distance >= 0) {
            this.force = force - distance;
            return true;
        } else {
            this.force = 0;
            return false;
        }
    }
}
