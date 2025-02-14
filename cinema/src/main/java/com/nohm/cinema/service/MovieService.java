package com.nohm.cinema.service;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.aggregate.Movie;
import com.nohm.cinema.repository.MovieRepository;

import java.util.List;


public class MovieService {

    private final MovieRepository mvr = new MovieRepository();

    public MovieService() {
    }

    public void searchMovie(Genre genre) {
        List<Movie> findMovies = mvr.selectMovieBy(genre);  // 영화 장르에 맞는 영화 가져옴

        if(findMovies != null) {
            System.out.println(genre + "영화 조회");
            for (Movie movie : findMovies) {
                System.out.println(movie);
            }
        } else {
            System.out.println("선택하신 장르의 영화는 없습니다.");
        }
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
