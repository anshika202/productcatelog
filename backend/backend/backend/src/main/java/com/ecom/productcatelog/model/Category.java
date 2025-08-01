package com.ecom.productcatelog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;
}
