package com.example.eshop;

import com.example.eshop.model.Product;
import com.example.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class EshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Autowired
    private ProductService productService;

    @Bean
    public CommandLineRunner clr() {
        return args -> {
            productService.deleteAll();
            for (int i = 1; i < 50; i++) {
                productService.save(new Product(i, "Product" + i, i * i));
            }
        };
    }

}
