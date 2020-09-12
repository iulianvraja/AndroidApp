package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Databases.DataBaseHelper;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private DataBaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    db = new DataBaseHelper(this);
    actionlogfinish();
    }

    private void actionlogfinish(){
        Button b=findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText it=findViewById(R.id.t1);
                EditText et=findViewById(R.id.p1);
                if(db.existUser(it.getText().toString(),et.getText().toString()))
                {  System.out.println("exista contul");
                    Intent intent = new Intent();
                    intent.putExtra("keyName", "LoginFinish");
                    setResult(RESULT_OK, intent);
                    finish();

                }

            }
        });


    }
}
