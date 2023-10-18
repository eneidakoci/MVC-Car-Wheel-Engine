package com.detyra.mvc.repository.impl;

import com.detyra.mvc.domain.entity.CarEntity;
import com.detyra.mvc.repository.CarRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryImpl implements CarRepository {
    @Override
    public CarEntity save(CarEntity car) {
        return null;
    }

    @Override
    public CarEntity update(CarEntity car) {
        return null;
    }

    @Override
    public CarEntity findById(Integer id) {
        return null;
    }

    @Override
    public CarEntity delete(CarEntity car) {
        return null;
    }
}
