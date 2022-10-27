package com.doontcare.me.customeffects.effects;

import com.doontcare.me.customeffects.CustomEffect;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.potion.PotionType;

import java.util.List;

public class Bleed extends CustomEffect {

    public Bleed(String identifier, String name, List<String> lore, List<PotionType> potionTypes, List<Particle> particles, List<Sound> sounds, String... chatMessages) {
        super(identifier, name, lore, potionTypes, particles, sounds, chatMessages);
    }

}
