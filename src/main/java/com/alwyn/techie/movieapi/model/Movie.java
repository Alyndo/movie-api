package com.alwyn.techie.movieapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title should not exceed 255 characters")
    private String title;

    @NotBlank(message = "Genre is mandatory")
    @Size(max = 255, message = "Genre should not exceed 255 characters")
    private String genre;

    @NotBlank(message = "Director is mandatory")
    @Size(max = 255, message = "Director should not exceed 255 characters")
    private String director;

    @NotNull(message = "Release date is mandatory")
    private LocalDate releaseDate;

    private String posterPath;
}
