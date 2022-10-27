package com.doontcare.me.ranks;

import org.bukkit.ChatColor;
import org.bukkit.permissions.PermissionAttachment;

import java.util.List;

public class Rank {

    private String identifier;
    private String prefix;
    private ChatColor chatColor;
    private List<PermissionAttachment> permissions;

    public Rank() {}

    public Rank(String identifier, String prefix, ChatColor chatColor, List<PermissionAttachment> permissions) {
        this.identifier = identifier;
        this.prefix = prefix;
        this.chatColor = chatColor;
        this.permissions = permissions;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setChatColor(ChatColor chatColor) {
        this.chatColor = chatColor;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public void setPermissions(List<PermissionAttachment> permissions) {
        this.permissions = permissions;
    }

    public List<PermissionAttachment> getPermissions() {
        return permissions;
    }

}
