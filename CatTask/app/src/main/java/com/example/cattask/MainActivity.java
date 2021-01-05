package com.example.cattask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<FilmListItem>arr = new ArrayList<FilmListItem>();
        for(int i =0 ;i < 16 ; i++)
            arr.add(new FilmListItem("spider-man" , getResources().getDrawable(R.drawable.download) , 12));


        RecyclerView recyclerView_vertical =findViewById(R.id.vertical_list);
        recyclerView_vertical.setLayoutManager(new LinearLayoutManager(  this ));
        FilmListAdapter ad = new FilmListAdapter(this , arr );
        recyclerView_vertical.setAdapter(ad);

        RecyclerView recyclerView_horizntal = findViewById(R.id.horizontal_list);
        recyclerView_horizntal.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false ));
        recyclerView_horizntal.setAdapter(ad);


    }

}