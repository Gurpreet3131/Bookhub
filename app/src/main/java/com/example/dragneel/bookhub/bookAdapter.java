package com.example.dragneel.bookhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dragneel on 4/2/17.
 */

public class bookAdapter extends BaseAdapter {
    ArrayList<String> bookname;
    ArrayList<String> bookid ;
    ArrayList<String> category;
    ArrayList<String> subcat;
    ArrayList<String> username;
    ArrayList<String> cost;
    Context c;

    public bookAdapter(ArrayList<String> bookid, ArrayList<String> bookname, ArrayList<String> category, ArrayList<String> subcat, ArrayList<String> username, ArrayList<String> cost,Context c) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.category = category;
        this.subcat = subcat;
        this.username = username;
        this.cost = cost;
        this.c = c;
    }

    @Override
    public int getCount()
    {
        return bookid.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row;

        if(view == null)
        {
            LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.book_item,null,false);
        }
        else
        {
            row = view;
        }

        TextView bname = (TextView) row.findViewById(R.id.booknameid);

        bname.setText(bookname.get(position));

        return null;
    }
}
