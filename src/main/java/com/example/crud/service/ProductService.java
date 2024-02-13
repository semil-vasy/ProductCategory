package com.example.crud.service;

import com.example.crud.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProduct();

    List<ProductDto> getProductByCategory(long categoryId);

    ProductDto getProductById(long productId);

    ProductDto addProduct(long categoryId, ProductDto productDto);

    ProductDto updateProduct(long productId, ProductDto productDto);

    void deleteProduct(long productId);


}
