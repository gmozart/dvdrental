package com.api.dvdrental.entity.category;

import com.api.dvdrental.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
