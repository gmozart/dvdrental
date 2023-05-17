package com.api.dvdrental.dto;

import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.film.Film;
import com.api.dvdrental.entity.film.Rating;
import com.api.dvdrental.entity.language.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class FilmDTO {


    private Long filmId;
    private String title;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String releaseYear;

    @JsonIgnoreProperties({"lastUpdate"})
    private Language language;

    private Integer rentalDuration;
    private Long rentalRate;
    @JsonIgnore
    private Long length;

    private Long replacementCost;

    private Rating rating;

    @JsonIgnore
    private LocalDateTime lastUpdate;
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "text[]")
    private String[] specialFeatures;
    @JsonIgnore
    private String fullText;

    @JsonIgnoreProperties({"lastUpdate"})
    private List<Actor> actor;


    public static FilmDTO of(Film film){
        return FilmDTO.builder()
                .filmId(film.getFilmId())
                .title(film.getTitle())
                .description(film.getDescription())
                .releaseYear(film.getReleaseYear())
                .language(film.getLanguage())
                .rentalDuration(film.getRentalDuration())
                .rentalRate(film.getRentalRate())
                .length(film.getLength())
                .replacementCost(film.getReplacementCost())
                .rating(film.getRating())
                .lastUpdate(film.getLastUpdate())
                .specialFeatures(film.getSpecialFeatures())
                .fullText(film.getFullText())
                .actor(film.getActor())
                .build();
    }

    public static Film of(FilmDTO filmDTO){
        return Film.builder()
                .filmId(filmDTO.getFilmId())
                .title(filmDTO.getTitle())
                .description(filmDTO.getDescription())
                .releaseYear(filmDTO.getReleaseYear())
                .language(filmDTO.getLanguage())
                .rentalDuration(filmDTO.getRentalDuration())
                .rentalRate(filmDTO.getRentalRate())
                .length(filmDTO.getLength())
                .replacementCost(filmDTO.getReplacementCost())
                .rating(filmDTO.getRating())
                .lastUpdate(filmDTO.getLastUpdate())
                .specialFeatures(filmDTO.getSpecialFeatures())
                .fullText(filmDTO.getFullText())
                .actor(filmDTO.getActor())
                .build();
    }

    public static Optional<FilmDTO> of(Optional<Film> film){
        return film.stream().map(FilmDTO::of).findAny();
    }

    public static List<FilmDTO> of(List<Film> filmList){
        return filmList.stream().map(FilmDTO::of).collect(Collectors.toList());
    }
}