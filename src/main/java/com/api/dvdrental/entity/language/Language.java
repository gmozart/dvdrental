package com.api.dvdrental.entity.language;

import com.api.dvdrental.entity.film.Film;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="language")
public class Language {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "language_id")
    private Long languageId;

    private String name;

    private LocalDateTime lastUpdate = LocalDateTime.now();;

}
