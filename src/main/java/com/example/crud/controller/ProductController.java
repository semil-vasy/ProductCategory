package com.example.crud.controller;

import com.example.crud.dto.ApiResponse;
import com.example.crud.dto.ProductDto;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("product")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping("category/{categoryId}/product")
    public ResponseEntity<ProductDto> addStudent(@PathVariable long categoryId, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(categoryId, productDto));
    }

    @GetMapping("category/{categoryId}/product")
    public ResponseEntity<List<ProductDto>> addStudent(@PathVariable long categoryId) {
        return ResponseEntity.ok(productService.getProductByCategory(categoryId));
    }

    @PutMapping("product/{productId}")
    public ResponseEntity<ProductDto> updateStudent(@PathVariable long productId, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productId, productDto));
    }

    @DeleteMapping("product/{productId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable long productId) {
        productService.deleteProduct(productId);
        ApiResponse apiResponse = new ApiResponse(200, "Success", "Product Deleted Successfully");
        return ResponseEntity.ok(apiResponse);
    }

}
