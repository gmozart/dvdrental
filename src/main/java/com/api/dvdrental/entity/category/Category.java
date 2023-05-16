package com.api.dvdrental.entity.category;

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
@Table(name="category")
public class Category {

    @Id
    private Long categoryId;

    private String name;

    private LocalDateTime lastUpdate;

    @ManyToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Film> film;

}
