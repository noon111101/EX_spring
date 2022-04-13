package com.example.demo.EX_5_7_8.DAO.JPA.Service.Interface;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
