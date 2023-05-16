package com.api.dvdrental.dto;

import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.film.Film;
import com.api.dvdrental.entity.language.Language;
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
    private String description;
    private String releaseYear;
    private Set<Category> category;
    private Set<Language> language;
    private Integer rentalDuration;
    private Long rentalRate;
    private Long length;
    private Long replacementCost;
    private String rating;
    private LocalDateTime lastUpdate;
    private String specialFeatures;
    private String fullText;
    private Set<Actor> actor;


    public static FilmDTO of(Film film){
        return FilmDTO.builder()
                .filmId(film.getFilmId())
                .title(film.getTitle())
                .description(film.getDescription())
                .releaseYear(film.getReleaseYear())
                .category(film.getCategory())
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
                .category(filmDTO.getCategory())
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