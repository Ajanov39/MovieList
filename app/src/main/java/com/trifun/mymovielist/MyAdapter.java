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

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Movies> listMovie;
    Context context;
    private TasksInterface listener;



    public MyAdapter(List<Movies> listMovie, Context context) {
        this.listMovie = listMovie;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movies mov = listMovie.get(position);
        holder.tvMovie.setText(mov.getMovieName());
        holder.tvDirector.setText(mov.getDirectorName());
        holder.tvYear.setText(mov.getYearRelease());
        holder.ibtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.deleteMovie(mov)}
        });
        holder.cbWatched.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        }



    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvMovie;
        TextView tvDirector;
        TextView tvYear;
        CheckBox cbWatched;
        ImageButton ibtnDel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovie = itemView.findViewById(R.id.tvMovie);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvYear = itemView.findViewById(R.id.tvYear);
            cbWatched = itemView.findViewById(R.id.cbWatched);
            ibtnDel = itemView.findViewById(R.id.ibtnDel);



        }
    }
}
