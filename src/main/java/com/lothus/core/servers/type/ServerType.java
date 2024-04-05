package com.lothus.core.servers.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerType {


    UNDEFINED("Undefined"),
    PROXY("Proxy"),
    LOGIN("Login #"),
    LOBBY("Lobby #"),

    LOBBY_DUELS("Lobby Duels #"),
    LOBBY_SKYWARS("Lobby Skywars #"),
    LOBBY_BEDWARS("Lobby Bedwars #"),

    TEST_LOBBY_DUELS("Lobby de Testes Duels #"),
    TEST_LOBBY_SKYWARS("Lobby de Testes Skywars #"),
    TEST_LOBBY_BEDWARS("Lobby de Testes Bedwars #"),

    ROOM_DUELS("Sala Duels #"),
    ROOM_SKYWARS("Sala Skywars #"),
    ROOM_BEDWARS("Sala Bedwars #"),

    ROOM_PUNISH("Sala de Detenção #"),

    TEST_ROOM_DUELS("Sala de Testes Duels #"),
    TEST_ROOM_SKYWARS("Sala de Testes Skywars #"),
    TEST_ROOM_BEDWARS("Sala de Testes Bedwars #"),
    TEST_ROOM_PUNISH("Sala de Testes Detenção #"),

    BUILDERS("Sala de Builders #");

    String name;

    public static ServerType getByName(String name) {
        for (ServerType serverType : values()) {
            if (serverType.name().equalsIgnoreCase(name)) {
                return serverType;
            }
            if (serverType.getName().equalsIgnoreCase(name)) {
                return serverType;
            }
        }
        return null;
    }
}
