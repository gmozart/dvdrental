package com.api.dvdrental.entity.actor;

import com.api.dvdrental.entity.film.Film;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="actor")
public class Actor {

    @Id
    private Long actorId;

    private String firstName;

    private String lastName;

    private LocalDateTime lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private Set<Film> film;





}