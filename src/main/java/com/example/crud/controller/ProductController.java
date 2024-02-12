package com.example.crud.controller;

import com.example.crud.dto.ApiResponse;
import com.example.crud.dto.ProductDto;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllStudents() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getStudentById(@PathVariable("id") long studentId) {
        return ResponseEntity.ok(productService.getProductById(studentId));
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> addStudent(@RequestBody ProductDto studentDto) {
        return ResponseEntity.ok(productService.addProduct(studentDto));
    }

    @PutMapping("{studentId}")
    public ResponseEntity<ProductDto> updateStudent(@PathVariable long studentId, @RequestBody ProductDto studentDto) {
        return ResponseEntity.ok(productService.updateProduct(studentId, studentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("id") long studentId) {
        productService.deleteProduct(studentId);
        ApiResponse apiResponse = new ApiResponse(200, "Success", "Student Deleted Successfully");
        return ResponseEntity.ok(apiResponse);
    }

}
