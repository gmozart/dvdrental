package com.api.dvdrental.entity.actor;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
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


}