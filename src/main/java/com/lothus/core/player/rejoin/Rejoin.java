package com.lothus.core.player.rejoin;

import com.lothus.core.games.room.RoomType;
import com.lothus.core.games.type.GameType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Rejoin {

    private UUID uniqueId;

    private String arenaName;
    private GameType gameType;
    private RoomType roomType;

    private long expires;
}
