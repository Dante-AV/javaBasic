package ru.otus.homework.hw07;

public class Human implements OpportunityToBurn {
    private final String name;
    private Moveable currentTransport;

    public int getForce() {
        return force;
    }

    private int force;


    public Human(String name, int force) {
        this.name = name;
        this.force = force;
    }

    public void sitDown(Moveable transport) {
        if (!(transport instanceof Human)) {
            currentTransport = transport;
            System.out.println("Человек сел на транспорт");
        }
    }

    public void standUp() {
        setCurrentTransport(null);
        System.out.println("Человек покинул траспорт");
    }

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
        if (force - distance >= 0) {
            force = force - distance;
            return true;
        } else {
            force = 0;
            return false;
        }
    }

    public void setCurrentTransport(Moveable currentTransport) {
        this.currentTransport = currentTransport;
    }
}
