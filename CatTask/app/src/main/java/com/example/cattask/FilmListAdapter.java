package com.example.cattask;
//TODO change the drawable
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FilmListAdapter extends
        RecyclerView.Adapter<FilmListAdapter.ViewHolder> {

    private ArrayList<FilmListItem>arr ;
    private LayoutInflater mtinflater;

    public FilmListAdapter (Context context  , ArrayList<FilmListItem>arr)
    {
        this.mtinflater = LayoutInflater.from(context);
        this.arr = arr ;
    }
    @NonNull
    @Override
    public FilmListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =mtinflater.inflate(R.layout.film_item , parent , false );
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FilmListAdapter.ViewHolder holder, int position) {

        holder.textView.setText(arr.get(position).getName());
        holder.img.setImageURI (Uri.parse(arr.get(position).getImg()));

    }
    @Override
    public int getItemCount() {
        return arr.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView img ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView  = itemView.findViewById(R.id.film_name);
            img = itemView.findViewById(R.id.film_img);
        }
    }


}



