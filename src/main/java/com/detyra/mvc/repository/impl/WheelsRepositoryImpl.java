package com.detyra.mvc.repository.impl;

import com.detyra.mvc.domain.dto.WheelsDTO;
import com.detyra.mvc.domain.entity.WheelsEntity;
import com.detyra.mvc.domain.mappers.WheelsMapper;
import com.detyra.mvc.filter.Filter;
import com.detyra.mvc.repository.WheelsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class WheelsRepositoryImpl implements WheelsRepository {
    private static final String FIND_QUERY = "select w from WheelsEntity w where w.id=:id";

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
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public WheelsEntity delete(WheelsEntity wheels) {
        entityManager.remove(wheels);
        return wheels;
    }

    /**
     * this method finds all the records that are being searched
     * it only works when the user has inputted the "=" operator
     * when the user has inputted a different operator, it will return an empty list and an error message.
     */
    @Override
    public List<WheelsEntity> findAll(Filter... filters) {
        StringBuilder jpqlQuery = new StringBuilder("SELECT w FROM WheelsEntity w WHERE 1=1");

        boolean filterApplied = false;
        Map<String, Object> parameters = new HashMap<>();

        for (Filter filter : filters) {
            if (filter.getValue() != null) {
                String operator = filter.getOperator();
                if ("=".equals(operator)) {
                    jpqlQuery.append(" AND w.").append(filter.getField()).append(" = :").append(filter.getField());
                    parameters.put(filter.getField(), filter.getValue());
                    filterApplied = true;
                }
            }
        }

        if (!filterApplied) {
            return Collections.emptyList(); // If there are no valid filters, return an empty list
        }

        Query query = entityManager.createQuery(jpqlQuery.toString(), WheelsEntity.class);

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

}
