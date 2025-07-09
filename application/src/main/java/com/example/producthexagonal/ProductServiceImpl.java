package com.example.producthexagonal;

import com.example.producthexagonal.model.Product;
import com.example.producthexagonal.ProductService;
import com.example.producthexagonal.ports.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Anotación para inyección de Spring
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    // Inyección de dependencias
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    // ... CRUD

    @Override
    public Product createProduct(Product product) {
        product.validatePrice();
        return repository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        product.validatePrice();
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

}