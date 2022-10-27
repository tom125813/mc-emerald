package com.doontcare.me.holograms;

import com.doontcare.me.Emerald;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

public class Hologram {

    private int count;

    private Location location;
    private ArmorStand armorStand;

    private String name;

    private Emerald emerald = Emerald.getInstance();
    private HologramManager hologramManager = emerald.getHologramManager();

    public Hologram(Location location, String name) {
        count = hologramManager.hologramHashMap.size();
        this.name = ChatColor.translateAlternateColorCodes('&', name);
        this.location = location;

        armorStand = location.getWorld().spawn(location, ArmorStand.class);

        armorStand.setInvisible(true);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setMarker(true);

        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(name);

        hologramManager.hologramHashMap.put(count, this);
    }

    public void delete() {
        hologramManager.hologramHashMap.remove(count);
        armorStand.remove();
    }
}
