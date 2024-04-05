package com.lothus.core.data.party;

import com.lothus.core.Core;
import com.lothus.core.player.party.Party;

import java.util.UUID;

public class DataParty {

    public void create(Party party) {
        for (UUID uuid : party.getMembers()) {
            Core.getRedis().set("party:" + uuid.toString(), Core.getGson().toJson(party));
        }
        Core.getRedis().set("party:" + party.getLeader().toString(), Core.getGson().toJson(party));
    }

    public void update(Party party) {
        for (UUID uuid : party.getMembers()) {
            Core.getRedis().set("party:" + uuid.toString(), Core.getGson().toJson(party));
        }
        Core.getRedis().set("party:" + party.getLeader().toString(), Core.getGson().toJson(party));
    }

    public void del(Party party) {
        for (UUID uuid : party.getMembers()) {
            Core.getRedis().del("party:" + uuid.toString());
        }
        Core.getRedis().del("party:" + party.getLeader().toString());
    }

    public void del(UUID uniqueID) {
        Core.getRedis().del("party:" + uniqueID.toString());
    }

    public Party get(UUID uniqueId) {
        return Core.getGson().fromJson(Core.getRedis().get("party:" + uniqueId.toString()), Party.class);
    }
}
