package com.example.myapplication;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Databases.DataBaseHelper;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ShowAntrenamentsIntent extends AppCompatActivity {
    private DataBaseHelper db;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_antrenament);
        Bundle extras = getIntent().getExtras();
        String AntrenamentName=extras.getString("AntrenamentName");
        TextView tx=findViewById(R.id.tw1);
        tx.setText(AntrenamentName);
        tx.setVisibility(View.VISIBLE);
        db=new DataBaseHelper(this);
        System.out.println("Antrenament="+AntrenamentName);
        ArrayList<String> a=db.getallAntrenaments();
        System.out.println("Some data "+a.get(0));

       ListView listView = findViewById(R.id.ListSh);

        ArrayList<FullDataAntrenament> ar=new ArrayList<>();
        AdapterList data_adapter = new AdapterList(this, db.getEx(AntrenamentName));
        ar=db.getEx(AntrenamentName);
        for(FullDataAntrenament j:ar)
            System.out.println(j.getDay()+" "+j.getExe());
    listView.setAdapter(data_adapter);
        listView.setVisibility(View.VISIBLE);
    }
}
