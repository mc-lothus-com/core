package com.lothus.core.servers.configuration;

import com.lothus.core.servers.configuration.permissions.ServerPermissions;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServerConfiguration {

    private String scoreboardTitle;
    private String scoreboardFooter;

    private boolean pvp;
    private boolean chat;

    private int maxPlayers;

    private ServerPermissions permissions;

    public ServerConfiguration() {
        scoreboardTitle = "§2§lLOTHUS MC";
        scoreboardFooter = "§awww.mc-lothus.com";

        pvp = true;
        chat = true;

        maxPlayers = 20;

        permissions = new ServerPermissions();
    }
}
