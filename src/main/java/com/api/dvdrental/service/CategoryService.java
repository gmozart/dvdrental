package com.api.dvdrental.service;

import com.api.dvdrental.dto.CategoryDTO;
import com.api.dvdrental.dto.FilmDTO;
import com.api.dvdrental.entity.category.Category;
import com.api.dvdrental.entity.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO save(CategoryDTO categoryDTO){
        return CategoryDTO.of(categoryRepository.save(CategoryDTO.of(categoryDTO)));
    }

}
