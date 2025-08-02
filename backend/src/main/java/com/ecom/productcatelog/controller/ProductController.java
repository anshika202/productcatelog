package com.ecom.productcatelog.controller;

import com.ecom.productcatelog.model.Product;
import com.ecom.productcatelog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{id}")
    private List<Product> getProductsByCategory(@PathVariable Long id){
        return productService.getProductsByCategory(id);
    }
}
