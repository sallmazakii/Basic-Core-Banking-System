package com.example.office.repo;

import com.example.office.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
