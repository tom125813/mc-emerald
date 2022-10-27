package com.doontcare.me.listeners;


import com.doontcare.me.events.PlayerDiedEvent;
import com.doontcare.me.utils.UtilsChat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class ListenerPlayerDeath implements Listener {

    @EventHandler
    public void deathEvent(EntityDamageEvent e) {
        if (e.getEntity().getType() != EntityType.PLAYER)
            return;

        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
            return;
        }

        double damage = e.getDamage();
        double health = ((LivingEntity)e.getEntity()).getHealth();
        if (health-damage <= 0) {
            e.setCancelled(true);

            Player player =  (Player) e.getEntity();
            PlayerDiedEvent deathEvent = new PlayerDiedEvent(player);
            Bukkit.getPluginManager().callEvent(deathEvent);

            // Reset health & hunger
            player.setHealth(((LivingEntity)e.getEntity()).getMaxHealth());
            player.setFoodLevel(20);

            // Display to player
            player.playSound(e.getEntity().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            player.sendTitle(
                    UtilsChat.translateHexCodes("&#3E0303Y&#570303o&#700202u&#890202 &#A10202d&#BA0202i&#D30101e&#EC0101d"),
                    "§7You have been sent to spawn",
                    0,
                    30,
                    10
            );

            // Teleport to spawn
            // ...
            player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 100, 0.5));
        }
    }

}