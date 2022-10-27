package com.doontcare.me.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ListenerBlock implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        //e.setCancelled(true);
        //e.getPlayer().sendMessage(ChatColor.RED + "No");
    }

}
