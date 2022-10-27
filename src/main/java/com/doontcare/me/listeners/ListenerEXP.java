package com.doontcare.me.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerEXP implements Listener {

    @EventHandler
    public void expGain(PlayerExpChangeEvent e) {
        Player player = e.getPlayer();
        float baseExp = e.getAmount();
        float newExp = baseExp/4;
        e.setAmount((int) newExp);
        e.getPlayer().spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes(
                        '&',
                        "&6&l⭐ &7Received &6" + newExp + " &7EXP")
                ));
        Location loc = player.getLocation();
    }

}
