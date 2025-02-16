package ru.otus.homework.hw07;

public class Human implements Moveable, OpportunityToBurn {
    private String name;
    private Moveable currentTransport;
    private int strength;


    public Human(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setCurrentTransport(Moveable currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void sitDown(Moveable transport) {
        if (!(currentTransport instanceof Human)) {
            currentTransport = transport;
            System.out.println("Человек сел на транспорт");
        }
    }

    public void standUp() {
        setCurrentTransport(null);
        System.out.println("Человек покинул транспорт");
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrainType);
        } else {
            return walk(distance);
        }
    }


    public boolean walk(int distance) {
        if (expend(distance)) {
            System.out.println("Человек идет пешком");
            return true;
        } else {
            System.out.println("Человек не может идти, человек устал");
            return false;
        }
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