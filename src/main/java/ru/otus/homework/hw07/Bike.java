package ru.otus.homework.hw07;

public class Bike implements Moveable {

    private Human human;

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Велосипед не может передвигаться по типу местности " + terrainType.getTerrain());
            return false;
        }
        if (human.expend(distance)) {
            System.out.println("Человек едет на велосипеде по типу местности " + terrainType.getTerrain() + ", силы у водителя = " + human.getStrength());
            return true;
        }
        System.out.println("Человек не может передвигатьcя на велосипеде, сил у водителя = " + human.getStrength());
        return false;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
