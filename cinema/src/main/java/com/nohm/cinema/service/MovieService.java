package com.nohm.cinema.service;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.aggregate.Member;
import com.nohm.cinema.aggregate.Movie;
import com.nohm.cinema.repository.MemberRepository;

public class MovieService {

    private final MemberRepository mr = new MemberRepository();

    public MovieService() {
    }

    public void searchMovie(Genre genre) {
    }

    public void findAllMovies() {
    }

    public void reserveMovie(Movie movie) {

    }

    public void findMemberForReservation(int memNo) {
    }

    public void cancelReserveMovie() {
    }
}
