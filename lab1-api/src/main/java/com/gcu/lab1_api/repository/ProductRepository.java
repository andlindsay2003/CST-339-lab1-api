package com.gcu.lab1_api.repository;

import java.util.List;
import java.util.Optional;

import com.gcu.lab1_api.entity.Product;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    Product update(Long id, Product updatedProduct);
}
