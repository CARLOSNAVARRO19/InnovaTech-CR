package com.carlos.navarro.InnovaTech.CR.repository;

import com.carlos.navarro.InnovaTech.CR.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductRepository, Long> {
    List<Product> findByCategoryId(Long categoryId);
}
