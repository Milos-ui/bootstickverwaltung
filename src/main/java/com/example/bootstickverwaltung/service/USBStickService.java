package com.example.bootstickverwaltung.service;

import com.example.bootstickverwaltung.dto.USBStickDTO;
import com.example.bootstickverwaltung.mapper.USBStickMapper;
import com.example.bootstickverwaltung.repository.USBStickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class USBStickService {

    @Autowired
    private USBStickMapper mapper;

    @Autowired
    private USBStickRepository repository;

    public List<USBStickDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    public Optional<USBStickDTO> findById(String inventarnummer) {
        return repository.findById(inventarnummer)
                .map(mapper::toDTO);
    }

    public USBStickDTO save(USBStickDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public void deleteById(String inventarnummer) {
        repository.deleteById(inventarnummer);
    }
}
