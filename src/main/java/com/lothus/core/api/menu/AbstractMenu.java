package com.lothus.core.api.menu;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public abstract class AbstractMenu implements Listener {

    private Inventory inventory;
    
    private String title;
    private int size;

    private boolean interact;

    private List<UUID> viewers;

    public AbstractMenu(String title, int size) {
        this.title = title;
        this.size = size;
        this.viewers = new ArrayList<>();
        this.interact = false;
        
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public AbstractMenu(String title, int size, boolean interact) {
        this.title = title;
        this.size = size;
        this.viewers = new ArrayList<>();
        this.interact = interact;

        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public abstract void items();
    public abstract void items(Player player);

    public void open(Player player) {
        items();
        items(player);

        viewers.add(player.getUniqueId());
        player.openInventory(inventory);
    }
}
