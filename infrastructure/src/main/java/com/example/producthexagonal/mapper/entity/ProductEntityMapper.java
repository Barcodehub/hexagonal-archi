package com.example.producthexagonal.mapper.entity;

import com.example.producthexagonal.entity.ProductEntity;
import com.example.producthexagonal.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntity toEntity(Product product);
    Product toDomain(ProductEntity entity);

}
