package com.lothus.core.utils.player;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Send {

    private UUID uniqueId;
    private String server;

    public Send(UUID uniqueId, String server) {
        this.uniqueId = uniqueId;
        this.server = server;
    }
}
