package com.alwyn.techie.movieapi.controller;

import com.alwyn.techie.movieapi.model.Movie;
import com.alwyn.techie.movieapi.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sortBy){
        return ResponseEntity.ok(movieService.getAllMovies(page, size, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.saveMovie(movie));
    }

    @PostMapping("/with-poster")
    public ResponseEntity<Movie> createMovieWithPoster(@Valid @RequestPart Movie movie, @RequestPart MultipartFile posterFile){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.saveMovieWithPoster(movie, posterFile));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @Valid @RequestBody Movie movie){
        if (!movieService.getMovieById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        movie.setId(id);
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        if (!movieService.getMovieById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
