package com.api.dvdrental.controller;


import com.api.dvdrental.dto.FilmDTO;
import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.film.Film;
import com.api.dvdrental.entity.language.Language;
import com.api.dvdrental.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    @Transactional
    public ResponseEntity<FilmDTO> save(@Valid @RequestBody FilmDTO filmDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.save(filmDTO));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @RequestBody FilmDTO filmDTO){
        return ResponseEntity.ok(filmService.update(id,filmDTO).get());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<FilmDTO> delete (@PathVariable Long id){
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}/actor")
    public ResponseEntity<List<Actor>> getActorByFilm(@PathVariable Long id){
        return ResponseEntity.ok(filmService.getActorByFilm(id));
    }

    @GetMapping("/{id}/language")
    public ResponseEntity<Language> getLanguageByFilm(@PathVariable Long id){
        return ResponseEntity.ok(filmService.getLanguageByFilm(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Film>> getFilmByCategory(@PathVariable Long categoryId){
        return ResponseEntity.ok(filmService.getFilmByCategory(categoryId));
    }

}