package com.lothus.core.player.prefs;

import com.lothus.core.player.prefs.visibility.Visibility;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Prefs {

    private Visibility visibility;

    private boolean fly, tell, lobby, chat, stats, censorShip;
    private boolean vanish, staffChat, report;

    public Prefs() {
        fly = false;
        tell = true;
        lobby = true;

        visibility = Visibility.ALL;
        chat = true;

        stats = true;
        censorShip = true;

        vanish = false;
        staffChat = true;
        report = true;
    }
}
