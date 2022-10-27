package com.doontcare.me.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDiedEvent extends Event {

    private Player player;
    private EntityDamageEvent.DamageCause cause;

    private static final HandlerList HANDLERS = new HandlerList();

    public PlayerDiedEvent(Player player) {
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return player;
    }



    public EntityDamageEvent.DamageCause getCause() {
        return cause;
    }

}
