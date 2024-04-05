package com.lothus.core.controller.rejoin;

import com.lothus.core.player.rejoin.Rejoin;

import java.util.HashMap;
import java.util.UUID;

public class RejoinController {

    private HashMap<UUID, Rejoin> rejoinMap = new HashMap<>();

    public void load(Rejoin rejoin) {
        rejoinMap.put(rejoin.getUniqueId(), rejoin);
    }

    public void unload(UUID uniqueId) {
        rejoinMap.remove(uniqueId);
    }

    public Rejoin getRejoin(UUID uniqueId) {
        return rejoinMap.get(uniqueId);
    }
}
