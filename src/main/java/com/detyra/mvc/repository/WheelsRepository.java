package com.detyra.mvc.repository;
import com.detyra.mvc.domain.entity.EngineEntity;
import com.detyra.mvc.domain.entity.WheelsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface WheelsRepository {
    WheelsEntity save(WheelsEntity wheels);
    WheelsEntity update(WheelsEntity wheels);
    WheelsEntity findById(Integer id);
    WheelsEntity delete(WheelsEntity wheels);
    List<WheelsEntity> findAll();
}
