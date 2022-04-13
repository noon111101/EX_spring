package com.example.demo.EX_5_7_8.DAO.JPA.Service;

import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Product;
import com.example.demo.EX_5_7_8.DAO.JPA.Repository.IProductRepository;
import com.example.demo.EX_5_7_8.DAO.JPA.Service.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
