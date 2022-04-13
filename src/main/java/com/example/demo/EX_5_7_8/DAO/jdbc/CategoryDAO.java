package com.example.demo.EX_5_7_8.DAO.jdbc;


import com.example.demo.EX_5_7_8.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDAO {
    @Autowired
    JdbcTemplate jdbc;

    public List<Category> findAll() {
        return jdbc.query(
                "SELECT * from tbl_loai_danh_muc ",
                (rs, rowNum) ->
                        new Category(
                                rs.getInt("ID"),
                                rs.getString("ma_loai_danh_muc"),
                                rs.getString("ten"),
                                rs.getString("mo_ta"),
                                rs.getString("ngay_tao"),
                                rs.getString("ngay_sua")
                                )
        );
    }
    public Integer countCategory(){
        return jdbc.queryForObject(
                "SELECT COUNT(*) FROM tbl_loai_danh_muc", Integer.class);
    }




}
