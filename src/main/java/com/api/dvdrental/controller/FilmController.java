package com.api.dvdrental.controller;


import com.api.dvdrental.dto.FilmDTO;
import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.film.Film;
import com.api.dvdrental.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<FilmDTO> save(@Valid @RequestBody FilmDTO filmDTO, UriComponentsBuilder uriComponentsBuilder){
        filmService.save(filmDTO);
        var uri = uriComponentsBuilder.path("/film/{id}").buildAndExpand(filmDTO.getFilmId()).toUri();
        return ResponseEntity.created(uri).body(filmDTO);
    }

    @RequestMapping(method = RequestMethod.HEAD)
    @Transactional
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @RequestBody FilmDTO filmDTO){
        return ResponseEntity.ok(filmService.update(id,filmDTO).get());
    }

    //[NÃO PERMITIDO, CAUSA -> tabela de inventory\\
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity<FilmDTO> delete (@PathVariable Long id){
//        filmService.delete(id);
//        return ResponseEntity.noContent().build();
//    }


    @GetMapping("/actor/film/{id}")
    public ResponseEntity<List<Actor>> queryActorFilmId(@PathVariable Long id){
        return ResponseEntity.ok(filmService.queryActorFilm(id));
    }

    @GetMapping("/language/film/{id}")
    public ResponseEntity<Film> queryLanguageFilmId(@PathVariable Long id){
        return ResponseEntity.ok(filmService.queryLanguageFilm(id));
    }

    @GetMapping("/category/film/{id}")
    public ResponseEntity<List<Film>> queryFilmCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(filmService.queryFilmCategory(id));
    }


}