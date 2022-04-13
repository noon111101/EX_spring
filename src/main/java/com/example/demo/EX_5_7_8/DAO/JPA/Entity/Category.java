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
@Table(name = "tbl_loai_danh_muc")
public class Category implements Serializable {
    @Column(name = "ID")
    private Integer id;
    @Id
    @Column(name = "ma_loai_danh_muc")
    private String categoryID;
    @NotNull
    @Size(min=2, max=30)
    @Column(name = "ten")
    private String name;
    @Column(name = "mo_ta")
    private String description;
    @Column(name = "ngay_tao")
    private String datecreated;
    @Column(name = "ngay_sua")
    private String dateupdated;
}
