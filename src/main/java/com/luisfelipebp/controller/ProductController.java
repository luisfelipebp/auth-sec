package com.luisfelipebp.controller;

import com.luisfelipebp.model.DTO.ProductDTO;
import com.luisfelipebp.model.Product;
import com.luisfelipebp.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok().body(productServices.findAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO product){
        return ResponseEntity.status(201).body(productServices.createProduct(product));
    }
}
