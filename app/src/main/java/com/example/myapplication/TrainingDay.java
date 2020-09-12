package com.example.myapplication;

import java.util.ArrayList;

public class TrainingDay {
    private String name;
    private String day;
    private ArrayList<String> exercice;
    private int reps;
    private int pictureId;

    public TrainingDay(){
        exercice=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<String> getExercice() {
        return exercice;
    }

    public void addex(String exe) {
       exercice.add(exe);
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
