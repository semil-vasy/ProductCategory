package com.example.crud.service.impl;

import com.example.crud.dto.CategoryDto;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Category;
import com.example.crud.repository.CategoryRepository;
import com.example.crud.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::categoryToDto).toList();
    }

    @Override
    public CategoryDto getCategoryById(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(404, "No data found with Id : " + categoryId));
        return this.categoryToDto(category);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.save(this.dtoToCategory(categoryDto));
        return this.categoryToDto(category);
    }

    @Override
    public CategoryDto updateCategory(long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(404, "No data found with Id : " + categoryId));

        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category newProject = categoryRepository.save(category);
        return this.categoryToDto(newProject);
    }

    @Override
    public void deleteCategory(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(404, "No data found with Id : " + categoryId));
        categoryRepository.delete(category);
    }


    public Category dtoToCategory(CategoryDto categoryDto) {
        return this.modelMapper.map(categoryDto, Category.class);
    }

    public CategoryDto categoryToDto(Category category) {
        return this.modelMapper.map(category, CategoryDto.class);
    }

}
