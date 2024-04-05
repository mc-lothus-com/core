package com.lothus.core.player.party.packet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class PacketParty {

    private String serverName;
    private List<UUID> members;

}
