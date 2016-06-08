package com.wpam.gamejamapp.model;

import com.wpam.gamejamapp.R;

public class CategoryTag {
    public enum Category {
        PROGRAMMING(R.color.category_programming),
        GRAPHICS(R.color.category_graphics),
        SOUND(R.color.category_programming),
        DESIGN(R.color.category_design),
        MOBILE(R.color.category_programming),
        STORY(R.color.category_programming),
        WEB(R.color.category_programming),
        ENGINE(R.color.category_graphics);

        private final int color;

        Category(int color) {
            this.color = color;
        }

        public int color(){
            return color;
        }
    }

    private Category tag;
    private String name;
    private boolean isSelected = false;

    public CategoryTag(final Category tag, final String name) {
        this.tag = tag;
        this.name = name;
    }

    public int getColor(){
        return tag.color();
    }

    public String getName() {
        return name;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public void setIsSelected(final boolean isSelected){
        this.isSelected = isSelected;
    }
}
