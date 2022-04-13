package com.example.demo.EX_5_7_8.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Warehouse {
    private Integer id;
    private String warehouseID;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String address;
    private String datecreated;
    private String dateupdated;
}
