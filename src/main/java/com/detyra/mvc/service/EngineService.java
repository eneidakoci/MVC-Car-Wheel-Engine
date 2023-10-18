package com.detyra.mvc.service;

import com.detyra.mvc.domain.dto.EngineDTO;
import com.detyra.mvc.domain.dto.EngineRequest;

import java.util.List;

public interface EngineService {
    EngineDTO save(EngineRequest engineRequest);
    EngineDTO update(EngineDTO engineDTO);
    EngineDTO findById(Integer id);
    EngineDTO delete(Integer id);
    List<EngineDTO> findAll();
}
