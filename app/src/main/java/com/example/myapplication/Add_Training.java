package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Databases.DataBaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_Training extends AppCompatActivity {
    private DataBaseHelper db;

    private String exercice;
    private String reps;
    private String sets;
    private static int notsel=1;
    private String AntrenamentDay;
    private String AntrenamentName;

    private static ArrayList<Exercice> newEx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_training);
        Bundle extras = getIntent().getExtras();
        AntrenamentName=extras.getString("AntrenamentName");
        AntrenamentDay=extras.getString("DayName");
        db = new DataBaseHelper(this);

        ArrayList<String> ex=new ArrayList<String>();
        ex.add("Chose an exercice");
        ex.add("ex1");
        ex.add("ex2");
        ex.add("ex3");
        ex.add("ex4");
        ex.add("ex5");
        ex.add("ex6");
        ex.add("ex7");

        ArrayList<Integer> ex2=new ArrayList<Integer>();

        for(int i=0;i<=25;i++)
            ex2.add(i);

        ArrayList<Integer> ex3=new ArrayList<Integer>();

        for(int i=0;i<=25;i++)
            ex3.add(i);



        final Spinner x=(Spinner) findViewById(R.id.spinEx);
        x.setAdapter(new ArrayAdapter<>(Add_Training.this,android.R.layout.simple_spinner_dropdown_item,ex));
        x.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    Toast.makeText(getApplicationContext(),"Select Item",Toast.LENGTH_SHORT).show();}
                else{
                    exercice=parent.getItemAtPosition(position).toString();
                    notsel=1;
                    System.out.println(exercice);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                notsel=0;

            }
        });

        final Spinner x2=(Spinner) findViewById(R.id.spinReps);
        x2.setAdapter(new ArrayAdapter<>(Add_Training.this,android.R.layout.simple_spinner_dropdown_item,ex2));
        x2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    Toast.makeText(getApplicationContext(),"Select Item",Toast.LENGTH_SHORT).show();}
                else{
                    reps=parent.getItemAtPosition(position).toString();
                    notsel=1;
                    System.out.println(reps);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                notsel=0;

            }
        });

        final Spinner x3=(Spinner) findViewById(R.id.spinSets);
        x3.setAdapter(new ArrayAdapter<>(Add_Training.this,android.R.layout.simple_spinner_dropdown_item,ex3));
        x3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    Toast.makeText(getApplicationContext(),"Select Item",Toast.LENGTH_SHORT).show();}
                else{
                    sets=parent.getItemAtPosition(position).toString();
                    notsel=1;
                    System.out.println(sets);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
             notsel=0;
            }
        });

        Button button = findViewById(R.id.addex);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("button2 create exercice+ "+notsel+" "+exercice+" "+reps+" "+sets);
                if(notsel==1) {
                  db.insert(AntrenamentDay,sets,reps,exercice,AntrenamentName);
                    System.out.println("button2 create exercice");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please select exercice and reps",Toast.LENGTH_SHORT).show();
                }
                x.setSelection(0);
                x2.setSelection(0);
                x3.setSelection(0);
            }
        });

        Button bt2=findViewById(R.id.saveA);
        bt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println("button SaveA finalizare activitate");
                Intent intent = new Intent();
                intent.putExtra("keyName", "");
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

    public static ArrayList<Exercice> getNewEx() {
        return newEx;
    }

    public static void setNewEx(ArrayList<Exercice> newEx) {
        Add_Training.newEx = newEx;
    }
}
