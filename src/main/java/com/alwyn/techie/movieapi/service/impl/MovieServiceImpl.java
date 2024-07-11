package com.alwyn.techie.movieapi.service.impl;

import com.alwyn.techie.movieapi.model.Movie;
import com.alwyn.techie.movieapi.repository.MovieRepository;
import com.alwyn.techie.movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Page<Movie> getAllMovies(int page, int size, String sortBy) {
        return movieRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie saveMovieWithPoster(Movie movie, MultipartFile posterFile) {
        if (!posterFile.isEmpty()){
            String fileName = posterFile.getOriginalFilename();
            File file = new File("posters/" + fileName);

            try {
                posterFile.transferTo(file);
                movie.setPosterPath(file.getAbsolutePath());
            } catch (IOException e){
                throw new RuntimeException("Failed to store poster file", e);
            }
        }
        return movieRepository.save(movie);
    }
}
