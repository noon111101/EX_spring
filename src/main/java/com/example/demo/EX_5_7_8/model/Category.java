package com.example.demo.EX_5_7_8.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Category {
    private Integer id;
    private String categoryID;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String description;
    private String datecreated;
    private String dateupdated;
    public Category(Integer id, String categoryID, String name, String description, String datecreated, String dateupdated) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.datecreated = datecreated;
        this.dateupdated = dateupdated;
    }
    public String toString() {
        return "Category(ID: " + this.id + ", categoryID: " + this.categoryID +",name :"+this.name+",description : "+this.description+"datecreated:"+this.datecreated+"dateupdated"+this.dateupdated+ ")";
    }

}
