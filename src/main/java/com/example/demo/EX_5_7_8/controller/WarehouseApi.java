package com.example.demo.EX_5_7_8.controller;


import com.example.demo.EX_5_7_8.DAO.JPA.Entity.Warehouse;
import com.example.demo.EX_5_7_8.DAO.JPA.Service.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WarehouseApi {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/warehouse")
    public ResponseEntity<Warehouse> addWarehouse (@Valid @RequestBody Warehouse warehouse) {
        return new ResponseEntity<>(warehouseService.save(warehouse), HttpStatus.OK);
    }

    @GetMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable (name = "id") Long id) {
        Optional<Warehouse> warehouseOptional = warehouseService.findById(id);
        return warehouseOptional.map(warehouse -> new ResponseEntity<>(warehouse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/warehouse")
    public ResponseEntity<Iterable<Warehouse>> getAllWarehouse() {
        return new ResponseEntity<>(warehouseService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        Optional<Warehouse> warehouseOptional = warehouseService.findById(id);
        return warehouseOptional.map(warehouse1 -> {
            warehouse.setID(warehouse1.getID());
            return new ResponseEntity<>(warehouseService.save(warehouse), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> deleteWarehouse (@PathVariable (name = "id") Long id){
        Optional<Warehouse> warehouseOptional = warehouseService.findById(id);
        return warehouseOptional.map(warehouse -> {
            warehouseService.remove(id);
            return new ResponseEntity<>(warehouse, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

};

