package com.example.bchacks;

public class ListData {
    String name, time;
    int ingredients, desc;
    int image;

    public ListData(String name, int desc, int image) {
        this.name = name;
        //this.time = time;
        //this.ingredients = ingredients;
        this.desc = desc;
        this.image = image;
    }
}