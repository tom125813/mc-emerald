package com.doontcare.me;

import com.doontcare.me.commands.CommandGamemode;
import com.doontcare.me.commands.admin.CommandGet;
import com.doontcare.me.abilities.dash.CommandDash;
import com.doontcare.me.holograms.HologramManager;
import com.doontcare.me.listeners.leaderboard.LeaderboardManager;
import com.doontcare.me.listeners.*;
import com.doontcare.me.abilities.dash.ListenerDash;
import com.doontcare.me.listeners.ListenerFoodBar;
import com.doontcare.me.player.PlayerManager;
import com.doontcare.me.ranks.RankManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Emerald extends JavaPlugin {

    /* TODO:
     *  - Player OOP
     *      - Levels
     *         -Input levels into stats
     *      - Class
     *        -make classes work/be able to pick one
     *      - Stats
     *        - use levels to have stats to upgrade the actual character
     *      - Rank
     *          (will do later)
     *      -Inventory
     *         -When shifted it switches there inventory to there skills and when shifted again it switches back to there weapons
     *      - Damage Indicators
     *  - Levelling system
     *      - Uses exp bar to display
     *      - Will also be displayed on leaderboard
     *  - Leaderboard
     *      - Rank
     *          - Shows levelling up multiplier
     *      - Shows level
     *      - Show region player is in
     *  - Classes
     *      - Assassin
     *          - Custom abilities
     *              - Invisibilty (short duration)
     *              - Speed Buff and light jump boost/Body flicker ability (short cooldown)
     *              - Smoke Bomb (Area of Effect(AOE))
     *              - Teleport (short distance) (long cooldown)
     *              - Summon Zombies (Long cooldown) roughly 3-5
     *              - Dash (complete)
     *          - Custom items
     *              - Daggers
     *                  -Starter Daggers (higher attack speed and lower damage)
     *                      - Wooden Dagger (worst but starting Weapon, more speed, less damage)
     *                      - Golden Dagger (2nd worse, more Damage than Wooden and Less Speed.
     *                      - Iron Dagger ( 3rd Worst, more damage and less attack speed bleed effect)
     *                      - Copper Daggers (Worse than Diamond but has a higher attack speed and damage than iron)
     *                      - Steel Daggers (More Damage than Diamond, less attack speed (same as iron)Possibly a bleed effect and same movement speed as Diamond
     *                      - Diamond Dagger (More Damage than the Iron Dagger and More attack Speed, and tad more movement speed)
     *                      - Amethyst Dagger (Better Than Diamond in every term, and include bleed)
     *                      BLEED EFFECT( ENEMY WILL TAKE TICS OFF THERE HP)
     *                      STUN EFFECT( ENEMY WILL GET SLOWNESS AND BLINDESS FOR 1 SECOND)
     *                      Lifesteal effect( When enemy is attacked, a small portion of hp is taken from there hp and add to the players)
     *                  - Magic Daggers
     *                      - Fire Dagger (Can shoot fireball (charge it)with right click, also have fire aspect) not a lot of damage
     *                      - Poison Dagger (when attack enemys they are inflicted with poison
     *                      - Ice Dagger (when it hits opponent they get slowness (cooldown) and when it right click ir shoots a light blue particle which freezes them)
     *                      - Earth Dagger (When held it increases resistance and when right click is held down it implements a fall of dirt)
     *                      - Lightning Dagger (Teleport when right click (short cooldown) then it ends and its a longer cooldown)
     *                      - Magma Dagger (when right click it summons a poll of lava in ur area, fire aspect)
     *                  - Secret Daggers
     *                      - A Hidden Dagger hidden in a dungeon. (Only one of them) Really high dmaage(will tell specifics later)
     *                      - A Hidden Weapon behind a gap (will tell specifics later)
     *                  - Mid-Game Daggers
     *                      - Enchanted Amethyst Dagger ( Does more damage than the previous Amthyst Dagger, and increased attack speed and character movement
     *                      - Obsidian Dagger ( Does More damage lower attack speed and slower character and the stun effect randomly)
     *                      - Mythril Dagger ( Does More damage, bleed effect and higher attack speed and high movement speed)
     *                      - Palladium Dagger ( Does More Damage, fire effect, higher attack speed and same movement speed)
     *                      - Orichalcum Dagger ( Does More Damage, Lifesteal effect, same attack speed, same movement speed)
     *                 End-Game Daggers:
     *                      -
     *                   - Boss Drop Daggers
     *                      - will be made when bosses are made
     *                  - Dungeon Drop Daggers
     *                      -will be made when dungeons are made
     *                  - Useless Daggers
     *                      -Carbon Dagger
     *                      -Glass Dagger
     *                      -Plastic Dagger
     *              - Cloak of Invisiblity
     *      - Swordsman
     *          - Custom abilities
     *              - Explosion Strike (short distance) ( 10 seconds)
     *              - Block (Recieves a small amount of damage) (short cooldown(5seconds))
     *              - Dash (complete)
     *              - Stab (Attack an enemy high damage)
     *              - Sharpness (Increases sword damage and increases players speed) Skill Display name: (will come back to it)
     *              - Dash and attack enemy nearby (AOE) (Use dash mechanic before and attack nearby mobs)
     */

    private static Emerald instance;
    private static Plugin instance2;

    private PlayerManager playerManager;
    private RankManager rankManager;
    private HologramManager hologramManager;

    private transient ListenerBlock blockListener;
    private transient ListenerEXP expListener;
    private transient ListenerCraftingAnvils listenerCraftingAnvils;
    private transient ListenerPlayerDeath listenerPlayerDeath;
    private transient ListenerClassesMenu listenerPlayerJoinSpawn;


    @Override
    public void onEnable() {
        instance = this;
        instance2 = this;

        playerManager = new PlayerManager();
        rankManager = new RankManager();
        hologramManager = new HologramManager();

        playerManager.init();
        rankManager.init();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ListenerEXP(), this);
        pm.registerEvents(new ListenerBlock(), this);
        pm.registerEvents(new ListenerDash(), this);
        pm.registerEvents(new ListenerPlayerDeath(), this);
        pm.registerEvents(new ListenerClassesMenu(), this);
        pm.registerEvents(new ListenerCraftingAnvils(), this);
        pm.registerEvents(new ListenerFoodBar(), this);
        pm.registerEvents(new LeaderboardManager(), this);
        pm.registerEvents(new ListenerSlotChange(), this);

        getCommand("c").setExecutor(new CommandGamemode());
        getCommand("dash").setExecutor(new CommandDash(this));
        getCommand("get").setExecutor(new CommandGet());
    }

    @Override
    public void onDisable() {
        // Save data into json & config
    }

    public HologramManager getHologramManager() {return hologramManager;}
    public PlayerManager getPlayerManager() {return playerManager;}
    public RankManager getRankManager() {return rankManager;}
    public static Emerald getInstance() {return instance;}
    public static Plugin getPlugin() {return instance2;}

}
