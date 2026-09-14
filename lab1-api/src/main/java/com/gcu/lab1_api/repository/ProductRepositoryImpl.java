package com.gcu.lab1_api.repository;

import com.gcu.lab1_api.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository 
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public ProductRepositoryImpl()
    {
        products.add(new Product(idCounter.incrementAndGet(), "Widger", "A useful widget", 19.99, 100));

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
        product.setId(idCounter.incrementAndGet());
        products.add(product);
        return product;
    }

    @Override
    public void deleteById(Long id)
    {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Product update(Long id, Product updatedProduct)
    {
        for (int i = 0; i < products.size();i++)
        {
            if(products.get(i).getId().equals(id))
            {
                updatedProduct.setId(id);
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return(null);

    }
}
