package com.trifun.mymovielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Movies extends AppCompatActivity implements TaskInterface {


    TextView wlcNote;
    String username;
    Button btnAddMovie;
    EditText etMovieName,etDirector,etYear;
    CheckBox cbWatched;
    MyAdapter adapter;

    List<Movies> listMovie = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        btnAddMovie =findViewById(R.id.btnAddMovie);
        etMovieName = findViewById(R.id.etMovieName);
        etDirector = findViewById(R.id.etDirector);
        etYear = findViewById(R.id.etYear);
        cbWatched = findViewById(R.id.cbWatched);

        wlcNote =findViewById(R.id.wlcNote);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        username =bundle.getString("EXTRA_USERNAME","");

        wlcNote.setText("Welcome  " + username + "!");



        recyclerView = findViewById(R.id.rvMovies);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TaskInterface listener = this;
        mAdapter = new MyAdapter(listMovie, listener);
        recyclerView.setAdapter(mAdapter);


        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String movieName =  etMovieName.getText().toString();
                String directorName =  etDirector.getText().toString();
                int yearRelease =  Integer.parseInt(etYear.getText().toString());

                MoviesList movie =new MoviesList(movieName,directorName,yearRelease);
                listMovie.add(movie);
                adapter.notifyDataSetChanged();






            }
        });


    }



    @Override
    public void deleteMovie() {
        listMovie.remove(movie);
        adapter.notifyDataSetChanged();
    }
}