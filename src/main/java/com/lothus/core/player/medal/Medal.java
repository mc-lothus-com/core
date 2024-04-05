package com.lothus.core.player.medal;

import com.lothus.core.player.group.rank.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Medal {

    NENHUM("Nenhum", "", "§7", "", Rank.MEMBRO, new String[] { "none", "nenhum" }),
    LOVE("Amor", " ❤", "§4", "medal.love", Rank.PRO, new String[] { "amor", "coracao", "heart" }),
    STAR("Estrela", " ✩", "§e", "medal.star", Rank.VIP, new String[] { "estrela", "estrelas" }),
    YIN("Yin-yang", " ☯", "§5", "medal.yin", Rank.VIP, new String[] { "yin", "yang", "japones" }),
    NITRO("Nitro Booster",  " ✦", "§d", "medal.nitro", Rank.BETA, new String[] { "nitro", "booster", "discord"}),
    PIX("Pix", " ❖", "§3", "medal.pix", Rank.PRO, new String[] { "pix" }),
    COFFE("Desenvolvedor",   " ☕", "§3", "medal.dev", Rank.BETA, new String[] { "cafe", "café", "coffe" }),
    FLAKE("Floco de Neve", " ❆", "§b", "medal.flake", Rank.VIP, new String[] { "floco", "neve", "flake"}),
    SONG("Notas Musicais", " ♫", "§b", "medal.song",Rank.MASTER, new String[] { "notas", "musicais" }),
    PAZ("Paz e Amor", " ✌", "§c", "medal.paz", Rank.MASTER, new String[] { "paz" }),
    CANCELLED("Cancelado", " ✘", "§b", "medal.cancelled", Rank.BETA, new String[] {"cancelado"}),
    HAT("Carinha", " ツ", "§6", "medal.hat", Rank.BETA, new String[] {"carinha"}),
    GENGIBRE("Casa de Gengibre", " ۩", "§6", "medal.casa", Rank.CEO, new String[] {"casa", "gengibre"}),
    CRUZ_DE_MALTA("Cruz de Malta", " ✠", "§c", "medal.cruzdemalta", Rank.MASTER, new String[] { "vasco", "cruz", "malta" });

    String display;
    String symbol;
    String color;

    String permission;
    Rank availableRank;

    String[] aliases;

    public static boolean exists(String args) {
        return get(args) != null;
    }

    public static Medal get(String args) {
        for (Medal medal : values()) {
            if (medal.getDisplay().equalsIgnoreCase(args)) {
                return medal;
            }

            if (medal.name().equalsIgnoreCase(args)) {
                return medal;
            }

            for (String s : medal.getAliases()) {
                if (s.equalsIgnoreCase(args)) {
                    return medal;
                }
            }
        }
        return null;
    }
}
