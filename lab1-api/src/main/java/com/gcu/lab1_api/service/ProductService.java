package com.gcu.lab1_api.service;

import java.util.List;

import com.gcu.lab1_api.dto.ProductDto;
import com.gcu.lab1_api.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto>getAllProducts() {
        // Implementation for retrieving all products
        return productRepository.findAll().stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()))
                .toList();
    }


}
