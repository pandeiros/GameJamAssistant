package com.wpam.gamejamapp.model;

public class Profile {
    private Team team;
    private String username;
    private Role role;
    private CategoryTag[] tags;

    public Profile(String username, Role role, Team team, CategoryTag[] tags){
        this.username = username;
        this.role = role;
        this.team = team;
        this.tags = tags;
    }

    public CategoryTag[] getTags() {
        return tags;
    }

    public String getUsername() {
        return username;
    }

    public Team getTeam() {
        return team;
    }

    public Role getRole() {
        return role;
    }
}
