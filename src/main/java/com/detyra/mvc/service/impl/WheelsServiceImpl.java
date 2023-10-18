package com.detyra.mvc.service.impl;

import com.detyra.mvc.domain.dto.WheelsDTO;
import com.detyra.mvc.domain.dto.WheelsRequest;
import com.detyra.mvc.domain.entity.WheelsEntity;
import com.detyra.mvc.domain.mappers.WheelsMapper;
import com.detyra.mvc.repository.WheelsRepository;
import com.detyra.mvc.service.WheelsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.detyra.mvc.domain.mappers.WheelsMapper.toDto;
@Service
public class WheelsServiceImpl implements WheelsService {
    @Autowired
    private WheelsRepository wheelsRepository;

    @Transactional
    @Override
    public WheelsDTO save(WheelsRequest wheelsRequest) {
        return toDto(wheelsRepository.save(WheelsMapper.toEntity(wheelsRequest)));
    }

    @Transactional
    @Override
    public WheelsDTO update(WheelsDTO wheelsDTO) {
        return toDto(wheelsRepository.save(WheelsMapper.toEntity(wheelsDTO)));
    }

    @Override
    public WheelsDTO findById(Integer id) {
        return toDto(wheelsRepository.findById(id));
    }

    @Transactional
    @Override
    public WheelsDTO delete(Integer id) {
        return toDto(wheelsRepository.delete(wheelsRepository.findById(id)));
    }

    @Override
    public List<WheelsDTO> findAll() {
        List<WheelsEntity> wheels = wheelsRepository.findAll();
        return wheels.stream()
                .map(WheelsMapper::toDto)
                .collect(Collectors.toList());
    }

}
