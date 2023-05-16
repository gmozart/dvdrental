package com.api.dvdrental.controller;


import com.api.dvdrental.dto.ActorDTO;

import com.api.dvdrental.service.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {


    private final ActorService actorService;

    @PostMapping
    @Transactional
    public ResponseEntity<ActorDTO> save(@Valid @RequestBody ActorDTO actorDTO, UriComponentsBuilder uriComponentsBuilder){
        actorService.save(actorDTO);
        var uri = uriComponentsBuilder.path("/film/{id}").buildAndExpand(actorDTO.getActorId()).toUri();
        return ResponseEntity.created(uri).body(actorDTO);
    }


}
