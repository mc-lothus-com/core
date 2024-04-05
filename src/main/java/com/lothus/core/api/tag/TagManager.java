package com.lothus.core.api.tag;

import com.lothus.core.player.group.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.UUID;

public class TagManager {

    private static HashMap<UUID, String> prefixMap = new HashMap<>();
    private static HashMap<UUID, String> suffixMap = new HashMap<>();
    private static HashMap<UUID, String> teamMap = new HashMap<>();

    public static void setTag(Player player, Rank tag) {
        setTag(player, (tag == Rank.MEMBRO ? "§7" : tag.getColor() + "§l" + tag.getName().toUpperCase() + " " + tag.getColor()), "", tag.getTeam());
    }

    public static void setTag(Player player, String prefix, String suffix, String teamFormat) {
        prefixMap.put(player.getUniqueId(), prefix);
        suffixMap.put(player.getUniqueId(), suffix);
        teamMap.put(player.getUniqueId(), teamFormat);
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            update(onlinePlayers);
        }
    }

    public static void update(Player player) {
        String prefix = prefixMap.get(player.getUniqueId());
        String suffix = suffixMap.get(player.getUniqueId());
        String teamFormat = teamMap.get(player.getUniqueId());
        if (prefix == null)
            return;

        Scoreboard scoreboard = player.getScoreboard();
        String format = teamFormat + (player.getName().length() >= 10 ? player.getName().substring(0, 6) : player.getName());

        Team newTeam = scoreboard.getTeam(format);
        if (newTeam == null) {
            for (Team team : scoreboard.getTeams()) {
                if (team.getName().equalsIgnoreCase(format)) {
                    team.unregister();
                }
            }
            newTeam = scoreboard.registerNewTeam(format);
        }
        if (!newTeam.hasEntry(player.getName())) {
            newTeam.addPlayer(player);
        }
        newTeam.setPrefix(prefix);
        newTeam.setSuffix(suffix);
        newTeam.setNameTagVisibility(NameTagVisibility.ALWAYS);

        player.setPlayerListName(newTeam.getPrefix() + player.getName() + suffix);
        player.setDisplayName(newTeam.getPrefix() + player.getName() + suffix);

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId() == players.getUniqueId())
                continue;

            String tagPrefix = prefixMap.get(players.getUniqueId());
            if (tagPrefix == null)
                continue;
            String f = teamMap.get(players.getUniqueId()) + (player.getName().length() >= 10 ? player.getName().substring(0, 6) : player.getName());
            Team newer = scoreboard.getTeam(f);
            if (newer == null) {
                for (Team team : scoreboard.getTeams()) {
                    if (team.getName().equalsIgnoreCase(f)) {
                        team.unregister();
                    }
                }
                newer = scoreboard.registerNewTeam(f);
            }
            String prefixFormat = prefixMap.get(players.getUniqueId());
            String suffixFormat = suffixMap.get(players.getUniqueId());
            newer.setPrefix(prefixFormat);
            newer.setSuffix(suffixFormat);
            newer.setNameTagVisibility(NameTagVisibility.ALWAYS);
            if (!newer.hasEntry(players.getName()))
                newer.addPlayer(players);
        }
    }

    public static void hideNick(Scoreboard scoreboard, Player player) {
        String teamFormat = teamMap.get(player.getUniqueId());
        String format = teamFormat + (player.getName().length() >= 10 ? player.getName().substring(0, 6) : player.getName());
        Team team = scoreboard.getTeam(format);

        if (team == null) {
            team = scoreboard.registerNewTeam(format);
        }
        team.setPrefix("");
        team.setSuffix("");
        team.setNameTagVisibility(NameTagVisibility.NEVER);

        if (!team.hasEntry(player.getName())) {
            team.addPlayer(player);
        }
    }

}
