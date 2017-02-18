package com.example.dragneel.bookhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String [] myitems ={"cse","ece","civil","mechanical"};
        ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this,R.layout.book_item,myitems);
        ListView List= (ListView) findViewById(R.id.listviewmain);
        List.setAdapter(Adapter);

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                Intent in = new Intent(category.this, book.class);
                startActivity(in);
            }
        });


    }

}
