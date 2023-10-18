package com.detyra.mvc.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="car")
public class CarEntity extends BaseEntity {
    private String fromYear;
    private String name;
    private String toYear;
    private String type;

    @ManyToOne
    @JoinColumn(name="engine_id", referencedColumnName = "id")
    private EngineEntity engine;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="wheels_id", referencedColumnName = "id")
    private WheelsEntity wheels;
}
