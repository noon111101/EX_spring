package com.example.demo.EX_5_7_8.DAO.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;
@Service
public class ProductDAO {
    @Autowired
    DataSource dataSource;


    public Map<String, Object> getProductproc() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("proc_luong_ban").withCatalogName("EX03_mysql");
        Map<String, Object> out = simpleJdbcCall.execute();
        return out;

}};
