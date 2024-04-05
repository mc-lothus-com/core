package com.lothus.core.games.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {

    SKY_WARS("SkyWars"),
    BED_WARS("BedWars"),
    DUELS("Treinamento");

    String name;

    public static GameType getByName(String name) {
        for (GameType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
