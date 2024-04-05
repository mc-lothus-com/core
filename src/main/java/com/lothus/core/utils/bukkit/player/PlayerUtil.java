package com.lothus.core.utils.bukkit.player;

import com.lothus.core.Core;
import com.lothus.core.player.LothPlayer;
import com.lothus.core.player.group.rank.Rank;
import com.lothus.core.player.network.packet.PacketServer;
import com.lothus.core.servers.ServerInfo;
import com.lothus.core.servers.status.ServerStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.lothus.core.storage.redis.channels.RedisChannel.PLAYER_CONNECT_SERVER;

public class PlayerUtil {

    private static HashMap<UUID, Long> cooldown = new HashMap<>();

    public static ConnectStatus connect(UUID uniqueId, ServerInfo serverInfo) {
        if (serverInfo == null) {
            return ConnectStatus.SERVER_NULL;
        }

        LothPlayer lothPlayer = Core.getPlayerController().get(uniqueId);

        if (serverInfo.getStatus() == ServerStatus.MAINTENANCE_MODE) {
            if (!lothPlayer.hasPermission(Rank.DEV)) {
                if (!lothPlayer.getGroup().containsPermission("maintenance.bypass")) {
                    return ConnectStatus.SERVER_MAINTENANCE;
                }
            }
        }

        if (serverInfo.getStatus() == ServerStatus.BETA_MODE) {
            if (!lothPlayer.hasPermission(Rank.BETA)) {
                if (!lothPlayer.getGroup().containsPermission("beta.bypass")) {
                    return ConnectStatus.SERVER_MAINTENANCE;
                }
            }
        }

        Player player = Bukkit.getPlayer(uniqueId);

        if (player == null) {
            return ConnectStatus.PLAYER_NULL;
        }

        if (cooldown.containsKey(uniqueId) && cooldown.get(uniqueId) > System.currentTimeMillis()) {
            return ConnectStatus.PLAYER_COOLDOWN;
        }

        cooldown.put(uniqueId, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(2));
        Core.getRedis().message(PLAYER_CONNECT_SERVER.name(), Core.getGson().toJson(new PacketServer(uniqueId, serverInfo.getName())));
        return ConnectStatus.CONNECTED;
    }

    public static enum ConnectStatus {

        SERVER_NULL,
        SERVER_FULL,
        SERVER_FULL_AND_ROOM,
        SERVER_MAINTENANCE,
        CONNECTED,
        PLAYER_COOLDOWN,
        PLAYER_NULL

    }
}
