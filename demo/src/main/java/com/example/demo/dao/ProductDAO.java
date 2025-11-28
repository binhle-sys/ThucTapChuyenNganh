package com.example.demo.dao;

import com.example.demo.entity.product;

import java.util.List;

public interface ProductDAO {
    List<product> findAll();
    product findById(int id);
    product save(product category);
    void deletedById(int id);
}
