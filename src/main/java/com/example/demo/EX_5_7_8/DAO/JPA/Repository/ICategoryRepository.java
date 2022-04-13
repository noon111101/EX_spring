package com.example.demo.EX_5_7_8.DAO.JPA.Repository;

import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
