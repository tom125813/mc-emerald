package com.doontcare.me.customeffects;

import com.doontcare.me.Emerald;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class CustomEffect {

    private String identifier;
    private String name;
    private List<String> lore;

    private List<String> chatMessages;

    // effects
    private List<PotionType> potionTypes;

    // cosmetics
    private List<Particle> particles;
    private List<Sound> sounds;

    public CustomEffect(
            String identifier, String name, List<String> lore, List<PotionType> potionTypes,
            List<Particle> particles, List<Sound> sounds, String... chatMessages) {
        try {
            this.identifier = identifier;
            this.name = name;
            this.lore = lore;
            this.potionTypes = potionTypes;
            this.particles = particles;
            this.sounds = sounds;
            this.chatMessages = Arrays.stream(chatMessages).toList();

            Emerald.getInstance().getCustomEffectManager().customEffects.add(this);
            Bukkit.broadcastMessage("[EMERALD] [CUSTOM EFFECTS] Effect " + identifier + " has loaded correctly");
        } catch (Exception ex) {
            Bukkit.broadcastMessage("[EMERALD] [CUSTOM EFFECTS] Effect " + identifier + " has not loaded correctly");
        }
    }

    public String getIdentifier() {
        return identifier;
    }

}
