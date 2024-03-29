package com.example.parichaymahanrashtra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME= "Register.db";

    public DBHelper(Context context) {
        super(context,"Register.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(email TEXT primary key,password TEXT,name TEXT,Phone TEXT)");
        MyDB.execSQL("create Table places( id primary key,name TEXT,description TEXT,category TEXT)");
        MyDB.execSQL("create Table bucketlist( id primary key,name TEXT,FOREIGN KEY(id) references users(id),FOREIGN KEY(name) references places(name))");
        //MyDB=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id",1);
        values.put("name","Kanheri Caves");
        values.put("Category","Caves");
        long result=MyDB.insert("places",null,values);
        values=new ContentValues();
        values.put("id",2);
        values.put("name","Ajanta Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        values=new ContentValues();
        values.put("id",3);
        values.put("name","Ellora Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        values=new ContentValues();
        values.put("id",4);
        values.put("name","Elephanta Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        values=new ContentValues();
        values.put("id",5);
        values.put("name","Karla Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        values=new ContentValues();
        values.put("id",6);
        values.put("name","Bhaja Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        values.put("id",7);
        values.put("name","Aurangabad Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        values.put("id",8);
        values.put("name","Lenyadri Caves");
        values.put("Category","Caves");
        result=MyDB.insert("places",null,values);
        //MyDB.execSQL("create Table places()")
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String email,String password,String name,String phone)
    {
            SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        long result= MyDB.insert("users",null,contentValues);
        if(result==-1) return false;
        else return true;
    }

    public Boolean checkemail(String email)
    {
        SQLiteDatabase MyDB =this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where email =?",new String[]{email});
        if(cursor.getCount() >0)
            return true;
        else
            return false;
    }

    public Boolean checkphone(String phone)
    {
        SQLiteDatabase MyDB =this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where phone =?",new String[]{phone});
        if(cursor.getCount() >0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email,String password)
    {
        SQLiteDatabase MyDB =this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where email = ? and password = ?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

//    public Boolean updateCount(String email)
//    {
//
//    }

}
