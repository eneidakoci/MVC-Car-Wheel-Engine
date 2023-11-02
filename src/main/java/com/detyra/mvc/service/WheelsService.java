package com.detyra.mvc.service;


import com.detyra.mvc.domain.dto.EngineDTO;
import com.detyra.mvc.domain.dto.WheelsDTO;
import com.detyra.mvc.domain.dto.WheelsRequest;
import com.detyra.mvc.domain.entity.WheelsEntity;
import com.detyra.mvc.filter.Filter;

import java.util.List;

public interface WheelsService {
    WheelsDTO save(WheelsRequest wheelsRequest);
    WheelsDTO update(WheelsDTO wheelsDTO);
    WheelsDTO findById(Integer id);
    WheelsDTO delete(Integer id);
    List<WheelsDTO> findAll(Filter...filters);
}
