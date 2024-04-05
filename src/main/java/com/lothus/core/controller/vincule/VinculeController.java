package com.lothus.core.controller.vincule;

import com.lothus.core.discord.vincule.Vincule;

import java.util.HashMap;
import java.util.UUID;

public class VinculeController {

    private HashMap<UUID, Vincule> vin = new HashMap<>();

    public void load(UUID uuid, Vincule vincule) {
        vin.put(uuid, vincule);
    }

    public void unload(UUID uniqueId) {
        vin.remove(uniqueId);
    }

    public Vincule get(UUID uniqueId) {
        return vin.get(uniqueId);
    }

}
