package com.api.dvdrental.entity.film;


import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.language.Language;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmImpl{


    private final EntityManager entityManager;



    public List<Film> queryFilmCategory(Long id){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> film = query.from(Film.class);

        Join<Film, Category> filmCategory = film.join("category", JoinType.INNER);
        filmCategory.on(cb.equal(filmCategory.get("categoryId"), id));

        return entityManager.createQuery(query).getResultList();

    }


     public Film queryLanguageFilm(Long id) {

         CriteriaBuilder cb = entityManager.getCriteriaBuilder();
         CriteriaQuery<Film> query = cb.createQuery(Film.class);
         Root<Film> film = query.from(Film.class);

         Join<Film, Language> filmLanguage = film.join("language", JoinType.INNER);
         filmLanguage.on(cb.equal(film.get("filmId"), id));

         return entityManager.createQuery(query).getSingleResult();
     }

     public List<Actor> queryActorFilm(Long id){

         CriteriaBuilder cb = entityManager.getCriteriaBuilder();
         CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
         Root<Actor> actor = query.from(Actor.class);

         Join<Actor, Film> filmActor = actor.join("film", JoinType.INNER);
         filmActor.on(cb.equal(filmActor.get("filmId"), id));

         return entityManager.createQuery(query).getResultList();
     }

}