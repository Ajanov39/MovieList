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

    RecyclerView rvMovies;
    Button btnAddMovie;
    TextView wlcNote;
    String username;

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


        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //MoviesList(String movieName,String directorName, int yearRelease)

                String movieName = etMoviename.getText().toString();
                String directorName = etDirector.getText().toString();
                String yearRelease = etYear.getText().toString();
                MoviesList movie = new MoviesList(movieName,directorName,yearRelease);
                listMovie.add(movie);
                adapter.notifyDataSetChanged();


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

    @Override
    public void deleteMovie(MoviesList movie) {
        listMovie.remove(movie);
        adapter.notifyDataSetChanged();
    }
}