package com.api.dvdrental.entity.film;

import com.api.dvdrental.entity.actor.Actor;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.language.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="film")
public class Film {

    @Id
    private Long filmId;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private String releaseYear;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    private Language language;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Long rentalRate;
    @Column(name = "length")
    private Long length;
    @Column(name = "replacement_cost")
    private Long replacementCost;
    @Column(name = "rating")
    private String rating;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "special_features")
    private String specialFeatures;
    @Column(name = "full_text")
    private String fullText;

    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Actor> actor;



}