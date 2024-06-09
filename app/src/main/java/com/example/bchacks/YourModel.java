package com.example.bchacks;

public class YourModel {
    public String name;
    public String location;
    public int GROLvl;
    public String minimum;
    public String maximum;
    public String type;
    public String stage;
    public String shortDescription;
    public String description;
    public int imageResource;
    public String phoneNumber;
    public String email;
    public String tag1;
    public String tag2;
    public String founder;
    public String employees;
    public String foundingDate;

    public YourModel(String name, String location, int GROLvl, String minimum, String maximum, String type, String stage,
                     String shortDescription, String description, int imageResource,
                     String phoneNumber, String email, String tag1, String tag2,
                     String founder, String employees, String foundingDate) {
        this.name = name;
        this.location = location;
        this.GROLvl = GROLvl;
        this.minimum = minimum;
        this.maximum = maximum;
        this.type = type;
        this.stage = stage;
        this.shortDescription = shortDescription;
        this.description = description;
        this.imageResource = imageResource;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.founder = founder;
        this.employees = employees;
        this.foundingDate = foundingDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
