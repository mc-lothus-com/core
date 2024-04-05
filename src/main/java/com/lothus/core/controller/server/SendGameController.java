package com.lothus.core.controller.server;

import com.lothus.core.utils.player.SendGame;

import java.util.HashMap;
import java.util.UUID;

public class SendGameController {

    private HashMap<UUID, SendGame> sends = new HashMap<>();

    public void load(SendGame game) {
        sends.put(game.getUniqueId(), game);
    }

    public void unload(UUID uniqueId) {
        sends.remove(uniqueId);
    }

    public SendGame get(UUID uniqueId) {
        return sends.get(uniqueId);
    }

    public boolean isExists(UUID uniqueId) {
        return sends.containsKey(uniqueId);
    }

}
