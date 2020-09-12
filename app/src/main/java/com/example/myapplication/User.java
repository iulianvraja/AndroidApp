package com.example.myapplication;

import java.util.ArrayList;

public class User {

    private String id;
    private String type;
    private ArrayList<TrainingDay> trains;
    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<TrainingDay> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<TrainingDay> trains) {
        this.trains = trains;
    }
}
