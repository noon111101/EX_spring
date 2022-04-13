package com.example.demo.EX_5_7_8.controller;


import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Product;
import com.example.demo.EX_5_7_8.DAO.JPA.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct (@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable (name = "id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/product")
    public ResponseEntity<Iterable<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.map(product1 -> {
            product.setId(product1.getId());
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct (@PathVariable (name = "id") Long id){
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.map(product -> {
            productService.remove(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

};

