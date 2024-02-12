package com.example.crud.service;

import com.example.crud.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProduct();

    ProductDto getProductById(long productId);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(long productId, ProductDto productDto);

    void deleteProduct(long productId);

//	ProductDto assignCategory(long productId, long categoryId);

}
