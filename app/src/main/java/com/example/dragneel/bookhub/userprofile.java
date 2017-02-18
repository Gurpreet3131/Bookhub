package com.example.dragneel.bookhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class userprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        Intent in = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("USERNAME");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //collapsingToolbarLayout.();
        //Context context = this;
        //collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context,R.color.colorAccent));
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void catbuttonfunc(View view)
    {
        Intent in = new Intent(this,category.class);
        startActivity(in);
    }
}
