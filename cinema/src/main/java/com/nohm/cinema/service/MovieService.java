package com.nohm.cinema.service;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.aggregate.Member;
import com.nohm.cinema.aggregate.Movie;
import com.nohm.cinema.repository.MovieRepository;

import java.util.ArrayList;
import com.nohm.cinema.repository.MemberRepository;

public class MovieService {

    private final MovieRepository mvr = new MovieRepository();

    public MovieService() {
    }

    public void findAllMovies() {
        ArrayList<Movie> findMovies = mvr.selectAllMovies();

        System.out.println("Service에서 조회 확인: ");
        for (Movie mv : findMovies) {
            System.out.println(mv);
        }
    }

    public void findNowMovies() {

    }

    public void searchMovie(Genre genre) {
    }

    public void reserveMovie(Movie movie) {
    }

    public void findMemberForReservation(int memNo) {
    }

    public void cancelReserveMovie() {
    }
}