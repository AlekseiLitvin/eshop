package com.example.eshop.service;

import com.example.eshop.model.Product;
import com.example.eshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(int id) {
        log.info("Get by id request received");
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAll() {
        log.info("Get all request received");
        return productRepository.findAll();
    }

    public void delete(int id) {
        log.info("Delete request received for id {}", id);
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        log.info("Delete all request received");
        productRepository.deleteAll();
    }

    public Product save(Product product) {
        log.info("New product with id: {}, and name: {} was saved", product.getId(), product.getName());
        return productRepository.save(product);
    }

    public Product update(Product product) {
        productRepository.delete(product);
        return productRepository.save(product);
    }

}
