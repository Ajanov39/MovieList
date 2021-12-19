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
import android.widget.Toast;

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
    WAdapter wadapter;



    ArrayList<MoviesList> listMovie = new ArrayList<>();
    ArrayList<MoviesList> unwatchedM = new ArrayList<>();

   



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
                unwatchedM.add(movie);
                adapter.notifyDataSetChanged();
                wadapter.notifyDataSetChanged();


            }

        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        username =bundle.getString("EXTRA_USERNAME","");

        wlcNote.setText("Welcome  " + username + "!");


        TaskInterface taskListener = this;
        adapter = new MyAdapter(listMovie,taskListener);
        wadapter = new WAdapter(unwatchedM,taskListener);
        rvMovies.setAdapter(adapter);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked()){
                    rvMovies.setAdapter(wadapter);
                    Toast.makeText(getApplicationContext(),"UW",Toast.LENGTH_LONG).show();
                }
                else {
                    rvMovies.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(),"L",Toast.LENGTH_LONG).show();

                }
                adapter.notifyDataSetChanged();
                wadapter.notifyDataSetChanged();
            }
        });

//        rvMovies.setAdapter(adapter);
        }


    @Override
    public void deleteMovie(MoviesList movie) {
        listMovie.remove(movie);
        wadapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
    }





}