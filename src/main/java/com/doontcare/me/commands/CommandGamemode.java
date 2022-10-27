package com.doontcare.me.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CommandGamemode implements CommandExecutor {

    private HashMap<UUID, Boolean> inCreative = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("c")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Must be a player to run '" + command + "'");
                return false;
            }
            Player p = (Player) sender;
            UUID u = p.getUniqueId();
            if (!p.isOp()) {
                p.sendMessage(ChatColor.RED + "Must be operator");
                return false;
            }

            if (inCreative.get(u) == null) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                    inCreative.put(u, false);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.spigot().sendMessage(
                            ChatMessageType.ACTION_BAR,
                            TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes(
                                    '&',
                                    "&6You are now in &asurvival"
                            )));
                } else {
                    inCreative.put(u,true);
                    p.setGameMode(GameMode.CREATIVE);
                    p.spigot().sendMessage(
                            ChatMessageType.ACTION_BAR,
                            TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes(
                                    '&',
                                    "&6You are now in &acreative"
                            )));
                }
                return false;
            }

            if (inCreative.get(u) == true) {
                inCreative.put(u, false);
                p.setGameMode(GameMode.SURVIVAL);
                p.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes(
                                '&',
                                "&6You are now in &asurvival"
                        )));
            } else {
                inCreative.put(u,true);
                p.setGameMode(GameMode.CREATIVE);
                p.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes(
                                '&',
                                "&6You are now in &acreative"
                        )));
            }

        }
        return false;
    }
}
