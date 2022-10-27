package com.doontcare.me.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    public HashMap<UUID, PlayerData> playerDataHashMap = new HashMap<>();

    public void init() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            // read shiiiiiiit
        }
    }

}
