package com.doontcare.me.abilities.dash;

import com.doontcare.me.Emerald;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.util.Vector;

import java.text.DecimalFormat;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CommandDash implements CommandExecutor {

    private Emerald emerald;
    public CommandDash(Emerald emerald) {
        this.emerald = emerald;
    }

    private final long cooldownLength = 5;
    public Cache<UUID,Long> dashCache = CacheBuilder.newBuilder().expireAfterWrite(cooldownLength, TimeUnit.SECONDS).build();

    // particle trail while player is flying

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("dash")) {
            if (sender instanceof Player)
                return false;

            if (args.length == 1) {
                String target = args[0];
                Player player = null;
                try {
                    Player targetPlayer = Bukkit.getPlayer(target);
                    UUID targetUUID = targetPlayer.getUniqueId();

                    if (dashCache.asMap().containsKey(targetUUID)) {
                        //targetPlayer.playSound(targetPlayer.getLocation(), Sound.BLOCK_CHAIN_HIT, 1, -10);
                        targetPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(
                                "§c§lDASH [2]      §7You must wait §c" + new DecimalFormat("0.00").format((double)(dashCache.asMap().get(targetUUID)-System.currentTimeMillis())/1000) + "s §7before dashing again"));
                        return false;
                    }

                    targetPlayer.setVelocity(targetPlayer.getVelocity().add(
                            new Vector(
                                    targetPlayer.getLocation().getDirection().getX() * 1.5,
                                    targetPlayer.getLocation().getDirection().getY() * 1.5,
                                    targetPlayer.getLocation().getDirection().getZ() * 1.5
                            )));

                    //magical ding innit
                    //targetPlayer.playSound(targetPlayer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 1, 1);
                    //targetPlayer.playSound(targetPlayer.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_CHIME, 1, 1);
                    //targetPlayer.playSound(targetPlayer.getLocation(), Sound.BLOCK_BELL_RESONATE, 1, 1);
                    // magical particle innit (yellow dot)
                    //targetPlayer.spawnParticle(Particle.TOTEM, targetPlayer.getLocation(), 500);


                    // visual effects
                    targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_PHANTOM_FLAP, 1, 1);
                    targetPlayer.spawnParticle(Particle.EXPLOSION_NORMAL, targetPlayer.getLocation(), 500);
                    targetPlayer.getInventory().setHeldItemSlot(0);

                    targetPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(
                            "§a§lDASH [2]      §7This ability can be used again in §a" + cooldownLength + "s"));

                    dashCache.put(targetPlayer.getUniqueId(), System.currentTimeMillis()+(cooldownLength*1000));
                } catch (Exception ex) {}

            }

        }
        return false;
    }

}