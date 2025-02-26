package com.example.bootstickverwaltung.service;

import com.example.bootstickverwaltung.dto.USBStickDTO;
import com.example.bootstickverwaltung.mapper.USBStickMapper;
import com.example.bootstickverwaltung.model.USBStick;
import com.example.bootstickverwaltung.repository.USBStickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class USBStickService {

    @Autowired
    private USBStickMapper mapper;

    @Autowired
    private USBStickRepository repository;
    public List<USBStickDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    public USBStickDTO save(USBStickDTO usbStick) {
        return mapper.toDTO(repository.save(mapper.toEntity(usbStick)));
    }
}
