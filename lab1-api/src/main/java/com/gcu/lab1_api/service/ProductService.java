package com.gcu.lab1_api.service;

import java.util.List;

import com.gcu.lab1_api.dto.ProductDto;
import com.gcu.lab1_api.entity.Product;
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

    public ProductDto getProductById(Long id)
    {
        return productRepository.findById(id)
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()))
                .orElse(null);
    }

    public ProductDto createProduct(ProductDto productDto)
    {
        var product = new Product(null, productDto.name(), productDto.description(), productDto.price(), productDto.quantity());
        var savedProduct = productRepository.save(product);
        return new ProductDto(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription(), savedProduct.getPrice(), savedProduct.getQuantity());
    }

    public ProductDto updateProduct(Long id, ProductDto productDto)
    {
        var existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent())
        {
            var product = existingProduct.get();
            product.setName(productDto.name());
            product.setDescription(productDto.description());
            product.setPrice(productDto.price());
            product.setQuantity(productDto.quantity());
            var updatedProduct = productRepository.save(product);
            return new ProductDto(updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getPrice(), updatedProduct.getQuantity());
        }
        return null;
    }

    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }
}
