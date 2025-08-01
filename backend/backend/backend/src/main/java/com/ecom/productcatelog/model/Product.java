package com.ecom.productcatelog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private  String imgUrl;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
//    @JsonIgnore
    private Category category;
}
