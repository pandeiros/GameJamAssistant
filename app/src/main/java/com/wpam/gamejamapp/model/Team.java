package com.wpam.gamejamapp.model;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private String name;
    private Game game;
    private Set<Profile> members;

    public Team(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    public void addMember(Profile member) {
        if (members == null)
            members = new HashSet<>();

        members.add(member);
    }
    public Set<Profile> getAllMembers() {
        return members;
    }
}
