package com.example.producthexagonal;

import com.example.producthexagonal.exception.BusinessErrorCodes;
import com.example.producthexagonal.exception.NotFoundException;
import com.example.producthexagonal.model.Product;
import com.example.producthexagonal.ports.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        BusinessErrorCodes.PRODUCT_NOT_FOUND.message(),
                        BusinessErrorCodes.PRODUCT_NOT_FOUND.code()
                ));
    }

    @Override
    public List<Product> getAllProducts() {

        return repository.findAll();

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        BusinessErrorCodes.PRODUCT_NOT_FOUND.message(),
                        BusinessErrorCodes.PRODUCT_NOT_FOUND.code()
                ));

        product.validatePrice();

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return repository.save(existingProduct);
    }


    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

}