package com.api.dvdrental.entity.film;

import com.api.dvdrental.dto.ActorDTO;
import com.api.dvdrental.dto.CategoryDTO;
import com.api.dvdrental.dto.FilmDTO;
import com.api.dvdrental.dto.LanguageDTO;
import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.language.Language;
import com.api.dvdrental.entity.language.LanguageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmImpl{


    private final EntityManager entityManager;

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

    public List<FilmDTO> queryFilmCategory(Long id){

        CriteriaQuery<FilmDTO> query = cb.createQuery(FilmDTO.class);
        Root<FilmDTO> film = query.from(FilmDTO.class);

        Join<FilmDTO, CategoryDTO> filmCategory = film.join("category", JoinType.INNER);
        filmCategory.on(cb.equal(filmCategory.get("categoryId"), id));

        return entityManager.createQuery(query).getResultList();

    }


     public FilmDTO queryLanguageFilm(Long id) {

         CriteriaQuery<FilmDTO> query = cb.createQuery(FilmDTO.class);
         Root<FilmDTO> film = query.from(FilmDTO.class);

         Join<FilmDTO, LanguageDTO> filmLanguage = film.join("language", JoinType.INNER);
         filmLanguage.on(cb.equal(film.get("filmId"), id));

         return entityManager.createQuery(query).getSingleResult();
     }

     public List<ActorDTO> queryActorFilm(Long id){

         CriteriaQuery<ActorDTO> query = cb.createQuery(ActorDTO.class);
         Root<ActorDTO> Actor = query.from(ActorDTO.class);

         Join<ActorDTO, FilmDTO> filmActor = Actor.join("film", JoinType.INNER);
         filmActor.on(cb.equal(filmActor.get("filmId"), id));

         return entityManager.createQuery(query).getResultList();
     }

}