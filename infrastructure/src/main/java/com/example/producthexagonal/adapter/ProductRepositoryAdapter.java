package com.example.producthexagonal.adapter;

import com.example.producthexagonal.entity.ProductEntity;
import com.example.producthexagonal.mapper.entity.ProductEntityMapper;
import com.example.producthexagonal.model.Product;
import com.example.producthexagonal.ports.ProductRepository;
import com.example.producthexagonal.repository.JpaProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryAdapter(JpaProductRepository jpaRepository, ProductEntityMapper productEntityMapper) {
        this.jpaRepository = jpaRepository;
        this.productEntityMapper = productEntityMapper;
    }


    @Override
    public Product save(Product product) {

        ProductEntity entity = productEntityMapper.toEntity(product);
        ProductEntity savedEntity = jpaRepository.save(entity);

        return productEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(productEntityMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(productEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }


}