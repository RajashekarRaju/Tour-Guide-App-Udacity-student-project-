package com.example.android.worldtourguide;

public class Country {
    private String name;
    private int worldRankings;
    private int thumbnail;

    Country(String name, int worldRankings, int thumbnail) {
        this.name = name;
        this.worldRankings = worldRankings;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getWorldRankings() {
        return worldRankings;
    }

    int getThumbnail() {
        return thumbnail;
    }

}