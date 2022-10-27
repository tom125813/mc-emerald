package com.doontcare.me.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ListenerSlotChange implements Listener {

    // TODO: Better custom item detection

    @EventHandler
    public void change(PlayerItemHeldEvent e) {
        int nextSlot = 0; // default position
        if (e.getPlayer().getInventory().getItem(e.getNewSlot())==null)
            return;
        String itemName = e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getDisplayName();
        if (itemName.equals("§cDash Ability")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "dash " + e.getPlayer().getName());
            e.getPlayer().getInventory().setHeldItemSlot(nextSlot);
        }
    }
}
