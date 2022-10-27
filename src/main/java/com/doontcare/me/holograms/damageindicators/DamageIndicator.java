package com.doontcare.me.holograms.damageindicators;

import com.doontcare.me.Emerald;
import com.doontcare.me.holograms.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;

public class DamageIndicator extends Hologram {

    private long lifeLength = 1;

    public DamageIndicator(Location location, String name) {
        super(location, ChatColor.RED + "-" + new DecimalFormat("0.00").format(Double.valueOf(name)));
        prepDeletion();
    }

    public void prepDeletion() {
        new BukkitRunnable() {
            @Override
            public void run() {
                delete();
            }
        }.runTaskLater(Emerald.getPlugin(), lifeLength*20);
    }

}
