package com.doontcare.me.classes;

import org.bukkit.ChatColor;
import org.bukkit.permissions.PermissionAttachment;

import java.util.List;

public class Class {

    private String identifier;
    private String suffix;

    public Class() {}

    public Class(String identifier, String suffix) {
        this.identifier = identifier;
        this.suffix = suffix;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

}
