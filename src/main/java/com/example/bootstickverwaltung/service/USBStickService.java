package com.example.bootstickverwaltung.service;

import com.example.bootstickverwaltung.model.USBStick;
import com.example.bootstickverwaltung.repository.USBStickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class USBStickService {

    @Autowired
    private USBStickRepository repository;
    public List<USBStick> findAll() {
        return repository.findAll();
    }

    public USBStick save(USBStick usbStick) {
        return repository.save(usbStick);
    }
}
