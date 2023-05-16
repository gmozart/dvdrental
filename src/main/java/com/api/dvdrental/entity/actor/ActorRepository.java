package com.api.dvdrental.entity.actor;


import com.api.dvdrental.entity.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
