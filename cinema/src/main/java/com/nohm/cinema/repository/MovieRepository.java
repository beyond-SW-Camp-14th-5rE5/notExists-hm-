package com.nohm.cinema.repository;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.aggregate.Movie;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private final ArrayList<Movie> movieList = new ArrayList<>();
    private final File file = new File("cinema/src/main/java/com/nohm/cinema/db/movieDB.dat");

    public MovieRepository() {
        if (!file.exists()) {
            ArrayList<Movie> defaultMovies = new ArrayList<>();
            defaultMovies.add(new Movie("기상충", "봉준오", LocalDate.parse("2025-02-01"), Genre.ACTION));
            defaultMovies.add(new Movie("올드브이", "박창욱", LocalDate.parse("2025-02-03"), Genre.ACTION));
            defaultMovies.add(new Movie("나의 결혼식", "이성근", LocalDate.parse("2025-02-07"), Genre.ROMANCE));
            defaultMovies.add(new Movie("스릴러", "이수정", LocalDate.parse("2025-02-12"), Genre.THRILLER));
            defaultMovies.add(new Movie("자바란", "김용섭", LocalDate.parse("2025-02-18"), Genre.ROMANCE));
            defaultMovies.add(new Movie("부산행3", "연영훈", LocalDate.parse("2025-03-01"), Genre.HORROR));
            defaultMovies.add(new Movie("모가디수", "조상렬", LocalDate.parse("2025-03-05"), Genre.ACTION));

            saveMovies(defaultMovies);
        }

        loadMovies();
    }

    private void loadMovies() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while (true) {
                movieList.add((Movie)ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("영화 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveMovies(ArrayList<Movie> inputMovies) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            for (Movie movie : inputMovies) {
                oos.writeObject(movie);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Movie> selectAllMovies() {
        return movieList;
    }

    public List<Movie> selectMovieBy(Genre genre) {
        List<Movie> returnMovieList = new ArrayList<>();

        for (Movie movie : movieList) {
            if (movie.getGenre() == genre) {
                returnMovieList.add(movie);      // 장르 일치하는 영화 발견하면 반환
            }
        }
        if(returnMovieList.size() == 0) return null;

        return returnMovieList;
    }
}