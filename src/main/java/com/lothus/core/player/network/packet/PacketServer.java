package com.lothus.core.player.network.packet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class PacketServer {

    private UUID uniqueId;
    private String serverName;

}
