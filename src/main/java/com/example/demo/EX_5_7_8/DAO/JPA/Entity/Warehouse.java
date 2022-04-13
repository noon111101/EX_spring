package com.example.demo.EX_5_7_8.DAO.JPA.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_kho")
public class Warehouse implements Serializable {
    @Column(name = "ID")
    private Integer ID;
    @Column(name = "ma_kho")
    @Id
    private String ma_kho;
    @Column(name = "ten")
    private String ten;
    @Column(name = "dia_diem")
    private String dia_diem;
    @Column(name = "ngay_tao")
    private String ngay_tao;
    @Column(name = "ngay_sua")
    private String ngay_sua;

      }
