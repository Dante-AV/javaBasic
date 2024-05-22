package ru.otus.homework.hw07;

public enum TerrainType {
    FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private final String name;

    TerrainType(String name) {
        this.name =  name;
    }

    public String getName() {
        return name;
    }
}
