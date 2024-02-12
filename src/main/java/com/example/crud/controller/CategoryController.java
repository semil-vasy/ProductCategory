package com.example.crud.controller;

import com.example.crud.dto.ApiResponse;
import com.example.crud.dto.CategoryDto;
import com.example.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAllProjects() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getProjectById(@PathVariable("id") long projectId) {
        return ResponseEntity.ok(categoryService.getCategoryById(projectId));
    }

    @PostMapping("")
    public ResponseEntity<CategoryDto> saveProject(@RequestBody CategoryDto projectDto) {
        return ResponseEntity.ok(categoryService.addCategory(projectDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateProject(@PathVariable("id") long projectId, @RequestBody CategoryDto projectDto) {
        return ResponseEntity.ok(categoryService.updateCategory(projectId, projectDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteProject(@PathVariable("id") long projectId) {
        categoryService.deleteCategory(projectId);
        ApiResponse apiResponse = new ApiResponse(200, "Success", "Project Deleted Successfully");
        return ResponseEntity.status(200).body(apiResponse);
    }
}
