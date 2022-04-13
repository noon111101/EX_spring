package com.example.demo.EX_5_7_8.DAO.JPA.Service;


import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Warehouse;

import com.example.demo.EX_5_7_8.DAO.JPA.Repository.IWarehouseRepository;
import com.example.demo.EX_5_7_8.DAO.JPA.Service.Interface.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService implements IWarehouseService {
    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Override
    public Iterable<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<Warehouse> findById(Long id) {
        return warehouseRepository.findById(id);
    }

    @Override
    public Warehouse save(Warehouse warehouseEntity) {
        return warehouseRepository.save(warehouseEntity);
    }

    @Override
    public void remove(Long id) {
        warehouseRepository.deleteById(id);
    }
}
