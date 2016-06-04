package com.wpam.gamejamapp;

/**
 * Created by milor on 6/3/2016.
 */
public class Role {
    public enum RoleType {
        CODE(R.color.role_code, "CODE"),
        GRAPHICS(R.color.role_graphics, "GRAPHICS"),
        SOUND(R.color.role_sound, "SOUND"),
        STORY(R.color.role_story, "STORY");

        private final int color;
        private final String title;

        RoleType(int color, String title) {
            this.color = color;
            this.title = title;
        }

        public int color() {
            return color;
        }

        public String title() {
            return title;
        }
    }

    private RoleType role;
    private boolean isSelected = false;

    public Role(final RoleType role) {
        this.role = role;
    }

    public int getColor() {
        return role.color();
    }

    public String getTitle() {
        return role.title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(final boolean isSelected) {
        this.isSelected = isSelected;
    }
}
