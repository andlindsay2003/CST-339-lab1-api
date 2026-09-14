package com.gcu.lab1_api.repository;

import com.gcu.lab1_api.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository 
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepositoryImpl()
    {
        products.add(new Product(1L, "Widger", "A useful widget", 19.99, 100));

    }

    @Override
    public List<Product> findAll()
    {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id)
    {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Product save(Product product)
    {
        products.add(product);
        return product;
    }

    @Override
    public void deleteById(Long id)
    {
        products.removeIf(p -> p.getId().equals(id));
    }
}
