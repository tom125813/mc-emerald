package com.doontcare.me.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CommandGet implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("get")) {
            if (!(sender instanceof Player))
                return false;

            Player player = (Player) sender;
            if (!player.isOp())
                return false;

            if (!(args.length == 1)) {
                player.sendMessage(ChatColor.RED + "Correct usage: /get <item>");
                return false;
            }

            String targetItem = args[0];
            Bukkit.broadcastMessage(targetItem);
            if (targetItem.equalsIgnoreCase("item_dash")) {
                ItemStack dashItem = new ItemStack(Material.STICK);
                ItemMeta dashMeta = dashItem.getItemMeta();
                dashMeta.setDisplayName("§cDash Ability");
                List<String> lore = new ArrayList<>();
                lore.add("§7This ability throws you into the");
                lore.add("§7direction you are looking at");
                lore.add("");
                lore.add("§aPress [2] to use this ability");
                dashMeta.setLore(lore);
                dashItem.setItemMeta(dashMeta);
                player.getInventory().addItem(dashItem);
                player.sendMessage("§aItem §e" + targetItem + " §areceived");
                return false;
            }

        }
        return false;
    }
}
