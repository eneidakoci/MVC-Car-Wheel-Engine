package com.detyra.mvc.service.impl;

import com.detyra.mvc.domain.dto.CarDTO;
import com.detyra.mvc.domain.dto.CarRequest;
import com.detyra.mvc.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public CarDTO save(CarRequest car) {
        return null;
    }

    @Override
    public CarDTO update(CarDTO car) {
        return null;
    }

    @Override
    public CarDTO findById(Integer id) {
        return null;
    }

    @Override
    public CarDTO delete(Integer id) {
        return null;
    }
}
