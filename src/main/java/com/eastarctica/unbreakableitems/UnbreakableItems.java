package com.eastarctica.unbreakableitems;

import com.eastarctica.unbreakableitems.events.OnCraft;
import com.eastarctica.unbreakableitems.events.OnDrop;
import com.eastarctica.unbreakableitems.events.OnEntityDeath;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnbreakableItems extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnCraft(), this);
        getServer().getPluginManager().registerEvents(new OnDrop(), this);
        getServer().getPluginManager().registerEvents(new OnEntityDeath(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
