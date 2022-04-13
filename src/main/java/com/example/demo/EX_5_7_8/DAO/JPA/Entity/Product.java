package com.example.demo.EX_5_7_8.DAO.JPA.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_san_pham")
public class Product implements Serializable {
    @Column(name = "ID")
    private Integer id;
    @Id
    @Column(name = "ma_san_pham")
    private String ProductID;
    @NotNull
    @Size(min=2, max=30)
    @Column(name = "ten")
    private String name;
    @Column(name = "danh_muc")
    private String categoryID;
    @Column(name = "kho")
    private String warehouseID;
    @Column(name = "mo_ta_san_pham")
    private String description;
    @Column(name = "duong_dan_anh")
    private String imageurl;
    @Column(name = "so_luong_san_pham")
    private int productamount;
    @Column(name = "so_luong_ban")
    private int sellamount;
    @Column(name = "gia")
    private float price;
    @Column(name = "ngay_tao")
    private String datecreated;
    @Column(name = "ngay_sua")
    private String dateupdated;


}