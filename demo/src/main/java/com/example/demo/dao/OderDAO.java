package com.example.demo.dao;

import com.example.demo.entity.Oder;

import java.util.List;

public interface OderDAO {
    List<Oder> findAll();
    Oder findById(int id);
    Oder save(Oder oder);
    void deletedById(int id);
}
