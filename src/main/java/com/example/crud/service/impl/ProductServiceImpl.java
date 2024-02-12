package com.example.crud.service.impl;

import com.example.crud.dto.ProductDto;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Product;
import com.example.crud.repository.CategoryRepository;
import com.example.crud.repository.ProductRepository;
import com.example.crud.service.CategoryService;
import com.example.crud.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::productToDto).toList();
    }

    @Override
    public ProductDto getProductById(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(404, "No data found with Id : " + productId));
        return this.productToDto(product);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productRepository.save(this.dtoToProduct(productDto));
        return this.productToDto(product);
    }

    @Override
    public ProductDto updateProduct(long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("No data found with Id : " + productId));

        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
//        product.setProject(productDto.getProject());

        Product newProduct = productRepository.save(product);
        return this.productToDto(newProduct);

    }

    @Override
    public void deleteProduct(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(404, "No data found with Id : " + productId));
        productRepository.delete(product);
    }

    Product dtoToProduct(ProductDto productDto) {
        return this.modelMapper.map(productDto, Product.class);
    }

    ProductDto productToDto(Product product) {
        return this.modelMapper.map(product, ProductDto.class);
    }

}
