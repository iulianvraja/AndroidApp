package com.example.myapplication;

public class Exercice {
    protected String Exe;
    protected String Reps;
    protected String Sets;

    public Exercice(String e,String r,String s){
        Exe=e;
        Reps=r;
        Sets=s;
    }

    public String getSets() {
        return Sets;
    }

    public void setSets(String sets) {
        Sets = sets;
    }

    public String getExe() {
        return Exe;
    }

    public void setExe(String exe) {
        Exe = exe;
    }

    public String getReps() {
        return Reps;
    }

    public void setReps(String reps) {
        Reps = reps;
    }
}
