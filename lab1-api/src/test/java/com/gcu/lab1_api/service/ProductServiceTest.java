package com.gcu.lab1_api.service;

import com.gcu.lab1_api.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gcu.lab1_api.entity.Product;
import com.gcu.lab1_api.service.ProductService;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void getAllProducts_returnsListFromRepository() {
        List<Product> mockProducts = List.of(new Product(1L, "Widget", "A useful widget", 19.99, 100));
        when(productRepository.findAll()).thenReturn(mockProducts);

        List<Product> result = productService.getAllProducts();

        assertEquals(1, result.size());
        verify(productRepository).findAll();
    }
}
