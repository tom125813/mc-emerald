package com.doontcare.me.ranks;

import com.doontcare.me.player.PlayerData;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RankManager {

    private List<Rank> ranks;
    public HashMap<Rank, List<UUID>> playerDataHashMap = new HashMap<>();

    public void init() {}

}
