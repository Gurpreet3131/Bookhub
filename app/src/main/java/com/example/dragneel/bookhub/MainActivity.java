package com.example.dragneel.bookhub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        final Button  bRegister= (Button) findViewById(R.id.bRegister);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

    }

    public void loginfunc(View view){
        Intent intent= new Intent(this,register.class);

        startActivity(intent);
    }
    public void registerfunc(View view){
        Intent intent= new Intent(this,register.class);

        startActivity(intent);
    }



}
