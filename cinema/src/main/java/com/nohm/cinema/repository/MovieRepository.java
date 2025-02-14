package com.nohm.cinema.repository;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.aggregate.Movie;

import java.io.*;
import java.util.ArrayList;

public class MovieRepository {
    private final ArrayList<Movie> movieList = new ArrayList<>();
    private final File file = new File("cinema/src/main/java/com/nohm/cinema/db/movieDB.dat");

    public MovieRepository() {
        if (!file.exists()) {
            ArrayList<Movie> defaultMovie = new ArrayList<>();
            defaultMovie.add(new Movie("title1", "director1", new java.util.Date(2025-02-14), Genre.COMEDY));
//            defaultMovie.add(new Movie());
//            defaultMovie.add(new Movie());

            saveMovies(defaultMovie);
        }

        loadMovies();
    }

    private void loadMovies() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                movieList.add((Movie) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
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
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for (Movie mv : inputMovies) {
                oos.writeObject(mv);
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
}