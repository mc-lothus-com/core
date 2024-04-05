package com.lothus.core.player.party;

import com.lothus.core.Core;
import com.lothus.core.player.LothPlayer;
import com.lothus.core.player.group.rank.Rank;
import com.lothus.core.player.party.state.PartyState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Getter @Setter
public class Party {

    private UUID leader;

    private PartyState state;
    private List<UUID> members;

    private HashMap<UUID, Long> requests;

    private int slots;
    private int maxSize;

    private boolean chat;

    public Party(UUID leader) {
        this.leader = leader;

        state = PartyState.CLOSED;
        members = new ArrayList<>();
        requests = new HashMap<>();

        LothPlayer lothPlayer = Core.getPlayerController().get(leader);
        this.slots = (lothPlayer.getGroup().getRank().ordinal() <= Rank.MIDIA_PLUS.ordinal() ? (120/2) : (80/2));
        this.maxSize = (lothPlayer.getGroup().getRank().ordinal() <= Rank.MIDIA_PLUS.ordinal() ? 120 : 80);

        this.chat = true;
    }

    public void add(UUID uniqueId) {
        members.add(uniqueId);
    }
    public void remove(UUID uniqueId) {
        members.remove(uniqueId);
    }
    public void transfer(UUID uniqueId) {
        setLeader(uniqueId);
    }

    public int size() {
        return members.size() + 1;
    }

    public void open(int slots) {
        setState(PartyState.OPEN);
        setSlots(slots);
    }
    public void close() {
        setState(PartyState.CLOSED);
    }

    public void addRequest(UUID uniqueId) {
        requests.put(uniqueId, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1));
    }
    public void removeRequest(UUID uniqueId) {
        requests.remove(uniqueId);
    }

    public boolean hasMember(UUID uniqueId) {
        if (leader == uniqueId) {
            return true;
        }
        return members.contains(uniqueId);
    }
    public boolean isLeader(UUID uniqueId) {
        return uniqueId == leader;
    }
    public boolean isState(PartyState state) {
        return this.state == state;
    }

}
