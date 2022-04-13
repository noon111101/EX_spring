package com.example.demo.EX_5_7_8.DAO.JPA.Service;

import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Category;
import com.example.demo.EX_5_7_8.DAO.JPA.Repository.ICategoryRepository;
import com.example.demo.EX_5_7_8.DAO.JPA.Service.Interface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
