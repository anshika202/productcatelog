package com.ecom.productcatelog.repository;

import com.ecom.productcatelog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// args : Product here is the entity is working with & data type of primary key
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long id);
}
