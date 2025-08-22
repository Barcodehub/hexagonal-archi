package com.example.producthexagonal.repository;

import com.example.producthexagonal.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    // Spring Data JPA implementa automáticamente los métodos de ProductRepository.
}