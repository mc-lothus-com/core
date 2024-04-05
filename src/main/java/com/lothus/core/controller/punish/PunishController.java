package com.lothus.core.controller.punish;

import com.lothus.core.player.LothPlayer;
import com.lothus.core.punish.PunishesInfo;
import com.lothus.core.punish.type.PunishType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PunishController {

    private HashMap<UUID, PunishesInfo> players = new HashMap<>();

    public void load(PunishesInfo player) {
        players.put(player.getUniqueId(), player);
    }

    public void unload(UUID uniqueDd) {
        players.remove(uniqueDd);
    }

    public PunishesInfo getPunishInfo(UUID uniqueId) {
        return players.get(uniqueId);
    }

    public List<PunishesInfo> getPunishsInfos() {
        List<PunishesInfo> serversInfos = new ArrayList<>();
        for (PunishesInfo serverInfo : players.values()) {
            serversInfos.add(serverInfo);
        }
        return serversInfos;
    }

    public List<PunishesInfo> getMutes(LothPlayer lothPlayer) {
        List<PunishesInfo> l = new ArrayList<>();
        for (PunishesInfo punishesInfo : lothPlayer.getPunishes().values()) {
            if (punishesInfo.getType() == PunishType.MUTE || punishesInfo.getType() == PunishType.TEMP_MUTE) {
                if (!punishesInfo.isExpired()) {
                    l.add(punishesInfo);
                }
            }
        }
        return l;
    }
}
