package com.example.cattask;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FilmListAdaptor extends ArrayAdapter<FilmListItem> {
    public FilmListAdaptor(Activity context , ArrayList<FilmListItem>arr)
    {
        super(context , 0, arr);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListItem = convertView;
        if(ListItem==null)
        {
            ListItem = LayoutInflater.from(getContext()).inflate(R.layout.film_item, parent  , false);

        }
        FilmListItem cureent_item =getItem(position);
        TextView nameoffilm = (TextView)ListItem.findViewById(R.id.filmname);
        TextView timeoffilm =(TextView)ListItem.findViewById(R.id.filmtime);
        if(cureent_item.getTime()!=0)
        {
            int h =  cureent_item.getTime() / 60 ;
            int m = cureent_item.getTime() % 60 ;
            String t = String.format( " %2d : %2d" , String.valueOf(h), String.valueOf(m) );
            timeoffilm.setText(t);
        }
        nameoffilm.setText(cureent_item.getName());
        ListItem.setBackground(cureent_item .getImg());
        return ListItem;
    }

}
