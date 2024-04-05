package com.lothus.core.controller.player;

import com.lothus.core.player.LothPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerController {

    private HashMap<UUID, LothPlayer> players = new HashMap<>();

    public void load(LothPlayer lothPlayer) {
        players.put(lothPlayer.getUniqueId(), lothPlayer);
    }

    public void unload(UUID uniqueId) {
        players.remove(uniqueId);
    }

    public void replace(LothPlayer lothPlayer) {
        players.replace(lothPlayer.getUniqueId(), lothPlayer);
    }

    public LothPlayer get(UUID uniqueId) {
        return players.get(uniqueId);
    }

    public LothPlayer get(String name) {
        for (LothPlayer l : players.values()) {
            if (l.getName().equalsIgnoreCase(name)) {
                return l;
            }
        }
        return null;
    }

    public List<LothPlayer> getAll() {
        List<LothPlayer> l = new ArrayList<>();

        for (LothPlayer lothPlayer : players.values()) {
            l.add(lothPlayer);
        }
        return l;
    }

}
