package com.detyra.mvc.domain.mappers;

import com.detyra.mvc.domain.dto.WheelsDTO;
import com.detyra.mvc.domain.dto.WheelsRequest;
import com.detyra.mvc.domain.entity.WheelsEntity;

public class WheelsMapper {
    public static WheelsEntity toEntity(WheelsRequest wheelsRequest){
        WheelsEntity wheels = new WheelsEntity();
        wheels.setSize(wheelsRequest.getSize());
        wheels.setType(wheelsRequest.getType());
        return wheels;
    }
    public static WheelsDTO toDto(WheelsEntity engineEntity){
        return new WheelsDTO(engineEntity.getId(), engineEntity.getSize(), engineEntity.getType());
    }
    public static WheelsEntity toEntity(WheelsDTO wheelsDTO){
        WheelsEntity wheels = new WheelsEntity();
        wheels.setId(wheelsDTO.getId());
        wheels.setSize(wheelsDTO.getSize());
        wheels.setType(wheelsDTO.getType());
        return wheels;
    }
}
