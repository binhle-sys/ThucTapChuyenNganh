package com.example.demo.service;

import com.example.demo.entity.Oder;

import java.util.List;

public interface OderService {
    List<Oder> findAll();
    Oder findById(int id);
    Oder save(Oder oder);
    void delete(int id);
}
