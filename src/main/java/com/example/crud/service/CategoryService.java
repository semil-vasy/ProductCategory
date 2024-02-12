package com.example.crud.service;

import com.example.crud.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategory();

    CategoryDto getCategoryById(long categoryId);

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(long categoryId, CategoryDto categoryDto);

    void deleteCategory(long categoryId);

}
