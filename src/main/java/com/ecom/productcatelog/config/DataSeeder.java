package com.ecom.productcatelog.config;

import com.ecom.productcatelog.model.Category;
import com.ecom.productcatelog.model.Product;
import com.ecom.productcatelog.repository.CategoryRepository;
import com.ecom.productcatelog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // clear all existing data in db
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // create categories
        Category electronics = new Category();
        electronics.setName("electronics");

        Category clothing = new Category();
        clothing.setName("clothing");

        Category home = new Category();
        home.setName("home & Appliances");

        categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));

        // create products

        Product phone = new Product();
        phone.setName("phone");
        phone.setImgUrl("https://placehold.co/600x400");
        phone.setDescription("Lastest model Smart phone");
        phone.setPrice(25000.0);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setImgUrl("https://placehold.co/600x400");
        laptop.setDescription("Lastest model Laptop");
        laptop.setPrice(55000.0);
        laptop.setCategory(electronics);

        Product tshirt = new Product();
        tshirt.setName("T-Shirt");
        tshirt.setImgUrl("https://placehold.co/600x400");
        tshirt.setDescription("Cotton T-Shirt for daily wear");
        tshirt.setPrice(500.0);
        tshirt.setCategory(clothing);

        Product jeans = new Product();
        jeans.setName("Jeans");
        jeans.setImgUrl("https://placehold.co/600x400");
        jeans.setDescription("Denim jeans with comfort fit");
        jeans.setPrice(1200.0);
        jeans.setCategory(clothing);

        // create home & appliance products
        Product fridge = new Product();
        fridge.setName("Refrigerator");
        fridge.setImgUrl("https://placehold.co/600x400");
        fridge.setDescription("Double door refrigerator");
        fridge.setPrice(22000.0);
        fridge.setCategory(home);

        Product microwave = new Product();
        microwave.setName("Microwave Oven");
        microwave.setImgUrl("https://placehold.co/600x400");
        microwave.setDescription("Convection microwave oven");
        microwave.setPrice(8500.0);
        microwave.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, tshirt, jeans, fridge, microwave));
    }
}
