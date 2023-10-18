package com.detyra.mvc.domain.mappers;

import com.detyra.mvc.domain.dto.EngineDTO;
import com.detyra.mvc.domain.dto.EngineRequest;
import com.detyra.mvc.domain.entity.CarEntity;
import com.detyra.mvc.domain.entity.EngineEntity;

public class EngineMapper {
    public static EngineEntity toEntity(EngineRequest engineRequest){
        EngineEntity engine = new EngineEntity();
        engine.setPower(engineRequest.getPower());
        engine.setType(engineRequest.getType());
        return engine;
    }
    public static EngineDTO toDto(EngineEntity engineEntity){
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setId(engineEntity.getId());
        engineDTO.setType(engineEntity.getType());
        engineDTO.setPower(engineEntity.getPower());
        return engineDTO;
    }

    public static EngineEntity toEntity(EngineDTO engineDTO){
        EngineEntity engine = new EngineEntity();
        engine.setId(engineDTO.getId());
        engine.setPower(engineDTO.getPower());
        engine.setType(engineDTO.getType());
        return engine;
    }
}
