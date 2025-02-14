package com.nohm.cinema.aggregate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Movie implements Serializable {
    private String title;
    private String director;
    private LocalDate startDate;
    private Genre genre;

    public Movie() {
    }

    public Movie(String title, String director, LocalDate startDate, Genre genre) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
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
        return "제목:'" + title + '\'' +
                ", 감독: '" + director + '\'' +
                ", 개봉일: " + startDate +
                ", 장르: " + genre;
    }
}