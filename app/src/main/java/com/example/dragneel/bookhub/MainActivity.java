package com.example.dragneel.bookhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText Etusername;
    EditText Etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        final Button  bRegister= (Button) findViewById(R.id.bRegister);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

        Etusername = (EditText) findViewById(R.id.Etusername);
        Etpassword = (EditText) findViewById(R.id.Etpassword);


    }

    public void loginfunc(View view){

        Intent bk=new Intent(this,books.class);
        startActivity(bk);
/*
        final String username = Etusername.getText().toString();
        final String password = Etpassword.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success"); // variable to be changed

                    if(success)
                    {
                        // putextra the extra things
                        Intent in = new Intent(MainActivity.this, userprofile.class);
                        MainActivity.this.startActivity(in);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Login failed").setNegativeButton("Retry",null)
                                .create().show();
                    }
                }catch(JSONException e)
                {
                    e.printStackTrace();
                }
            }


        };

        loginRequest loginreq = new loginRequest(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(loginreq);
        */

    }
    public void registerfunc(View view){
        Intent intent= new Intent(this,register.class);
        startActivity(intent);
    }



}
