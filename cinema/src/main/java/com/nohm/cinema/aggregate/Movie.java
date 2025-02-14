package com.nohm.cinema.aggregate;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
    private String title;
    private String director;
    private java.util.Date startDate;
    private Genre genre;

    public Movie() {
    }

    public Movie(String title, String director, Date startDate, Genre genre) {
        this.title = title;
        this.director = director;
        this.startDate = startDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", startDate=" + startDate +
                ", genre=" + genre +
                '}';
    }
}