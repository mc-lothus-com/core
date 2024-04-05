package com.lothus.core.api.hologram.impl;

import com.lothus.core.api.hologram.Hologram;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NPCHologram extends Hologram {

    private String name;

    public NPCHologram(@NonNull Location location, String name) {
        super(location);
        this.name = name;
    }

    public void update(int onlinePlayers) {
        List<String> lines = new ArrayList<>();

        lines.add("§b§l" + name);
        lines.add("§e" + onlinePlayers + " jogando agora!");

        setText(lines);
    }
}