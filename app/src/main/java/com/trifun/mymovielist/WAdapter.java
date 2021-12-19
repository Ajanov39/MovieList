package com.trifun.mymovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

public class WAdapter extends RecyclerView.Adapter<WAdapter.WViewHolder>{

    ArrayList<MoviesList>listMovie;
    ArrayList<MoviesList> unwatchedM;
    TaskInterface listener;
    Context c;

    public WAdapter(ArrayList<MoviesList>unwatchedM, TaskInterface listener){
        this.unwatchedM = unwatchedM;
        this.listener = listener;
        this.c=c;

    }

    @NonNull
    @Override
    public WAdapter.WViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,null);
        WAdapter.WViewHolder wviewHolder = new WAdapter.WViewHolder(view);

        return wviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WAdapter.WViewHolder holder, int position) {

        MoviesList movie = unwatchedM.get(position);

        holder.tvMovie.setText(movie.getMovieName());
        holder.tvDirector.setText(movie.getDirectorName());
        holder.tvYear.setText(movie.getYearRelease());
        holder.ibtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.deleteMovie(movie);
            }
        });


        holder.cbWatched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cbWatched.isChecked()){
                    unwatchedM.remove(movie);
                }
                else {
                    //listMovie.add(movie);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return unwatchedM.size();
    }



    public class WViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovie,tvDirector,tvYear;
        ImageButton ibtnDel;
        CheckBox cbWatched;


        public WViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMovie = itemView.findViewById(R.id.tvMovie);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvYear = itemView.findViewById(R.id.tvYear);
            cbWatched = itemView.findViewById(R.id.cbWatched);
            ibtnDel = itemView.findViewById(R.id.ibtnDel);


        }

    }


}