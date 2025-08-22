package com.example.producthexagonal.controller;

import com.example.producthexagonal.generated.api.ProductApi;
import com.example.producthexagonal.generated.dto.DataProductListDto;
import com.example.producthexagonal.generated.dto.ProductDto;
import com.example.producthexagonal.mapper.dto.ProductMapper;
import com.example.producthexagonal.model.Product;
import com.example.producthexagonal.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto dto) {

        Product product = productMapper.fromDto(dto);
        Product saved = productService.createProduct(product);

        ProductDto responseDto = productMapper.toDto2(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(
            Long id,
            ProductDto dto) {

        Product product = productMapper.fromDto(dto);
        Product saved = productService.updateProduct(id, product);

        ProductDto responseDto = productMapper.toDto2(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long productId) {
        Product product = productService.getProductById(productId);

        ProductDto dto = productMapper.toDto2(product);

        return ResponseEntity.ok(dto);

        }

    @Override
    public ResponseEntity<Void> deleteProduct(Long productId) {
        productService.deleteProduct(productId);
        return null;
    }


}