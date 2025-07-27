package com.ecom.productcatelog.repository;

import com.ecom.productcatelog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// args : Category here is the entity is working with & data type of primary key
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
