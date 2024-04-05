package com.lothus.core.api.loaders;

import com.lothus.core.Core;
import com.lothus.core.utils.bukkit.classes.ClassGetter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerLoader {

    public static void loadListeners(JavaPlugin instance, String packageName) {
        for (Class<?> listenerClass : ClassGetter.getClassesForPackage(instance, packageName)) {
            if (Listener.class.isAssignableFrom(listenerClass)) {
                try {
                    Listener listener = (Listener) listenerClass.newInstance();
                    Bukkit.getPluginManager().registerEvents(listener, instance);
                } catch (Exception e) {
                    Core.getLogger().severe("Não foi possível carregar o com.redelegit.npc.listener " + listenerClass.getName() + "!");
                }
            }
        }
    }

}
