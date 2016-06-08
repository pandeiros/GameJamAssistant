package com.wpam.gamejamapp.model;

import com.wpam.gamejamapp.R;

/**
 * Created by milor on 6/3/2016.
 */
public class Role {
    public enum RoleType {
        CODE(R.color.role_code, "CODE", "Programmer"),
        GRAPHICS(R.color.role_graphics, "GRAPHICS", "Graphic designer"),
        SOUND(R.color.role_sound, "SOUND", "Sound designer"),
        STORY(R.color.role_story, "STORY", "Story designer");

        private final int color;
        private final String title;
        private final String function;

        RoleType(int color, String title, String function) {
            this.color = color;
            this.title = title;
            this.function = function;
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

    public String getFunction() {
        return role.function;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(final boolean isSelected) {
        this.isSelected = isSelected;
    }
}
