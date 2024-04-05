package com.lothus.core.games;

import com.lothus.core.games.room.RoomType;
import com.lothus.core.games.state.GameState;
import com.lothus.core.games.type.GameType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameInfo {

    private String id;
    private String display;
    private String name;

    private GameState state;

    private GameType type;
    private RoomType roomType;

    private int players;
    private int maxPlayers;

    public GameInfo(String id, String display, String name, GameType type, RoomType roomType, int maxPlayers) {
        this.id = id;
        this.display = display;
        this.name = name;
        this.type = type;
        this.roomType = roomType;
        this.maxPlayers = maxPlayers;

        players = 0;
        state = GameState.ESPERANDO;
    }
}
