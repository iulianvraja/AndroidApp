package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Databases.DataBaseHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> ex;
    private String day;
    private String AntrenamentName;
    private DataBaseHelper db;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private static final int THIRD_ACTIVITY_REQUEST_CODE = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);
       /* db=openOrCreateDatabase("TrainingsBase",MODE_PRIVATE,null);
        db.execSQL("Create Table if not exists Training (Text name,Text day, Text exercice,Integer reps,Integer pictureId)");*/
        Button button = findViewById(R.id.NewAntrenament);
        ListView listView = findViewById(R.id.AntrenamentView);

        ArrayAdapter<String> data_adapter = new ArrayAdapter<>(this, R.layout.list_ant, db.getallAntrenaments());
        listView.setAdapter(data_adapter);
        listView.setVisibility(View.INVISIBLE);
        actionshow();
        actioncreate_account();
        actionlogin();

        TextView twyy=findViewById(R.id.PremiumLogin);
        twyy.setVisibility(View.INVISIBLE);

        ex = new ArrayList<String>();
        ex.add("Chose a day");
        ex.add("Monday");
        ex.add("Tuesday");
        ex.add("Wednesday");
        ex.add("Thursday");
        ex.add("Friday");
        ex.add("Saturday");
        ex.add("Sunday");
        final Button bt = findViewById(R.id.button);
        final Spinner x = (Spinner) findViewById(R.id.spinDay2);
        final EditText nameTxt = (EditText) findViewById(R.id.nameText);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Am dat click");

                TextView t2 = findViewById(R.id.textView);
                t2.setVisibility(View.VISIBLE);
                TextView t3 = findViewById(R.id.textView5);
                t3.setVisibility(View.VISIBLE);
                bt.setVisibility(View.VISIBLE);
                x.setVisibility(View.VISIBLE);
                nameTxt.setVisibility(View.VISIBLE);
            }
        });


        //AntrenamentName=nameTxt.getText().toString();


        x.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, ex));
        x.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Select Item", Toast.LENGTH_SHORT).show();
                } else {
                    day = parent.getItemAtPosition(position).toString();
                    System.out.println(day);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AntrenamentName = nameTxt.getText().toString();
                System.out.println(AntrenamentName);
                if (AntrenamentName == null)
                    Toast.makeText(getApplicationContext(), "Select a name", Toast.LENGTH_SHORT).show();
                else{
                        Intent i=new Intent(MainActivity.this, Add_Training.class);
                        i.putExtra("AntrenamentName",AntrenamentName);
                        i.putExtra("DayName",day);
                    startActivityForResult(i, SECOND_ACTIVITY_REQUEST_CODE);}
            }
        });
        actiononList();
    }

    private void actiononList(){
        ListView ls=findViewById(R.id.AntrenamentView);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Antrenament=parent.getItemAtPosition(position).toString();
                Intent i=new Intent(MainActivity.this, ShowAntrenamentsIntent.class);
                i.putExtra("AntrenamentName",Antrenament);
                System.out.println("Main ANtrenamentname"+Antrenament);
                startActivity(i);
            }
        });
    }
    private void actionshow() {

        Button shAnt = findViewById(R.id.ShowAntrenaments);
        shAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = findViewById(R.id.AntrenamentView);
                if (listView.getVisibility() == View.VISIBLE) {
                    listView.setVisibility(View.INVISIBLE);
                } else
                    listView.setVisibility(View.VISIBLE);
            }
        });
    }
    private void actioncreate_account(){
        Button x=findViewById(R.id.paccount);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,New_Premium.class));
            }
        });
    }
    private void actionlogin(){
        Button bt=findViewById(R.id.log);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                startActivityForResult(i,THIRD_ACTIVITY_REQUEST_CODE);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                ArrayAdapter<String> data_adapter = new ArrayAdapter<>(this, R.layout.list_ant,db.getallAntrenaments());
                ListView listView = findViewById(R.id.AntrenamentView);
                listView.setAdapter(data_adapter);
                listView.setVisibility(View.INVISIBLE);
                EditText nameTxt = (EditText) findViewById(R.id.nameText);
                nameTxt.setVisibility(View.INVISIBLE);
                TextView tx=findViewById(R.id.textView);
                tx.setVisibility(View.INVISIBLE);

            }
        }

        if (requestCode == THIRD_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
               TextView tw=findViewById(R.id.PremiumLogin);
               tw.setText("You are logged on the premium account.Congratulations!");
               tw.setVisibility(View.VISIBLE);
            }
        }
    }


}
