package com.example.dragneel.bookhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class books extends AppCompatActivity {

    ListView list;

    private String GET_URL = Config.BASEURL + "";
    ArrayList<String> bookname = new ArrayList<>();
    ArrayList<String> bookid = new ArrayList<>();
    ArrayList<String> category = new ArrayList<>();
    ArrayList<String> subcat = new ArrayList<>();
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);


        list = (ListView) findViewById(R.id.listid);
        Intent in = getIntent();

        final bookAdapter adapter = new bookAdapter(bookid, bookname, category, subcat, username, cost, getApplicationContext());
        list.setAdapter(adapter);

        final ProgressDialog dialog = new ProgressDialog(books.this);
        dialog.setMessage("Please Wait...");
        dialog.setCancelable(false);
        dialog.show();

        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, GET_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try
                {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray ar = jsonObject.getJSONArray("books");

                    for(int i=0;i<ar.length();i++){
                        JSONObject ob = ar.getJSONObject(i);
                        bookname.add(ob.getString("bookname"));
                        bookid.add(ob.getString("bookid"));
                        cost.add(ob.getString("cost"));
                        username.add(ob.getString("category"));
                        category.add(ob.getString("cost"));
                        subcat.add(ob.getString("category"));

                    }
                    dialog.dismiss();
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("VolleyError", volleyError.toString());
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "No connection", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("roll", roll);
                //params.put("semester", roll+semester);
                return params;
            }
        };

        rq.add(request);


        //get data throught intent

    }
}
