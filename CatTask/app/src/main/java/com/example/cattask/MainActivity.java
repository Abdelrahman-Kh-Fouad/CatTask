package com.example.cattask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<FilmListItem>arr =new ArrayList<FilmListItem>();
        arr.add(new FilmListItem("spider-man" , getResources().getDrawable(R.drawable.download) , 0 ));
        arr.add(new FilmListItem("batman" , getResources().getDrawable(R.drawable.download) , 0 ));
        arr.add(new FilmListItem("tenet" , getResources().getDrawable(R.drawable.download) , 0 ));
        arr.add(new FilmListItem("darknight" , getResources().getDrawable(R.drawable.download) , 0 ));
        arr.add(new FilmListItem("superman" , getResources().getDrawable(R.drawable.download) , 0 ));

        FilmListAdaptor filmLad = (ListView)
    }
}