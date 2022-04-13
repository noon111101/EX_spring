package com.example.demo.EX_5_7_8.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Product {
    private Integer id;
    private String productID;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String categoryID;
    private String warehouseID;
    private String description;
    private String imageurl;
    private int productamount;
    private int sellamount;
    private float price;
    private String datecreated;
    private String dateupdated;



}
