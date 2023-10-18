package com.detyra.mvc.service.impl;

import com.detyra.mvc.domain.dto.EngineDTO;
import com.detyra.mvc.domain.dto.EngineRequest;
import com.detyra.mvc.domain.entity.EngineEntity;
import com.detyra.mvc.domain.mappers.EngineMapper;
import com.detyra.mvc.repository.EngineRepository;
import com.detyra.mvc.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.detyra.mvc.domain.mappers.EngineMapper.toDto;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public List<EngineDTO> findAll() {
        List<EngineEntity> engines = engineRepository.findAll();
        return engines.stream()
                .map(EngineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public EngineDTO save(EngineRequest engineRequest) {
        return toDto(engineRepository.save(EngineMapper.toEntity(engineRequest)));
    }

    @Transactional
    @Override
    public EngineDTO update(EngineDTO engineDTO) {
        return toDto(engineRepository.update(EngineMapper.toEntity(engineDTO)));
    }

    @Override
    public EngineDTO findById(Integer id) {
        return toDto(engineRepository.findById(id));
    }

    @Transactional
    @Override
    public EngineDTO delete(Integer id) {
        EngineEntity engineToDelete =  EngineMapper.toEntity(findById(id));
        return toDto(engineRepository.delete(engineToDelete));
    }
}