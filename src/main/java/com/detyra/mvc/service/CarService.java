package com.detyra.mvc.service;

import com.detyra.mvc.domain.dto.CarDTO;
import com.detyra.mvc.domain.dto.CarRequest;

public interface CarService {
    CarDTO save(CarRequest car);
    CarDTO update(CarDTO car);
    CarDTO findById(Integer id);
    CarDTO delete(Integer id);
}
