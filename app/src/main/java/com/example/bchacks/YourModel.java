package com.example.bchacks;

public class YourModel {
    private String profileName;
    private String profileDescription;
    private int imageResource;

    public YourModel(String profileName, String profileDescription, int imageResource) {
        this.profileName = profileName;
        this.profileDescription = profileDescription;
        this.imageResource = imageResource;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public int getImageResource() {
        return imageResource;
    }
}
