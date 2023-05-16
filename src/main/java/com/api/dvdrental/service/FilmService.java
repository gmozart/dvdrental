package com.api.dvdrental.service;


import com.api.dvdrental.dto.ActorDTO;
import com.api.dvdrental.dto.FilmDTO;
import com.api.dvdrental.entity.film.FilmImpl;
import com.api.dvdrental.entity.film.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    private final FilmImpl filmImpl;


    public void save(FilmDTO filmDTO){
        filmRepository.save(FilmDTO.of(filmDTO));
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


    public List<FilmDTO> queryFilmCategory(Long id){
        return filmImpl.queryFilmCategory(id);
    }

    public List<FilmDTO> queryLanguageFilm(Long id){
        return filmImpl.queryFilmCategory(id);
    }

    public List<ActorDTO> queryActorFilm(Long Id){
        return filmImpl.queryActorFilm(Id);
    }

}