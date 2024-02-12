package com.example.crud.repository;

import com.example.crud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM category c ORDER BY c.category_id ASC", nativeQuery = true)
    List<Category> findAll();
}
