package com.api.dvdrental.service;

import com.api.dvdrental.dto.FilmDTO;
import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.film.Film;
import com.api.dvdrental.entity.film.FilmImpl;
import com.api.dvdrental.entity.film.FilmRepository;
import com.api.dvdrental.entity.language.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    private final FilmImpl filmImpl;


    public FilmDTO save(FilmDTO filmDTO){
        return  FilmDTO.of(filmRepository.save(FilmDTO.of(filmDTO)));
    }

    public Optional<List<FilmDTO>> findAll(){
        return Optional.of(FilmDTO.of(filmRepository.findAll()));
    }

    public Optional<FilmDTO> update(Long id, FilmDTO filmDTO){
        filmDTO.setFilmId(id);
        return Optional.of(FilmDTO.of(filmRepository.save(FilmDTO.of(filmDTO))));
    }

    public void delete(Long id){
        filmRepository.deleteById(id);
    }


    public List<Film> getFilmByCategory(Long id){

        return filmImpl.getFilmByCategory(id);
    }

    public Language getLanguageByFilm(Long id){
        return filmImpl.getLanguageByFilm(id);
    }

    public List<Actor> getActorByFilm(Long Id){
        return filmImpl.getActorByFilm(Id);
    }

}