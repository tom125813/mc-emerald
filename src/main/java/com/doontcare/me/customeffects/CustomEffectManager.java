package com.doontcare.me.customeffects;

import com.doontcare.me.customeffects.effects.Bleed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class CustomEffectManager implements Listener {

    public List<CustomEffect> customEffects = new ArrayList<>();

    public void init() {
        Bleed bleed = new Bleed("customeffect_bleed", "Bleed", List.of("Lore1", "Lore2"), List.of(PotionType.INSTANT_DAMAGE), List.of(Particle.CLOUD), List.of(Sound.BLOCK_ANVIL_HIT), "","you are bleeding out", "");
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.PLAYER)
            return;
        if (e.getEntityType() != EntityType.PLAYER)
            return;

        Player damager = (Player) e.getDamager();
        Player damaged = (Player) e.getEntity();

        if (damager.getInventory().getItemInMainHand() == null)
            return;

        ItemStack item = damager.getInventory().getItemInMainHand();

        if (item.getItemMeta().getLore() == null)
            return;

        List<String> effects = item.getItemMeta().getLore().stream().toList();
        for (CustomEffect customEffect : customEffects)
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "(REAL) EFFECT: " + ChatColor.GREEN + customEffect.getIdentifier());
        for (String effect : effects)
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "(LORE) EFFECT: " + ChatColor.RED + effect);
    }

}