package com.example.dragneel.bookhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {

    EditText EtfirstName;
    EditText Etusername;
    EditText Etemail;
    EditText Etcontact;
    EditText Etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent in = getIntent();
        EtfirstName= (EditText) findViewById(R.id.EtfirstName);
        Etusername= (EditText) findViewById(R.id.Etusername);
        Etemail= (EditText) findViewById(R.id.Etemail);
        Etcontact= (EditText) findViewById(R.id.Etcontact);
        Etpassword= (EditText) findViewById(R.id.Etpassword);


    }

    public void regfunc(View view)
    {
        final String firstName = EtfirstName.getText().toString();
        final String username = Etusername.getText().toString();
        final String email = Etemail.getText().toString();
        final String contact = Etcontact.getText().toString();
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
                        Intent in = new Intent(register.this, MainActivity.class);
                        register.this.startActivity(in);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                        builder.setMessage("REgisster faield").setNegativeButton("Retry",null)
                                .create().show();
                    }
                }catch(JSONException e)
                {
                    e.printStackTrace();
                }
            }


        };

        registerRequest registerreq = new registerRequest(firstName, username, email, contact, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(register.this);
        queue.add(registerreq);

    }

    public void termsfunc(View view) {
        // Do something in response to button
        Intent in = new Intent(this,terms.class);
        startActivity(in);
    }

}

