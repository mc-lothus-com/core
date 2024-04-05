package com.lothus.core.api.hologram;

import com.lothus.core.Core;
import org.bukkit.entity.Player;

public class HologramAPI {

    public static void spawnGlobal(Hologram hologram) {
        Core.getHologramManager().addGlobal(hologram);
    }

    public static Hologram spawn(Hologram hologram, Player... players) {
        for (Player player : players)
            Core.getHologramManager().addPlayerHologram(player, hologram);

        return hologram;
    }

}
