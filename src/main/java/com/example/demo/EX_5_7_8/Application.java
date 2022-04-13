package com.example.demo.EX_5_7_8;




import com.example.demo.EX_5_7_8.DAO.JPA.Service.WarehouseService;
import com.example.demo.EX_5_7_8.DAO.jdbc.CategoryDAO;
import com.example.demo.EX_5_7_8.DAO.jdbc.ProductDAO;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private ProductDAO productDAO;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocaleDateAdapter())
            .create();
    static class LocaleDateAdapter implements JsonSerializer<LocalDate> {
        @Override
        public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_DATE));

        }
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(gson.toJson(productDAO.getProductproc()));
        System.out.println(gson.toJson(categoryDAO.findAll()));
        System.out.println(gson.toJson(warehouseService.findAll()));
    }
}
