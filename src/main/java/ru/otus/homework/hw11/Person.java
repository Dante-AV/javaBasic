package ru.otus.homework.hw11;

public class Person {
    private String name;
    private Position position;
    private Long id;

    public Position getPosition() {
        return position;
    }

    public Person(String name, Position position, long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", id=" + id +
                '}';
    }
}
