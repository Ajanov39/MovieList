package com.trifun.mymovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MovieViewHolder>{

    ArrayList<MoviesList> movielist;
    TaskInterface listener;
    Context c;

    boolean isWatched = false;


    public MyAdapter(ArrayList<MoviesList>movielist, TaskInterface listener){
        this.movielist = movielist;
        this.listener = listener;
        this.c=c;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,null);
       MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        MoviesList movie = movielist.get(position);

        holder.tvMovie.setText(movie.getMovieName());
        holder.tvDirector.setText(movie.getDirectorName());
        holder.tvYear.setText(movie.getYearRelease());
        holder.ibtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.deleteMovie(movie);
            }
        });

        holder.cbWatched.setChecked(movie.isWatched());

    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        TextView tvMovie,tvDirector,tvYear;
        ImageButton ibtnDel;
        CheckBox cbWatched;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMovie = itemView.findViewById(R.id.tvMovie);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvYear = itemView.findViewById(R.id.tvYear);
            cbWatched = itemView.findViewById(R.id.cbWatched);
            ibtnDel = itemView.findViewById(R.id.ibtnDel);

        }
    }
}