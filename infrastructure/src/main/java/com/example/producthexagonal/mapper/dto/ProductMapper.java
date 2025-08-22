package com.example.producthexagonal.mapper.dto;

import com.example.producthexagonal.generated.dto.DataProductListDto;
import com.example.producthexagonal.generated.dto.ProductDto;
import com.example.producthexagonal.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    DataProductListDto toDto(Product product);

    ProductDto toDto2(Product product);

    List<ProductDto> toDto(List<Product> products);

    Product fromDto(ProductDto dto);
}
