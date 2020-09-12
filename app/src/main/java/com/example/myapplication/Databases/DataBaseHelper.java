package com.example.myapplication.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.FullDataAntrenament;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String dataName="Antrenament.db";
    private static final String antrenamentTable="Antrenament_table";
    private static final String paccount="PremiumAccount";
    private static final String Col_Day="Day";
    private static final String Col_Sets="Sets";
    private static final String Col_Reps="Reps";
    private static final String Col_Ex="Exercitiu";
    private static final String Col_Antrenament="Antrenament";


    public DataBaseHelper(@Nullable Context context) {
        super(context, dataName, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+antrenamentTable+" (Day Text,Sets Text,Reps Text,Exercitiu Text,Antrenament Text) ");
        db.execSQL("create table "+paccount+" (AccountName Text,Password Text,Goal Text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table "+paccount+" (AccountName Text,Password Text,Goal Text) ");

    }

    public boolean insertAccount(String name, String pass, String goal){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cnt=new ContentValues();
        cnt.put("AccountName",name);
        cnt.put("Password",pass);
        cnt.put("Goal",goal);

        long res=db.insert("PremiumAccount",null,cnt);
        if(res==-1)
            return false;
        else
            return true;

    }

    public boolean existUser(String name, String pass){
        System.out.println(name+" "+pass);
        String sq="SELECT * FROM "+paccount+" where AccountName='"+name+"'"+" AND Password='"+pass+"'";
        SQLiteDatabase db=getWritableDatabase();
        Cursor cx=db.rawQuery(sq,null);



        if(cx.getCount()==0){

            return false;}

        return true;
    }


    public boolean insert(String Day, String Sets, String Reps,String Ex,String Antrenament){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cnt=new ContentValues();
        cnt.put(Col_Day,Day);
        cnt.put(Col_Sets,Sets);
        cnt.put(Col_Reps,Reps);
        cnt.put(Col_Ex,Ex);
        cnt.put(Col_Antrenament,Antrenament);
        long res=db.insert(antrenamentTable,null,cnt);
        if(res==-1)
            return false;
        else
            return true;

    }

    public ArrayList<String> getallAntrenaments(){
        String sq="Select Distinct Antrenament from "+antrenamentTable;
        SQLiteDatabase db=getWritableDatabase();
        Cursor cx=db.rawQuery(sq,null);
        ArrayList<String> retName=new ArrayList<>();
        if(cx.getCount()==0)
            return null;
        else {
            while(cx.moveToNext()){
                retName.add(cx.getString(0));
            }
        }
        return retName;
    }

    public ArrayList<FullDataAntrenament> getEx(String Antr){
        String sq="Select * from "+antrenamentTable+" where Antrenament like"+"'%"+Antr+"%'";
        SQLiteDatabase db=getWritableDatabase();
        Cursor cx=db.rawQuery(sq,null);
        ArrayList<FullDataAntrenament> retName=new ArrayList<>();
        String s="";
        if(cx.getCount()==0)
            return null;
        else {
            while(cx.moveToNext()){
                FullDataAntrenament x=new FullDataAntrenament(cx.getString(0),cx.getString(1),cx.getString(2),cx.getString(3));

              retName.add(x);
            }
        }
        return retName;
    }
}
