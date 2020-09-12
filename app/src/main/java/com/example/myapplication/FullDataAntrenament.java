package com.example.myapplication;

public class FullDataAntrenament extends Exercice {
    private String day;

    public FullDataAntrenament(String Day,String e,String r,String s){
        super(e, r, s);
        day=Day;
    }

    public String getDay() {
        return day;
    }


    public void setDay(String day) {
        this.day = day;
    }
}
