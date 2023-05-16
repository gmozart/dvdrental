package com.api.dvdrental.service;


import com.api.dvdrental.dto.ActorDTO;
import com.api.dvdrental.entity.actor.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorService {

     private final ActorRepository actorRepository;

     public void save(ActorDTO actorDTO){
     actorRepository.save(ActorDTO.of(actorDTO));
     }


}
