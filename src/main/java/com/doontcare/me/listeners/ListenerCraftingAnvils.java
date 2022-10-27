package com.doontcare.me.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

public class ListenerCraftingAnvils implements Listener {

    @EventHandler
    public void crafting(PrepareItemCraftEvent e) {

    }

    @EventHandler
    public void forging(PrepareAnvilEvent e) {
        e.setResult(null);
    }

}
