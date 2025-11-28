package com.example.demo.service;

import com.example.demo.dao.OderDAO;
import com.example.demo.entity.Oder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderServiceImp implements OderService {
    private OderDAO oderDAO;
    @Autowired
    public OderServiceImp(OderDAO oderDAO) {this.oderDAO = oderDAO;}
    @Override
    public List<Oder> findAll() {
        return oderDAO.findAll();

    }

    @Override
    public Oder findById(int id) {
        return null;
    }

    @Override
    public Oder save(Oder oder) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
