package com.api.dvdrental.dto;

import com.api.dvdrental.entity.actor.Actor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class ActorDTO {

    private Long actorId;

    private String firstName;

    private String lastName;

    private LocalDateTime lastUpdate;


    public static ActorDTO of(Actor actor){
        return ActorDTO.builder()
                .actorId(actor.getActorId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .lastUpdate(actor.getLastUpdate())
                .build();
    }

    public static Actor of(ActorDTO actorDTO){
        return Actor.builder()
                .actorId(actorDTO.getActorId())
                .firstName(actorDTO.getFirstName())
                .lastName(actorDTO.getLastName())
                .lastUpdate(actorDTO.getLastUpdate())
                .build();
    }

    public static Optional<ActorDTO> of(Optional<Actor> actor){
        return actor.stream().map(ActorDTO::of).findAny();
    }

    public static List<ActorDTO> of(List<Actor> actorList){
        return actorList.stream().map(ActorDTO::of).collect(Collectors.toList());
    }
}