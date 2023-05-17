package com.api.dvdrental.controller;


import com.api.dvdrental.dto.ActorDTO;


import com.api.dvdrental.service.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {


    private final ActorService actorService;

    @PostMapping
    @Transactional
    public ResponseEntity<ActorDTO> save(@Valid @RequestBody ActorDTO actorDTO){
          return ResponseEntity.status(HttpStatus.CREATED).body(actorService.save(actorDTO));
    }

}