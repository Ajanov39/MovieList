package com.trifun.mymovielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Movies extends AppCompatActivity implements TaskInterface {

    RecyclerView rvMovies;
    Button btnAddMovie;
    TextView wlcNote;
    String username;
    Switch switch1;

    EditText etMoviename, etDirector,etYear;
    CheckBox cbWatched;
    MyAdapter adapter;



    ArrayList<MoviesList> listMovie = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        rvMovies  = findViewById(R.id.rvMovies);
        btnAddMovie =findViewById(R.id.btnAddMovie);
        etMoviename = findViewById(R.id.etMovieName);
        etDirector = findViewById(R.id.etDirector);
        etYear = findViewById(R.id.etYear);
        cbWatched = findViewById(R.id.cbWatched);
        wlcNote =findViewById(R.id.wlcNote);
        switch1 = findViewById(R.id.switch1);



        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String movieName = etMoviename.getText().toString();
                String directorName = etDirector.getText().toString();
                String yearRelease = etYear.getText().toString();
                MoviesList movie = new MoviesList(movieName,directorName,yearRelease);
                listMovie.add(movie);
                adapter.notifyDataSetChanged();


            }

        });

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbWatched.isChecked()){

                etDirector.setVisibility(View.VISIBLE);
                etYear.setVisibility(View.VISIBLE);
                cbWatched.setVisibility(View.VISIBLE);
                etMoviename.setVisibility(View.VISIBLE);
           }
            else{
                etMoviename.setVisibility(View.GONE);
                    etDirector.setVisibility(View.GONE);
                    etYear.setVisibility(View.GONE);
               cbWatched.setVisibility(View.GONE);

           }

            }
        });





        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        username =bundle.getString("EXTRA_USERNAME","");

        wlcNote.setText("Welcome  " + username + "!");


        TaskInterface taskListener = this;
        adapter = new MyAdapter(listMovie,taskListener);
        rvMovies.setAdapter(adapter);




}

    private View switch1() {
        switch1.setChecked(false);
        adapter.notifyDataSetChanged();
        return null;
    }



    @Override
    public void deleteMovie(MoviesList movie) {
        listMovie.remove(movie);

        adapter.notifyDataSetChanged();
    }





}