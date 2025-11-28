package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private ProductDAO productDAO;
    @Autowired
    public ProductServiceImp(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public product findById(int id) {
        return null;
    }

    @Override
    public product save(product product) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
