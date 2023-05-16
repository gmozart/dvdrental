package com.api.dvdrental.controller;

import com.api.dvdrental.dto.ActorDTO;
import com.api.dvdrental.dto.FilmDTO;
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


    @GetMapping("/actor/film/{id}")
    public ResponseEntity<List<ActorDTO>> queryActorFilmId(@PathVariable Long id){
        return ResponseEntity.ok(filmService.queryActorFilm(id));
    }

    @GetMapping("/language/film/{id}")
    public ResponseEntity<List<FilmDTO>> queryLanguageFilmId(@PathVariable Long id){
        return ResponseEntity.ok(filmService.queryLanguageFilm(id));
    }

    @GetMapping("/category/film/{id}")
    public ResponseEntity<List<FilmDTO>> queryFilmCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(filmService.queryFilmCategory(id));
    }


}
