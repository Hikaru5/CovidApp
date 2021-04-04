package com.example.covidapp.models;

public class State {

    public String stateName;
    public int deathCount;
    public int infectedCount;
    public int recoveredCount;
    public String imgPath;

    public State(String stateName, Integer deathCount, Integer infectedCount, Integer recoveredCount, String imgPath) {
        this.stateName = stateName;
        this.deathCount = deathCount;
        this.infectedCount = infectedCount;
        this.recoveredCount = recoveredCount;
        this.imgPath = imgPath;//imgPath is the place where the state's image is stored at
    }
}
