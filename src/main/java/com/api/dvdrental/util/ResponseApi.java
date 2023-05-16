package com.api.dvdrental.util;

import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.film.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi {

    private List<Film> filmResponse;

    private List<Actor> actorResponse;


}