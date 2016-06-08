package com.wpam.gamejamapp.model;

public class Game extends DbObject{
    private String name;
    private Team team;
    private Boolean isSelected = false;

    int height = 0;

    public Game(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public Boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(final Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
