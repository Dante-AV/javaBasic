package ru.otus.homework.hw07;

import java.util.Objects;

public class Human implements Moveable, OpportunityToBurn {
    private String name;
    private Moveable currentTransport;
    private int force;


    public Human(String name, int force) {
        this.name = name;
        this.force = force;
    }

    public void sitDown(Moveable transport) {
        currentTransport = transport;
        System.out.println("Человек сел на транспорт");
    }

    public void standUp() {
        currentTransport = null;
        System.out.println("Человек покинул траспорт");
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (currentTransport != null) {
               currentTransport.move(distance, terrainType);
            if (currentTransport instanceof Bike) {
                if (expend(distance)) {
                    System.out.println("Человек едет на велосипеде по типу местности " + terrainType.getName() + ", силы у водителя = " + force);
                } else {
                    System.out.println("Человек не может дальше передвигатьcя на велосипеде, силы у водителя = " + force);
                }
                return true;
            }
        }
        System.out.println("Человек идет пешком");
        return false;
    }

    @Override
    public boolean expend(int distance) {
        if (force - distance >= 0) {
            this.force = force - distance;
            return true;
        } else {
            this.force = distance - (force - (force - distance));
            return false;
        }
    }


//    public void setCurrentTransport(String currentTransport) {
//        this.currentTransport = currentTransport;
//    }
//
//    public Moveable getCurrentTransport() {
//        return currentTransport;
//    }
}
