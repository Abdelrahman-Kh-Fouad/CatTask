package com.example.cattask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbmanager extends SQLiteOpenHelper {
    private static final String dpname = "dbfilm";
    private static final String tablename ="tablefilm";
    private static final String KEY_ID= "id" ;
    private static final String KEY_Name ="name";
    private static final String KEY_URL ="img";

    public dbmanager(@Nullable Context context) {
        super(context, dpname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "create table "+tablename +" (id integer primary key autoincrement , name TEXT ,img TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename );
        onCreate(db);
    }


    public void addFilm(FilmListItem film)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(KEY_Name , film.getName());
        value.put(KEY_URL , film.getImg());

        db.insert(tablename , null , value);
        db.close();
    }
    public ArrayList<FilmListItem> getAllFilms ()
    {
        ArrayList <FilmListItem>res =new ArrayList<FilmListItem>();
        String select = "SELECT * FROM " +tablename;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cur = db.rawQuery(select, null);
        while(cur.moveToFirst())
        {
            FilmListItem film = new FilmListItem(cur.getString(1) , cur.getString(2) );
            res.add(film);
        }
        cur.close();
        return res ;

    }



}
