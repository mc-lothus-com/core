package com.lothus.core.player.group.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Rank {

    CEO("§4", "CEO", "A", new String[] { "ceo", "owner", "dono" }, false),
    GER("§c", "Ger", "B", new String[] { "gerente", "ger" }, false),
    DEV("§3", "Dev", "C", new String[] { "dev", "developer" }, false),
    ADMIN("§4", "Admin", "D", new String[] { "admin", "administrator" }, false),
    MOD("§2", "Mod", "E", new String[] { "mod", "moderador" }, false),
    TRIAL("§d", "Trial", "F", new String[] { "ajudante", "helper", "trial" }, false),
    BUILDER("§2", "Builder", "G", new String[] { "builder", "construtor" },true),
    STUDIO("§9", "Studio", "L", new String[] { "estudio", "studio" },true),
    MIDIA_PLUS("§5", "Mídia+", "H", new String[] { "yt+", "youtuber+", "influencerplus", "influencer+" }, true),
    MIDIA("§6", "Mídia", "I", new String[] { "yt", "youtuber", "influencer", "influenciador" }, true),
    BETA("§1", "Beta", "M", new String[] { "beta", "beta" },true),
    NATAL("§c", "Natal", "M_M", new String[] { "natal", "christimans" },true),
    FERIAS("§a", "Férias", "N", new String[] { "ferias", "feriado" },true),
    LOTHUS("§a", "Lothus", "P", new String[] { "lothus", "lothus" },true),
    MASTER("§d", "Master", "Q", new String[] { "master" },false),
    PRO("§6", "PRO", "R", new String[] { "pro" },false),
    VIP("§a", "VIP", "S", new String[] { "vip" },false),
    MEMBRO("§7", "Membro", "Z", new String[] { "membro", "normal" },false);

    String color;
    String name;
    String team;
    String[] aliases;
    boolean onlyPermission;

    public static Rank getRankByName(String name) {
        for (Rank rank : values()) {
            if (rank.name().equalsIgnoreCase(name)) {
                return rank;
            }

            if (rank.getName().equalsIgnoreCase(name)) {
                return rank;
            }

            for (String s : rank.getAliases()) {
                if (s.equalsIgnoreCase(name)) {
                    return rank;
                }
            }
        }
        return null;
    }

    public static boolean exists(String name) {
        return getRankByName(name) != null;
    }
}
