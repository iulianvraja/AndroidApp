package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Databases.DataBaseHelper;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class New_Premium extends AppCompatActivity {
    private String name;
    private String pass;
    private String goals;
    private DataBaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name=null;
        pass=null;
        goals=null;
        setContentView(R.layout.new_account);
        db = new DataBaseHelper(this);
        ArrayList<String> goal=new ArrayList<>();
        goal.add("Choose your goal to receive information");
        goal.add("Road to 75kg");
        goal.add("Road to 85kg");
        goal.add("Road to 95kg");
        goal.add("Muscle Defining");
        action_create();
        final Spinner x = (Spinner) findViewById(R.id.spinGoal);
        x.setAdapter(new ArrayAdapter<>(New_Premium.this, android.R.layout.simple_spinner_dropdown_item, goal));
        x.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Select Item", Toast.LENGTH_SHORT).show();
                } else {
                    goals = parent.getItemAtPosition(position).toString();
                    System.out.println(goals);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }
    private void action_create(){
        Button b=findViewById(R.id.createAcc);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText txt= findViewById(R.id.accountName);
                name=txt.getText().toString();
                EditText txt2=findViewById(R.id.accountPass);
                pass=txt2.getText().toString();
                if(goals!=null && name!=null && pass!=null){
                    db.insertAccount(name,pass,goals);
                    System.out.println("account inserted");
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(),"Review your choose and make sure you completed all",Toast.LENGTH_SHORT);
            }
        });
    }
}
