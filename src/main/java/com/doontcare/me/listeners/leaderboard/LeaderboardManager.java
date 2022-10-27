package com.doontcare.me.listeners.leaderboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class LeaderboardManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("testboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6§l⭐ §eServer Name               ");

        Score empty2 = obj.getScore("  ");
        empty2.setScore(7);

        Score name = obj.getScore("§7Name: §f" + p.getName());
        name.setScore(6);

        Score rank = obj.getScore("§7Rank: §cProfessional §a(1.2x)");
        rank.setScore(5);

        Score balance = obj.getScore("§7Bank: §a$0.00");
        balance.setScore(4);

        Score classes = obj.getScore("§7Class: §eMelee");
        classes.setScore(3);

        Score empty = obj.getScore(" ");
        empty.setScore(2);

        Score website = obj.getScore("§7§owww.servername.com");
        website.setScore(1);

        p.setScoreboard(board);
    }
}
