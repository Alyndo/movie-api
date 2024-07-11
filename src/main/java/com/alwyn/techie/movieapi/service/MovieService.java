package com.alwyn.techie.movieapi.service;

import com.alwyn.techie.movieapi.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface MovieService {
    Page<Movie> getAllMovies(int page, int size, String sortBy);
    Optional<Movie> getMovieById(Long id);
    Movie saveMovie(Movie movie);
    void deleteMovie(Long id);
    Movie saveMovieWithPoster(Movie movie, MultipartFile posterFile);
}
