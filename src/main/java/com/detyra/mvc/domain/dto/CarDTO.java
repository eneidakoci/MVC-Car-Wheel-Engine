package com.detyra.mvc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO extends BaseDomainDTO{
    private String fromYear;
    private String name;
    private String toYear;
    private String type;
    private EngineDTO engine;
    private WheelsDTO wheels;
    private Integer id;
}
