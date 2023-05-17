package com.api.dvdrental.dto;

import com.api.dvdrental.entity.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class CategoryDTO {

    @JsonIgnore
    private Long categoryId;
    private String name;
    @JsonIgnore
    private LocalDateTime lastUpdate;

    public static CategoryDTO of(Category category){
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .lastUpdate(category.getLastUpdate())
                .build();
    }

    public static Category of(CategoryDTO categoryDTO){
        return Category.builder()
                .categoryId(categoryDTO.getCategoryId())
                .name(categoryDTO.getName())
                .lastUpdate(categoryDTO.lastUpdate = LocalDateTime.now())
                .build();
    }

    public static Optional<CategoryDTO> of(Optional<Category> category){
        return category.stream().map(CategoryDTO::of).findAny();
    }

    public static List<CategoryDTO> of(List<Category> categoryList){
        return categoryList.stream().map(CategoryDTO::of).collect(Collectors.toList());
    }

}