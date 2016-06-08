package com.wpam.gamejamapp.db;

import com.wpam.gamejamapp.model.CategoryTag;
import com.wpam.gamejamapp.model.Game;
import com.wpam.gamejamapp.model.Profile;
import com.wpam.gamejamapp.model.Role;
import com.wpam.gamejamapp.model.Team;

import java.util.HashMap;
import java.util.Map;

public class DB {
    static private DB instance;

    private DB() {

    }

    static public DB getInstance() {
        if (instance == null)
            instance = new DB();

        return instance;
    }

    public void refresh() {
        profiles = new HashMap<>();
        teams = new HashMap<>();
        games = new HashMap<>();

        Team team = new Team("WPAM Team");
        Profile profile1 = new Profile("Agata Dębska", new Role(Role.RoleType.CODE), team, new CategoryTag[]{
                new CategoryTag(CategoryTag.Category.PROGRAMMING, "C++"),
                new CategoryTag(CategoryTag.Category.ENGINE, "Unity")});
        team.addMember(profile1);
        profiles.put(0, profile1);

        Profile profile2 = new Profile("Pandeiros", new Role(Role.RoleType.CODE), team, new CategoryTag[]{
                new CategoryTag(CategoryTag.Category.PROGRAMMING, "C++"),
                new CategoryTag(CategoryTag.Category.ENGINE, "Unity")});
        team.addMember(profile2);
        profiles.put(1, profile2);

        Profile profile3 = new Profile("Markovnik", new Role(Role.RoleType.CODE), team, new CategoryTag[]{
                new CategoryTag(CategoryTag.Category.PROGRAMMING, "C++"),
                new CategoryTag(CategoryTag.Category.ENGINE, "Unity")});
        team.addMember(profile3);
        profiles.put(2, profile3);

        teams.put(0, team);

        games.put(0, new Game("Super Ultra Hyper Rocket Science Game VII", team));
        team.setGame(games.get(0));

        profile = profiles.get(1);
    }

    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public Game[] getGamesAsArray() {
        return games.values().toArray(new Game[0]);
//        Set<Game> gameSet = new HashSet<>();
//        for (Game g : games.values()) {
//            gameSet.add(g);
//        }
//        return games.
    }

    private Map<Integer, Game> games;
    private Map<Integer, Team> teams;
    private Map<Integer, Profile> profiles;
}
