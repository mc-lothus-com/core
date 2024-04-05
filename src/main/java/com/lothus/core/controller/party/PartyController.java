package com.lothus.core.controller.party;


import com.lothus.core.player.party.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PartyController {

    private List<Party> parties = new ArrayList<>();

    public void load(Party party) {
        if (parties.stream().filter(p -> p.getLeader().equals(party.getLeader())).findFirst().orElse(null) == null) {
            parties.add(party);
        }
    }

    public void unload(Party party) {
        parties.remove(party);
    }

    public Party get(UUID uniqueId) {
        for (Party party: parties) {
            if (party.isLeader(uniqueId)) {
                return party;
            }

            if (party.hasMember(uniqueId)) {
                return party;
            }
        }
        return null;
    }

}
