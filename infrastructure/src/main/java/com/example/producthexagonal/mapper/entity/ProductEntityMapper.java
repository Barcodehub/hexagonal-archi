package com.example.producthexagonal.mapper.entity;

import com.example.producthexagonal.entity.ProductEntity;
import com.example.producthexagonal.model.Product;
import org.mapstruct.Mapping;

public interface ProductEntityMapper {


    ProductEntity toEntity(Product product);

    Product toDomain(ProductEntity entity);

}
