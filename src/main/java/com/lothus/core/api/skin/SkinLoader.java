package com.lothus.core.api.skin;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Iterables;
import com.lothus.core.api.tag.TagManager;
import com.lothus.core.player.skin.Skin;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SkinLoader {

    public static final LoadingCache<GameProfile, Property> textures = CacheBuilder.newBuilder().expireAfterWrite(30L,
            TimeUnit.MINUTES).build(new CacheLoader<GameProfile, Property>() {
        public Property load(GameProfile key) {
            return loadTextures(key);
        }
    });

    private static final Property loadTextures(GameProfile profile) {
        MinecraftServer.getServer().aD().fillProfileProperties(profile, true);
        return Iterables.getFirst(profile.getProperties().get("textures"), null);
    }

    private static MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();

    public static MinecraftServer getNmsServer() {
        return nmsServer;
    }

    public static WorldServer getNmsWorld(World world) {
        return ((CraftWorld)world).getHandle();
    }

    public static Skin changeSkin(Player player, Property property) {
        PlayerList list = MinecraftServer.getServer().getPlayerList();
        CraftPlayer craftPlayer = (CraftPlayer) player;
        EntityPlayer entityPlayer = craftPlayer.getHandle();
        GameProfile profile = entityPlayer.getProfile();
        PacketPlayOutPlayerInfo remove = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, entityPlayer);
        PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(entityPlayer.getId());
        sendPacket(remove, null);
        sendPacket(destroy, null);
        try {
            PropertyMap map = profile.getProperties();
            map.removeAll("textures");
            map.put("textures", property);
            Field properties = profile.getClass().getDeclaredField("properties");
            properties.setAccessible(true);
            properties.set(profile, map);
            properties.setAccessible(false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        PacketPlayOutPlayerInfo add = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, entityPlayer);
        PacketPlayOutPlayerInfo update = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.UPDATE_DISPLAY_NAME, entityPlayer);
        PacketPlayOutEntityMetadata metadata = new PacketPlayOutEntityMetadata(entityPlayer.getId(), entityPlayer.getDataWatcher(), true);
        sendPacket(add, null);
        sendPacket(update, null);
        sendPacket(metadata, player);
        list.moveToWorld(entityPlayer, 0, false, player.getLocation(), false);
        player.teleport(player.getLocation().add(0.0D, 0.2D, 0.0D));
        TagManager.update(player);
        return new Skin(property.getName(), null, property.getValue(), property.getSignature());
    }

    private static void sendPacket(Packet packet, Player target) {
        List<Player> list;
        if(target != null)
            list = Bukkit.getOnlinePlayers().stream().filter(player -> player.canSee(target) &&
                    !player.getUniqueId().equals(target.getUniqueId())).collect(Collectors.toList());
        else
            list = new ArrayList<>(Bukkit.getOnlinePlayers());
        list.forEach(player -> ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet));
    }
}
