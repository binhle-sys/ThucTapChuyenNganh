package com.example.demo.service;
import com.example.demo.entity.product;
import java.util.List;

public interface ProductService {
    List<product> findAll();
    product findById(int id);
    product save(product product);
    void delete(int id);
}
