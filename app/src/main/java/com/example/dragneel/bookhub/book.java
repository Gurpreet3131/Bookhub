package com.example.dragneel.bookhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String [] myitems ={"xyz"};
        ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this,R.layout.book_item,myitems);
        ListView List= (ListView) findViewById(R.id.listviewmain);
        List.setAdapter(Adapter);
    }
}
