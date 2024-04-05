package com.lothus.core.player.social;

import com.lothus.core.player.group.rank.Rank;
import com.lothus.core.player.social.fake.Fake;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Social {

    private List<UUID> friends = new ArrayList<>();
    private List<UUID> requests = new ArrayList<>();

    private List<UUID> blocked = new ArrayList<>();
    private String lastServer;

    private long discord;
    private boolean online;

    private Fake fake;

    public Social(String name) {
        this.lastServer = "LOBBY";
        this.discord = -1L;
        this.online = true;

        fake = new Fake(name, Rank.MEMBRO);
    }

    public void addFriend(UUID uuid) {
        this.friends.add(uuid);
    }

    public void removeFriend(UUID uuid) {
        this.friends.remove(uuid);
    }

    public void addRequest(UUID uuid) {
        this.requests.add(uuid);
    }

    public void removeRequest(UUID uuid) {
        this.requests.remove(uuid);
    }

    public boolean hasFriend(UUID uuid) {
        return this.friends.contains(uuid);
    }

    public boolean hasRequest(UUID uuid) {
        return this.requests.contains(uuid);
    }

}
