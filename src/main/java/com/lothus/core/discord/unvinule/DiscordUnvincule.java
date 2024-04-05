package com.lothus.core.discord.unvinule;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class DiscordUnvincule {

    private String name;
    private UUID uniqueId;

    private String id;

    public DiscordUnvincule(String name, UUID uniqueId, String id) {
        this.name = name;
        this.uniqueId = uniqueId;

        this.id = id;
    }
}
