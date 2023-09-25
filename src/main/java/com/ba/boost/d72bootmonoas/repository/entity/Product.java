package com.ba.boost.d72bootmonoas.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String productName;
    private Double price;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private EQuantityType quantityType;

//    @ManyToMany(mappedBy = "products")
//    private List<Cart> carts;

}
