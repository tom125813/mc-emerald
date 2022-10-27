package com.doontcare.me.holograms;

import com.doontcare.me.Emerald;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

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

        // prevent flash of armourstand
        armorStand = location.getWorld().spawn(location.add(0,0,0), ArmorStand.class);

        armorStand.setInvisible(true);

        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(name);

        armorStand.teleport(armorStand.getLocation().subtract(0,0,0));

        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setMarker(true);

        hologramManager.hologramHashMap.put(count, this);
    }

    public void delete() {
        hologramManager.hologramHashMap.remove(count);
        armorStand.remove();
    }
}
