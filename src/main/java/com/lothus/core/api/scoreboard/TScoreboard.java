package com.lothus.core.api.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public abstract class TScoreboard {

	protected Player player;
	protected Scoreboard scoreboard;
	protected Objective mainObjective;
	
	public TScoreboard(Player player, String objective, String title) {
		this.player = player;
		this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		
		this.mainObjective = scoreboard.registerNewObjective(objective, "dummy");
		this.mainObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
		this.mainObjective.setDisplayName(title);
		
		this.player.setScoreboard(scoreboard);
	}
	
	public void setDisplayName(String displayName) {
		if (mainObjective.getDisplayName() != displayName)
			this.mainObjective.setDisplayName(displayName);
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}
	
	public Objective getMainObjective() {
		return mainObjective;
	}
	
	public abstract void create();
	public abstract void update();
	
	public void setRow(int index, String parse) {
		setRow(Row.byId(index), parse);
	}
	
	public void setRow(Row row, String parse) {
		if (parse.length() <= 16)
			setRow(row, parse, "");
		else if (parse.length() <= 32) {
			String prefix = parse.substring(0, 16);
			String suffix = parse.substring(16);

			if (prefix.endsWith("§")) {
				prefix = prefix.substring(0, 15);
				suffix = "§"+suffix;
			}
			
			suffix = ChatColor.getLastColors(prefix)+suffix;
			
			setRow(row, prefix, suffix);
		} else {
			throw new ArrayIndexOutOfBoundsException(parse.length()+" it's bigger than 32");
		}
	}
	
	public void setRow(int index, String prefix, String suffix) {
		setRow(Row.byId(index), prefix, suffix);
	}
	
	public void setRow(Row row, String prefix, String suffix) {
		String entry = row.getEntry();
		
		Team t = scoreboard.getTeam(entry);
		if (t == null) {
			t = scoreboard.registerNewTeam(entry);
		}
		if (t.getPrefix() != prefix)
			t.setPrefix(prefix);
		
		if (t.getSuffix() != suffix)
			t.setSuffix(suffix);
		
		if (!t.hasEntry(entry))
			t.addEntry(entry);
		
		Score score = mainObjective.getScore(entry);
		
		if (score.getScore() != row.getScore())
			score.setScore(row.getScore());
	}
	
	public void clearLines() {
		for (Row row : Row.values()) {
			scoreboard.resetScores(row.getEntry());
			
			Team t = scoreboard.getTeam(row.getEntry());
			if (t != null) {
				t.unregister();
			}
		}
	}

}
