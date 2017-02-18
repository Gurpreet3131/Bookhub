package com.example.dragneel.bookhub;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText Etusername;
    EditText Etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        final Button  bRegister= (Button) findViewById(R.id.bRegister);

        Etusername = (EditText) findViewById(R.id.Etusername);
        Etpassword = (EditText) findViewById(R.id.Etpassword);
        Button bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                String username= "123",password = "456";
                System.out.println(username+ " " + password);

                username = Etusername.getText().toString();
                password = Etpassword.getText().toString();

                System.out.println(username+ " " + password);


                MyDatabase obj = new MyDatabase(MainActivity.this);
                Cursor c = obj.myLogin(username, password);
                if(c!=null)
                {
                    c.moveToFirst();
                    Intent i = new Intent(MainActivity.this, userprofile.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
                }
                /*Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            //System.out
                            Log.v("jksdhf",response);
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success"); // variable to be changed
                            String uname = jsonResponse.getString("uname");
                            String pass = jsonResponse.getString("pass");
                            System.out.println(uname + " " + pass);
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
                queue.add(loginreq);*/
            }
        });

    }
    public void registerfunc(View view){
        Intent intent= new Intent(this,register.class);
        startActivity(intent);
    }



}
