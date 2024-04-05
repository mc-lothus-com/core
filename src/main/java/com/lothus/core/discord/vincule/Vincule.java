package com.lothus.core.discord.vincule;

import com.lothus.core.discord.state.LinkState;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Vincule {

    private long id;
    private String nick;

    private String discordTag;
    private LinkState state;

    public Vincule(long id, String nick, String discordTag, LinkState state) {
        this.id = id;
        this.nick = nick;
        this.discordTag = discordTag;
        this.state = state;
    }
}
