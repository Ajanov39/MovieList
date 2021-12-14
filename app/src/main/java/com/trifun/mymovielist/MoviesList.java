package com.trifun.mymovielist;

public class MoviesList {

    String movieName, directorName;
    String yearRelease;


    public MoviesList(String movieName,String directorName, String yearRelease) {
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

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }


}
