package com.trifun.mymovielist;

public class MoviesList {

    String movieName, directorName;
    int yearRelease;


    public MoviesList(String movieName,String directorName, int yearRelease) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.yearRelease = yearRelease;

    }



    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }


}
