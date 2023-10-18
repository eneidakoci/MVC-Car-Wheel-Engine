package com.detyra.mvc.domain.dto;

import com.detyra.mvc.domain.entity.EngineEntity;
import com.detyra.mvc.domain.entity.WheelsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    private String fromYear;
    private String name;
    private String toYear;
    private String type;
    private Integer engineId;
    private Integer wheelsId;
}
