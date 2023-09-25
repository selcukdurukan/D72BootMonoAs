package com.ba.boost.d72bootmonoas.repository;

import com.ba.boost.d72bootmonoas.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


}
