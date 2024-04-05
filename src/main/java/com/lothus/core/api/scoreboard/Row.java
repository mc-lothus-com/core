package com.lothus.core.api.scoreboard;

import org.bukkit.ChatColor;

public enum Row {

	ROW_1,
	ROW_2,
	ROW_3,
	ROW_4,
	ROW_5,
	ROW_6,
	ROW_7,
	ROW_8,
	ROW_9,
	ROW_10,
	ROW_11,
	ROW_12,
	ROW_13,
	ROW_14,
	ROW_15,
	ROW_16;

	public int getScore() {
		return 16-ordinal();
	}
	
	public String getEntry() {
		return ChatColor.values()[ordinal()]+ChatColor.RESET.toString();
	}

	public static Row byId(int index) {
		return values()[index];
	}
}
