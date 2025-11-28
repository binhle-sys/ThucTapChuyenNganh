package com.example.demo.dao;


import com.example.demo.entity.product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public class ProductDAOimp implements ProductDAO {
    private EntityManager em;
    @Autowired
    public ProductDAOimp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<product> findAll() {
        TypedQuery<product> query = em.createQuery("from product", product.class);
        return query.getResultList();
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
    public void deletedById(int id) {

    }
}
