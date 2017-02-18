package com.example.dragneel.bookhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yatendra maurya on 7/3/2016.
 */
class MyDatabase extends SQLiteOpenHelper {

    public static  final  String DATABASE_NAME="Bookhub";
    public static  final  int DATABASE_VERSION=1;


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table Login(uname text,pwd text) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void myReg(ContentValues cv)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.insert("Login",null,cv);



    }
    public Cursor  myLogin(String uname,String pwd)
    {
        SQLiteDatabase db=getReadableDatabase();

        Cursor c=db.rawQuery("select * from Login where uname='"+uname+"' and pwd='"+pwd+"'",null);

        return  c;


    }

    public void change(String np,String op)

    {
        SQLiteDatabase db=getWritableDatabase();

        db.execSQL("update Login set pwd='"+np+"' where pwd='"+op+"'");


    }

}
