package ru.otus.homework.hw07;

public enum TerrainType {
    FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private final String terrain;

    public String getTerrain() {
        return terrain;
    }

    TerrainType(String terrain) {
        this.terrain = terrain;
    }
}
