package com.detyra.mvc.repository.impl;

import com.detyra.mvc.domain.entity.WheelsEntity;
import com.detyra.mvc.repository.WheelsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WheelsRepositoryImpl implements WheelsRepository {

    private static final String FIND_QUERY="select w from WheelsEntity w where w.id=:id";
    private static final String FIND_ALL_QUERY = "SELECT w FROM WheelsEntity w";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public WheelsEntity save(WheelsEntity wheels) {
        entityManager.merge(wheels);
        return wheels;
    }

    @Override
    public WheelsEntity update(WheelsEntity wheels) {
        entityManager.merge(wheels);
        return wheels;
    }

    @Override
    public WheelsEntity findById(Integer id) {
        return entityManager.createQuery(FIND_QUERY, WheelsEntity.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public WheelsEntity delete(WheelsEntity wheels) {
        entityManager.remove(wheels);
        return wheels;
    }

    @Override
    public List<WheelsEntity> findAll() {
        return entityManager.createQuery(FIND_ALL_QUERY, WheelsEntity.class)
                .getResultList();
    }
}
