package com.example.cattask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    dbmanager db;
    RecyclerView recyclerView_horizintal;
    RecyclerView recyclerView_vertical;
    ArrayList<FilmListItem>arr ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new dbmanager(this);
        try {
            getfilms();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recyclerView_horizintal =findViewById(R.id.horizontal_list);
        recyclerView_horizintal.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_horizintal.setAdapter(new FilmListAdapter(this ,(ArrayList<FilmListItem>) arr.subList(0 , arr.size() /2 ) ));

        recyclerView_vertical =findViewById(R.id.vertical_list);
        recyclerView_vertical.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false) );
        recyclerView_vertical.setAdapter(new FilmListAdapter(this , (ArrayList<FilmListItem>) arr.subList(arr.size()/2 , arr.size() )));

    }
    public void getfilms () throws IOException {
        arr = db.getAllFilms();
        if(arr.size() == 0 )
        {
            crawling crawling =new crawling();
            arr= crawling.getArr();
            for(FilmListItem i : arr)
                db.addFilm(i);
        }
    }


}