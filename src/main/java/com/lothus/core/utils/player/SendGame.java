package com.lothus.core.utils.player;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class SendGame {

    private UUID uniqueId;

    private String game;

    public SendGame(UUID uniqueId, String game) {
        this.uniqueId = uniqueId;
        this.game = game;
    }
}
