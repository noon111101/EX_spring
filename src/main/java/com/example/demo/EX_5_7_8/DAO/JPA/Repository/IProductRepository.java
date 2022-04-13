package com.example.demo.EX_5_7_8.DAO.JPA.Repository;

import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
