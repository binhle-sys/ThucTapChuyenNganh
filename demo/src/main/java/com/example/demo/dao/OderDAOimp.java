package com.example.demo.dao;

import com.example.demo.entity.Oder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OderDAOimp implements OderDAO {
    private EntityManager em;

    @Autowired
    public OderDAOimp(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Oder> findAll() {
        TypedQuery<Oder> query = em.createQuery("from Oder", Oder.class);
        return query.getResultList();
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
    public void deletedById(int id) {

    }
}
