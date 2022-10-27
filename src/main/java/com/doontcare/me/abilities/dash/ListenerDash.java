package com.doontcare.me.abilities.dash;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ListenerDash implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        /*if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("§cDash")) {
            // make better detection, might not be needed
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "dash " + e.getPlayer().getName());
        }*/
    }
}
