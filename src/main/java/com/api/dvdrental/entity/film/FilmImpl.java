package com.api.dvdrental.entity.film;


import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.language.Language;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmImpl{


    private final EntityManager entityManager;


    public List<Film> getFilmByCategory(Long categoryId){ //Funcionando

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> film = query.from(Film.class);

        Join<Film, Category> filmCategory = film.join("category", JoinType.INNER);
        filmCategory.on(cb.equal(filmCategory.get("categoryId"), categoryId));

        return entityManager.createQuery(query).getResultList();
    }

     public Language getLanguageByFilm(Long filmId) { //está funcionando

         CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
         CriteriaQuery<Film> query = criteriaBuilder.createQuery(Film.class);
         Root<Film> film = query.from(Film.class);

         query.where(criteriaBuilder.equal(film.get("filmId"), filmId)); //montagem da query

         return entityManager.createQuery(query).getSingleResult().getLanguage(); //retorno da query
     }

     public List<Actor> getActorByFilm(Long filmId){ //Não está funcionando

         CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
         CriteriaQuery<Film> query = criteriaBuilder.createQuery(Film.class);
         Root<Film> film = query.from(Film.class);

         query.where(criteriaBuilder.equal(film.get("filmId"), filmId)); //montagem da query

         return entityManager.createQuery(query).getSingleResult().getActor();
    }
}