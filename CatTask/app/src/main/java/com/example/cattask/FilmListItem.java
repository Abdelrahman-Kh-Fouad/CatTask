package com.example.cattask;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.sql.RowId;

public class FilmListItem {
    private String name;
    private Drawable img;
    private int time ;
    public FilmListItem(String name , Drawable img , int time )
    {
        this.name =name ;
        this.img=img;
        this.time=0;
    }

    public Drawable getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
