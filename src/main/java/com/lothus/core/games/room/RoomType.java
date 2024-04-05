package com.lothus.core.games.room;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {

    SOLO("Solo", 1),
    DUPLAS("Duplas", 2),
    TRIOS("Trios", 3),
    QUARTETOS("Quartetos", 4),

    RANQUEADO("Ranqueado", 1),

    DUEL_1V1("1v1", 1),
    DUEL_2V2("2v2", 2),
    DUEL_3V3("3v3", 3),
    DUEL_4V4("4v4", 4);

    String name;
    int maxPlayersPerTeam;

    public static RoomType getRoomType(String name) {
        for (RoomType roomType : values()) {
            if (roomType.name().equalsIgnoreCase(name)) {
                return roomType;
            }

            if (roomType.getName().equalsIgnoreCase(name)) {
                return roomType;
            }
        }
        return null;
    }



}
