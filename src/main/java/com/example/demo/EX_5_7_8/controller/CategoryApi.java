package com.example.demo.EX_5_7_8.controller;


import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Category;
import com.example.demo.EX_5_7_8.DAO.JPA.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryApi {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory (@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable (name = "id") Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        return categoryOptional.map(category1 -> {
            category.setId(category1.getId());
            return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
        @DeleteMapping("/category/{id}")
        public ResponseEntity<Category> deleteCategory (@PathVariable (name = "id") Long id){
            Optional<Category> categoryOptional = categoryService.findById(id);
            return categoryOptional.map(category -> {
                categoryService.remove(id);
                return new ResponseEntity<>(category, HttpStatus.OK);
            }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

    };

