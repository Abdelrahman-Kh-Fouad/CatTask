package com.example.cattask;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.sql.RowId;

public class FilmListItem {
    private String name;
    private String img;
    public FilmListItem(String name , String img  )
    {
        this.name =name ;
        this.img=img;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }


    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

}
