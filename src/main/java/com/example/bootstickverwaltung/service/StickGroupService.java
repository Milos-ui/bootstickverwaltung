package com.example.bootstickverwaltung.service;

import com.example.bootstickverwaltung.dto.StickGroupDTO;
import com.example.bootstickverwaltung.mapper.StickGroupMapper;
import com.example.bootstickverwaltung.model.StickGroup;
import com.example.bootstickverwaltung.repository.StickGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StickGroupService {

    @Autowired
    private StickGroupMapper mapper;

    @Autowired
    private StickGroupRepository repository;

    public List<StickGroupDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    public Optional<StickGroupDTO> findById(String groupId) {
        return repository.findById(groupId)
                .map(mapper::toDTO);
    }

    public StickGroupDTO save(StickGroupDTO dto) {
        StickGroup entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public void deleteById(String groupId) {
        repository.deleteById(groupId);
    }
}
