package com.lothus.core.player.booster.type;

public enum BoosterType {

    COINS("Coins"),
    XP("XP"),
    POINTS("Points");

    private String name;

    BoosterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BoosterType getByName(String name) {
        for (BoosterType boosterType : values()) {
            if (boosterType.name().equalsIgnoreCase(name)) {
                return boosterType;
            }

            if (boosterType.getName().equalsIgnoreCase(name)) {
                return boosterType;
            }
        }
        return null;
    }
}
