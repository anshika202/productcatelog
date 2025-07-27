package com.ecom.productcatelog.service;

import com.ecom.productcatelog.model.Product;
import com.ecom.productcatelog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Long id) {
        return productRepository.findByCategoryId(id);
    }
}
