package com.detyra.mvc.domain.mappers;

import com.detyra.mvc.domain.dto.CarDTO;
import com.detyra.mvc.domain.dto.CarRequest;
import com.detyra.mvc.domain.dto.EngineDTO;
import com.detyra.mvc.domain.dto.EngineRequest;
import com.detyra.mvc.domain.entity.CarEntity;
import com.detyra.mvc.domain.entity.EngineEntity;
import com.detyra.mvc.domain.entity.WheelsEntity;

public class CarMapper {
    public static CarEntity toEntity(CarRequest carRequest, EngineEntity engineEntity, WheelsEntity wheelsEntity){
        CarEntity car = new CarEntity();
        car.setName(carRequest.getName());
        car.setType(carRequest.getType());
        car.setFromYear(carRequest.getType());
        car.setToYear(carRequest.getType());
        car.setEngine(engineEntity);
        car.setWheels(wheelsEntity);
        return car;
    }
    public static CarDTO toDto(CarEntity carEntity){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(carEntity.getId());
        carDTO.setType(carEntity.getType());
        carDTO.setFromYear(carEntity.getType());
        carDTO.setToYear(carEntity.getType());
        carDTO.setEngine(EngineMapper.toDto(carEntity.getEngine()));
        carDTO.setWheels(WheelsMapper.toDto(carEntity.getWheels()));
        return carDTO;
    }
}
