package com.api.dvdrental.controller;


import com.api.dvdrental.dto.CategoryDTO;
import com.api.dvdrental.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO categoryDTO, UriComponentsBuilder uriComponentsBuilder){
        categoryService.save(categoryDTO);
        var uri = uriComponentsBuilder.path("/film/{id}").buildAndExpand(categoryDTO.getCategoryId()).toUri();
        return ResponseEntity.created(uri).body(categoryDTO);
    }


}
