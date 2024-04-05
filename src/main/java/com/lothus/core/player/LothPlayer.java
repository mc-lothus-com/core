package com.lothus.core.player;

import com.lothus.core.player.booster.GameBooster;
import com.lothus.core.player.group.Group;
import com.lothus.core.player.group.rank.Rank;
import com.lothus.core.player.medal.Medal;
import com.lothus.core.player.network.Network;
import com.lothus.core.player.prefs.Prefs;
import com.lothus.core.player.skin.Skin;
import com.lothus.core.player.social.Social;
import com.lothus.core.player.stats.PunishStats;
import com.lothus.core.punish.PunishesInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class LothPlayer {

    private UUID uniqueId;
    private String name;

    private Group group;
    private Prefs prefs;
    private Medal medal;
    private Social social;

    private Skin skin;

    private int level;
    private int xp;

    private int coins;
    private int cash;

    private HashMap<String, PunishesInfo> punishes;
    private List<GameBooster> boosters;

    private PunishStats punishStats;

    private Network network;

    private boolean premium;

    private long firstLogin;
    private long lastLogin;

    public LothPlayer(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;

        this.group = new Group(Rank.MEMBRO, Rank.MEMBRO, new ArrayList<>(), System.currentTimeMillis(), System.currentTimeMillis(), -1L);
        this.prefs = new Prefs();

        this.medal = Medal.NENHUM;
        this.skin = new Skin(name, uniqueId, "", "");

        this.social = new Social(name);

        this.level = 0;
        this.xp = 0;

        this.coins = 0;
        this.cash = 0;

        this.punishes = new HashMap<>();
        this.boosters = new ArrayList<>();

        this.punishStats = new PunishStats();
        this.network = new Network();

        this.firstLogin = System.currentTimeMillis();
        this.lastLogin = System.currentTimeMillis();
    }

    public void addBooster(GameBooster booster) {
        boosters.add(booster);
    }

    public boolean isFake() {
        return (!social.getFake().getName().equalsIgnoreCase(name));
    }

    public boolean hasPermission(String permission) {
        return (group.containsPermission(permission));
    }

    public boolean hasPermission(Rank rank) {
        return (group.getRank().ordinal() <= rank.ordinal());
    }

    public boolean hasMedal(Medal medal) {
        return (group.containsPermission(medal.getPermission()) || group.getRank().ordinal() <= medal.getAvailableRank().ordinal());
    }
}
