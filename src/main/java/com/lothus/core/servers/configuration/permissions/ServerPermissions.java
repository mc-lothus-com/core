package com.lothus.core.servers.configuration.permissions;

import com.lothus.core.player.group.rank.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ServerPermissions {

    private HashMap<Rank, List<String>> permissions;

    public ServerPermissions() {
        permissions = new HashMap<>();
    }

    public List<String> findAllByRank(Rank rank) {
        return permissions.get(rank);
    }

    public boolean hasPermission(Rank rank, String permission) {
        if (permissions.containsKey(rank)) {
            return permissions.get(rank).contains(permission);
        }
        return false;
    }

    public void addPermission(Rank rank, String permission) {
        if (permissions.containsKey(rank)) {
            permissions.get(rank).add(permission);
        } else {
            permissions.put(rank, Arrays.asList(permission));
        }
    }

    public void removePermission(Rank rank, String permission) {
        if (permissions.containsKey(rank)) {
            List<String> permissions = this.permissions.get(rank);
            permissions.remove(permission);
            this.permissions.put(rank, permissions);
        }
    }
}
