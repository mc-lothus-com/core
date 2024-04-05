package com.lothus.core.player.stats;

import com.lothus.core.punish.type.PunishType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter @Setter
public class PunishStats {

    private int mutePunishments;
    private int banPunishments;
    private int totalPunishments;

    private int penaltiesRevoked;

    private HashMap<PunishType, String> punishesId;

    public PunishStats() {
        mutePunishments = 0;
        banPunishments = 0;
        totalPunishments = 0;

        penaltiesRevoked = 0;

        punishesId = new HashMap<>();
    }
}
