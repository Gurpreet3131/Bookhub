package com.example.dragneel.bookhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView firstNameTv;
        EditText firstNameEt;
        GridView grid;
        grid = (GridView) findViewById(R.id.grid);
        firstNameTv = new TextView(this);
        firstNameEt = new EditText(this);
        firstNameTv.setText("First Name: ");
        grid.addView(firstNameTv);
        grid.addView(firstNameEt);
    }

}

