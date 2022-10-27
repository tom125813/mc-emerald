package com.doontcare.me.player;

import com.doontcare.me.ranks.Rank;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerData {

    private Player player;
    private UUID uuid;

    private Rank rank;
    private double level;
    private double balance;

    public PlayerData() {

    }

    public String getName() {
        return player.getName();
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public double level() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
