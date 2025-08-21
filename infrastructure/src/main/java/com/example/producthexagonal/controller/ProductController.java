package com.example.producthexagonal.controller;

import com.example.producthexagonal.generated.api.ProductApi;
import com.example.producthexagonal.generated.dto.DataProductListDto;
import com.example.producthexagonal.mapper.dto.ProductMapper;
import com.example.producthexagonal.model.Product;
import com.example.producthexagonal.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController implements ProductApi {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseEntity<DataProductListDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new DataProductListDto().data(productMapper.toDto(products)));
    }


}