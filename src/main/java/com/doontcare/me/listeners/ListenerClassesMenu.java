package com.doontcare.me.listeners;

import com.doontcare.me.events.PlayerDiedEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ListenerClassesMenu implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        openInventory(e.getPlayer());
    }

    @EventHandler
    public void onDeath(PlayerDiedEvent e) {
        //openInventory(e.getPlayer());
    }

    private void openInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, ChatColor.DARK_GRAY + "Class Selection");

        ItemStack item = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Assassin");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "Hide in the the shadows and work alone..");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        inv.setItem(1, item);

        ItemStack item1 = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(ChatColor.GOLD + "Swordsman");
        List<String> lore1 = new ArrayList<>();
        lore1.add("");
        lore1.add(ChatColor.RED + "Become a Fabled Swordsman!");
        meta1.setLore(lore1);
        meta1.addEnchant(Enchantment.DURABILITY, 1, true);
        meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item1.setItemMeta(meta1);
        inv.setItem(3, item1);

        ItemStack item2 = new ItemStack(Material.POTION);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.AQUA + "Alchemist");
        List<String> lore2 = new ArrayList<>();
        lore2.add("");
        lore2.add(ChatColor.RED + "Learn the Magic of Potions!");
        meta2.setLore(lore2);
        meta2.addEnchant(Enchantment.DURABILITY, 1, true);
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        item2.setItemMeta(meta2);
        inv.setItem(5, item2);

        ItemStack item3 = new ItemStack(Material.BOW);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName(ChatColor.GREEN + "Archer");
        List<String> lore3 = new ArrayList<>();
        lore3.add("");
        lore3.add(ChatColor.GREEN + "Learn the way of the bow!");
        meta3.setLore(lore3);
        meta3.addEnchant(Enchantment.DURABILITY, 1, true);
        meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item3.setItemMeta(meta3);
        inv.setItem(7, item3);

        ItemStack item4 = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName(ChatColor.DARK_RED + "Tank");
        List<String> lore4 = new ArrayList<>();
        lore4.add("");
        lore4.add(ChatColor.GREEN + "Become the wall for your teammates!");
        meta4.setLore(lore4);
        meta4.addEnchant(Enchantment.DURABILITY, 1, true);
        meta4.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item4.setItemMeta(meta4);
        inv.setItem(11, item4);

        ItemStack item5 = new ItemStack(Material.HONEYCOMB);
        ItemMeta meta5 = item5.getItemMeta();
        meta5.setDisplayName(ChatColor.YELLOW + "Healer");
        List<String> lore5 = new ArrayList<>();
        lore5.add("");
        lore5.add(ChatColor.GREEN + "Become the Healer!");
        meta5.setLore(lore5);
        meta5.addEnchant(Enchantment.DURABILITY, 1, true);
        meta5.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item5.setItemMeta(meta5);
        inv.setItem(13, item5);

        ItemStack item6 = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta6 = item6.getItemMeta();
        meta6.setDisplayName(ChatColor.BLACK + "Melee");
        List<String> lore6 = new ArrayList<>();
        lore6.add("");
        lore6.add(ChatColor.GREEN + "Brawl with your enemies!");
        meta6.setLore(lore6);
        meta6.addEnchant(Enchantment.DURABILITY, 1, true);
        meta6.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item6.setItemMeta(meta6);
        inv.setItem(15, item6);

        for (int slot = 0; slot < inv.getSize(); slot++) {
            if (inv.getItem(slot) == null) {
                inv.setItem(slot, new ItemStack(Material.PURPLE_STAINED_GLASS_PANE));
            }
        }

        player.openInventory(inv);

    }

}

