package com.luisfelipebp.services;

import com.luisfelipebp.model.DTO.ProductDTO;
import com.luisfelipebp.model.Product;
import com.luisfelipebp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(ProductDTO product){
        Product newProduct = new Product(product);
        return productRepository.save(newProduct);
    }
}
