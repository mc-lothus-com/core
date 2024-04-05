package com.lothus.core.controller.game;

import com.lothus.core.games.GameInfo;
import com.lothus.core.games.room.RoomType;
import com.lothus.core.games.type.GameType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameController {

    private HashMap<String, GameInfo> g = new HashMap<>();

    public void load(GameInfo gameInfo) {
        g.put(gameInfo.getId(), gameInfo);
    }

    public void unload(String display) {
        g.remove(display);
    }

    public void update(GameInfo serverInfo) {
        if (g.containsKey(serverInfo.getId())) {
            g.replace(serverInfo.getId(), serverInfo);
        } else {
            g.put(serverInfo.getId(), serverInfo);
        }
    }

    public GameInfo getGame(String display) {
        return g.get(display);
    }
    public GameInfo getByServer(String server) {
        for (GameInfo ga : g.values()) {
            if (ga.getName().equalsIgnoreCase(server)) {
                return ga;
            }
        }
        return null;
    }

    public List<GameInfo> getAll() {
        List<GameInfo> games = new ArrayList<>();
        for (GameInfo gameInfo : g.values()) {
            games.add(gameInfo);
        }
        return games;
    }

    public List<GameInfo> getAll(GameType gameType) {
        List<GameInfo> games = new ArrayList<>();
        for (GameInfo gameInfo : g.values()) {
            if (gameInfo.getType() == gameType) {
                games.add(gameInfo);
            }
        }
        return games;
    }


    public List<GameInfo> getAll(GameType gameType, RoomType roomType) {
        List<GameInfo> games = new ArrayList<>();
        for (GameInfo gameInfo : g.values()) {
            if (gameInfo.getType() == gameType) {
                if (gameInfo.getRoomType() == roomType) {
                    games.add(gameInfo);
                }
            }
        }
        return games;
    }


}
